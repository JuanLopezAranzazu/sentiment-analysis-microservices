import pandas as pd
import joblib

from sklearn.model_selection import train_test_split
from sklearn.feature_extraction.text import TfidfVectorizer
from sklearn.linear_model import LogisticRegression

from utils.preprocessing import clean_text
from config import DATA_PATH, MODEL_PATH, VECTORIZER_PATH

def train():
    df = pd.read_csv(DATA_PATH)

    df["clean_text"] = df["text"].apply(clean_text)

    X = df["clean_text"]
    y = df["sentiment"]

    X_train, X_test, y_train, y_test = train_test_split(
        X, y, test_size=0.2, random_state=42
    )

    vectorizer = TfidfVectorizer(
        ngram_range=(1, 2),
        max_features=15000,
        stop_words="english",
        min_df=2,
        sublinear_tf=True
    )
    X_train_vec = vectorizer.fit_transform(X_train)

    model = LogisticRegression(
        max_iter=2000,
        class_weight="balanced",
        solver="lbfgs"
    )
    model.fit(X_train_vec, y_train)

    joblib.dump(model, MODEL_PATH)
    joblib.dump(vectorizer, VECTORIZER_PATH)

    print("Modelo y vectorizador guardados exitosamente.")

if __name__ == "__main__":
    train()
