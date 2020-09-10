`include"define.v"
`timescale 1ns / 1ps

////////////////////////////////////////////////////////////////////////////////////
//// Company: NTU
//// Engineer: Dr. Smitha K G
////////////////////////////////////////////////////////////////////////////////////

module datapath_mux (
	// inputs
	clk,
	rst,
	inst,

	//outputs
	aluout
);

// inputs
input		  clk;
input		  rst;
input  [`ISIZE-1:0] inst;


// outputs
output  [`DSIZE-1:0] aluout;

wire [2:0]	aluop;

wire wen;
wire [`DSIZE-1:0] rdata1;
wire [`DSIZE-1:0] rdata2;





//Here you need to instantiate the control , Alu ,and regfile. 
//The codes below are not given to students.

//-insert your code here

control C0(.inst_cntrl(inst[31:21]), .wen_cntrl(wen), .aluop_cntrl(aluop));

regfile RF0 (.clk(clk), .rst(rst), .wen(wen), .raddr1(inst[9:5]), .raddr2(inst[20:16]), .waddr(inst[4:0]), .wdata(aluout), .rdata1(rdata1), .rdata2(rdata2));

alu ALU0 (.a(rdata1), .b(rdata2), .op(aluop), .out(aluout));



endmodule // end of datapath module

