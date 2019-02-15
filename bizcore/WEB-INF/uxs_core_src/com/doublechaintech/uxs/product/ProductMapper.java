
package com.doublechaintech.uxs.product;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.uxs.BaseRowMapper;
import com.doublechaintech.uxs.platform.Platform;

public class ProductMapper extends BaseRowMapper<Product>{
	
	protected Product internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		Product product = getProduct();		
		 		
 		setId(product, rs, rowNumber); 		
 		setName(product, rs, rowNumber); 		
 		setPlatform(product, rs, rowNumber); 		
 		setAvarageScore(product, rs, rowNumber); 		
 		setVersion(product, rs, rowNumber);

		return product;
	}
	
	protected Product getProduct(){
		return new Product();
	}		
		
	protected void setId(Product product, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String id = rs.getString(ProductTable.COLUMN_ID);
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		product.setId(id);
	}
		
	protected void setName(Product product, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String name = rs.getString(ProductTable.COLUMN_NAME);
		if(name == null){
			//do nothing when nothing found in database
			return;
		}
		
		product.setName(name);
	}
		 		
 	protected void setPlatform(Product product, ResultSet rs, int rowNumber) throws SQLException{
 		String platformId = rs.getString(ProductTable.COLUMN_PLATFORM);
 		if( platformId == null){
 			return;
 		}
 		if( platformId.isEmpty()){
 			return;
 		}
 		Platform platform = product.getPlatform();
 		if( platform != null ){
 			//if the root object 'product' already have the property, just set the id for it;
 			platform.setId(platformId);
 			
 			return;
 		}
 		product.setPlatform(createEmptyPlatform(platformId));
 	}
 	
	protected void setAvarageScore(Product product, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		BigDecimal avarageScore = rs.getBigDecimal(ProductTable.COLUMN_AVARAGE_SCORE);
		if(avarageScore == null){
			//do nothing when nothing found in database
			return;
		}
		
		product.setAvarageScore(avarageScore);
	}
		
	protected void setVersion(Product product, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Integer version = rs.getInt(ProductTable.COLUMN_VERSION);
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		product.setVersion(version);
	}
		
		

 	protected Platform  createEmptyPlatform(String platformId){
 		Platform platform = new Platform();
 		platform.setId(platformId);
 		platform.setVersion(Integer.MAX_VALUE);
 		return platform;
 	}
 	
}


