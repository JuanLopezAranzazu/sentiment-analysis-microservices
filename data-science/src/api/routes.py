from fastapi import APIRouter
from pydantic import BaseModel
from ..services.sentiment_service import analyze_text

router = APIRouter(prefix="/api")

class TextRequest(BaseModel):
    text: str

class SentimentResponse(BaseModel):
    sentiment: str
    confidence: float

@router.post("/analyze", response_model=SentimentResponse)
def analyze(request: TextRequest):
    return analyze_text(request.text)
