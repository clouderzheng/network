package com.night.webservice;

/**
 * @author night
 * @version 1.1.0
 * @Date 2019/11/7 17:10
 */
public class Client {
    public static void main(String[] args) {
        Businessimpl business = new Businessimpl();
        Business businessPort = business.getBusinessPort();
        businessPort.echo("hello im webservice client ");
    }
}
