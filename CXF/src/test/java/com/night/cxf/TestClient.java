package com.night.cxf;

import com.night.cxf.service.BusinessService;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxws.JaxWsClientFactoryBean;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.jaxws.JaxWsServerFactoryBean;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;

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

        staticClient();

        dynamicClient();
    }

    /**
     * 静态调用
     */
    private static void staticClient(){
        JaxWsProxyFactoryBean factoryBean = new JaxWsProxyFactoryBean();
        factoryBean.setServiceClass(BusinessService.class);
        factoryBean.setAddress("http://localhost:9112/business");
        BusinessService businessService =  (BusinessService)factoryBean.create();
        String resp = businessService.echo("hello server  , i am static ");
        System.out.println(resp);
    }

    /**
     * 动态调用
     */
    private static void dynamicClient(){
        JaxWsDynamicClientFactory factory = JaxWsDynamicClientFactory.newInstance();
        Client client = factory.createClient("http://127.0.0.1:9112/business?wsdl");
        try {
            Object[] invoke = client.invoke("echo", "hello i am dynamic");
            System.out.println("resp -- >" + invoke[0]);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
