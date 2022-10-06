import random
import numpy
list = []
i = 0
while i<=9:
    randomValue = random.randint(-100,100)
    list.append(randomValue)
    for i in range(len(list)):
        for j in range(i+1,len(list)):
            if list[i] > list[j]:
                    list[i],list[j] = list[j],list[i]
    
    vector = numpy.array(list)
    print("List: ",list)
    print("Vector: ",vector)
    i = i+1
