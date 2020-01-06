import elastic.elasticStore
import glob


def send2elastic(elasticHost, index, fileName):
    doc = {
        'fileName': fileName,
        'host': 'localhost'
    }

    elastic.elasticStore.indexDoc(elasticHost, index, doc)


for f in glob.glob('/home/vagrant/ops/**', recursive=True):
    send2elastic('localhost:9200', 'files', f)
