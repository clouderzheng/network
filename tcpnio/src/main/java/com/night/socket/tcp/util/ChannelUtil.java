package com.night.socket.tcp.util;

import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @author night
 * @version 1.1.0
 * @Date 2019/11/7 14:36
 */
public class ChannelUtil {


    /**
     * 轮询 selector  处理 连接请求
     * @param selector
     * @param point
     */
    public static void handlerSelector(Selector selector,String point){
        try {
            //selector 每秒唤醒一次查询
            selector.select(5000);
            //轮询准备就绪的key
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = selectionKeys.iterator();
            SelectionKey selectionKey = null;
            //遍历key
            while(iterator.hasNext()){
                selectionKey = iterator.next();
                //当前key处理过后 移除掉
                iterator.remove();
                try {
                    handlerKey(selectionKey,selector,point );
                } catch (Exception e) {
                    e.printStackTrace();
                    selectionKey.cancel();
                    selectionKey.channel().close();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * 处理连接会话
     * @param selectionKey
     * @param selector
     */
    public static void handlerKey(SelectionKey selectionKey, Selector selector,String point){
        //判断key是否有效
        if(!selectionKey.isValid()){
            return ;
        }
        //判断是否tcp 握手连接
        if(selectionKey.isAcceptable()){
            ServerSocketChannel serverSocketChannel = (ServerSocketChannel) selectionKey.channel();
            try {
                SocketChannel socketChannel = serverSocketChannel.accept();
                //建立物理连接 设置客户端请求非阻塞
                socketChannel.configureBlocking(false);
                socketChannel.register(selector,SelectionKey.OP_READ);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else if(selectionKey.isReadable()){//判断消息是否读取类型

            SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            try {
                int readBytes = socketChannel.read(buffer);
                if(readBytes > 0){
                    buffer.flip();
                    byte[] bytes = new byte[buffer.remaining()];
                    buffer.get(bytes);
                    String info = new String(bytes);
                    System.out.println("receive info from "+point+" -->"+info);

                    write(socketChannel,"***hello  " +point+"***");
                }else if(readBytes < 0){
                    selectionKey.cancel();;
                    socketChannel.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else if(selectionKey.isConnectable()){
            try {
                SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
                if(socketChannel.finishConnect()){
                    socketChannel.register(selector,SelectionKey.OP_READ);
                    write(socketChannel,"***hello  " +point+"***");
                }else{
                    System.out.println("异常退出");
                    System.exit(1);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 发送消息
     * @param channel
     * @param response
     */
    public static void write(SocketChannel channel,String response){

        try {
            response = "time : "+DateUtil.getCurrentDateTime() +" **" +response;
            byte[] bytes = response.getBytes();
            ByteBuffer writeBuffer = ByteBuffer.allocate(bytes.length);
            writeBuffer.put(bytes);
            writeBuffer.flip();
            channel.write(writeBuffer);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
