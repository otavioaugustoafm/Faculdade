/*
Guia_0102.v
851568 - Otávio Augusto de Assis Ferreira Monteiro
*/
module Guia_0102;
// define data
integer a = 0; // decimal
integer b = 0; // decimal
integer c = 0; // decimal
integer d = 0; // decimal
integer e = 0; // decimal
reg [4:0] a1 = 8'b0010101; // binary (bits - little endian)
reg [4:0] b1 = 8'b0011011; // binary (bits - little endian)
reg [4:0] c1 = 8'b0010010; // binary (bits - little endian)
reg [5:0] d1 = 8'b0101011; // binary (bits - little endian)
reg [5:0] e1 = 8'b0110111; // binary (bits - little endian)
// actions
initial
begin : main
$display ( "Guia_0102 - Tests" );
$display ( "Em binario a = %8b", a1 );
a = a1;
$display ( "Em decimal a = %d", a );
$display ( "Em binario b = %8b", b1 );
b = b1;
$display ( "Em decimal b = %d", b );
$display ( "Em binario c = %8b", c1 );
c = c1;
$display ( "Em decimal c = %d", c );
$display ( "Em binario d = %8b", d1 );
d = d1;
$display ( "Em decimal d = %d", d );
$display ( "Em binario e = %8b", e1 );
e = e1;
$display ( "Em decimal e = %d", e );

end // main
endmodule // Guia_0102

