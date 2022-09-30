from lib2to3.pytree import Base
import requests

BASE = "http://127.0.0.1:5000/"

respone = requests.post(BASE + "helloworld?lang=en", {"lang":"en"})
print(respone.json())