from urllib import request, parse
import json

# doc elastic index cat sorting
# simple http server
# check https://docs.python.org/3/howto/urllib2.html
# https://requests.readthedocs.io/en/master/
# check basic and digest authentication
# do end2end tests with docker


def indexDoc(host, index, doc):
    req = request.Request(f'http://{host}/{index}/_doc',
                          data=json.dumps(doc).encode(),
                          headers={'Content-Type': 'application/json'},
                          method='POST')

    client = request.urlopen(req)
    print(client.read())
