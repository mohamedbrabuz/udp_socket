package org.example;

import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Sender {
    public static void main(String[] args) {
    StringBuilder s=new StringBuilder();
    BufferedReader br = null;
    String str ;
    try {
        //new file reader
        br = new BufferedReader(new FileReader("txt.txt"));
        while((str = br.readLine()) != null){
            s.append(str + "\n");
        }
        int port =1234;
        DatagramSocket socket = new DatagramSocket();
        s.deleteCharAt(s.length()-1);
        str= String.valueOf(s);
        byte [] message=str.getBytes();
        InetAddress ip=InetAddress.getByName("localhost");
        DatagramPacket p=new DatagramPacket(message,message.length, ip,port);
        socket.send(p);
    }catch(Exception e){
        e.printStackTrace();
        }
    }

    public String read(InputStream inputStream){
        BufferedReader b=new BufferedReader(new InputStreamReader( inputStream));
        return "";
    }
}