//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.02.10 at 01:16:16 PM EST 
//


package com.acg.services.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for aaaDriveDataType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="aaaDriveDataType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="licenseNo" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="alertDate" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="asOfDate" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="journeys" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="mileage" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "aaaDriveDataType", propOrder = {
    "licenseNo",
    "alertDate",
    "asOfDate",
    "journeys",
    "mileage"
})
public class AaaDriveDataType {

    @XmlElement(required = true)
    protected String licenseNo;
    @XmlElement(required = true)
    protected String alertDate;
    @XmlElement(required = true)
    protected String asOfDate;
    @XmlElement(required = true)
    protected String journeys;
    @XmlElement(required = true)
    protected String mileage;

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
     * Gets the value of the asOfDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAsOfDate() {
        return asOfDate;
    }

    /**
     * Sets the value of the asOfDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAsOfDate(String value) {
        this.asOfDate = value;
    }

    /**
     * Gets the value of the journeys property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getJourneys() {
        return journeys;
    }

    /**
     * Sets the value of the journeys property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setJourneys(String value) {
        this.journeys = value;
    }

    /**
     * Gets the value of the mileage property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMileage() {
        return mileage;
    }

    /**
     * Sets the value of the mileage property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMileage(String value) {
        this.mileage = value;
    }

}
