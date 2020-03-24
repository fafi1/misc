from urllib import request


def get(url):
    response = request.urlopen(url)

    return str(response.read(), 'utf-8')


def post(url, body):
    req = request.Request(url,
                          data=body.encode(),
                          headers={'Content-Type': 'application/json'},
                          method='POST')

    client = request.urlopen(req)
    return str(client.read(), 'utf-8')
