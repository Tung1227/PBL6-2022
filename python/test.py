# import os
# path = "C:\\Tung\\nam4\\pbl6\\samples-full\\samples-full\\"



# list = os.listdir(path)
# i = 0

# for x in os.listdir(path):
#         listname = x.split('-')
#         os.rename(path+x,path+ str(i) + listname[0])
#         i+=1

IMAGE_PATH = "C:\\Tung\\nam4\\pbl6\\python\\image\\"
TEXT_PATH = "C:\\Tung\\nam4\\pbl6\\python\\text\\"

f = open(TEXT_PATH + 'a.txt', 'w', encoding="utf-8")
#remove all content in file
f.truncate()