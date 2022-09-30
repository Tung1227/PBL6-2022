import easyocr 
import cv2


reader = easyocr.Reader(['vi'],gpu=False)
result = reader.readtext('s.png')
for (box,text,prob) in result:
    [tl,tr,br,bl] = box
    print(text)