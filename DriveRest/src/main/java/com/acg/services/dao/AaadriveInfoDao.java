package com.acg.services.dao;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.acg.services.domain.AaadriveInfo;
import com.acg.services.domain.AaadriveInfoPK;

public interface AaadriveInfoDao extends
		CrudRepository<AaadriveInfo, AaadriveInfoPK> {

	@Query("select a from AaadriveInfo a where a.id.asOfDate= (select max(b.id.asOfDate) from AaadriveInfo b where b.drvLicNumber=?1) and a.drvLicNumber =?1 ")
	public List<AaadriveInfo> getByLicenseNumber(String license);
	
	
	@Query(value= "SELECT a.mileage amile, b.mileage bmile ,c.mileage cmile , " + 
			" to_char(a.as_of_date , 'yyyymmdd') asOfDate,to_char(b.as_of_date , 'yyyymmdd')  effDate, to_char(c.as_of_date , 'yyyymmdd')  effDateMinus1," + 
			" (case when to_date(to_char(c.as_of_date , 'yyyymmdd'), 'yyyymmdd') = to_date(to_char(b.as_of_date , 'yyyymmdd'), 'yyyymmdd') then a.mileage " + 
			"      when to_date(to_char(b.as_of_date , 'yyyymmdd'), 'yyyymmdd') > to_date(?3 , 'yyyymmdd') then a.mileage " + 
			"      when to_date(to_char(c.as_of_date , 'yyyymmdd'), 'yyyymmdd') != to_date(to_char(b.as_of_date , 'yyyymmdd'), 'yyyymmdd') and c.mileage!=b.mileage then a.mileage - c.mileage " + 
			"      when to_date(to_char(c.as_of_date , 'yyyymmdd'), 'yyyymmdd') != to_date(to_char(b.as_of_date , 'yyyymmdd'), 'yyyymmdd') and c.mileage=b.mileage then a.mileage - b.mileage " + 
			"      else a.mileage - b.mileage  end ) Actualmiles,  " + 
			"      a.journeys ajourney, b.journeys bjourney, c.journeys cjourney, " + 
			" (case when to_date(to_char(c.as_of_date , 'yyyymmdd'), 'yyyymmdd') = to_date(to_char(b.as_of_date , 'yyyymmdd'), 'yyyymmdd') then a.journeys  " + 
			"      when to_date(to_char(b.as_of_date , 'yyyymmdd'), 'yyyymmdd') > to_date(?3 , 'yyyymmdd') then a.journeys  " + 
			"      when to_date(to_char(c.as_of_date , 'yyyymmdd'), 'yyyymmdd') != to_date(to_char(b.as_of_date , 'yyyymmdd'), 'yyyymmdd') and c.journeys!=b.journeys then a.journeys - c.journeys " + 
			"      when to_date(to_char(c.as_of_date , 'yyyymmdd'), 'yyyymmdd') != to_date(to_char(b.as_of_date , 'yyyymmdd'), 'yyyymmdd') and c.journeys=b.journeys then a.journeys - b.journeys " + 
			"      else a.journeys - b.journeys  end ) ActualJourneys , " + 
			" a.ins_opt_in_date, a.guid aguid, b.guid bguid  " + 
			" FROM AAADRIVE_INFO a  " +  //--alertdate 
			" join AAADRIVE_INFO b  " +  //--effective date 
			" on a.guid = b.guid " + 
			" join AAADRIVE_INFO c  " +  //--effective date -1
			" on c.guid = a.guid   " + 
			" WHERE  a.drv_lic_number= ?1  " + 
			" and a.as_of_date = (SELECT MAX(d.as_of_date) FROM AAADRIVE_INFO d WHERE d.drv_lic_number= ?1 and TRUNC(d.as_of_date)<=to_date(?2, 'yyyymmdd'))  " + 
			" and b.as_of_date = (SELECT MIN(d.as_of_date) FROM AAADRIVE_INFO d WHERE d.guid = a.guid and TRUNC(d.as_of_date)>=to_date(?3, 'yyyymmdd'))  " + 
			" and c.as_of_date = (SELECT MIN(d.as_of_date) FROM AAADRIVE_INFO d WHERE d.guid = a.guid and TRUNC(d.as_of_date)>= (to_date(?3 , 'yyyymmdd') -1))  " + 
			" order by a.as_of_date desc, a.drv_lic_number, a.ins_opt_in_date desc,a.mileage_120 desc " , nativeQuery=true)
	public Object[] getByLicenseNumberAlertAndEffDates(String license,String alertDate, String effDate);
			
	
	
	
	@Query(value="SELECT MAX(a.MILEAGE) - MIN(a.MILEAGE), MAX(a.JOURNEYS)- MIN(a.JOURNEYS)  FROM aaadrive_info a," +
			"(select max(b.as_Of_Date) as max_asOfDate from aaadrive_info b where b.drv_Lic_Number=?1) c," +
			"(select b.GUID from aaadrive_info b where b.drv_Lic_Number=?1) d WHERE a.GUID = d.GUID AND a.AS_OF_DATE BETWEEN  c.max_asOfDate- 24 AND c.max_asOfDate" , nativeQuery=true)
	public Object[] get23DayDataByLicense (String license);
	
	@Query(value=" SELECT a.END_MILES_23-a.BEGIN_MILES_23 ,a.END_JOURNEYS_23-a.BEGIN_JOURNEYS_23 from " +
			" (SELECT MAX(ROUND(MILEAGE)) AS END_MILES_23, MIN(ROUND(MILEAGE)) AS BEGIN_MILES_23, MAX(ROUND(JOURNEYS)) AS END_JOURNEYS_23," +
			"  MIN(ROUND(JOURNEYS)) AS BEGIN_JOURNEYS_23, COUNT(*) AS EVALDAYS_23 FROM AAADRIVE_INFO  WHERE GUID = ?1 AND  AS_OF_DATE BETWEEN ?2 - 24  AND ?2) a" , nativeQuery=true)
	public Object[] get23DayDataByGuidAndAsOfDate (String guid,Date asOfDate);

	@Query(value="select min(A.as_of_date) FROM AAADRIVE_INFO A WHERE A.GUID IN (SELECT DISTINCT b.GUID FROM AAADRIVE_INFO b WHERE b.drv_lic_number = ?1) and a.journeys > 1 and a.mileage > 9" , nativeQuery=true)
	Timestamp getMinParticipationEligDate(String license);

}
