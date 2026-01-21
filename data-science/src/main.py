from fastapi import FastAPI
from src.api.routes import router

app = FastAPI(
    title="Sentiment Analysis Service",
    version="1.0.0",
    description="API para análisis de sentimientos utilizando un modelo entrenado de regresión logística.",
)

app.include_router(router)

@app.get("/")
def read_root():
    return {"message": "Bienvenido al servicio de análisis de sentimientos"}

@app.get("/health")
def health():
    return {"status": "ok"}
