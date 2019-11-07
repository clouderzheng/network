package com.night.webservice.service.impl;

import com.night.webservice.service.Business;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.ws.Endpoint;

/**
 * @author night
 * @version 1.1.0
 * @Date 2019/11/7 17:01
 */
@WebService(name = "Business",serviceName = "Businessimpl",targetNamespace = "com.night.webservice.service.Business/client")
@SOAPBinding(style = SOAPBinding.Style.RPC)
public class Businessimpl implements Business {

    public String echo(String message) {
        if("quit".equalsIgnoreCase(message)){
            System.out.println("server will quit ");
            System.exit(0);
        }
        System.out.println("message form client " + message);
        return message;
    }

    public static void main(String[] args) {
        Endpoint.publish("http://localhost:9112/Businessimpl",new Businessimpl());
        System.out.println("server has been started");
    }
}
