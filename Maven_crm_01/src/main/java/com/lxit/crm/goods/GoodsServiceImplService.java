
package com.lxit.crm.goods;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "GoodsServiceImplService", targetNamespace = "http://service.goods.lxit.com/", wsdlLocation = "http://192.168.18.89:8080/GoodsMe/getGoods?wsdl")
public class GoodsServiceImplService
    extends Service
{

    private final static URL GOODSSERVICEIMPLSERVICE_WSDL_LOCATION;
    private final static WebServiceException GOODSSERVICEIMPLSERVICE_EXCEPTION;
    private final static QName GOODSSERVICEIMPLSERVICE_QNAME = new QName("http://service.goods.lxit.com/", "GoodsServiceImplService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://192.168.18.89:8080/GoodsMe/getGoods?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        GOODSSERVICEIMPLSERVICE_WSDL_LOCATION = url;
        GOODSSERVICEIMPLSERVICE_EXCEPTION = e;
    }

    public GoodsServiceImplService() {
        super(__getWsdlLocation(), GOODSSERVICEIMPLSERVICE_QNAME);
    }

    public GoodsServiceImplService(WebServiceFeature... features) {
        super(__getWsdlLocation(), GOODSSERVICEIMPLSERVICE_QNAME, features);
    }

    public GoodsServiceImplService(URL wsdlLocation) {
        super(wsdlLocation, GOODSSERVICEIMPLSERVICE_QNAME);
    }

    public GoodsServiceImplService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, GOODSSERVICEIMPLSERVICE_QNAME, features);
    }

    public GoodsServiceImplService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public GoodsServiceImplService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns GoodsServiceImpl
     */
    @WebEndpoint(name = "GoodsServiceImplPort")
    public GoodsServiceImpl getGoodsServiceImplPort() {
        return super.getPort(new QName("http://service.goods.lxit.com/", "GoodsServiceImplPort"), GoodsServiceImpl.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns GoodsServiceImpl
     */
    @WebEndpoint(name = "GoodsServiceImplPort")
    public GoodsServiceImpl getGoodsServiceImplPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://service.goods.lxit.com/", "GoodsServiceImplPort"), GoodsServiceImpl.class, features);
    }

    private static URL __getWsdlLocation() {
        if (GOODSSERVICEIMPLSERVICE_EXCEPTION!= null) {
            throw GOODSSERVICEIMPLSERVICE_EXCEPTION;
        }
        return GOODSSERVICEIMPLSERVICE_WSDL_LOCATION;
    }

}
