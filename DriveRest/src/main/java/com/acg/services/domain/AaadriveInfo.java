package com.acg.services.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;


/**
 * The persistent class for the AAADRIVE_INFO database table.
 * 
 */
@Entity
@Table(name="AAADRIVE_INFO")
public class AaadriveInfo implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private AaadriveInfoPK id;

	@Column(name="CREATED_BY")
	private String createdBy;

	@Column(name="CREATION_DT")
	private Timestamp creationDt;

	@Column(name="DEACTIVATION_DATE")
	private Timestamp deactivationDate;

	@Column(name="DRV_LIC_NUMBER")
	private String drvLicNumber;

	@Column(name="INS_OPT_IN_DATE")
	private Timestamp insOptInDate;

	@Column(name="INS_OPT_OUT_DATE")
	private Timestamp insOptOutDate;

	private BigDecimal journeys;

	@Column(name="JOURNEYS_120")
	private BigDecimal journeys120;

	private BigDecimal mileage;

	@Column(name="MILEAGE_120")
	private BigDecimal mileage120;

	@Column(name="OVERALL_SCORE")
	private BigDecimal overallScore;

	@Column(name="OVERALL_SCORE_120")
	private BigDecimal overallScore120;

	@Column(name="REGISTRATION_DATE")
	private Timestamp registrationDate;

	@Column(name="UPDATED_BY")
	private String updatedBy;

	@Column(name="UPDATED_DT")
	private Timestamp updatedDt;

    public AaadriveInfo() {
    }

	public AaadriveInfoPK getId() {
		return this.id;
	}

	public void setId(AaadriveInfoPK id) {
		this.id = id;
	}
	
	public String getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Timestamp getCreationDt() {
		return this.creationDt;
	}

	public void setCreationDt(Timestamp creationDt) {
		this.creationDt = creationDt;
	}

	public Timestamp getDeactivationDate() {
		return this.deactivationDate;
	}

	public void setDeactivationDate(Timestamp deactivationDate) {
		this.deactivationDate = deactivationDate;
	}

	public String getDrvLicNumber() {
		return this.drvLicNumber;
	}

	public void setDrvLicNumber(String drvLicNumber) {
		this.drvLicNumber = drvLicNumber;
	}

	public Timestamp getInsOptInDate() {
		return this.insOptInDate;
	}

	public void setInsOptInDate(Timestamp insOptInDate) {
		this.insOptInDate = insOptInDate;
	}

	public Timestamp getInsOptOutDate() {
		return this.insOptOutDate;
	}

	public void setInsOptOutDate(Timestamp insOptOutDate) {
		this.insOptOutDate = insOptOutDate;
	}

	public BigDecimal getJourneys() {
		return this.journeys;
	}

	public void setJourneys(BigDecimal journeys) {
		this.journeys = journeys;
	}

	public BigDecimal getJourneys120() {
		return this.journeys120;
	}

	public void setJourneys120(BigDecimal journeys120) {
		this.journeys120 = journeys120;
	}

	public BigDecimal getMileage() {
		return this.mileage;
	}

	public void setMileage(BigDecimal mileage) {
		this.mileage = mileage;
	}

	public BigDecimal getMileage120() {
		return this.mileage120;
	}

	public void setMileage120(BigDecimal mileage120) {
		this.mileage120 = mileage120;
	}

	public BigDecimal getOverallScore() {
		return this.overallScore;
	}

	public void setOverallScore(BigDecimal overallScore) {
		this.overallScore = overallScore;
	}

	public BigDecimal getOverallScore120() {
		return this.overallScore120;
	}

	public void setOverallScore120(BigDecimal overallScore120) {
		this.overallScore120 = overallScore120;
	}

	public Timestamp getRegistrationDate() {
		return this.registrationDate;
	}

	public void setRegistrationDate(Timestamp registrationDate) {
		this.registrationDate = registrationDate;
	}

	public String getUpdatedBy() {
		return this.updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Timestamp getUpdatedDt() {
		return this.updatedDt;
	}

	public void setUpdatedDt(Timestamp updatedDt) {
		this.updatedDt = updatedDt;
	}

}