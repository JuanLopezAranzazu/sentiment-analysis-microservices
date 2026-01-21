import joblib
from pathlib import Path
from ..utils.preprocessing import clean_text

BASE_DIR = Path(__file__).resolve().parents[2]

model = joblib.load(BASE_DIR / "models/sentiment_model.pkl")
vectorizer = joblib.load(BASE_DIR / "models/vectorizer.pkl")

def analyze_text(text: str):
    cleaned = clean_text(text)
    X = vectorizer.transform([cleaned])

    prediction = model.predict(X)[0]
    score = model.predict_proba(X).max()

    return {
        "sentiment": prediction,
        "confidence": round(float(score), 4)
    }
