//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.02.10 at 01:12:24 PM EST 
//


package com.acg.services.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="licenseNo" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="alertDate" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="effectDate" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "licenseNo",
    "alertDate",
    "effectDate"
})
@XmlRootElement(name = "aaaDriveRequest")
public class AaaDriveRequest {

    @XmlElement(required = true)
    protected String licenseNo;
    @XmlElement(required = true)
    protected String alertDate;
    @XmlElement(required = true)
    protected String effectDate;

    /**
     * Gets the value of the licenseNo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLicenseNo() {
        return licenseNo;
    }

    /**
     * Sets the value of the licenseNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLicenseNo(String value) {
        this.licenseNo = value;
    }

    /**
     * Gets the value of the alertDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAlertDate() {
        return alertDate;
    }

    /**
     * Sets the value of the alertDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAlertDate(String value) {
        this.alertDate = value;
    }

    /**
     * Gets the value of the effectDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEffectDate() {
        return effectDate;
    }

    /**
     * Sets the value of the effectDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEffectDate(String value) {
        this.effectDate = value;
    }

}
