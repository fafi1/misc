import glob
import os

for f in glob.glob('/tmp/**', recursive=True):
    print(f)


def listDirs(path):
    for f in os.listdir(path):
        fullPath = os.path.join(path, f)
        if os.path.isdir(fullPath):
            listDirs(fullPath)
        print(fullPath)


listDirs('/tmp')
