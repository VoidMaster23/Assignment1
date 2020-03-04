import subprocess
from random import seed
from random import randint

seed(1)

outFile = open('../testOut/BSTArrayTest.txt','w')
path = '../res/'
n = 297

for i in range(10):
    print(n)
    fileN = 'input'+str((i+1))+'.txt'
    f = open(path+fileN, 'r')
    fl = f.readlines()
    line = 'Find operations for '+str(n)+' data items: '
    for j in range (100):
        rand = randint(0,n)
        key =fl[rand].split(" ")[0]
        params = key.split("_")

        p1 = subprocess.run(['java','LSArrayApp',params[0], params[1], params[2], fileN ], capture_output=True, text=True)
        print(j)
        if j< (99):
            line+=p1.stdout+", "
        else:
            line+=p1.stdout+'\n'
    outFile.write(line)
    n+= 297
outFile.close()
