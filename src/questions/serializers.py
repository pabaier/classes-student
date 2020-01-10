from questions.models import Question
from rest_framework import serializers

class QuestionSerializer(serializers.HyperlinkedModelSerializer):
    creator_id = serializers.PrimaryKeyRelatedField(many=False, queryset=Question.objects.all())

    class Meta:
        model = Question
        fields = ['id', 'text', 'a', 'b', 'c', 'd', 'answer', 'public', 'category', 'creator_id']
