from .models import Question
from .serializers import QuestionSerializer
from rest_framework.viewsets import ModelViewSet

class QuestionViewSet(ModelViewSet):
    serializer_class = QuestionSerializer
    queryset = Question.objects.all()
