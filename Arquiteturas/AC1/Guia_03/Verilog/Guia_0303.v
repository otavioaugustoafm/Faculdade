// Guia_0303.v
// 851568 - Otávio Augusto de Assis Ferreira Monteiro

module Guia_0303;

  reg signed [5:0] a1 = 6'b101110; 
  reg signed [5:0] a2 = 6'b110011; 
  reg signed [5:0] a3 = 6'b100100; 
  reg signed [6:0] a4 = 7'b1011011; 
  reg signed [6:0] a5 = 7'b1110011; 

  reg signed [5:0] c2_1;
  reg signed [5:0] c2_2;
  reg signed [5:0] c2_3;
  reg signed [6:0] c2_4;
  reg signed [6:0] c2_5;

  initial begin : main
    $display("Guia_0303 - Tests");

    c2_1 = ~a1 + 1;
    $display("10110(2) -> Complemento de 2: %6b -> Valor Positivo: %d", c2_1, c2_1);

    c2_2 = ~a2 + 1;
    $display("110011(2) -> Complemento de 2: %6b -> Valor Positivo: %d", c2_2, c2_2);

    c2_3 = ~a3 + 1;
    $display("100100(2) -> Complemento de 2: %6b -> Valor Positivo: %d", c2_3, c2_3);

    c2_4 = ~a4 + 1;
    $display("1011011(2) -> Complemento de 2: %7b -> Valor Positivo: %d", c2_4, c2_4);

    c2_5 = ~a5 + 1;
    $display("1110011(2) -> Complemento de 2: %7b -> Valor Positivo: %d", c2_5, c2_5);
  end // main
endmodule // Guia_0303
