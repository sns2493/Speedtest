Clone this repository and perform the following steps:

In the server:
1. run **launch_server.sh**. It will prompt you for the port at which the server will listen to tcp requests.
2. enter a port number and use the same for the client.
3. Alternatively run the server program from the command line as follows:
```
java socket_server
```

In the client:
1. Edit **launch_client.sh** and input the IP address and port number of the server in the respective placeholders.
2. Run **launch_client.sh** and it will print the Upload and Download Speed in the terminal.
3. Alternatively, run the client program from the command line as follows:
```
java socket_client <Server IP Address> <port number>
```