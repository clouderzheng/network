
package com.night.webservice;

import javax.xml.namespace.QName;
import javax.xml.ws.*;
import java.net.MalformedURLException;
import java.net.URL;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "Businessimpl", targetNamespace = "com.night.webservice.service.Business/client", wsdlLocation = "http://localhost:9112/Businessimpl?wsdl")
public class Businessimpl
    extends Service
{

    private final static URL BUSINESSIMPL_WSDL_LOCATION;
    private final static WebServiceException BUSINESSIMPL_EXCEPTION;
    private final static QName BUSINESSIMPL_QNAME = new QName("com.night.webservice.service.Business/client", "Businessimpl");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:9112/Businessimpl?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        BUSINESSIMPL_WSDL_LOCATION = url;
        BUSINESSIMPL_EXCEPTION = e;
    }

    public Businessimpl() {
        super(__getWsdlLocation(), BUSINESSIMPL_QNAME);
    }

    public Businessimpl(WebServiceFeature... features) {
        super(__getWsdlLocation(), BUSINESSIMPL_QNAME, features);
    }

    public Businessimpl(URL wsdlLocation) {
        super(wsdlLocation, BUSINESSIMPL_QNAME);
    }

    public Businessimpl(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, BUSINESSIMPL_QNAME, features);
    }

    public Businessimpl(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public Businessimpl(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns Business
     */
    @WebEndpoint(name = "BusinessPort")
    public Business getBusinessPort() {
        return super.getPort(new QName("com.night.webservice.service.Business/client", "BusinessPort"), Business.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns Business
     */
    @WebEndpoint(name = "BusinessPort")
    public Business getBusinessPort(WebServiceFeature... features) {
        return super.getPort(new QName("com.night.webservice.service.Business/client", "BusinessPort"), Business.class, features);
    }

    private static URL __getWsdlLocation() {
        if (BUSINESSIMPL_EXCEPTION!= null) {
            throw BUSINESSIMPL_EXCEPTION;
        }
        return BUSINESSIMPL_WSDL_LOCATION;
    }

}
