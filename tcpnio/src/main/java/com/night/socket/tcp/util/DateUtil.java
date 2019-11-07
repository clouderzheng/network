package com.night.socket.tcp.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author night
 * @version 1.1.0
 * @Date 2019/11/7 15:17
 */
public class DateUtil {


    /**
     * 获取格式化时间
     * @return
     */
    public static String getCurrentDateTime(){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.format(new Date());
    }

}
