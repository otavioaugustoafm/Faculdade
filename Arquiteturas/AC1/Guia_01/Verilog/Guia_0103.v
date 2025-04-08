/*
Guia_0103.v
851568 - Otávio Augusto de Assis Ferreira Monteiro
*/
module Guia_0103;
// define data
integer a = 61; // decimal
reg [7:0] a1 = 0; // binary
integer b = 53; // decimal
reg [7:0] b1 = 0; // binary
integer c = 77; // decimal
reg [7:0] c1 = 0; // binary
integer d = 153; // decimal
reg [7:0] d1 = 0; // binary
integer e = 753; // decimal
reg [11:0] e1 = 0; // binary
// actions
initial
begin : main
$display ( "Guia_0103 - Tests" );
$display ( "Em decimal a = %d" , a );
a1 = a;
$display ( "a = %B (2) = %o (8) = %x (16) = %d (4)", a1, a1, a1, decimal_to_base4(a));
$display ( "--------------------------------");
$display ( "Em decimal b = %d" , b );
b1 = b;
$display ( "b = %B (2) = %o (8) = %x (16))", b1, b1, b1 );
$display ( "--------------------------------");
$display ( "Em decimal c = %d" , c );
c1 = c;
$display ( "c = %B (2) = %o (8) = %x (16)", c1, c1, c1);
$display ( "--------------------------------");
$display ( "Em decimal d = %d" , d );
d1 = d;
$display ( "d = %B (2) = %o (8) = %x (16)", d1, d1, d1 );
$display ( "--------------------------------");
$display ( "Em decimal e = %d" , e );
e1 = e;
$display ( "e = %B (2) = %o (8) = %x (16)", e1, e1, e1 );
$display ( "--------------------------------");

end // main
function [15:0] decimal_to_base4;
    input [31:0] decimal;
    integer base4;
    integer place;
    begin
        base4 = 0;
        place = 1;
        while (decimal > 0) begin
            base4 = base4 + (decimal % 4) * place;
            decimal = decimal / 4;
            place = place * 10;
        end
        decimal_to_base4 = base4;
    end
endfunction
endmodule // Guia_0103
