from .models import Game, Active_Game, Option, Game_Option
from rest_framework import serializers

class GameSerializer(serializers.ModelSerializer):
	class Meta:
		model = Game
		fields = "__all__"
		read_only_fields = ("creator",)

class ActiveGameSerializer(serializers.ModelSerializer):
	class Meta:
		model = Active_Game
		fields = "__all__"

class OptionSerializer(serializers.ModelSerializer):
	class Meta:
		model: Option
		fields = "__all__"

class GameOptionSerializer(serializers.ModelSerializer):
	class Meta:
		model: Game_Option
		fields = "__all__"