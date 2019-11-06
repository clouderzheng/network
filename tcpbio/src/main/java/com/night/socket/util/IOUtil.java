package com.night.socket.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @author night
 * @version 1.1.0
 * @Date 2019/11/6 17:59
 */
public class IOUtil {

    /**
     * 读取 socket 信息
     * @param socket
     * @return
     * @throws Exception
     */
    public static String reader(Socket socket) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader( socket.getInputStream()));
        StringBuilder result = new StringBuilder();
        String param;
        while ((param = reader.readLine()) != null){
            result.append(param);
        }
        return result.toString();
    }

    /**
     * 输出信息
     * @param socket
     * @param param
     * @throws Exception
     */
    public static void writer(Socket socket,String param) throws Exception{
        PrintWriter writer = new PrintWriter(socket.getOutputStream());
        writer.println(param);
    }
}
