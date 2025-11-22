import matplotlib.pyplot as plt

def draw_neural_network(layers):
    fig, ax = plt.subplots(figsize=(7, 7))
    ax.axis('off')

    # Definições visuais
    layer_colors = ['mediumseagreen', 'mediumpurple', 'gold']
    layer_labels = ['Entrada', 'Oculta', 'Saída']

    max_neurons = max(layers)
    v_spacing = 1.0 / (max_neurons + 1)
    h_spacing = 1.0 / (len(layers) + 1)

    # Armazenar coordenadas de cada neurônio
    coords = []
    for i, n_neurons in enumerate(layers):
        layer_coords = []
        x = (i + 1) * h_spacing
        for j in range(n_neurons):
            y = 1 - (j + 1) * v_spacing
            layer_coords.append((x, y))
            # tipo de forma (quadrado só na saída)
            shape = 's' if i == len(layers) - 1 else 'o'
            ax.scatter(x, y, s=1200, c=layer_colors[i], edgecolors='k', zorder=3, marker=shape)
            label = f"{layer_labels[i][0]}{j+1}"
            ax.text(x, y, label, ha='center', va='center', fontsize=10, color='black', weight='bold')
        coords.append(layer_coords)

    # Conexões entre camadas
    for i in range(len(layers) - 1):
        for (x1, y1) in coords[i]:
            for (x2, y2) in coords[i + 1]:
                ax.plot([x1, x2], [y1, y2], 'k-', lw=0.8, alpha=0.6)

    # Título
    ax.text(0.5, 1.02, "Rede Neural 7-5-4 (Display de 7 segmentos)",
            ha='center', va='bottom', fontsize=13, weight='bold')

    plt.show()


# Executar
draw_neural_network([7, 5, 4])
