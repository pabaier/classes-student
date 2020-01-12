from .models import Game, Game_Question, Active_Game
from rest_framework import serializers

class GameGetSerializer(serializers.ModelSerializer):
	class Meta:
		model = Game
		fields = "__all__"

class GameEditSerializer(serializers.ModelSerializer):
	class Meta:
		model = Game
		exclude = ("creator",)