`include "define.v"


module PC1(
       clk,
		 rst,       
		 nextPC,		 
		 currPC);
		 
		  
		 input clk,rst;		 
		 input [`DSIZE - 1:0]nextPC;		 //instruction address is 16 bit as it can address more memory locations
		 output reg [`DSIZE - 1:0]currPC;
		 
		 
		 
always @( posedge clk)
begin
if (rst) begin
	 currPC <= 64'h0000000000000000;
	end else begin
	 currPC <= nextPC;
	end

end
endmodule	

