__author__ = 'PrateekMehrotra'
import sys
time = input()
splitStr = time.split(':')
end = splitStr[len(splitStr)-1]
ampm = end[-2:]
if ampm == "PM":
    if int(splitStr[0]) != 12:
        newhhvalue = 12+int(splitStr[0])
    else:
        newhhvalue = int(splitStr[0])
    newmmvalue = splitStr[1]
    newssvalue = end[:2]
    sys.stdout.write("{}:{}:{}".format(str(newhhvalue),str(newmmvalue),str(newssvalue)))
elif ampm == "AM":
    if int(splitStr[0]) == 12:
        newhhvalue = 12-int(splitStr[0])
        newhhvalue = str(newhhvalue) + "0"
    else:
        newhhvalue = int(splitStr[0])
        if newhhvalue < 12:
            newhhvalue = "0" + str(newhhvalue)
    newmmvalue = splitStr[1]
    newssvalue = end[:2]
    sys.stdout.write("{0}:{1}:{2}".format(newhhvalue,str(newmmvalue),str(newssvalue)))




