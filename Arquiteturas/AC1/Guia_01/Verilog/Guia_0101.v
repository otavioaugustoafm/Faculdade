/*
Guia_0101.v
851568 - Otávio Augusto de Assis Ferreira Monteiro
*/
module Guia_0101;
// define data
integer a = 26; // decimal
integer b = 53; // decimal
integer c = 713; // decimal
integer d = 213; // decimal
integer e = 365; // decimal
reg [4:0] a2 = 0; // binary (bits - little endian)
reg [5:0] b2 = 0; // binary (bits - little endian)
reg [9:0] c2 = 0; // binary (bits - little endian)
reg [7:0] d2 = 0; // binary (bits - little endian)
reg [8:0] e2 = 0; // binary (bits - little endian)
// actions
initial
begin : main
$display ( "Guia_0101 - Tests" );
$display ( "Em decimal a = %d" , a );
a2 = a;
$display ( "Em binario a = %8b", a2 );
$display ( "Em decimal b = %d" , b );
b2 = b;
$display ( "Em binario b = %8b", b2 );
$display ( "Em decimal c = %d" , c );
c2 = c;
$display ( "Em binario c = %8b", c2 );
$display ( "Em decimal d = %d" , d );
d2 = d;
$display ( "Em binario d = %8b", d2 );
$display ( "Em decimal e = %d" , e );
e2 = e;
$display ( "Em binario e = %8b", e2 );
end // main
endmodule // Guia_0101