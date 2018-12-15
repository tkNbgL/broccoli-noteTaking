from rest_framework import serializers
from takeNoteBackend.models import TextNote

class TextNoteSerializer(serializers.ModelSerializer):
	class Meta:
		model = TextNote
		fields = ('id','subject','note')