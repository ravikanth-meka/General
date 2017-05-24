package com.acg.services.domain;

import java.math.BigDecimal;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.acg.services.dao.AaadriveInfoDao;

@Component
public class AaaDriveRepository {

	AaaDriveDataType aaaDriveData;
	@Autowired
	AaadriveInfoDao aaadriveInfoDao;
	
	@PostConstruct
	public void initData(){
	}
	
	public AaaDriveDataType getAaaDriveData(AaaDriveRequest aaaDriverequest){
		Object[] obj=  aaadriveInfoDao.getByLicenseNumberAlertAndEffDates(aaaDriverequest.getLicenseNo().trim(),aaaDriverequest.getAlertDate().trim(),aaaDriverequest.getEffectDate().trim());
		AaaDriveDataType  aaaDriveDataType = new AaaDriveDataType();
		try{
			 aaaDriveDataType.setLicenseNo(aaaDriverequest.getLicenseNo());
			 aaaDriveDataType.setAlertDate(aaaDriverequest.getAlertDate());
			 aaaDriveDataType.setAsOfDate(aaaDriverequest.getAlertDate());
			 aaaDriveDataType.setMileage("0");
			 aaaDriveDataType.setJourneys("0");
			if(obj!=null && obj.length > 0 ) {
				 
				Object[] info= (Object[])obj[0];
				 aaaDriveDataType.setAsOfDate(info[3]!=null?String.valueOf(info[3]):aaaDriverequest.getAlertDate());
				 aaaDriveDataType.setMileage(info[6]!=null?String.valueOf((BigDecimal)info[6]):"0");
				 aaaDriveDataType.setJourneys(info[10]!=null?String.valueOf((BigDecimal)info[10]):"0");
			}	
			
		//	Method method
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return aaaDriveDataType;
	}
}
