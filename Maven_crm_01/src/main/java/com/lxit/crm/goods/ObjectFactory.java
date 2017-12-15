
package com.lxit.crm.goods;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.lxit.crm.goods package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _SelectByGid_QNAME = new QName("http://service.goods.lxit.com/", "selectByGid");
    private final static QName _GetSelectId_QNAME = new QName("http://service.goods.lxit.com/", "getSelectId");
    private final static QName _GetSelectIdResponse_QNAME = new QName("http://service.goods.lxit.com/", "getSelectIdResponse");
    private final static QName _PageGoodsList_QNAME = new QName("http://service.goods.lxit.com/", "pageGoodsList");
    private final static QName _InsertGoods_QNAME = new QName("http://service.goods.lxit.com/", "insertGoods");
    private final static QName _DeleteGoodsResponse_QNAME = new QName("http://service.goods.lxit.com/", "deleteGoodsResponse");
    private final static QName _InsertGoodsResponse_QNAME = new QName("http://service.goods.lxit.com/", "insertGoodsResponse");
    private final static QName _DeleteGoods_QNAME = new QName("http://service.goods.lxit.com/", "deleteGoods");
    private final static QName _PageGoodsListResponse_QNAME = new QName("http://service.goods.lxit.com/", "pageGoodsListResponse");
    private final static QName _GetGoodsCountResponse_QNAME = new QName("http://service.goods.lxit.com/", "getGoodsCountResponse");
    private final static QName _GetGoodsCount_QNAME = new QName("http://service.goods.lxit.com/", "getGoodsCount");
    private final static QName _SelectByGidResponse_QNAME = new QName("http://service.goods.lxit.com/", "selectByGidResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.lxit.crm.goods
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link PageGoodsList }
     * 
     */
    public PageGoodsList createPageGoodsList() {
        return new PageGoodsList();
    }

    /**
     * Create an instance of {@link PageGoodsList.Arg0 }
     * 
     */
    public PageGoodsList.Arg0 createPageGoodsListArg0() {
        return new PageGoodsList.Arg0();
    }

    /**
     * Create an instance of {@link SelectByGidResponse }
     * 
     */
    public SelectByGidResponse createSelectByGidResponse() {
        return new SelectByGidResponse();
    }

    /**
     * Create an instance of {@link GetGoodsCount }
     * 
     */
    public GetGoodsCount createGetGoodsCount() {
        return new GetGoodsCount();
    }

    /**
     * Create an instance of {@link PageGoodsListResponse }
     * 
     */
    public PageGoodsListResponse createPageGoodsListResponse() {
        return new PageGoodsListResponse();
    }

    /**
     * Create an instance of {@link GetGoodsCountResponse }
     * 
     */
    public GetGoodsCountResponse createGetGoodsCountResponse() {
        return new GetGoodsCountResponse();
    }

    /**
     * Create an instance of {@link DeleteGoods }
     * 
     */
    public DeleteGoods createDeleteGoods() {
        return new DeleteGoods();
    }

    /**
     * Create an instance of {@link InsertGoods }
     * 
     */
    public InsertGoods createInsertGoods() {
        return new InsertGoods();
    }

    /**
     * Create an instance of {@link DeleteGoodsResponse }
     * 
     */
    public DeleteGoodsResponse createDeleteGoodsResponse() {
        return new DeleteGoodsResponse();
    }

    /**
     * Create an instance of {@link InsertGoodsResponse }
     * 
     */
    public InsertGoodsResponse createInsertGoodsResponse() {
        return new InsertGoodsResponse();
    }

    /**
     * Create an instance of {@link GetSelectIdResponse }
     * 
     */
    public GetSelectIdResponse createGetSelectIdResponse() {
        return new GetSelectIdResponse();
    }

    /**
     * Create an instance of {@link GetSelectId }
     * 
     */
    public GetSelectId createGetSelectId() {
        return new GetSelectId();
    }

    /**
     * Create an instance of {@link SelectByGid }
     * 
     */
    public SelectByGid createSelectByGid() {
        return new SelectByGid();
    }

    /**
     * Create an instance of {@link Goods }
     * 
     */
    public Goods createGoods() {
        return new Goods();
    }

    /**
     * Create an instance of {@link PageGoodsList.Arg0 .Entry }
     * 
     */
    public PageGoodsList.Arg0 .Entry createPageGoodsListArg0Entry() {
        return new PageGoodsList.Arg0 .Entry();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SelectByGid }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.goods.lxit.com/", name = "selectByGid")
    public JAXBElement<SelectByGid> createSelectByGid(SelectByGid value) {
        return new JAXBElement<SelectByGid>(_SelectByGid_QNAME, SelectByGid.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetSelectId }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.goods.lxit.com/", name = "getSelectId")
    public JAXBElement<GetSelectId> createGetSelectId(GetSelectId value) {
        return new JAXBElement<GetSelectId>(_GetSelectId_QNAME, GetSelectId.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetSelectIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.goods.lxit.com/", name = "getSelectIdResponse")
    public JAXBElement<GetSelectIdResponse> createGetSelectIdResponse(GetSelectIdResponse value) {
        return new JAXBElement<GetSelectIdResponse>(_GetSelectIdResponse_QNAME, GetSelectIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PageGoodsList }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.goods.lxit.com/", name = "pageGoodsList")
    public JAXBElement<PageGoodsList> createPageGoodsList(PageGoodsList value) {
        return new JAXBElement<PageGoodsList>(_PageGoodsList_QNAME, PageGoodsList.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InsertGoods }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.goods.lxit.com/", name = "insertGoods")
    public JAXBElement<InsertGoods> createInsertGoods(InsertGoods value) {
        return new JAXBElement<InsertGoods>(_InsertGoods_QNAME, InsertGoods.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteGoodsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.goods.lxit.com/", name = "deleteGoodsResponse")
    public JAXBElement<DeleteGoodsResponse> createDeleteGoodsResponse(DeleteGoodsResponse value) {
        return new JAXBElement<DeleteGoodsResponse>(_DeleteGoodsResponse_QNAME, DeleteGoodsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InsertGoodsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.goods.lxit.com/", name = "insertGoodsResponse")
    public JAXBElement<InsertGoodsResponse> createInsertGoodsResponse(InsertGoodsResponse value) {
        return new JAXBElement<InsertGoodsResponse>(_InsertGoodsResponse_QNAME, InsertGoodsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteGoods }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.goods.lxit.com/", name = "deleteGoods")
    public JAXBElement<DeleteGoods> createDeleteGoods(DeleteGoods value) {
        return new JAXBElement<DeleteGoods>(_DeleteGoods_QNAME, DeleteGoods.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PageGoodsListResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.goods.lxit.com/", name = "pageGoodsListResponse")
    public JAXBElement<PageGoodsListResponse> createPageGoodsListResponse(PageGoodsListResponse value) {
        return new JAXBElement<PageGoodsListResponse>(_PageGoodsListResponse_QNAME, PageGoodsListResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetGoodsCountResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.goods.lxit.com/", name = "getGoodsCountResponse")
    public JAXBElement<GetGoodsCountResponse> createGetGoodsCountResponse(GetGoodsCountResponse value) {
        return new JAXBElement<GetGoodsCountResponse>(_GetGoodsCountResponse_QNAME, GetGoodsCountResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetGoodsCount }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.goods.lxit.com/", name = "getGoodsCount")
    public JAXBElement<GetGoodsCount> createGetGoodsCount(GetGoodsCount value) {
        return new JAXBElement<GetGoodsCount>(_GetGoodsCount_QNAME, GetGoodsCount.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SelectByGidResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.goods.lxit.com/", name = "selectByGidResponse")
    public JAXBElement<SelectByGidResponse> createSelectByGidResponse(SelectByGidResponse value) {
        return new JAXBElement<SelectByGidResponse>(_SelectByGidResponse_QNAME, SelectByGidResponse.class, null, value);
    }

}
