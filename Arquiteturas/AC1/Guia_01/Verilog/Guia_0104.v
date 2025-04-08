/*
Guia_0104.v
851568 - Otávio Augusto de Assis Ferreira Monteiro
*/
module Guia_0104;
// define data
reg [5:0] a1 = 6'b10100; // binary
reg [5:0] b1 = 6'b11010; // binary
reg [7:0] c1 = 6'b100111; // binary
reg [5:0] d1 = 6'b100101; // binary
reg [5:0] e1 = 6'b101101; // binary
// actions
initial
begin : main
$display ( "Guia_0104 - Tests" );
$display ( "a = %b", a1);
$display ( "a = [%2b] [%2b] [%2b] = %d(4)", a1[5:4], a1[3:2], a1[1:0], decimal_to_base4(a1) );
$display ( "b = %b", b1);
$display ( "b = [%3b] [%3b] = %o(8)", b1[5:3], b1[2:0], b1 );
$display ( "c = %b", c1);
$display ( "c = [%4b] [%4b] = %x(16)", c1[7:4], c1[3:0], c1 );
$display ( "d = %b", d1);
$display ( "d = [%3b] [%3b] = %o(8)", d1[5:3], d1[2:0], d1 );
$display ( "e = %b", e1);
$display ( "e = [%2b] [%2b] [%2b] = %d(4)", e1[5:4], e1[3:2], e1[1:0], decimal_to_base4(e1) );

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
endmodule // Guia_0104
