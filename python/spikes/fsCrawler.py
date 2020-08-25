import elastic.elasticStore
import glob
import sys
import os
import time

path = sys.argv[1]


def send2elastic(elasticHost, index, fileName):
    doc = {
        'fileName': fileName,
        'host': 'localhost'
    }

    elastic.elasticStore.indexDoc(elasticHost, index, doc)


def findAndSend():
    for f in glob.glob('/tmp/**', recursive=True):
        send2elastic('localhost:9200', 'files', f)


def find_n_analyze(path):
    for f in glob.glob(f'{path}**', recursive=True):
        if os.path.isfile(f):
            fsize = os.path.getsize(f)
            ctime = int(os.path.getctime(f))
            print(os.path.dirname(f) + ' ' + os.path.basename(f) + ' ' + str(fsize) + ' ' + str(ctime) + ' ' + time.strftime('%Y-%m-%dT%H:%M:%S%z'))


find_n_analyze(path)

