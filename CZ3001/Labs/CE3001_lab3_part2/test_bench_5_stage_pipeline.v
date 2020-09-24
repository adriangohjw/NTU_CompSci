`timescale 1ns / 1ps

////////////////////////////////////////////////////////////////////////////////
// Company: 
// Engineer:
//
// Create Date:   15:33:39 09/24/2020
// Design Name:   pipelined_regfile_5stage
// Module Name:   C:/Users/jgoh070/Desktop/CE3001_lab3_part2/test_bench_5_stage_pipeline.v
// Project Name:  CE3001_lab3_part2
// Target Device:  
// Tool versions:  
// Description: 
//
// Verilog Test Fixture created by ISE for module: pipelined_regfile_5stage
//
// Dependencies:
// 
// Revision:
// Revision 0.01 - File Created
// Additional Comments:
// 
////////////////////////////////////////////////////////////////////////////////

module test_bench_5_stage_pipeline;

	// Inputs
	reg clk;
	reg rst;

	// Outputs
	wire PCOUT;
	wire INST;
	wire rdata1;
	wire rdata2;
	wire rdata1_ID_EXE;
	wire rdata2_ID_EXE;
	wire imm_ID_EXE;
	wire rdata2_imm_ID_EXE;
	wire [2:0] aluop_ID_EXE;
	wire alusrc_ID_EXE;
	wire waddr_ID_EXE;
	wire aluout;
	wire waddr_EXE_MEM;
	wire aluout_EXE_MEM;
	wire rdata2_EXE_MEM;
	wire dmemdata;
	wire waddr_MEM_WB;
	wire aluout_MEM_WB;
	wire wdata_WB;

	// Instantiate the Unit Under Test (UUT)
	pipelined_regfile_5stage uut (
		.clk(clk), 
		.rst(rst), 
		.PCOUT(PCOUT), 
		.INST(INST), 
		.rdata1(rdata1), 
		.rdata2(rdata2), 
		.rdata1_ID_EXE(rdata1_ID_EXE), 
		.rdata2_ID_EXE(rdata2_ID_EXE), 
		.imm_ID_EXE(imm_ID_EXE), 
		.rdata2_imm_ID_EXE(rdata2_imm_ID_EXE), 
		.aluop_ID_EXE(aluop_ID_EXE), 
		.alusrc_ID_EXE(alusrc_ID_EXE), 
		.waddr_ID_EXE(waddr_ID_EXE), 
		.aluout(aluout), 
		.waddr_EXE_MEM(waddr_EXE_MEM), 
		.aluout_EXE_MEM(aluout_EXE_MEM), 
		.rdata2_EXE_MEM(rdata2_EXE_MEM), 
		.dmemdata(dmemdata), 
		.waddr_MEM_WB(waddr_MEM_WB), 
		.aluout_MEM_WB(aluout_MEM_WB), 
		.wdata_WB(wdata_WB)
	);
	
	always #15 clk = ~clk;

	initial begin
		// Initialize Inputs
		clk = 0;
		rst = 0;

		// Wait 100 ns for global reset to finish
		#100;
        
		// Add stimulus here
		#25 rst = 1;
		#25 rst = 0;

	end
      
endmodule

