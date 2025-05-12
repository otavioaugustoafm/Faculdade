### Remoção na Árvore B   

# Como ocorre  

Caso 1 - Elemento ESTÁ em uma folha: Fazemos a busca até o elemento e o removemos, arrumando as chaves após essa remoção  
Exemplo: Remover o 12 da seguinte página: (.2.4.12.14.)  -> (.2.4.14.-.)  

Caso 2 - Elemento NÃO está em uma folha: Fazemos a busca até o elemento, identificando que ele não está em uma folha. Após isso, substituímos ele 
pelo seu antecessor ou sucessor imediato. Eles estarão nas folhas.  
Exemplo: Remover o 29 da seguinte página raiz (.29.-.-.-.) -> Supondo que as folhas estão na seguinte disposição:  
--------------------(.29.-.-.-.)-----------------------
----(.8.15.-.-.)---------------------(.37.45.60.-.)----
(...)(...)(.18.20.25.-.)----(.30.35.-.-.)(...)(...)----
Podemos substituir o 29 por 25 ou 30, nesse caso sendo melhor substituir por 25, já que ele não demanda nenhum movimento a mais para manter as 
páginas envolvidas atualizadas  