// Guia_0302.v
// 851568 - Otávio Augusto de Assis Ferreira Monteiro

module Guia_0302;
  reg [5:0] a1 = 6'b001110; 
  reg [7:0] a2 = 8'b10110010;
  reg [5:0] a3 = 6'b101101;  
  reg [9:0] a4 = 10'b0010010010; 
  reg [7:0] a5 = 8'b01101111; 


  reg [5:0] c1_6;
  reg [7:0] c1_8;
  reg [5:0] c2_6;
  reg [9:0] c2_10;
  reg [7:0] c2_8;
  reg [5:0] temp_c1_6;
  reg [9:0] temp_c1_10;


  initial begin : main
    $display("Guia_0302 - Tests");

    temp_c1_6 = ~a1;
    $display("C1,6 (321_4) = %6b", temp_c1_6);

    c1_8 = ~a2;
    $display("C1,8 (B2_16) = %8b", c1_8);

    c1_6 = ~a3;
    c2_6 = c1_6 + 1;
    $display("C2,6 (231_4) = %6b", c2_6);

    temp_c1_10 = ~a4;
    c2_10 = temp_c1_10 + 1;
    $display("C2,10 (146_8) = %10b", c2_10);

    c1_8 = ~a5;
    c2_8 = c1_8 + 1;
    $display("C2,8 (6F_16) = %8b", c2_8);
  end // main
endmodule // Guia_0302
