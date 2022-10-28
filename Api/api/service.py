import easyocr 

IMAGE_PATH = "C:\\Tung\\nam4\\pbl6\\repo\\python\\image\\"
TEXT_PATH = "C:\\Tung\\nam4\\pbl6\\repo\\python\\text\\"
reader = easyocr.Reader(['vi'],gpu=False)

def convert_image(file):
    #get name of image file
    element = file.split('.')
    prefix = ''
    # get prefix of image's name to create txt file
    for i in range(len(element)-1):
        prefix += element[i]
    #create new file or read an exist file
    f = open(TEXT_PATH + prefix +'.txt', 'w', encoding="utf-8")
    #remove all content in file
    f.truncate()
    #read text in image
    result = reader.readtext(IMAGE_PATH + file)
    #write into file
    for (box,text,prob) in result:
        f.write(text + '\n')
    f.close()