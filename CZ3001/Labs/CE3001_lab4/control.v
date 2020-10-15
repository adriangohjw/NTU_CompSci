//control unit for write enable and ALU control

`include "define.v"

module control(
	input [10:0] inst_cntrl, 
	output reg wen_cntrl,
	output reg alusrc_cntrl,
	output reg reg2loc_cntrl,
	output reg [2:0] aluop_cntrl,
	output reg memwrite_cntrl,
	output reg memtoreg_cntrl,
	output reg branch_cntrl,
	output reg unconditional_branch_cntrl
);
  
  always@(inst_cntrl)
  begin
 
    case(inst_cntrl)
		`ADD: begin
			wen_cntrl=1;
			alusrc_cntrl=0;
			reg2loc_cntrl=0;
			aluop_cntrl=inst_cntrl[2:0];
			memwrite_cntrl=0;
			memtoreg_cntrl=1;
			branch_cntrl=0;
			unconditional_branch_cntrl=0;
		end
        `SUB: begin
			wen_cntrl=1;
			alusrc_cntrl=0;
			reg2loc_cntrl=0;
			aluop_cntrl=inst_cntrl[2:0];
			memwrite_cntrl=0;
			memtoreg_cntrl=1;
			branch_cntrl=0;
			unconditional_branch_cntrl=0;
        end
        `AND: begin
			wen_cntrl=1;
			alusrc_cntrl=0;
			reg2loc_cntrl=0;
			aluop_cntrl=inst_cntrl[2:0];
			memwrite_cntrl=0;
			memtoreg_cntrl=1;
			branch_cntrl=0;
			unconditional_branch_cntrl=0;
        end
        `XOR: begin
			wen_cntrl=1;
			alusrc_cntrl=0;
			reg2loc_cntrl=0;
			aluop_cntrl=inst_cntrl[2:0];
			memwrite_cntrl=0;
			memtoreg_cntrl=1;
			branch_cntrl=0;
			unconditional_branch_cntrl=0;
        end
     
        `ORR: begin
			wen_cntrl=1;
			alusrc_cntrl=0;
			reg2loc_cntrl=0;
			aluop_cntrl=inst_cntrl[2:0];
			memwrite_cntrl=0;
			memtoreg_cntrl=1;
			branch_cntrl=0;
			unconditional_branch_cntrl=0;
        end
        
		`LDUR: begin
			wen_cntrl=1;
			alusrc_cntrl=1;
			reg2loc_cntrl=0;
			aluop_cntrl=3'b000;//opcode for addition
			memwrite_cntrl=0;
			memtoreg_cntrl=0;
			branch_cntrl=0;
			unconditional_branch_cntrl=0;
		end
		`STUR: begin
			wen_cntrl=0;
			alusrc_cntrl=1;//As the instruction stops in DMEM regdst, wen and MemtoReg is not needed.
			aluop_cntrl=3'b000;//opcode for addition
			memwrite_cntrl=1;
			reg2loc_cntrl=1;
			memtoreg_cntrl=0;
			branch_cntrl=0;
			unconditional_branch_cntrl=0;
		end	
		
		default:
		if (inst_cntrl[10:3] == `CBZ)
			begin 
				wen_cntrl=0;//the default condition is set for R type inst
				alusrc_cntrl=0;
				reg2loc_cntrl=1;
				aluop_cntrl=3'b101;
			 	memwrite_cntrl=0;
				memtoreg_cntrl=0;
				branch_cntrl=1;
				unconditional_branch_cntrl=0;
			end
		else
			if (inst_cntrl[10:5] == `B)
				begin 
					wen_cntrl=1;//the default condition is set for R type inst
					alusrc_cntrl=0;
					reg2loc_cntrl=0;
					aluop_cntrl=3'b111; //the ALU, this will be default
					memwrite_cntrl=0;
					memtoreg_cntrl=0;
					branch_cntrl=0;
					unconditional_branch_cntrl=1;
				end
			else
				begin
					wen_cntrl=1;//the default condition is set for R type inst
					alusrc_cntrl=0;
					reg2loc_cntrl=0;
					aluop_cntrl=inst_cntrl[2:0];
					memwrite_cntrl=0;
					memtoreg_cntrl=0;
					branch_cntrl=0;
					unconditional_branch_cntrl=0;
				end	
	
	endcase
end
  
endmodule
