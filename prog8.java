import java.net.*;

public class UDPServer {
    public static void main(String[] args) throws Exception {
        
        DatagramSocket serverSocket = new DatagramSocket(9876);
        byte[] receiveBuffer = new byte[1024];
        byte[] sendBuffer;

        System.out.println("Server Started... Waiting for client message...\n");

        while (true) {
            DatagramPacket packet = new DatagramPacket(receiveBuffer, receiveBuffer.length);
            serverSocket.receive(packet);

            String data = new String(packet.getData()).trim();
            System.out.println("Received from client: " + data);

            String reply = data.toUpperCase();
            sendBuffer = reply.getBytes();

            DatagramPacket sendPacket = new DatagramPacket(sendBuffer, sendBuffer.length,
                    packet.getAddress(), packet.getPort());

            serverSocket.send(sendPacket);
        }
    }
}

import java.net.*;
import java.io.*;

public class UDPClient {
    public static void main(String[] args) throws Exception {

        DatagramSocket clientSocket = new DatagramSocket();
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        InetAddress serverAddress = InetAddress.getByName("localhost");

        System.out.println("Enter a line of text in lowercase:");
        String message = input.readLine();

        byte[] sendBuffer = message.getBytes();
        byte[] receiveBuffer = new byte[1024];

        DatagramPacket sendPacket = new DatagramPacket(sendBuffer, sendBuffer.length, serverAddress, 9876);
        clientSocket.send(sendPacket);

        DatagramPacket receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);
        clientSocket.receive(receivePacket);

        String serverReply = new String(receivePacket.getData()).trim();
        System.out.println("\nFROM SERVER: " + serverReply);

        clientSocket.close();
    }
}
