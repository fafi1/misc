from urllib import request


def get(url):
    response = request.urlopen(url)

    return str(response.read(), 'utf-8')
