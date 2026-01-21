import pandas as pd
import joblib

from sklearn.metrics import classification_report, confusion_matrix
from utils.preprocessing import clean_text
from config import DATA_PATH, MODEL_PATH, VECTORIZER_PATH

def evaluate():
    df = pd.read_csv(DATA_PATH)

    df["clean_text"] = df["text"].apply(clean_text)

    X = df["clean_text"]
    y = df["sentiment"]

    model = joblib.load(MODEL_PATH)
    vectorizer = joblib.load(VECTORIZER_PATH)

    X_vec = vectorizer.transform(X)
    predictions = model.predict(X_vec)

    print("\nInforme de Clasificación:\n")
    print(classification_report(y, predictions))

    print("\nMatriz de Confusión:\n")
    print(confusion_matrix(y, predictions))

if __name__ == "__main__":
    evaluate()
