`timescale 1ns / 1ps

`include "define.v"
module alu_tb_file_io;

parameter DSIZE = 64;

reg [DSIZE-1:0] a,b;
reg [2:0] op;

wire [DSIZE-1:0] out;


integer fin, fout, c, r;

real real_time;

reg [8*`MAX_LINE_LENGTH:0] line; /* Line of text read from file */

alu #(DSIZE) A0(a,b,op,out);

initial
begin
  a=0; b=0; op=3'd0; 
  fin = $fopen("input.txt","r");
  fout = $fopen("output.txt","w");


///////////////////////////////////////////--- fetch input ---///////////////////////////////////////////////////////
  while (!$feof(fin)) 
  begin
        c = $fgetc(fin);
        /* Check the first character for comment */
        if (c == "/" | c == "#" | c == "%")
            r = $fgets(line, fin);
        else
            begin
            // Push the character back to the file then read the next time
            r = $ungetc(c, fin);
			#10 r = $fscanf(fin, "%h %h %h \n", a,b,op);
	    // NOTE: ALU should be combinational, so the output should have already changed...
	    #10 $fwrite(fout, "%h\n",out);
	 	end
  end // while not EOF
  #10; // so that all output is recorded before closing the files
  $fclose(fin);
  $fclose(fout);
  $finish;
end // end of initial
endmodule

