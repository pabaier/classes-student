import requests
import threading 

session = requests.Session()
# adapter = requests.adapters.HTTPAdapter(
#     pool_connections=100,
#     pool_maxsize=100)
# session.mount('http://', adapter)
# response = session.get("http://localhost:8080")

def send():
	while True:
		session.get("http://localhost:8080")

# # t = []
# # for i in range (1,100):

while True:
	t = threading.Thread(target=send)
	t.start()



# for thred in t:
#     thred.start() 
    # thred.join() 
  
print("Done!") 