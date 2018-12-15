from django.urls import path
from backEnd import views

urlpatterns = [
	path('takeNote/', views.textNote_byId),
]