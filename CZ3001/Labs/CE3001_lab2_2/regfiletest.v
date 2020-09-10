`timescale 1ns / 1ps

////////////////////////////////////////////////////////////////////////////////
// Company: NTU
// Engineer:Dr. Smitha K G

module regfiletest;

	// Inputs
	reg clk;
	reg rst;
	reg wen;
	reg [1:0] raddr1;
	reg [1:0] raddr2;
	reg [1:0] waddr;
	reg [3:0] wdata;

	// Outputs
	wire [3:0] rdata1;
	wire [3:0] rdata2;

//additionally added for file I/O
integer fin, fout, r, c;
reg [8*1000:0] line;

	// Instantiate the Unit Under Test (UUT)
	regfile uut (
		.clk(clk), 
		.rst(rst), 
		.wen(wen), 
		.raddr1(raddr1), 
		.raddr2(raddr2), 
		.waddr(waddr), 
		.wdata(wdata), 
		.rdata1(rdata1), 
		.rdata2(rdata2)
	);
// given the start @ clk=0, posedges at 5's
always #5 clk = ~clk; 	// generate the clk

initial
begin
	clk = 0;
	rst = 0;
	wen = 0;
	fin = $fopen("input_regfile.txt","r");
	fout = $fopen("output_regfile.txt","w");
#20	rst = 1;
#10	rst = 0; 

// scan input.txt //////////////////////////////////////////////////
	while (!$feof(fin))
	begin
		c = $fgetc(fin);
		// check for comment
		if (c == "/" | c == "#" | c == "%")
			r = $fgets(line, fin);
		else
		begin
			// Push the character back to the file then read the next time
			r = $ungetc(c, fin);
			r = $fscanf(fin, "%h %h %h %h %h", raddr1, raddr2, wen, waddr, wdata);
		end
	#10;		
$fwrite(fout, "%h %h\n", rdata1,rdata2);
	end
$fclose(fin);
	
$fclose(fout);
#100	$finish;


	end
      
endmodule

