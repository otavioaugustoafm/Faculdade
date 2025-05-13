### Remoção na Árvore B   

# Como ocorre  

Caso 1 - Elemento ESTÁ em uma folha e ela mantiver 50% de ocupação: Fazemos a busca até o elemento e o removemos, arrumando as chaves após essa remoção  
Exemplo: Remover o 12 da seguinte página: (.2.4.12.14.)  -> (.2.4.14.-.)  

Caso 2 - Elemento NÃO está em uma folha: Fazemos a busca até o elemento, identificando que ele não está em uma folha. Após isso, substituímos ele 
pelo seu antecessor ou sucessor imediato. Eles estarão nas folhas.  
Exemplo: Remover o 29 da seguinte página raiz (.29.-.-.-.) -> Supondo que as folhas estão na seguinte disposição:  
--------------------(.29.-.-.-.)-----------------------  
----(.8.15.-.-.)---------------------(.37.45.60.-.)----  
(...)(...)(.18.20.25.-.)--------(.30.35.-.-.)(...)(...)-------  
Podemos substituir o 29 por 25 ou 30, nesse caso sendo melhor substituir por 25, já que ele não demanda nenhum movimento a mais para manter as 
páginas envolvidas atualizadas. Fica assim:  
--------------------(.25.-.-.-.)-----------------------  
----(.8.15.-.-.)---------------------(.37.45.60.-.)----  
(...)(...)(.18.20.-.-.)--------(.30.35.-.-.)(...)(...)-------  

Caso 3 - Se a folha ficar com menos de 50% e a irmã puder ceder: Fazemos a busca, identificando que a folha ficou com 50% de ocupação, então observamos se a página irmã pode 
ceder uma chave. Nesse caso, observamos que sim, uma irmã pode ceder. Fazemos uma rotação  
Exemplo: Remover o 35  
--------------------(.29.-.-.-.)-----------------------  
----(.8.15.-.-.)---------------------(.37.45.60.-.)----  
(...)(...)(.18.20.25.-.)--------(.30.35.-.-.)(.40.51.52.-.)(...)----
Nesse caso cedemos o 40, subindo com ele e descendo com o 37, ou seja, uma rotação  
--------------------(.29.-.-.-.)-----------------------  
----(.8.15.-.-.)---------------------(.40.45.60.-.)----  
(...)(...)(.18.20.25.-.)--------(.30.37.-.-.)(.41.42.-.-.)(...)----  

Caso 4 - Se a folha ficar com menos de 50% e a irmã NÃO puder ceder: Fazemos a busca, identificando que a folha ficou com 50% de ocupação, então observamos se a página irmã pode 
ceder uma chave. Nesse caso, observamos que sim, uma irmã NÃO pode ceder. Fazemos uma junção  
Exemplo: Remover o 42
--------------------(.29.-.-.-.)-----------------------  
----(.8.15.-.-.)------------------------- (.40.45.60.-.)----  
(...)(...)(.18.20.25.-.)--------(.30.37.-.-.)(.41.42.-.-.)(.51.52.-.-.)----  
Aqui vamos remover o 42 e perceber que a folha fica com menos de 50% de ocupação. Então, procuramos fazer uma junção de folhas. Depende do cógido, mas olhamos uma das folhas irmãs 
primeiro, descendo a chave em comum entre elas e juntando as demais chaves em uma folha.  
--------------------(.29.-.-.-.)-----------------------  
----(.8.15.-.-.)------------------------- (.40.45.60.-.)----  
(...)(...)(.18.20.25.-.)--------(.30.37.-.-.)(.41.-.-.-.)(.51.52.-.-.)----  
Aqui percebemos que não podemos apenas ceder o 51 e nem o 37. Nesse caso, vamos fazer uma junção. Depende da implementação, juntando com a página direita obtemos:
--------------------(.29.-.-.-.)-----------------------  
----(.8.15.-.-.)------------------------- (.40.60.-.-.)----  
(...)(...)(.18.20.25.-.)--------(.30.37.-.-.)(.41.51.-.-.)----  