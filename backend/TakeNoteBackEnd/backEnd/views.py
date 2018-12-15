from django.shortcuts import render
from rest_framework.renderers import JSONRenderer
from rest_framework.parsers import JSONParser
from backEnd.models import TextNote
from backEnd.serializers import TextNoteSerializer
from django.http import HttpResponse, JsonResponse

# Create your views here.


def textNote_byId(request):
	if request.method == 'GET':
		textNotes = TextNote.objects.get(pk=1)
		serializer = TextNoteSerializer(textNotes, many=False)
		return JsonResponse(serializer.data, safe=False)

	elif request.method == 'POST':
		data = JSONParser().parse(request)
		serializer = TextNoteSerializer(data = data)
		if serializer.is_valid():
			serializer.save()
			return JsonResponse(serializer.data, status=201)
		return JsonResponse(serializer.errors, status=400)	