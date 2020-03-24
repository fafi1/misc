from http import server


class Handler(server.BaseHTTPRequestHandler):
    def do_GET(self):
        self.send_response(200)
        self.send_header('Content-type','text/html')
        self.end_headers()
        # Send the html message
        self.wfile.write(b"Hello World !")
        return


def run(server_class=server.HTTPServer, handler_class=server.BaseHTTPRequestHandler):
    server_address = ('', 8000)
    httpd = server_class(server_address, Handler)
    httpd.serve_forever()


run()

