/* Guia_0301_C1_C2.v
851568 - Otávio Augusto de Assis Ferreira Monteiro
*/

module C1_6;
  reg [5:0] a = 6'b001010;
  
  reg [5:0] c1;

  initial begin
    c1 = ~a;
    
    $display("C1,6 (1010_2) = %6b", c1);
  end
endmodule

module C1_8;
  reg [7:0] a = 8'b00001101; 

  reg [7:0] c1;

  initial begin
    c1 = ~a;
    
    $display("C1,8 (1101_2) = %8b", c1);
  end
endmodule

module C2_6;
  reg [5:0] a = 6'b101001; 

  reg [5:0] c2;
  reg [5:0] c1;

  initial begin
    c1 = ~a;
    c2 = c1 + 1;
    
    $display("C2,6 (101001_2) = %6b", c2);
  end
endmodule

module C2_7;
  reg [6:0] a = 7'b101111; 
  reg [6:0] c2;
  reg [6:0] c1;

  initial begin
    c1 = ~a;
    c2 = c1 + 1;
    
    $display("C2,7 (101111_2) = %7b", c2);
  end
endmodule

module C2_8;
  reg [7:0] a = 8'b110100; 

  reg [7:0] c2;
  reg [7:0] c1;

  initial begin
    c1 = ~a;
    c2 = c1 + 1;
    
    $display("C2,8 (110100_2) = %8b", c2);
  end
endmodule