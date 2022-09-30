import cv2
import pytesseract

pytesseract.pytesseract.tesseract_cmd = "C:\\Program Files\\Tesseract-OCR\\tesseract.exe"
img = cv2.imread('s.png')
hImg, wImg,_ = img.shape
boxes = pytesseract.image_to_boxes(img)

data = pytesseract.image_to_data(img) 
print(data)
for b in boxes.splitlines():
    b = b.split(' ')
    x,y,w,h = int(b[1]), int(b[2]), int(b[3]), int(b[4])
    cv2.rectangle(img, (x, hImg-y),(w, hImg-h),(0,0,255),3)
    cv2.putText(img, b[0],(x,hImg-y+25,), cv2.FONT_HERSHEY_COMPLEX_SMALL,1,(50,50,255),2)
cv2.imshow('imge',img)
cv2.waitKey()
