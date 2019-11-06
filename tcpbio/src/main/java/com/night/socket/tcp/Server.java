package com.night.socket.tcp;

import com.night.socket.util.IOUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author night
 * @version 1.1.0
 * @Date 2019/11/6 17:55
 */
public class Server {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(9112);
        System.out.println("等待客服端发送信息-----------------");
        while (true){//这里用true  反复轮询信息
            Socket socket = server.accept();
            InputStream inputStream = socket.getInputStream();
            byte[] buffer = new byte[1024];
            int len = inputStream.read(buffer);
            String str = new String(buffer);
            System.out.println(str);
        }
    }

}
