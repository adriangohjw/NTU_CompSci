`include "define.v"
//memory is implemented using a different technology. But inorder to do simulation we are using this program and here memory is just reading from a file.
module dmemory( clk, rst, wen, addr, data_in, fileid, data_out);//This memory can be used as instuction as well as data memory

  input clk;
  input rst;
  input wen;// if wen=1, we can write into memory and this is made used by datamemory. For Imem- wen=0
  input [`DSIZE-1:0] addr;      // address input is 16 bit wide 
  input [`DSIZE-1:0] data_in;          // data input
  input  fileid;//file id selects which amoung the files given below (0 for imem) and (8 for D-mem inputs) for this lab we are using fileid=0
  output [`DSIZE-1:0] data_out;    // data output

  reg [`DSIZE-1:0] dmemory [0:32*`ISIZE-1]; //size of the memory
  reg [8*`MAX_LINE_LENGTH:0] line; /* Line of text read from file */

integer fin, i, c, r;
reg [`DSIZE-1:0] t_addr;
reg [`DSIZE-1:0] t_data;

reg [`DSIZE-1:0] addr_r;

assign data_out = dmemory[addr_r];//Reading from the memory. Do note that there is a clock cycle delay for reading from the memory just to indicate that memories are slower.

  always @(posedge clk)
    begin
      if(rst)
        begin
	   addr_r <=0;
  	   case(fileid)
	        0: fin = $fopen("imem_test_ex.txt","r");
	        1: fin = $fopen("dmem_test_ex.txt","r");//here we are using this as the data memory input.txt file. 

	  endcase
	  $write("Opening Fileid %d\n", fileid);

	  while(!$feof(fin)) begin
              c = $fgetc(fin);
              // check for comment
              if (c == "/" | c == "#" | c == "%")
                  r = $fgets(line, fin);
              else
                 begin
                    // Push the character back to the file then read the next time
                    r = $ungetc(c, fin);
                    r = $fscanf(fin, "%h %h",t_addr, t_data);
                    dmemory[t_addr]=t_data;
                 end
            end
            $fclose(fin);
	end
      else
        begin
	  addr_r <= addr;
          if (wen)// active-high write enable
            begin            
              dmemory[addr] <= data_in;
            end
	end
    end

endmodule