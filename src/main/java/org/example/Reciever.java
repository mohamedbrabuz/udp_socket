package org.example;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Reciever {
    public static void main(String[] args) {
        String ip="localhost";
        int port=1234;
        try {

    boolean ready=true;
            DatagramSocket socket = new DatagramSocket(1234);
            while(ready){
            byte[] buffer = new byte[65536];
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
            socket.receive(packet);
            byte[] fileContent = packet.getData();
            String fileName = "recieved";
            FileOutputStream f=new FileOutputStream(fileName+".txt");
                System.out.println("done with txt extention");
            f.write(fileContent);
            f.close();
            FileOutputStream f2=new FileOutputStream(fileName+".jpg");
            System.out.println("done with jpg extention");

            f2.write(fileContent);
            f2.close();
            }
            socket.close();
        } catch (SocketException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
