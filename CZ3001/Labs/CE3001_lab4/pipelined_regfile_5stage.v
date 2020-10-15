`timescale 1ns / 1ps
`include "define.v"

module pipelined_regfile_5stage(clk, rst, PCOUT, INST, rdata1, rdata2, rdata1_ID_EXE, rdata2_ID_EXE, imm_ID_EXE,rdata2_imm_ID_EXE, aluop_ID_EXE, alusrc_ID_EXE, branch_ID_EXE, unconditional_branch_ID_EXE, waddr_ID_EXE,aluout,waddr_EXE_MEM,aluout_EXE_MEM,rdata2_EXE_MEM, dmemdata, waddr_MEM_WB,aluout_MEM_WB,wdata_WB);

input clk;				
											
input rst;

 
output [`DSIZE-1:0]PCOUT;
output [`DSIZE-1:0] rdata1;
output [`DSIZE-1:0] rdata1_ID_EXE;
output [`DSIZE-1:0] rdata2;
output [`DSIZE-1:0] rdata2_ID_EXE;
output [`DSIZE-1:0] imm_ID_EXE;
output [`DSIZE-1:0] rdata2_imm_ID_EXE;
output [`ISIZE-1:0]INST;
output alusrc_ID_EXE;
output [2:0]aluop_ID_EXE;
output [`ASIZE-1:0] waddr_ID_EXE;
output [`DSIZE-1:0] aluout;
output branch_ID_EXE;
output unconditional_branch_ID_EXE;


output [`DSIZE-1:0] rdata2_EXE_MEM;
output [`ASIZE-1:0] waddr_EXE_MEM;
output [`DSIZE-1:0] aluout_EXE_MEM;
output [`DSIZE-1:0] dmemdata;				
output [`ASIZE-1:0] waddr_MEM_WB;	
output [`DSIZE-1:0] aluout_MEM_WB;
output [`DSIZE-1:0] wdata_WB;							
 	 
//Program counter
wire [`DSIZE-1:0] PCIN;
wire [`DSIZE-1:0] jump_mux;
wire [`DSIZE-1:0] jump_mux_b;
wire [`DSIZE-1:0] PC_IF_ID;


PC1 pc(.clk(clk),.rst(rst),.nextPC(jump_mux),.currPC(PCOUT));//PCOUT is your PC value and PCIN is your next PC


assign PCIN = PCOUT + 64'b1; //increments PC to PC +1

IF_ID_stage PIPE0 (.clk(clk), .rst(rst), .PC_in(PCOUT), .PC_out(PC_IF_ID));


//instruction memory
imemory im( .clk(clk), .rst(rst), .wen(1'b0), .addr(PCOUT), .data_in(64'b0), .fileid(1'b0),.data_out(INST));//note that memory read is having one clock cycle delay as memory is a slow operation


wire wen;
wire alusrc;
wire reg2loc;
wire memwrite;
wire memtoreg;
wire [2:0] aluop;
wire branch;
wire unconditional_branch;

//control logic for all instructions
control C0 (.inst_cntrl(INST[31:21]),.wen_cntrl(wen),.alusrc_cntrl(alusrc),.reg2loc_cntrl(reg2loc), .aluop_cntrl(aluop), .memwrite_cntrl(memwrite), .memtoreg_cntrl(memtoreg), .branch_cntrl(branch), .unconditional_branch_cntrl(unconditional_branch));

//mux for selecting the readaddress using reg2loc for STUR
wire [`ASIZE-1:0]raddr1_mux=reg2loc ? INST[4:0] : INST[20:16];// mux for selecting read address for STUR instcutions

//initialization of regfiles is not needed as we have datamemory available. So we can alsways load from memory to register
regfile  RF0 ( .clk(clk), .rst(rst), .wen(writeenable_MEM_WB), .raddr1(INST[9:5]), .raddr2(raddr1_mux), .waddr(waddr_MEM_WB), .wdata(wdata_WB), .rdata1(rdata1), .rdata2(rdata2));//note that waddr and wdata needs to come from last pipeline register (EXE/WB stage)

