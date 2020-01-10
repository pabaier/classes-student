from .models import Question
from rest_framework.serializers import ModelSerializer

class QuestionSerializer(ModelSerializer):
    class Meta:
        model = Question
        fields = "__all__"
