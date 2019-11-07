package com.night.cxf.service.impl;

import com.night.cxf.service.BusinessService;
import org.apache.cxf.jaxws.JaxWsServerFactoryBean;

import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * @author night
 * @version 1.1.0
 * @Date 2019/11/7 17:41
 */
@WebService(serviceName = "hello",endpointInterface = "com.night.cxf.service.BusinessService")
public class BusinessServiceImpl implements BusinessService {
    public String echo(@WebParam(name = "param")String param) {

        if("quit".equalsIgnoreCase(param)){
            System.out.println("server will quit'");
            System.exit(0);
        }
        System.out.println("param from client --->"+param);
        return "hello client";
    }


}
