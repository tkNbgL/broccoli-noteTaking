from django.db import models

# Create your models here.
class TextNote(models.Model):
	subject = models.CharField(max_length=20)
	note = models.TextField(max_length=200)
