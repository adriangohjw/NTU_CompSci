`include "define.v"// defines DSIZE, ADD, SUB etc


module alu(
   a,   //1st operand
   b,   //2nd operand
   op,   //3-bit operation
   out,
   zero   );


   
   input [`DSIZE-1:0] a, b;
   input [2:0] op;
   output reg [`DSIZE-1:0] out;
   output reg zero;

   
      
always @(a or b or op )
begin
   case(op)
       3'b000: out = a+b;
       3'b001: out = a - b;
       3'b010: out = a & b;
       3'b011:  out = a^b;
       3'b100: out = a|b;
       3'b101: out = b;//pass the input B outside

       
default: out = 0;  
   endcase

    if (out==0)
        zero = 1;
    else
        zero = 0;

end

endmodule
   
       

       
