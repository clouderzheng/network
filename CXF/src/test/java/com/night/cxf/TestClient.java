package com.night.cxf;

import com.night.cxf.service.BusinessService;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

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
        JaxWsProxyFactoryBean factoryBean = new JaxWsProxyFactoryBean();
        factoryBean.setServiceClass(BusinessService.class);
        factoryBean.setAddress("http://localhost:9112/business");
        BusinessService businessService =  (BusinessService)factoryBean.create();
        String resp = businessService.echo("hello server  , i am cxf");
        System.out.println(resp);

    }
}
