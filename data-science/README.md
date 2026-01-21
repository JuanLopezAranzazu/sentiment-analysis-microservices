# Data Science

## Preparación del entorno

Para el entorno virtual
```bash
python -m venv .venv
source .venv/bin/activate   # Linux/Mac
.venv\Scripts\activate      # Windows
```

Para instalar dependencias
```bash
pip install -r requirements.txt
```

## Ejecución

Para entrenar el modelo
```bash
python src/train.py
```

Para evaluar el modelo
```bash
python src/evaluate.py
```

Para correr el programa usar el siguiente comando:
```bash
uvicorn src.main:app --reload
```
