package com.acg.services.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The primary key class for the AAADRIVE_INFO database table.
 * 
 */
@Embeddable
public class AaadriveInfoPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private String guid;

    @Temporal( TemporalType.TIMESTAMP)
	@Column(name="AS_OF_DATE")
	private java.util.Date asOfDate;

	@Column(name="BATCH_TRACK_ID")
	private long batchTrackId;

    public AaadriveInfoPK() {
    }
	public String getGuid() {
		return this.guid;
	}
	public void setGuid(String guid) {
		this.guid = guid;
	}
	public java.util.Date getAsOfDate() {
		return this.asOfDate;
	}
	public void setAsOfDate(java.util.Date asOfDate) {
		this.asOfDate = asOfDate;
	}
	public long getBatchTrackId() {
		return this.batchTrackId;
	}
	public void setBatchTrackId(long batchTrackId) {
		this.batchTrackId = batchTrackId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof AaadriveInfoPK)) {
			return false;
		}
		AaadriveInfoPK castOther = (AaadriveInfoPK)other;
		return 
			this.guid.equals(castOther.guid)
			&& this.asOfDate.equals(castOther.asOfDate)
			&& (this.batchTrackId == castOther.batchTrackId);

    }
    
	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.guid.hashCode();
		hash = hash * prime + this.asOfDate.hashCode();
		hash = hash * prime + ((int) (this.batchTrackId ^ (this.batchTrackId >>> 32)));
		
		return hash;
    }
}