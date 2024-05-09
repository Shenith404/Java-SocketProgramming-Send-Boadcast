# Server Broadcasting with LAN IP Address

This Java application demonstrates how to implement server broadcasting using UDP to announce the server's presence on the local area network (LAN) along with its LAN IP address.

## Features

- Server application broadcasts its presence on the LAN using UDP.
- Client application listens for broadcast messages and discovers available servers on the LAN.
- Server IP address displayed in the broadcast message is the LAN IP address.

## Prerequisites

- Java Development Kit (JDK) installed on your system.
- Basic understanding of Java programming.

## How to Use

### Server

1. Compile the `Server.java` file: `javac Server.java`.
2. Run the server application: `java Server`.
3. The server will start listening for connections on port 1234 and broadcast its presence on the LAN.

### Client

1. Compile the `Client.java` file: `javac Client.java`.
2. Run the client application: `java Client`.
3. The client will listen for broadcast messages and display the discovered servers along with their LAN IP addresses.

## Additional Notes

- The server broadcasting functionality uses UDP broadcasting to announce its presence.
- The LAN IP address of the server is determined dynamically using the `NetworkInterface` class.
- You may need to turn off your firewall.



