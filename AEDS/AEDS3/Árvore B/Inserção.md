### Inserção na Árvore B   

# Como ocorre  
Trabalhamos com o conjunto P0|C0D0  

Queremos inserir o número 20. Temos uma Árvore B de ordem 5  
Começamos na raiz, que está da seguinte maneira: (.29.-.-.-.) -> . é o ponteiro e - significa vazio  
20 = 29 -> Falso | 20 < 29 -> Verdadeiro  
Seguimos o ponteiro esquerdo (valores menores que 29). Ele nos leva uma página que está assim: (.8.15.-.-.)  
20 = 8 -> FALSO | 20 < 8 -> Falso  
Incrementamos o contador e passamos para a próxima chave (15)  
20 = 15 -> Falso | 20 < 15 -> Falso  
Incrementamos o contador e passamos para a próxima chave -> Estouramos o contador, pois ele atingiu a quantidade de chaves, logo não temos 
nenhuma chave adiante. Dessa forma, passamos para o próximo ponteiro, dessa vez o direito (valores maiores que 15)  
Por fim, na última página, temos: (.18.24.25.-.)  
20 = 18 -> Falso | 20 < 18 -> Falso  
Incrementamos o contador e passamos para a próxima chave  
20 = 24 -> Falso | 20 < 24 -> Verdadeiro -> Nesse caso, a página comporta mais uma chave. Então, "arrastamos" as outras chaves para a direita e 
inserimos o 20 no lugar ideal  

Caso a página não comporte, precisamos fazer algumas operações a mais. É preciso lembrar também que na Árvore B o crescimento é para cima  
Exemplo: Quero inserir o 20, mas a página que encontramos no exemplo anterior é a seguinte: (.18.24.25.30.)  
Percebemos que a página está cheia e analisamos onde entraria o 20 (entre 18 e 24)  
Dividimos essa página em duas, ficando então (.18.24.-.-.) e (.25.30.-.-.)  
Inserimos o 20 em uma das duas. Atente-se a qual chave devemos promover com base em qual das páginas você inserir  
Aqui, só podemos inserir na da esquerda, pois o 20 não é maior que 30 (.18.20.24.-.) e (.25.30.-.-.)  
Nesse caso, PROMOVEMOS o 24 (chave mais a direita da página esquerda)  
Ficando então (.18.20.-.-.) e (.25.30.-.-.), sendo a página pai dessas duas (.8.15.24.-.)  

Caso o valor fosse maior que 30, por exemplo 31, iríamos inserir na da direita, obtendo (.18.24.-.-.) e (.25.30.31.-.)  
Nesse caso, PROMOVEMOS o 25 (chave mais a esquerda da página direita)  
Ficando então (.18.24.-.-.) e (.30.31.-.-.), sendo a página pai dessas duas (.8.15.25.-.)  

Se a página pai estiver cheia e precisamos inserir o valor promovido a ela, entramos com a recursividade, fazendo o mesmo processo de divisão descrito acima 
nas páginas necessárias  

