### Busca na Árvore B  

# Como ocorre 
N|P0|C0D0|P1|C1D1|P2|C2D2|P3|C3D3|...|Pn-1|Cn-1Dn-1|Pn  

Estamos querendo buscar o número 20 na seguinte página:
2|P0|18D0|P1|25D1|P2  

Começamos com um contador de elementos em 0 e fazemos a primeira comparação:  
20 = 18 -> Falso | 20 < 18 -> Falso
Passamos para a próxima comparação e incrementamos o contador (se torna 1):  
20 = 25 -> Falso | 20 < 25 -> Verdadeiro  
Retornamos o valor de P1, pois ele é o ponteiro que aponta para o filho dessa página que corresponde os valores maiores 
que 18 e menores que 25 (onde o 20 pode estar)  
Continuamos a busca nessa outra página para qual o ponteiro aponta  
Resultados como -1 ou 0 significam que o ponteiro para onde estaria o 20 não existe, logo não temos o 20 no nosso arquivo  