`include "define.v"

module IF_ID_stage(
	input clk, rst,
	input [`DSIZE - 1:0] PC_in,
	output reg [`DSIZE - 1:0] PC_out
);

always @ (posedge clk) begin
	if(rst)
	begin
		PC_out <= 0;
	end
   else
	begin
		PC_out <= PC_in;
	end
 
end
endmodule