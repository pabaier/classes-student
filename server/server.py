import aiohttp
from aiohttp import web
import argparse

async def handle(request):
    name = request.match_info.get('name', "World!")
    text = "hello, " + name
    print('received request, replaying with "{}".'.format(text))
    return web.Response(text=text)

async def handlePost(request):
    print('handling post request')
    if request.body_exists:
        b = await request.json()
    try:
        print(b['hi'])
    except:
        print('json hi not defined')
    async with aiohttp.ClientSession() as session:
        async with session.get('http://localhost:' + str(args.rport)) as resp:
            print(resp.status)
            print(await resp.text())
    return web.Response(text='ok')

parser = argparse.ArgumentParser(description='small http server')
parser.add_argument('-port', type=int, help='port for this server to run')
parser.add_argument('-rport', type=int, help='port another server is running on')
args = parser.parse_args()

app = web.Application()
app.router.add_get('/', handle)
app.router.add_get('/{name}', handle)
app.router.add_post('/send',handlePost)

web.run_app(app, port=args.port)
