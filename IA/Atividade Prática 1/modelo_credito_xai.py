import pandas as pd
import numpy as np
from sklearn.tree import DecisionTreeClassifier
import shap
import matplotlib.pyplot as plt

# ============================
# 1. Gerar dados simulados
# ============================
rng = np.random.default_rng(42)
n = 200
renda = rng.integers(1000, 10000, n)
historico = rng.integers(0, 10, n)
idade = rng.integers(18, 70, n)

# Regra simulada: renda e histórico altos → aprovado
aprovado = ((renda > 5000) & (historico > 5)).astype(int)

df = pd.DataFrame({
    "renda": renda,
    "historico": historico,
    "idade": idade,
    "aprovado": aprovado
})

# 2. Treinar o modelo
X = df[["renda", "historico", "idade"]]
y = df["aprovado"]

modelo = DecisionTreeClassifier(max_depth=3, random_state=42)
modelo.fit(X, y)

# 3. Explicabilidade com SHAP
explainer = shap.Explainer(modelo, X)
shap_values = explainer(X)

# --- Importância global (summary plot)
shap.summary_plot(shap_values[..., 1], X, show=False)
plt.savefig("importancia_global_APROVADO.png", bbox_inches="tight")
plt.close()

print("explainer.expected_value:", explainer.expected_value, type(explainer.expected_value))
print("shap_values type:", type(shap_values))
if hasattr(shap_values, "values"):
    print("shap_values.values.shape:", shap_values.values.shape)
else:
    try:
        print("shap_values shape (np):", shap_values.shape)
    except Exception:
        print("shap_values has no .shape")
print("X shape:", getattr(X, "shape", None))
print("X.iloc[0,:] type:", type(X.iloc[0,:]))

# --- Explicação local 
sample_idx = 0
output_idx = 0

exp_sample = shap_values[sample_idx]         # Explanation para a amostra
exp_output = exp_sample[..., output_idx]     # Explanation para a saída escolhida

# debug: inspecionar tipos/atributos antes de desenhar
print("type(exp_sample):", type(exp_sample))
print("hasattr exp_sample.values:", hasattr(exp_sample, 'values'))
if hasattr(exp_sample, 'values'):
    try:
        print("exp_sample.values.shape:", exp_sample.values.shape)
    except Exception as e:
        print("could not get exp_sample.values.shape:", e)
print("type(exp_output):", type(exp_output))
print("hasattr exp_output.values:", hasattr(exp_output, 'values'))
if hasattr(exp_output, 'values'):
    try:
        print("exp_output.values.shape:", exp_output.values.shape)
    except Exception as e:
        print("could not get exp_output.values.shape:", e)

# o exp_output tem shape 1D em .values; o visualizador espera 2D (n_samples, n_features).
# Reconstruímos um Explanation com shapes 2D (1, n_features) usando os metadados
# do exp_output e os dados da amostra.
vals_2d = exp_output.values.reshape(1, -1)                 # (1, n_features)
base_1d = np.array([float(explainer.expected_value[output_idx])])
data_2d = X.iloc[[sample_idx]].values                      # (1, n_features)
feature_names = X.columns.tolist()

exp2 = shap.Explanation(values=vals_2d,
                        base_values=base_1d,
                        data=data_2d,
                        feature_names=feature_names)

# Alternativa: passar o Explanation de toda a saída (todos os samples x features)
# para o visualizador e deixar ele renderizar; isso normalmente é aceito.
try:
    # tentativa com a API legado `shap.force_plot` que aceita arrays e funciona em várias versões
    force_plot = shap.force_plot(float(explainer.expected_value[output_idx]),
                                shap_values.values[sample_idx, :, output_idx],
                                X.iloc[sample_idx, :])
    shap.save_html("explicacao_local.html", force_plot)
except Exception:
    # fallback: se falhar, tente passar o Explanation de todos os samples (última tentativa)
    exp_all_output = shap_values[..., output_idx]
    force_plot = shap.plots.force(float(explainer.expected_value[output_idx]), exp_all_output, X)
    shap.save_html("explicacao_local.html", force_plot)

print("✅ Análise concluída com sucesso!")
print("👉 Arquivos gerados:")
print(" - importancia_global.png (importância das variáveis)")
print(" - explicacao_local.html (explicação individual)")
