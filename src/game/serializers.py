from game.models import Question, Game, Game_Question, Active_Game
from rest_framework import serializers

class QuestionSerializer(serializers.HyperlinkedModelSerializer):
    class Meta:
        model = Question
        fields = ['text', 'a', 'b', 'c', 'd', 'answer', 'public', 'category', 'creator_user_id']
