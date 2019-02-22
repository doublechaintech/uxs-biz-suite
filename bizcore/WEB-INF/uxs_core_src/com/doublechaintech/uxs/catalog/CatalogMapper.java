
package com.doublechaintech.uxs.catalog;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.uxs.BaseRowMapper;
import com.doublechaintech.uxs.site.Site;
import com.doublechaintech.uxs.platform.Platform;

public class CatalogMapper extends BaseRowMapper<Catalog>{
	
	protected Catalog internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		Catalog catalog = getCatalog();		
		 		
 		setId(catalog, rs, rowNumber); 		
 		setName(catalog, rs, rowNumber); 		
 		setSellerId(catalog, rs, rowNumber); 		
 		setSite(catalog, rs, rowNumber); 		
 		setPlatform(catalog, rs, rowNumber); 		
 		setVersion(catalog, rs, rowNumber);

		return catalog;
	}
	
	protected Catalog getCatalog(){
		return new Catalog();
	}		
		
	protected void setId(Catalog catalog, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String id = rs.getString(CatalogTable.COLUMN_ID);
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		catalog.setId(id);
	}
		
	protected void setName(Catalog catalog, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String name = rs.getString(CatalogTable.COLUMN_NAME);
		if(name == null){
			//do nothing when nothing found in database
			return;
		}
		
		catalog.setName(name);
	}
		
	protected void setSellerId(Catalog catalog, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String sellerId = rs.getString(CatalogTable.COLUMN_SELLER_ID);
		if(sellerId == null){
			//do nothing when nothing found in database
			return;
		}
		
		catalog.setSellerId(sellerId);
	}
		 		
 	protected void setSite(Catalog catalog, ResultSet rs, int rowNumber) throws SQLException{
 		String siteId = rs.getString(CatalogTable.COLUMN_SITE);
 		if( siteId == null){
 			return;
 		}
 		if( siteId.isEmpty()){
 			return;
 		}
 		Site site = catalog.getSite();
 		if( site != null ){
 			//if the root object 'catalog' already have the property, just set the id for it;
 			site.setId(siteId);
 			
 			return;
 		}
 		catalog.setSite(createEmptySite(siteId));
 	}
 	 		
 	protected void setPlatform(Catalog catalog, ResultSet rs, int rowNumber) throws SQLException{
 		String platformId = rs.getString(CatalogTable.COLUMN_PLATFORM);
 		if( platformId == null){
 			return;
 		}
 		if( platformId.isEmpty()){
 			return;
 		}
 		Platform platform = catalog.getPlatform();
 		if( platform != null ){
 			//if the root object 'catalog' already have the property, just set the id for it;
 			platform.setId(platformId);
 			
 			return;
 		}
 		catalog.setPlatform(createEmptyPlatform(platformId));
 	}
 	
	protected void setVersion(Catalog catalog, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Integer version = rs.getInt(CatalogTable.COLUMN_VERSION);
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		catalog.setVersion(version);
	}
		
		

 	protected Site  createEmptySite(String siteId){
 		Site site = new Site();
 		site.setId(siteId);
 		site.setVersion(Integer.MAX_VALUE);
 		return site;
 	}
 	
 	protected Platform  createEmptyPlatform(String platformId){
 		Platform platform = new Platform();
 		platform.setId(platformId);
 		platform.setVersion(Integer.MAX_VALUE);
 		return platform;
 	}
 	
}


