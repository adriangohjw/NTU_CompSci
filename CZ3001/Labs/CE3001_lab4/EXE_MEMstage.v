`include "define.v"

module EXE_MEM_stage (
	
	input  clk,  rst, 
	input [`DSIZE-1:0] alu_in,
	input [`DSIZE-1:0] rdata2_in,
	input [`ASIZE-1:0]waddr_in, 
	input memwrite_in,
	input memtoreg_in,
	input writeenable_in,

	
	output reg [`DSIZE-1:0] alu_out,
	output reg [`DSIZE-1:0] rdata2_out,
	output reg[`ASIZE-1:0]waddr_out,
	output reg memwrite_out,
	output reg memtoreg_out,
	output reg writeenable_out

	
);




//EXE_MEM register to save the values.



always @ (posedge clk) begin
	if(rst)
	begin
		waddr_out <= 0;
		alu_out <= 0;
		rdata2_out <= 0;
		memwrite_out <= 0;
		memtoreg_out <= 0;
		writeenable_out <= 0;
	end
   else
	begin
		waddr_out <= waddr_in;
		alu_out <= alu_in;
		rdata2_out <= rdata2_in;
		memwrite_out <= memwrite_in;
		memtoreg_out <= memtoreg_in;
		writeenable_out <= writeenable_in;
		
	end
 
end
endmodule


