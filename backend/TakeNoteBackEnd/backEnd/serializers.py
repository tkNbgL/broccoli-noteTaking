from rest_framework import serializers
from backEnd.models import TextNote

class TextNoteSerializer(serializers.ModelSerializer):
	class Meta:
		model = TextNote
		fields = ('id', 'subject', 'note')