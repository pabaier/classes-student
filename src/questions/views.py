from django.shortcuts import render
from questions.models import Question
from questions.serializers import QuestionSerializer
from rest_framework import viewsets, generics

class QuestionsViewSet(viewsets.ModelViewSet):
    """
    API endpoint that allows questions to be viewed or edited.
    """
    queryset = Question.objects.all()
    serializer_class = QuestionSerializer

    def create(self, request):
        print("*****************************")
        pass

class QuestionViewSet(viewsets.ModelViewSet):
    """
    API endpoint that allows questions to be viewed or edited.
    """
    serializer_class = QuestionSerializer

    def list(self, request):
        print('yeaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa')
        pk = self.kwargs['pk']
        return Question.objects.filter(id=pk)

#     def create(self, validated_data):
#         a = validated_data.get("hi", None)
#         logger.info(a)
#         return Question.objects.all()
