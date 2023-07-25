# Spring Rest Controller Advice Error

This is a minimal reproduction of an error I'm running into with Spring.

## Steps to reproduce

### Start the spring application
Navigate to the spring application directory:
```powershell
cd demo
```

Start the application:
```powershell
.\gradlew bootRun
```

### Run the poorly-behaved client
In a separate terminal window, navigate to the client directory
```powershell
cd api-calls
```

Create a virtual environment:
```powershell
python3 -m virtualenv venv
```

Activate the virtual environment (this may look slightly different on *nix machines):
```powershell
./venv/Scripts/activate
```

Install the requirements:
```powershell
pip install -r requirements.txt
```

Run the script:
```powershell
python make-many-bad-requests.py
```

Observe the error logs thrown in the first terminal :'(