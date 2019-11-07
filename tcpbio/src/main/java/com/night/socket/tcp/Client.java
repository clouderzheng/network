package com.night.socket.tcp;

import com.night.socket.util.IOUtil;

import java.io.*;
import java.net.Socket;

/**
 * @author night
 * @version 1.1.0
 * @Date 2019/11/6 17:47
 */
public class Client {

    public static void main(String[] args) {
        try {
            // 要连接的服务端IP地址和端口
            Socket client = new Socket("127.0.0.1",9112);
            //发送消息
            PrintWriter writer = new PrintWriter(client.getOutputStream());
            writer.write("hello server");
            client.close();
            writer.close();
            System.out.println("发送信息完毕");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
