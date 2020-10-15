`timescale 1ns / 1ps

////////////////////////////////////////////////////////////////////////////////
// Company: 
// Engineer:
//
// Create Date:   15:09:23 10/15/2020
// Design Name:   alu
// Module Name:   Y:/cz3001/CE3001_lab4/alu_test.v
// Project Name:  CE3001_lab4
// Target Device:  
// Tool versions:  
// Description: 
//
// Verilog Test Fixture created by ISE for module: alu
//
// Dependencies:
// 
// Revision:
// Revision 0.01 - File Created
// Additional Comments:
// 
////////////////////////////////////////////////////////////////////////////////

module alu_test;

	// Inputs
	reg [63:0] a;
	reg [63:0] b;
	reg [2:0] op;

	// Outputs
	wire [63:0] out;
	wire zero;

	// Instantiate the Unit Under Test (UUT)
	alu uut (
		.a(a), 
		.b(b), 
		.op(op), 
		.out(out), 
		.zero(zero)
	);

	always #15 clk = ~clk;
	initial begin
		// Initialize Inputs
		a = 0;
		b = 0;
		op = 0;

		// Wait 100 ns for global reset to finish
		#100;
        
		// Add stimulus here
		#25 rst = 1;
		#25 rst = 0;

	end
      
endmodule

