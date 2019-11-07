package com.night.cxf;

import org.apache.cxf.jaxws.JaxWsServerFactoryBean;

/**
 * @author night
 * @version 1.1.0
 * @Date 2019/11/7 17:58
 */
public class TestClient {

    /**
     * 客户端代码测试
     * @param args
     */
    public static void main(String[] args) {
        JaxWsServerFactoryBean factoryBean = new JaxWsServerFactoryBean();
        factoryBean.setServiceClass(BusinessService.class);
        factoryBean.setAddress("http://localhost:9112/business");
        BusinessService businessService =  (BusinessService)factoryBean.create();
        businessService.echo("hello server  , i am cxf");

    }
}
