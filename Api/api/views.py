from django.http import JsonResponse
from rest_framework import status
from . import service
from django.views.decorators.csrf import csrf_exempt
from rest_framework.views import APIView

class convertImage(APIView):
    @csrf_exempt
    def convert(request):
        print('POST', request.POST)
        post_data = request.POST.copy()
        name = post_data.get("name")
        print(name)
        if name != "":
            #insert inage name in name param
            service.convert_image(name)

            return JsonResponse({
                'message': 'Convert success!'
            }, status=status.HTTP_201_CREATED)

        return JsonResponse({
            'message': 'Create a new Car unsuccessful!'
        }, status=status.HTTP_400_BAD_REQUEST)

# Create your views here.
