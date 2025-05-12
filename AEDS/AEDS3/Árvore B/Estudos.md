### Árvore B  

# Base  
* Estrutura de dados auto-balanceada que mantém dados ordenados e permite buscas, inserções e remoções em tempos logarítmicos.  
* Amplamente utilizada em sistemas de gerenciamento de banco de dados e sistemas de arquivos.  
* É, essencialmente, uma árvore 2-3 (embora existam algumas diferenças)  

# Características principais  
* Cada página pode conter múltiplas chaves e filhos  
* A ordem da árvore define o número máximo de filhos que uma página pode ter (M)    
* A inserção e remoção são eficientes, para que assim consigam sempre manter a árvore balanceada  

# Propriedades  
* As páginas podem ter, no MÁXIMO, M - 1 chaves  
* As páginas (exceto a raiz) devem conter no mínimo ⌈M/2⌉ -> Pelo menos 50% de ocupação  
* Cada nó que não seja uma folha tem um filho para cada uma de suas chaves + 1  
* Todas folhas estão no mesmo nível e o crescimento é pra cima  

# Anotações  
* Chamamos os nodos de PÁGINAS  

# Estrutura da página
N|P0|C0D0|P1|C1D1|P2|C2D2|P3|C3D3|...|Pn-1|Cn-1Dn-1|Pn  
N -> é o número de chaves armazenadas nessa página  
C -> é a chave que está armazenada nessa página
P -> é o ponteiro que aponta para o filho em determinada faixa de valor. No caso de P0, ele aponta para o filho esquerdo (valores menores) da chave C0  
D -> é o endereço físico onde a chave está armazenada no disco (dados)  
OBS: Trabalhamos normalmente com o valor de ponteiro -1 ou 0 para ponteiros vazios  
