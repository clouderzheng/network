package com.night.socket.tcp.nio;
/**
 * @author night
 * @version 1.1.0
 * @Date 2019/11/7 10:38
 */
public class Client {
    public static void main(String[] args) {
        try {

            Thread thread1 =  new Thread(new ClientThread("client no 1"));
            Thread thread2 =  new Thread(new ClientThread("client no 2"));

            thread1.start();
            thread2.start();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
