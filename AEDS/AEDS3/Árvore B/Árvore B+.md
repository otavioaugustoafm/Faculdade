### Árvore B+

# Como ocorre 

* Todas as chaves são armazenadas nas folhas  
* Cada folha aponta para a próxima folha (para permitir a leitura sequencial)  

# Inserção  
* Ao incluir uma chave que demande uma divisão da página folha, copiamos o elemento para a página superior. No entanto, ainda assim mantemos 
seu valor na página folha, pois apenas lá que temos valores válidos.  
* Diferente da árvore B padrão, ao dividir a página quando inserimos uma nova chave, devemos promover única e exclusivamente a menor chave da 
página da DIREITA, mesmo que a chave seja inserida na da esquerda.  
* Se uma página superior precisar ser dividida, por exemplo: (.10.20.30.40.) e o número 25 precisar subir devido a uma inserção.  
Primeiro vamos dividir essa página superior: (.10.20.-.-.) e (.30.40.-.-.)  
Após isso inserimos o 25 onde convém (.10.20.25.-.) e sobra (.30.40.-.-.)  
Então, por fim, subimos o 25 novamente. Isso seguindo a regra da árvore B normal, pois é dito que se inserimos na página da esquerda, subimos 
o maior elemento dela (mais a direita). Caso tivéssemos inserido na página direita, subiríamos o menor elemento dela (mais a esquerda)  

# Remoção
* Seguimos as mesmas regras da árvore B padrão, tanto de redistribuição e fusão  
* No entanto, se vamos fazer uma junção de páginas e o elemento da página superior descer para uma folha, ele some. Caso seja em páginas 
não folhas, mantemos a mesma lógica da árvore B normal  
