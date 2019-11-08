package com.night.cxf;

import com.night.cxf.service.BusinessService;
import com.night.cxf.service.impl.BusinessServiceImpl;
import org.apache.cxf.jaxws.JaxWsServerFactoryBean;

import javax.xml.ws.Endpoint;

/**
 * @author night
 * @version 1.1.0
 * @Date 2019/11/7 17:57
 */
public class TestServer {

    /**
     * 服务端代码测试
     * @param args
     */
    public static void main(String[] args) {
        BusinessService businessService = new BusinessServiceImpl();
        JaxWsServerFactoryBean factoryBean = new JaxWsServerFactoryBean();
        factoryBean.setServiceClass(BusinessService.class);
        factoryBean.setAddress("http://localhost:9112/business");
        factoryBean.setServiceBean(businessService);
        factoryBean.create();
//        BusinessService businessService = new BusinessServiceImpl();
//        Endpoint.publish("http://localhost:9112/business",businessService);
//        System.out.println("server start");
    }
}
