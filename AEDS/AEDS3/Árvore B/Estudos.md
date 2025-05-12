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
