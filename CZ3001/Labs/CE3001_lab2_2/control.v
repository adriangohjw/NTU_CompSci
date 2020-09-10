//control unit for write enable and ALU control

`include "define.v"

module control(
  input [10:0] inst_cntrl, 
  output reg wen_cntrl,
  output reg [2:0] aluop_cntrl
 
 
  
  );
  
  always@(inst_cntrl)
  begin
 
  	 
    case(inst_cntrl)
			`ADD: begin
					wen_cntrl=1;
					aluop_cntrl=inst_cntrl[2:0];
				
			end
        `SUB: begin
                wen_cntrl=1;
					 aluop_cntrl=inst_cntrl[2:0];
				
        end
        `AND: begin
                wen_cntrl=1;
					 aluop_cntrl=inst_cntrl[2:0];
					
        end
        `XOR: begin
                wen_cntrl=1;
					 aluop_cntrl=inst_cntrl[2:0];
				
        end
     
        `ORR: begin
                wen_cntrl=1;
					 aluop_cntrl=inst_cntrl[2:0];
					
        end
    		  				
		
		default: begin
				wen_cntrl=1;//the default condition is set for R type inst
				aluop_cntrl=inst_cntrl[2:0];
				
		end
	
		
    endcase
	 end
	 
  
endmodule
