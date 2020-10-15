// defines
`define ADD 11'b00000000000
`define SUB 11'b00000000001
`define AND 11'b00000000010
`define XOR 11'b00000000011
`define ORR 11'b00000000100
`define LDUR 11'b00000000101
`define STUR 11'b00000000110
`define CBZ 8'b00000111
`define B 6'b001000




//for fileIO
`timescale 1ns / 10ps
`define EOF 64'hFFFF_FFFF_FFFF_FFFF
`define NULL 0
`define MAX_LINE_LENGTH 1000
`define DSIZE 64 // Bitwidth of each register 
`define NREG 32 //Number of registers 
`define ISIZE 32 //instuction size
`define ASIZE 5//Address size

