from .models import Question, Question_Game, Question_Answer_Option
from rest_framework.serializers import ModelSerializer

class QuestionSerializer(ModelSerializer):
    class Meta:
        model = Question
        fields = "__all__"

class QuestionGameSerializer(ModelSerializer):
    class Meta:
        model = Question_Game
        fields = "__all__"

class QuestionAnswerOptionSerializer(ModelSerializer):
    class Meta:
        model = Question_Answer_Option
        fields = "__all__"