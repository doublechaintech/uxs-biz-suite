
package com.doublechaintech.uxs.brand;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.uxs.BaseRowMapper;
import com.doublechaintech.uxs.platform.Platform;

public class BrandMapper extends BaseRowMapper<Brand>{
	
	protected Brand internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		Brand brand = getBrand();		
		 		
 		setId(brand, rs, rowNumber); 		
 		setBrandName(brand, rs, rowNumber); 		
 		setLogo(brand, rs, rowNumber); 		
 		setRemark(brand, rs, rowNumber); 		
 		setPlatform(brand, rs, rowNumber); 		
 		setVersion(brand, rs, rowNumber);

		return brand;
	}
	
	protected Brand getBrand(){
		return new Brand();
	}		
		
	protected void setId(Brand brand, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String id = rs.getString(BrandTable.COLUMN_ID);
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		brand.setId(id);
	}
		
	protected void setBrandName(Brand brand, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String brandName = rs.getString(BrandTable.COLUMN_BRAND_NAME);
		if(brandName == null){
			//do nothing when nothing found in database
			return;
		}
		
		brand.setBrandName(brandName);
	}
		
	protected void setLogo(Brand brand, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String logo = rs.getString(BrandTable.COLUMN_LOGO);
		if(logo == null){
			//do nothing when nothing found in database
			return;
		}
		
		brand.setLogo(logo);
	}
		
	protected void setRemark(Brand brand, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String remark = rs.getString(BrandTable.COLUMN_REMARK);
		if(remark == null){
			//do nothing when nothing found in database
			return;
		}
		
		brand.setRemark(remark);
	}
		 		
 	protected void setPlatform(Brand brand, ResultSet rs, int rowNumber) throws SQLException{
 		String platformId = rs.getString(BrandTable.COLUMN_PLATFORM);
 		if( platformId == null){
 			return;
 		}
 		if( platformId.isEmpty()){
 			return;
 		}
 		Platform platform = brand.getPlatform();
 		if( platform != null ){
 			//if the root object 'brand' already have the property, just set the id for it;
 			platform.setId(platformId);
 			
 			return;
 		}
 		brand.setPlatform(createEmptyPlatform(platformId));
 	}
 	
	protected void setVersion(Brand brand, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Integer version = rs.getInt(BrandTable.COLUMN_VERSION);
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		brand.setVersion(version);
	}
		
		

 	protected Platform  createEmptyPlatform(String platformId){
 		Platform platform = new Platform();
 		platform.setId(platformId);
 		platform.setVersion(Integer.MAX_VALUE);
 		return platform;
 	}
 	
}


