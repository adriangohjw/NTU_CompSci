// Register File module
`include "define.v"
`timescale 1ns / 1ps

module regfile (
	clk,
	rst,
	wen,
	raddr1, 
	raddr2, 
	waddr, 
	wdata, 

	rdata1,
	rdata2
	);

    
	input clk;
	input rst;
	input wen;
	input [`ASIZE-1:0] raddr1; 
	input [`ASIZE-1:0] raddr2; 
	input [`ASIZE-1:0] waddr; 
	input [`DSIZE-1:0] wdata; 

	output [`DSIZE-1:0] rdata1;
	output [`DSIZE-1:0] rdata2;



	reg [`DSIZE-1:0] regdata [0:`NREG-1];
	
integer i;
	always@(posedge clk)
		begin
			if(rst)
				begin
					for (i=0; i<`NREG; i=i+1)
					regdata[i] <=0;
				end
			else
				regdata[waddr] <= (wen == 1) ? wdata : regdata[waddr];//when wen=1, then write wdata to Left Hand Side or maintain the same data
		end
	
	assign rdata1 = ((wen) && (waddr == raddr1)) ? wdata : regdata[raddr1];//Here dataforwarding is done when both wen=1 and waddr=raddr1, then rdata1=wdata (this enables us to get the wdata in the same clock cycle-more useful in pipeling)
	assign rdata2 = ((wen) && (waddr == raddr2)) ? wdata : regdata[raddr2];

endmodule 
