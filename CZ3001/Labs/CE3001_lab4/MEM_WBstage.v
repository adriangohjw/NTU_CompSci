`include "define.v"

module MEM_WB_stage (
	
	input  clk,  rst, 
	input [`DSIZE-1:0] alu_in,
	input [`ASIZE-1:0]waddr_in, 
	input memtoreg_in,
	input writeenable_in,

	
	output reg [`DSIZE-1:0] alu_out,
	output reg[`ASIZE-1:0]waddr_out,
	output reg memtoreg_out,
	output reg writeenable_out
	
);




//MEM_WB register to save the values.



always @ (posedge clk) begin
	if(rst)
	begin
		waddr_out <= 0;
		alu_out <= 0;
		memtoreg_out <= 0;
		writeenable_out <= 0;
		
	end
   else
	begin
		waddr_out <= waddr_in;
		alu_out <= alu_in;
		memtoreg_out <= memtoreg_in;
		writeenable_out <= writeenable_in;
		
	end
 
end
endmodule


