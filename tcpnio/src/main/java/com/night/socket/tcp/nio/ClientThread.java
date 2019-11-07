package com.night.socket.tcp.nio;

import com.night.socket.tcp.util.ChannelUtil;

import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;

/**
 * @author night
 * @version 1.1.0
 * @Date 2019/11/7 15:22
 */
public class ClientThread implements Runnable{

    private String clientName ;

    public ClientThread(String clientName) {
        this.clientName = clientName;
    }

    public void run() {
        try {
            Selector selector = Selector.open();
            SocketChannel channel = SocketChannel.open();
            channel.configureBlocking(false);
            SocketAddress address = new InetSocketAddress("127.0.0.1",9112);
            //判断是否连接成功，如果连接成功，则直接注册读状态位到多路复用器中，
            if(channel.connect(address)){
                channel.register(selector, SelectionKey.OP_READ);
                ChannelUtil.write(channel,clientName);
                //设置为非阻塞模式
            }else{//如果当前没有连接成功 向Reactor线程的多路复用器注册OP_CONNECT状态位，监听服务端的TCP ACK应答
                channel.register(selector, SelectionKey.OP_CONNECT);
            }
            System.out.println("*********客户端连接开启*********");
            while (true){
                Thread.sleep(5000);
                ChannelUtil.handlerSelector(selector,clientName);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
