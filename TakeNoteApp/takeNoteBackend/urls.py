from django.urls import path
from takeNoteBackend import views

urlpatterns = [
	path('takeNote/', views.textNote_byId),
]