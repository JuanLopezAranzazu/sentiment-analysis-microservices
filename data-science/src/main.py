from fastapi import FastAPI

app = FastAPI(
    title="Sentiment Analysis NLP Service",
    description="NLP microservice for sentiment classification",
    version="1.0.0"
)

@app.get("/health")
def health_check():
    return {"status": "UP"}
