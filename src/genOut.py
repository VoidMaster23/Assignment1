import subprocess

outFile = open('../testOut/BSTArrayTest.txt','w')
path = '../res/'
n = 297

for i in range(10):
    fileN = 'input'+str((i+1))+'.txt'
    f = open(path+fileN, 'r')
    fl = f.readlines()
    line = 'Find operations for '+str(n)+'data items: '
    for x in range(len(fl)):
        key =fl[x].split(" ")[0]
        params = key.split("_")

        p1 = subprocess.run(['java','LSArrayApp',params[0], params[1], params[2], fileN ], capture_output=True, text=True)
        if x< (len(fl)-1):
            line+=p1.stdout+", "
        else:
            line+=p1.stdout+'\n'
    outFile.write(line)
    n+= 297
outFile.close()
