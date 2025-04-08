/*
Guia_0105.v
851568 - Otávio Augusto de Assis Ferreira Monteiro
*/
module Guia_0105;
// define data
reg [7:0] octal_codes [0:4]; 
reg [7:0] hex_codes [0:4]; 
// actions
initial
begin : main
$display ( "Guia_0105 - Tests" );
$display ( "PUC-M.G." );
$display ( "P = %h", "P" );
$display ( "U = %h", "U" );
$display ( "C = %h", "C" );
$display ( "- = %h", "-" );
$display ( "M = %h", "M" );
$display ( ". = %h", "." );
$display ( "G = %h", "G" );
$display ( ". = %h", "." );
$display ( "------------------------------" );
$display ( "2024-02" );
$display ( "2 = %h", "2" );
$display ( "0 = %h", "0" );
$display ( "2 = %h", "2" );
$display ( "4 = %h", "4" );
$display ( "- = %h", "-" );
$display ( "0 = %h", "0" );
$display ( "2 = %h", "2" );
$display ( "------------------------------" );
$display ( "Belo Horizonte" );
$display ( "B = %h", "B" );
$display ( "e = %h", "e" );
$display ( "l = %h", "l" );
$display ( "o = %h", "o" );
$display ( "  = %h", " " );
$display ( "H = %h", "H" );
$display ( "o = %h", "o" );
$display ( "r = %h", "r" );
$display ( "i = %h", "i" );
$display ( "z = %h", "z" );
$display ( "o = %h", "o" );
$display ( "n = %h", "n" );
$display ( "t = %h", "t" );
$display ( "e = %h", "e" );
$display ( "------------------------------" );
$display ( "156 157 151 164 145(8)" );
octal_codes[0] = 8'o156; 
octal_codes[1] = 8'o157; 
octal_codes[2] = 8'o151; 
octal_codes[3] = 8'o164;
octal_codes[4] = 8'o145; 
$display ( "156 = %h", octal_codes[0] );
$display ( "157 = %h", octal_codes[1] );
$display ( "151 = %h", octal_codes[2] );
$display ( "164 = %h", octal_codes[3] );
$display ( "145 = %h", octal_codes[4] );
$display ( "------------------------------" );
$display ( "4D 61 6E 68 61(16)" );
hex_codes[0] = 8'h4D; // 4D (16) -> 'M'
hex_codes[1] = 8'h61; // 61 (16) -> 'a'
hex_codes[2] = 8'h6E; // 6E (16) -> 'n'
hex_codes[3] = 8'h68; // 68 (16) -> 'h'
hex_codes[4] = 8'h61; // 61 (16) -> 'a'
$display("4D = %s", hex_codes[0]); 
$display("61 = %s", hex_codes[1]); 
$display("6E = %s", hex_codes[2]); 
$display("68 = %s", hex_codes[3]); 
$display("61 = %s", hex_codes[4]);


end // main
endmodule // Guia_0105