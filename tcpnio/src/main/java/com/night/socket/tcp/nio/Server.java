package com.night.socket.tcp.nio;

import com.night.socket.tcp.util.ChannelUtil;

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.channels.*;

/**
 * @author night
 * @version 1.1.0
 * @Date 2019/11/7 11:14
 */
public class Server {

    public static void main(String[] args) {
        try {
            Selector selector = Selector.open();
            //打开服务端连接 监听客户端连接
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            //设置为非阻塞  多路复用
            serverSocketChannel.configureBlocking(false);
            ServerSocket server = serverSocketChannel.socket();
            //绑定端口
            server.bind(new InetSocketAddress(9112),1024);
            //注册selector轮询
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
            //创建消息处理器
            System.out.println("*********服务端连接开启*********");
            while(true){
                ChannelUtil.handlerSelector(selector,"server");
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