//sign extention of address filed in D-type instruction
wire [`DSIZE-1:0]extended_add;
assign extended_add=({{55{INST[20]}},INST[20:12]});

wire [`DSIZE-1:0] PC_ID_EXE;
wire [`ISIZE-1:0] INST_ID_EXE;

//first pipeline register between ID and EXE stage
ID_EXE_stage PIPE1(.clk(clk), .rst(rst), .rdata1_in(rdata1),.rdata2_in(rdata2),.imm_in(extended_add),.opcode_in(aluop), .alusrc_in(alusrc),.memwrite_in(memwrite),.memtoreg_in(memtoreg),.writeenable_in(wen), .waddr_in(INST[4:0]), .branch_in(branch), .PC_in(PC_IF_ID), .INST_in(INST), .unconditional_branch_in(unconditional_branch), .unconditional_branch_out(unconditional_branch_ID_EXE), .INST_out(INST_ID_EXE), .PC_out(PC_ID_EXE), .branch_out(branch_ID_EXE), .waddr_out(waddr_ID_EXE),.imm_out(imm_ID_EXE), .rdata1_out(rdata1_ID_EXE), .rdata2_out(rdata2_ID_EXE),.alusrc_out(alusrc_ID_EXE), .opcode_out(aluop_ID_EXE),.memwrite_out(memwrite_ID_EXE),.memtoreg_out(memtoreg_ID_EXE),.writeenable_out(writeenable_ID_EXE));//immediate value is only zero extended. As we are concentrationg only on R type instuctions, this is not an issue.

//mux for selecting the input to ALU using alusrc
wire [`DSIZE-1:0]rdata2_imm_ID_EXE=alusrc_ID_EXE ? imm_ID_EXE : rdata2_ID_EXE;// mux for selecting immedaite or the rdata2 value

wire zero_flag;
//alu
alu ALU0 ( .a(rdata1_ID_EXE), .b(rdata2_imm_ID_EXE), .op(aluop_ID_EXE), .out(aluout), .zero(zero_flag));//ALU takes its input from pipeline register and the output of mux.

wire PC_src = (zero_flag & branch_ID_EXE) | unconditional_branch_ID_EXE;

wire [`DSIZE-1:0] extended_CBZ_addr;
assign extended_CBZ_addr = {{46{INST_ID_EXE[23]}}, INST_ID_EXE[22:5]};

wire [`DSIZE-1:0] extended_B_addr;
assign extended_B_addr = {{39{INST_ID_EXE[25]}}, INST_ID_EXE[24:0]};

wire [`DSIZE-1:0] temp;
assign temp = (unconditional_branch_ID_EXE)?extended_B_addr:extended_CBZ_addr;

assign jump_mux = PC_src ? (temp+PC_ID_EXE): PCIN;

//second pipeline register between EXE and MEM stage
EXE_MEM_stage PIPE2(.clk(clk),.rst(rst),.alu_in(aluout),.waddr_in(waddr_ID_EXE),.rdata2_in(rdata2_ID_EXE),.memwrite_in(memwrite_ID_EXE),.memtoreg_in(memtoreg_ID_EXE), .writeenable_in(writeenable_ID_EXE),.alu_out(aluout_EXE_MEM),.rdata2_out(rdata2_EXE_MEM),.waddr_out(waddr_EXE_MEM),.memwrite_out(memwrite_EXE_MEM),.memtoreg_out(memtoreg_EXE_MEM),.writeenable_out(writeenable_EXE_MEM));

//data memory
//As there is a clock delay for the memory to read the data, the output is not connected to the last pipeline (explained in manual)
dmemory dm( .clk(clk), .rst(rst), .wen(memwrite_EXE_MEM), .addr(aluout_EXE_MEM), .data_in(rdata2_EXE_MEM), .fileid(1'b1),.data_out(dmemdata));//note that memory read is having one clock cycle delay as memory is a slow operation

//third pipeline register between MEM and WBstage
MEM_WB_stage PIPE3(.clk(clk),.rst(rst),.alu_in(aluout_EXE_MEM),.waddr_in(waddr_EXE_MEM),.memtoreg_in(memtoreg_EXE_MEM), .writeenable_in(writeenable_EXE_MEM),.alu_out(aluout_MEM_WB),.waddr_out(waddr_MEM_WB),.memtoreg_out(memtoreg_MEM_WB),.writeenable_out(writeenable_MEM_WB));

//mux for selecting the wdata to regfile using memtoreg
assign wdata_WB =memtoreg_MEM_WB ? aluout_MEM_WB : dmemdata;

endmodule


