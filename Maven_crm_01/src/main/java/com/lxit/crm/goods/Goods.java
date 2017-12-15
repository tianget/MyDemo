
package com.lxit.crm.goods;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>goods complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
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
     * 获取gid属性的值。
     * 
     */
    public int getGid() {
        return gid;
    }

    /**
     * 设置gid属性的值。
     * 
     */
    public void setGid(int value) {
        this.gid = value;
    }

    /**
     * 获取gname属性的值。
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
     * 设置gname属性的值。
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
     * 获取gprice属性的值。
     * 
     */
    public double getGprice() {
        return gprice;
    }

    /**
     * 设置gprice属性的值。
     * 
     */
    public void setGprice(double value) {
        this.gprice = value;
    }

    /**
     * 获取gstock属性的值。
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
     * 设置gstock属性的值。
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
     * 获取gtype属性的值。
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
     * 设置gtype属性的值。
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
     * 获取peopleNum属性的值。
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
     * 设置peopleNum属性的值。
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
