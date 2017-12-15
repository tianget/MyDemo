
package com.lxit.crm.goods;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "GoodsServiceImpl", targetNamespace = "http://service.goods.lxit.com/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface GoodsServiceImpl {


    /**
     * 
     * @param arg0
     * @return
     *     returns com.lxit.crm.goods.Goods
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "selectByGid", targetNamespace = "http://service.goods.lxit.com/", className = "com.lxit.crm.goods.SelectByGid")
    @ResponseWrapper(localName = "selectByGidResponse", targetNamespace = "http://service.goods.lxit.com/", className = "com.lxit.crm.goods.SelectByGidResponse")
    @Action(input = "http://service.goods.lxit.com/GoodsServiceImpl/selectByGidRequest", output = "http://service.goods.lxit.com/GoodsServiceImpl/selectByGidResponse")
    public Goods selectByGid(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0);

    /**
     * 
     * @param arg0
     */
    @WebMethod
    @RequestWrapper(localName = "insertGoods", targetNamespace = "http://service.goods.lxit.com/", className = "com.lxit.crm.goods.InsertGoods")
    @ResponseWrapper(localName = "insertGoodsResponse", targetNamespace = "http://service.goods.lxit.com/", className = "com.lxit.crm.goods.InsertGoodsResponse")
    @Action(input = "http://service.goods.lxit.com/GoodsServiceImpl/insertGoodsRequest", output = "http://service.goods.lxit.com/GoodsServiceImpl/insertGoodsResponse")
    public void insertGoods(
        @WebParam(name = "arg0", targetNamespace = "")
        Goods arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns int
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "deleteGoods", targetNamespace = "http://service.goods.lxit.com/", className = "com.lxit.crm.goods.DeleteGoods")
    @ResponseWrapper(localName = "deleteGoodsResponse", targetNamespace = "http://service.goods.lxit.com/", className = "com.lxit.crm.goods.DeleteGoodsResponse")
    @Action(input = "http://service.goods.lxit.com/GoodsServiceImpl/deleteGoodsRequest", output = "http://service.goods.lxit.com/GoodsServiceImpl/deleteGoodsResponse")
    public int deleteGoods(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns java.util.List<com.lxit.crm.goods.Goods>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "pageGoodsList", targetNamespace = "http://service.goods.lxit.com/", className = "com.lxit.crm.goods.PageGoodsList")
    @ResponseWrapper(localName = "pageGoodsListResponse", targetNamespace = "http://service.goods.lxit.com/", className = "com.lxit.crm.goods.PageGoodsListResponse")
    @Action(input = "http://service.goods.lxit.com/GoodsServiceImpl/pageGoodsListRequest", output = "http://service.goods.lxit.com/GoodsServiceImpl/pageGoodsListResponse")
    public List<Goods> pageGoodsList(
        @WebParam(name = "arg0", targetNamespace = "")
        com.lxit.crm.goods.PageGoodsList.Arg0 arg0);

    /**
     * 
     * @return
     *     returns int
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getGoodsCount", targetNamespace = "http://service.goods.lxit.com/", className = "com.lxit.crm.goods.GetGoodsCount")
    @ResponseWrapper(localName = "getGoodsCountResponse", targetNamespace = "http://service.goods.lxit.com/", className = "com.lxit.crm.goods.GetGoodsCountResponse")
    @Action(input = "http://service.goods.lxit.com/GoodsServiceImpl/getGoodsCountRequest", output = "http://service.goods.lxit.com/GoodsServiceImpl/getGoodsCountResponse")
    public int getGoodsCount();

    /**
     * 
     * @param arg0
     * @return
     *     returns java.util.List<com.lxit.crm.goods.Goods>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getSelectId", targetNamespace = "http://service.goods.lxit.com/", className = "com.lxit.crm.goods.GetSelectId")
    @ResponseWrapper(localName = "getSelectIdResponse", targetNamespace = "http://service.goods.lxit.com/", className = "com.lxit.crm.goods.GetSelectIdResponse")
    @Action(input = "http://service.goods.lxit.com/GoodsServiceImpl/getSelectIdRequest", output = "http://service.goods.lxit.com/GoodsServiceImpl/getSelectIdResponse")
    public List<Goods> getSelectId(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0);

}