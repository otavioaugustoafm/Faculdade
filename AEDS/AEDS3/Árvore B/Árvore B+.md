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
Exemplo: Remover o 42
--------------------(.29.-.-.-.)-----------------------  
----(.8.15.-.-.)------------------------- (.40.45.60.-.)----  
(...)(...)(.18.20.25.-.)--------(.30.37.-.-.)(.41.42.-.-.)(.51.52.-.-.)----  
Aqui vamos remover o 42 e perceber que a folha fica com menos de 50% de ocupação. Então, procuramos fazer uma junção de folhas. Depende do cógido, mas olhamos uma das folhas irmãs 
primeiro, descendo a chave em comum entre elas e juntando as demais chaves em uma folha.  
--------------------(.29.-.-.-.)-----------------------  
----(.8.15.-.-.)------------------------- (.40.45.60.-.)----  
(...)(...)(.18.20.25.-.)--------(.30.37.-.-.)(.41.-.-.-.)(.51.52.-.-.)----  
Aqui percebemos que não podemos apenas ceder o 51 e nem o 37. Nesse caso, vamos fazer uma junção. Juntando com a página direita obtemos:
--------------------(.29.-.-.-.)-----------------------  
----(.8.15.-.-.)------------------------- (.40.60.-.-.)----  
(...)(...)(.18.20.25.-.)--------(.30.37.-.-.)(.41.51.-.-.)----  
Obs: Excluímos o 45 já que ele não é chave válida na folha. Se fossemos juntar as duas folhas superiores com a raiz, ai sim manteríamos a regra da árvore B normal