package com.z.pc;

import java.io.IOException;
import java.net.ServerSocket;

public class pc2 {
    public void pc2() throws IOException {
        while (true){
            ServerSocket serverSocket = null;
            try {
                serverSocket = new ServerSocket(3256);
                serverSocket.accept().getOutputStream().write("啊hello".getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
            finally {
                if(serverSocket!=null)serverSocket.close();
            }
        }
    }

    public static void main(String[] args) {
        pc2 p2 = new pc2();
        try {
            p2.pc2();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
