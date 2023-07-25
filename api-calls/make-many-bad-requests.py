import multiprocessing
import requests

"""
Make a lot of requests with a very quick timeout. The goal is to trigger a 
ClientAbortException/closed pipe error from the server in order to trigger
a bug. 
"""

URL = 'http://localhost:8080/throw/illegal-argument-exception?waitForSeconds=5'


def make_request():
    requests.get(URL)


def main():
    for i in range(10):
        print(i)
        p = multiprocessing.Process(target=make_request)
        p.start()

        # Wait for 1 seconds or until process finishes
        p.join(1)

        # If thread is still active
        if p.is_alive():
            p.kill()
            p.join()


if __name__ == "__main__":
    main()
