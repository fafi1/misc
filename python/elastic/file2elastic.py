from urllib import request, parse
import json

def hello_elastic(message):
    doc = {
        'message': message,
        'host': 'localhost'
    }

    req = request.Request('http://localhost:9200/someindex/_doc',
                          data=json.dumps(doc).encode(),
                          headers={'Content-Type': 'application/json'},
                          method='POST')

    client = request.urlopen(req)
    print(client.read())


for i in range(100):
    hello_elastic('hi there ' + str(i))

