
package com.doublechaintech.uxs.levelncategory;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.uxs.BaseRowMapper;
import com.doublechaintech.uxs.leveltwocategory.LevelTwoCategory;

public class LevelNCategoryMapper extends BaseRowMapper<LevelNCategory>{
	
	protected LevelNCategory internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		LevelNCategory levelNCategory = getLevelNCategory();		
		 		
 		setId(levelNCategory, rs, rowNumber); 		
 		setParentCategory(levelNCategory, rs, rowNumber); 		
 		setName(levelNCategory, rs, rowNumber); 		
 		setVersion(levelNCategory, rs, rowNumber);

		return levelNCategory;
	}
	
	protected LevelNCategory getLevelNCategory(){
		return new LevelNCategory();
	}		
		
	protected void setId(LevelNCategory levelNCategory, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String id = rs.getString(LevelNCategoryTable.COLUMN_ID);
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		levelNCategory.setId(id);
	}
		 		
 	protected void setParentCategory(LevelNCategory levelNCategory, ResultSet rs, int rowNumber) throws SQLException{
 		String levelTwoCategoryId = rs.getString(LevelNCategoryTable.COLUMN_PARENT_CATEGORY);
 		if( levelTwoCategoryId == null){
 			return;
 		}
 		if( levelTwoCategoryId.isEmpty()){
 			return;
 		}
 		LevelTwoCategory levelTwoCategory = levelNCategory.getParentCategory();
 		if( levelTwoCategory != null ){
 			//if the root object 'levelNCategory' already have the property, just set the id for it;
 			levelTwoCategory.setId(levelTwoCategoryId);
 			
 			return;
 		}
 		levelNCategory.setParentCategory(createEmptyParentCategory(levelTwoCategoryId));
 	}
 	
	protected void setName(LevelNCategory levelNCategory, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String name = rs.getString(LevelNCategoryTable.COLUMN_NAME);
		if(name == null){
			//do nothing when nothing found in database
			return;
		}
		
		levelNCategory.setName(name);
	}
		
	protected void setVersion(LevelNCategory levelNCategory, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Integer version = rs.getInt(LevelNCategoryTable.COLUMN_VERSION);
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		levelNCategory.setVersion(version);
	}
		
		

 	protected LevelTwoCategory  createEmptyParentCategory(String levelTwoCategoryId){
 		LevelTwoCategory levelTwoCategory = new LevelTwoCategory();
 		levelTwoCategory.setId(levelTwoCategoryId);
 		levelTwoCategory.setVersion(Integer.MAX_VALUE);
 		return levelTwoCategory;
 	}
 	
}


