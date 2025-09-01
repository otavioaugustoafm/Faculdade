// Trabalho_1/NãoDirecionado_Ponderado.cpp

#include <iostream>
#include <vector>
#include <queue>
#include <chrono>
#include <limits> // Necessário para numeric_limits
#include <algorithm> // Necessário para reverse

using namespace std;
using par_int = pair<int, int>;
using std::chrono::high_resolution_clock;
using std::chrono::duration_cast;
using std::chrono::milliseconds;
using std::chrono::nanoseconds;

struct Grafo {
    int n; // número de vértices
    /*
       Grafo não direcionado e ponderado usando lista de adjacência com pares (destino, peso):

       1. Cada aresta (u, v, peso) é armazenada em adj[u] e adj[v], 
          pois a conexão é bidirecional.
       2. Eficiência de memória: lista de adjacência ocupa O(n + m), melhor para grafos esparsos.
       3. Fácil acesso aos vizinhos e seus pesos.
       4. Ideal para algoritmos de caminhos mínimos, MST, etc.
    */
    vector<vector<pair<int, int>>> adj; // lista de adjacência com (vértice, peso)

    Grafo(int n) {
        this->n = n;
        adj.resize(n);
    }

    void addAresta(int u, int v, int peso) {
        adj[u].push_back({v, peso});
        adj[v].push_back({u, peso}); // adiciona a aresta no sentido contrário
    }

    void print() {
        for (int i = 0; i < n; i++) {
            cout << i << ": ";
            for (auto edge : adj[i]) {
                int v = edge.first;
                int peso = edge.second;
                cout << "(" << v << ", " << peso << ") ";
            }
            cout << "\n";
        }
    }

    // Função para fazer a busca com profundidade em grafo
    void DFS(int inicio) {
        vector<bool> visitado(n, false);
        DFS_Recursivo(inicio, visitado);
        cout << "\n";
    }

    // Função auxiliar para fazer a busca com profundidade em grafo
    void DFS_Recursivo(int atual, vector<bool>& visitado) {
        visitado[atual] = true;
        for (auto edge : adj[atual]) {
            int vizinho = edge.first;
            if (!visitado[vizinho]) {
                DFS_Recursivo(vizinho, visitado);
            }
        }
    }

    // Função para fazer a busca com largura em grafo
    void BFS(int inicio) {
        vector<bool> visitado(n, false);
        queue<int> q;

        q.push(inicio);
        visitado[inicio] = true;

        while (!q.empty()) {
            int atual = q.front();
            q.pop();

            for (auto edge : adj[atual]) {
                int vizinho = edge.first;
                if (!visitado[vizinho]) {
                    visitado[vizinho] = true;
                    q.push(vizinho);
                }
            }
        }
        cout << "\n";
    }

    void dijkstra(int inicio) {
        if (inicio >= n) return;

        // Fila de prioridade para armazenar {distância, vértice}.
        // O `greater` a transforma em uma fila de prioridade mínima.
        priority_queue<par_int, vector<par_int>, greater<par_int>> pq;

        // Vetor de distâncias, inicializado com "infinito"
        vector<int> dist(n, numeric_limits<int>::max());
        
        // Vetor para reconstruir o caminho
        vector<int> pred(n, -1);

        // A distância da origem para si mesma é 0
        dist[inicio] = 0;
        pq.push({0, inicio});

        while (!pq.empty()) {
            // Pega o vértice `u` com a menor distância da fila
            int u = pq.top().second;
            pq.pop();

            // Itera sobre todos os vizinhos `v` de `u`
            for (auto& edge : adj[u]) {
                int v = edge.first;
                int peso = edge.second;

                // "Relaxamento" da aresta: se um caminho melhor para `v` foi encontrado
                if (dist[u] + peso < dist[v]) {
                    dist[v] = dist[u] + peso; // Atualiza a distância
                    pred[v] = u;              // Atualiza o predecessor
                    pq.push({dist[v], v});    // Adiciona o vizinho na fila para ser explorado
                }
            }
        }
    }
};

int main()
{
    int qntVertices;
    cin >> qntVertices;
    Grafo g(qntVertices);

    int v1, v2, peso;
    while (1) {
        cin >> v1;
        if (v1 == -1) {
            break;
        }
        cin >> v2 >> peso;
        g.addAresta(v1, v2, peso);
    }

    cout << "\nGrafo carregado com sucesso!\n";

    cout << "\nBusca em Profundidade (DFS) a partir do vertice 0:\n";
    auto inicio_dfs = high_resolution_clock::now();
    g.DFS(0);
    auto fim_dfs = high_resolution_clock::now();
    auto duracao_dfs = duration_cast<milliseconds>(fim_dfs - inicio_dfs);
    cout << "Tempo do DFS: " << duracao_dfs.count() << " ms" << endl;

    cout << "\nBusca em Largura (BFS) a partir do vertice 0:\n";
    auto inicio_bfs = high_resolution_clock::now();
    g.BFS(0);
    auto fim_bfs = high_resolution_clock::now();
    auto duracao_bfs = duration_cast<nanoseconds>(fim_bfs - inicio_bfs);
    cout << "Tempo do BFS: " << duracao_bfs.count() << " ms" << endl;

    cout << "\nExecutando Algoritmo de Dijkstra a partir do vertice 0...\n";
    auto inicio_dijkstra = high_resolution_clock::now();
    g.dijkstra(0);
    auto fim_dijkstra = high_resolution_clock::now();
    auto duracao_dijkstra = duration_cast<milliseconds>(fim_dijkstra - inicio_dijkstra);
    cout << "Tempo do Dijkstra: " << duracao_dijkstra.count() << " ms" << endl;

    return 0;
}