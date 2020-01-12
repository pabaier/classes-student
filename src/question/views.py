from .models import Question, Question_Game, Question_Answer_Option
from .serializers import QuestionSerializer, QuestionGameSerializer, QuestionAnswerOptionSerializer
from rest_framework.viewsets import ModelViewSet
from rest_framework.permissions import IsAuthenticated

class QuestionViewSet(ModelViewSet):
    serializer_class = QuestionSerializer
    queryset = Question.objects.all()
    permission_classes = (IsAuthenticated,)

class QuestionGameViewSet(ModelViewSet):
    serializer_class = QuestionGameSerializer
    queryset = Question_Game.objects.all()
    permission_classes = (IsAuthenticated,)

class QuestionAnswerOptionViewSet(ModelViewSet):
    serializer_class = QuestionAnswerOptionSerializer
    queryset = Question_Answer_Option.objects.all()
    permission_classes = (IsAuthenticated,)
