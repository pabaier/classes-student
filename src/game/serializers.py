from .models import Game, ActiveGame, Option, GameOption
from rest_framework import serializers


class GameSerializer(serializers.ModelSerializer):
    class Meta:
        model = Game
        fields = "__all__"
        read_only_fields = ("creator",)


class ActiveGameSerializer(serializers.ModelSerializer):
    class Meta:
        model = ActiveGame
        fields = "__all__"


class OptionSerializer(serializers.ModelSerializer):
    class Meta:
        model: Option
        fields = "__all__"


class GameOptionSerializer(serializers.ModelSerializer):
    class Meta:
        model: GameOption
        fields = "__all__"
