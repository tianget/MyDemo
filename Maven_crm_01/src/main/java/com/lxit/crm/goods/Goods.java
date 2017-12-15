
package com.lxit.crm.goods;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>goods complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="goods">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="gid" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="gname" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="gprice" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="gstock" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="gtype" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="peopleNum" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "goods", propOrder = {
    "gid",
    "gname",
    "gprice",
    "gstock",
    "gtype",
    "peopleNum"
})
public class Goods {

    protected int gid;
    protected String gname;
    protected double gprice;
    protected String gstock;
    protected String gtype;
    protected String peopleNum;

    /**
     * ��ȡgid���Ե�ֵ��
     * 
     */
    public int getGid() {
        return gid;
    }

    /**
     * ����gid���Ե�ֵ��
     * 
     */
    public void setGid(int value) {
        this.gid = value;
    }

    /**
     * ��ȡgname���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGname() {
        return gname;
    }

    /**
     * ����gname���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGname(String value) {
        this.gname = value;
    }

    /**
     * ��ȡgprice���Ե�ֵ��
     * 
     */
    public double getGprice() {
        return gprice;
    }

    /**
     * ����gprice���Ե�ֵ��
     * 
     */
    public void setGprice(double value) {
        this.gprice = value;
    }

    /**
     * ��ȡgstock���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGstock() {
        return gstock;
    }

    /**
     * ����gstock���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGstock(String value) {
        this.gstock = value;
    }

    /**
     * ��ȡgtype���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGtype() {
        return gtype;
    }

    /**
     * ����gtype���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGtype(String value) {
        this.gtype = value;
    }

    /**
     * ��ȡpeopleNum���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPeopleNum() {
        return peopleNum;
    }

    /**
     * ����peopleNum���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPeopleNum(String value) {
        this.peopleNum = value;
    }

}
