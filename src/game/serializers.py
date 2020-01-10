from .models import Game, Game_Question, Active_Game
from rest_framework import serializers

class GameSerializer(serializers.ModelSerializer):
	class Meta:
		model = Game
		fields = "__all__"