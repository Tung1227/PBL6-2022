from email.mime import image
from flask import Flask, jsonify, request
from flask_restful import Resource, Api, reqparse
from numpy import array, imag
from easy_ocr_api import *
  
# creating a Flask app
app = Flask(__name__)
api = Api(app)

class ConvertImage(Resource):
    def get(self,num):
        print(num)
        return {"data": "Hello World!"}
    def post(self):
        #get params 
        file = request.args.get("listFile")
        #call convert function
        convert_image(file)
        return {"status": "ok"}

api.add_resource(ConvertImage, "/convert/vi")

if __name__ == "__main__":
    app. run(debug=True)