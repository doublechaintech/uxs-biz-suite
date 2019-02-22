
package com.doublechaintech.uxs.catalog;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.math.BigDecimal;
import com.terapico.caf.DateTime;
import com.doublechaintech.uxs.BaseEntity;
import com.doublechaintech.uxs.SmartList;
import com.doublechaintech.uxs.KeyValuePair;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.doublechaintech.uxs.levelonecategory.LevelOneCategory;
import com.doublechaintech.uxs.product.Product;
import com.doublechaintech.uxs.editorpickproduct.EditorPickProduct;
import com.doublechaintech.uxs.newproduct.NewProduct;
import com.doublechaintech.uxs.site.Site;
import com.doublechaintech.uxs.platform.Platform;
import com.doublechaintech.uxs.topratedproduct.TopRatedProduct;
import com.doublechaintech.uxs.recommandproduct.RecommandProduct;

@JsonSerialize(using = CatalogSerializer.class)
public class Catalog extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String NAME_PROPERTY                  = "name"              ;
	public static final String SELLER_ID_PROPERTY             = "sellerId"          ;
	public static final String SITE_PROPERTY                  = "site"              ;
	public static final String PLATFORM_PROPERTY              = "platform"          ;
	public static final String VERSION_PROPERTY               = "version"           ;

	public static final String LEVEL_ONE_CATEGORY_LIST                  = "levelOneCategoryList";
	public static final String PRODUCT_LIST                             = "productList"       ;
	public static final String NEW_PRODUCT_LIST                         = "newProductList"    ;
	public static final String EDITOR_PICK_PRODUCT_LIST                 = "editorPickProductList";
	public static final String TOP_RATED_PRODUCT_LIST                   = "topRatedProductList";
	public static final String RECOMMAND_PRODUCT_LIST                   = "recommandProductList";

	public static final String INTERNAL_TYPE="Catalog";
	public String getInternalType(){
		return INTERNAL_TYPE;
	}
	
	public String getDisplayName(){
	
		String displayName = getName();
		if(displayName!=null){
			return displayName;
		}
		
		return super.getDisplayName();
		
	}

	private static final long serialVersionUID = 1L;
	

	protected		String              	mId                 ;
	protected		String              	mName               ;
	protected		String              	mSellerId           ;
	protected		Site                	mSite               ;
	protected		Platform            	mPlatform           ;
	protected		int                 	mVersion            ;
	
	
	protected		SmartList<LevelOneCategory>	mLevelOneCategoryList;
	protected		SmartList<Product>  	mProductList        ;
	protected		SmartList<NewProduct>	mNewProductList     ;
	protected		SmartList<EditorPickProduct>	mEditorPickProductList;
	protected		SmartList<TopRatedProduct>	mTopRatedProductList;
	protected		SmartList<RecommandProduct>	mRecommandProductList;
	
		
	public 	Catalog(){
		//lazy load for all the properties
	}
	//disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){
		setSite( null );
		setPlatform( null );

		this.changed = true;
	}
	
	public 	Catalog(String name, String sellerId, Site site, Platform platform)
	{
		setName(name);
		setSellerId(sellerId);
		setSite(site);
		setPlatform(platform);

		this.mLevelOneCategoryList = new SmartList<LevelOneCategory>();
		this.mProductList = new SmartList<Product>();
		this.mNewProductList = new SmartList<NewProduct>();
		this.mEditorPickProductList = new SmartList<EditorPickProduct>();
		this.mTopRatedProductList = new SmartList<TopRatedProduct>();
		this.mRecommandProductList = new SmartList<RecommandProduct>();	
	}
	
	//Support for changing the property
	
	public void changeProperty(String property, String newValueExpr) {
     	
		if(NAME_PROPERTY.equals(property)){
			changeNameProperty(newValueExpr);
		}
		if(SELLER_ID_PROPERTY.equals(property)){
			changeSellerIdProperty(newValueExpr);
		}

      
	}
    
    
	protected void changeNameProperty(String newValueExpr){
		String oldValue = getName();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateName(newValue);
		this.onChangeProperty(NAME_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			
	protected void changeSellerIdProperty(String newValueExpr){
		String oldValue = getSellerId();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateSellerId(newValue);
		this.onChangeProperty(SELLER_ID_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			


	
	
	
	public void setId(String id){
		this.mId = trimString(id);;
	}
	public String getId(){
		return this.mId;
	}
	public Catalog updateId(String id){
		this.mId = trimString(id);;
		this.changed = true;
		return this;
	}
	public void mergeId(String id){
		if(id != null) { setId(id);}
	}
	
	
	public void setName(String name){
		this.mName = trimString(name);;
	}
	public String getName(){
		return this.mName;
	}
	public Catalog updateName(String name){
		this.mName = trimString(name);;
		this.changed = true;
		return this;
	}
	public void mergeName(String name){
		if(name != null) { setName(name);}
	}
	
	
	public void setSellerId(String sellerId){
		this.mSellerId = trimString(sellerId);;
	}
	public String getSellerId(){
		return this.mSellerId;
	}
	public Catalog updateSellerId(String sellerId){
		this.mSellerId = trimString(sellerId);;
		this.changed = true;
		return this;
	}
	public void mergeSellerId(String sellerId){
		if(sellerId != null) { setSellerId(sellerId);}
	}
	
	
	public void clearSellerId(){
		setSellerId ( null );
		this.changed = true;
	}
	
	public void setSite(Site site){
		this.mSite = site;;
	}
	public Site getSite(){
		return this.mSite;
	}
	public Catalog updateSite(Site site){
		this.mSite = site;;
		this.changed = true;
		return this;
	}
	public void mergeSite(Site site){
		if(site != null) { setSite(site);}
	}
	
	
	public void clearSite(){
		setSite ( null );
		this.changed = true;
	}
	
	public void setPlatform(Platform platform){
		this.mPlatform = platform;;
	}
	public Platform getPlatform(){
		return this.mPlatform;
	}
	public Catalog updatePlatform(Platform platform){
		this.mPlatform = platform;;
		this.changed = true;
		return this;
	}
	public void mergePlatform(Platform platform){
		if(platform != null) { setPlatform(platform);}
	}
	
	
	public void clearPlatform(){
		setPlatform ( null );
		this.changed = true;
	}
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	public Catalog updateVersion(int version){
		this.mVersion = version;;
		this.changed = true;
		return this;
	}
	public void mergeVersion(int version){
		setVersion(version);
	}
	
	

	public  SmartList<LevelOneCategory> getLevelOneCategoryList(){
		if(this.mLevelOneCategoryList == null){
			this.mLevelOneCategoryList = new SmartList<LevelOneCategory>();
			this.mLevelOneCategoryList.setListInternalName (LEVEL_ONE_CATEGORY_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mLevelOneCategoryList;	
	}
	public  void setLevelOneCategoryList(SmartList<LevelOneCategory> levelOneCategoryList){
		for( LevelOneCategory levelOneCategory:levelOneCategoryList){
			levelOneCategory.setCatalog(this);
		}

		this.mLevelOneCategoryList = levelOneCategoryList;
		this.mLevelOneCategoryList.setListInternalName (LEVEL_ONE_CATEGORY_LIST );
		
	}
	
	public  void addLevelOneCategory(LevelOneCategory levelOneCategory){
		levelOneCategory.setCatalog(this);
		getLevelOneCategoryList().add(levelOneCategory);
	}
	public  void addLevelOneCategoryList(SmartList<LevelOneCategory> levelOneCategoryList){
		for( LevelOneCategory levelOneCategory:levelOneCategoryList){
			levelOneCategory.setCatalog(this);
		}
		getLevelOneCategoryList().addAll(levelOneCategoryList);
	}
	public  void mergeLevelOneCategoryList(SmartList<LevelOneCategory> levelOneCategoryList){
		if(levelOneCategoryList==null){
			return;
		}
		if(levelOneCategoryList.isEmpty()){
			return;
		}
		addLevelOneCategoryList( levelOneCategoryList );
		
	}
	public  LevelOneCategory removeLevelOneCategory(LevelOneCategory levelOneCategoryIndex){
		
		int index = getLevelOneCategoryList().indexOf(levelOneCategoryIndex);
        if(index < 0){
        	String message = "LevelOneCategory("+levelOneCategoryIndex.getId()+") with version='"+levelOneCategoryIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        LevelOneCategory levelOneCategory = getLevelOneCategoryList().get(index);        
        // levelOneCategory.clearCatalog(); //disconnect with Catalog
        levelOneCategory.clearFromAll(); //disconnect with Catalog
		
		boolean result = getLevelOneCategoryList().planToRemove(levelOneCategory);
        if(!result){
        	String message = "LevelOneCategory("+levelOneCategoryIndex.getId()+") with version='"+levelOneCategoryIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return levelOneCategory;
        
	
	}
	//断舍离
	public  void breakWithLevelOneCategory(LevelOneCategory levelOneCategory){
		
		if(levelOneCategory == null){
			return;
		}
		levelOneCategory.setCatalog(null);
		//getLevelOneCategoryList().remove();
	
	}
	
	public  boolean hasLevelOneCategory(LevelOneCategory levelOneCategory){
	
		return getLevelOneCategoryList().contains(levelOneCategory);
  
	}
	
	public void copyLevelOneCategoryFrom(LevelOneCategory levelOneCategory) {

		LevelOneCategory levelOneCategoryInList = findTheLevelOneCategory(levelOneCategory);
		LevelOneCategory newLevelOneCategory = new LevelOneCategory();
		levelOneCategoryInList.copyTo(newLevelOneCategory);
		newLevelOneCategory.setVersion(0);//will trigger copy
		getLevelOneCategoryList().add(newLevelOneCategory);
		addItemToFlexiableObject(COPIED_CHILD, newLevelOneCategory);
	}
	
	public  LevelOneCategory findTheLevelOneCategory(LevelOneCategory levelOneCategory){
		
		int index =  getLevelOneCategoryList().indexOf(levelOneCategory);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "LevelOneCategory("+levelOneCategory.getId()+") with version='"+levelOneCategory.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getLevelOneCategoryList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpLevelOneCategoryList(){
		getLevelOneCategoryList().clear();
	}
	
	
	


	public  SmartList<Product> getProductList(){
		if(this.mProductList == null){
			this.mProductList = new SmartList<Product>();
			this.mProductList.setListInternalName (PRODUCT_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mProductList;	
	}
	public  void setProductList(SmartList<Product> productList){
		for( Product product:productList){
			product.setCatalog(this);
		}

		this.mProductList = productList;
		this.mProductList.setListInternalName (PRODUCT_LIST );
		
	}
	
	public  void addProduct(Product product){
		product.setCatalog(this);
		getProductList().add(product);
	}
	public  void addProductList(SmartList<Product> productList){
		for( Product product:productList){
			product.setCatalog(this);
		}
		getProductList().addAll(productList);
	}
	public  void mergeProductList(SmartList<Product> productList){
		if(productList==null){
			return;
		}
		if(productList.isEmpty()){
			return;
		}
		addProductList( productList );
		
	}
	public  Product removeProduct(Product productIndex){
		
		int index = getProductList().indexOf(productIndex);
        if(index < 0){
        	String message = "Product("+productIndex.getId()+") with version='"+productIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        Product product = getProductList().get(index);        
        // product.clearCatalog(); //disconnect with Catalog
        product.clearFromAll(); //disconnect with Catalog
		
		boolean result = getProductList().planToRemove(product);
        if(!result){
        	String message = "Product("+productIndex.getId()+") with version='"+productIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return product;
        
	
	}
	//断舍离
	public  void breakWithProduct(Product product){
		
		if(product == null){
			return;
		}
		product.setCatalog(null);
		//getProductList().remove();
	
	}
	
	public  boolean hasProduct(Product product){
	
		return getProductList().contains(product);
  
	}
	
	public void copyProductFrom(Product product) {

		Product productInList = findTheProduct(product);
		Product newProduct = new Product();
		productInList.copyTo(newProduct);
		newProduct.setVersion(0);//will trigger copy
		getProductList().add(newProduct);
		addItemToFlexiableObject(COPIED_CHILD, newProduct);
	}
	
	public  Product findTheProduct(Product product){
		
		int index =  getProductList().indexOf(product);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "Product("+product.getId()+") with version='"+product.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getProductList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpProductList(){
		getProductList().clear();
	}
	
	
	


	public  SmartList<NewProduct> getNewProductList(){
		if(this.mNewProductList == null){
			this.mNewProductList = new SmartList<NewProduct>();
			this.mNewProductList.setListInternalName (NEW_PRODUCT_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mNewProductList;	
	}
	public  void setNewProductList(SmartList<NewProduct> newProductList){
		for( NewProduct newProduct:newProductList){
			newProduct.setCatalog(this);
		}

		this.mNewProductList = newProductList;
		this.mNewProductList.setListInternalName (NEW_PRODUCT_LIST );
		
	}
	
	public  void addNewProduct(NewProduct newProduct){
		newProduct.setCatalog(this);
		getNewProductList().add(newProduct);
	}
	public  void addNewProductList(SmartList<NewProduct> newProductList){
		for( NewProduct newProduct:newProductList){
			newProduct.setCatalog(this);
		}
		getNewProductList().addAll(newProductList);
	}
	public  void mergeNewProductList(SmartList<NewProduct> newProductList){
		if(newProductList==null){
			return;
		}
		if(newProductList.isEmpty()){
			return;
		}
		addNewProductList( newProductList );
		
	}
	public  NewProduct removeNewProduct(NewProduct newProductIndex){
		
		int index = getNewProductList().indexOf(newProductIndex);
        if(index < 0){
        	String message = "NewProduct("+newProductIndex.getId()+") with version='"+newProductIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        NewProduct newProduct = getNewProductList().get(index);        
        // newProduct.clearCatalog(); //disconnect with Catalog
        newProduct.clearFromAll(); //disconnect with Catalog
		
		boolean result = getNewProductList().planToRemove(newProduct);
        if(!result){
        	String message = "NewProduct("+newProductIndex.getId()+") with version='"+newProductIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return newProduct;
        
	
	}
	//断舍离
	public  void breakWithNewProduct(NewProduct newProduct){
		
		if(newProduct == null){
			return;
		}
		newProduct.setCatalog(null);
		//getNewProductList().remove();
	
	}
	
	public  boolean hasNewProduct(NewProduct newProduct){
	
		return getNewProductList().contains(newProduct);
  
	}
	
	public void copyNewProductFrom(NewProduct newProduct) {

		NewProduct newProductInList = findTheNewProduct(newProduct);
		NewProduct newNewProduct = new NewProduct();
		newProductInList.copyTo(newNewProduct);
		newNewProduct.setVersion(0);//will trigger copy
		getNewProductList().add(newNewProduct);
		addItemToFlexiableObject(COPIED_CHILD, newNewProduct);
	}
	
	public  NewProduct findTheNewProduct(NewProduct newProduct){
		
		int index =  getNewProductList().indexOf(newProduct);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "NewProduct("+newProduct.getId()+") with version='"+newProduct.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getNewProductList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpNewProductList(){
		getNewProductList().clear();
	}
	
	
	


	public  SmartList<EditorPickProduct> getEditorPickProductList(){
		if(this.mEditorPickProductList == null){
			this.mEditorPickProductList = new SmartList<EditorPickProduct>();
			this.mEditorPickProductList.setListInternalName (EDITOR_PICK_PRODUCT_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mEditorPickProductList;	
	}
	public  void setEditorPickProductList(SmartList<EditorPickProduct> editorPickProductList){
		for( EditorPickProduct editorPickProduct:editorPickProductList){
			editorPickProduct.setCatalog(this);
		}

		this.mEditorPickProductList = editorPickProductList;
		this.mEditorPickProductList.setListInternalName (EDITOR_PICK_PRODUCT_LIST );
		
	}
	
	public  void addEditorPickProduct(EditorPickProduct editorPickProduct){
		editorPickProduct.setCatalog(this);
		getEditorPickProductList().add(editorPickProduct);
	}
	public  void addEditorPickProductList(SmartList<EditorPickProduct> editorPickProductList){
		for( EditorPickProduct editorPickProduct:editorPickProductList){
			editorPickProduct.setCatalog(this);
		}
		getEditorPickProductList().addAll(editorPickProductList);
	}
	public  void mergeEditorPickProductList(SmartList<EditorPickProduct> editorPickProductList){
		if(editorPickProductList==null){
			return;
		}
		if(editorPickProductList.isEmpty()){
			return;
		}
		addEditorPickProductList( editorPickProductList );
		
	}
	public  EditorPickProduct removeEditorPickProduct(EditorPickProduct editorPickProductIndex){
		
		int index = getEditorPickProductList().indexOf(editorPickProductIndex);
        if(index < 0){
        	String message = "EditorPickProduct("+editorPickProductIndex.getId()+") with version='"+editorPickProductIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        EditorPickProduct editorPickProduct = getEditorPickProductList().get(index);        
        // editorPickProduct.clearCatalog(); //disconnect with Catalog
        editorPickProduct.clearFromAll(); //disconnect with Catalog
		
		boolean result = getEditorPickProductList().planToRemove(editorPickProduct);
        if(!result){
        	String message = "EditorPickProduct("+editorPickProductIndex.getId()+") with version='"+editorPickProductIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return editorPickProduct;
        
	
	}
	//断舍离
	public  void breakWithEditorPickProduct(EditorPickProduct editorPickProduct){
		
		if(editorPickProduct == null){
			return;
		}
		editorPickProduct.setCatalog(null);
		//getEditorPickProductList().remove();
	
	}
	
	public  boolean hasEditorPickProduct(EditorPickProduct editorPickProduct){
	
		return getEditorPickProductList().contains(editorPickProduct);
  
	}
	
	public void copyEditorPickProductFrom(EditorPickProduct editorPickProduct) {

		EditorPickProduct editorPickProductInList = findTheEditorPickProduct(editorPickProduct);
		EditorPickProduct newEditorPickProduct = new EditorPickProduct();
		editorPickProductInList.copyTo(newEditorPickProduct);
		newEditorPickProduct.setVersion(0);//will trigger copy
		getEditorPickProductList().add(newEditorPickProduct);
		addItemToFlexiableObject(COPIED_CHILD, newEditorPickProduct);
	}
	
	public  EditorPickProduct findTheEditorPickProduct(EditorPickProduct editorPickProduct){
		
		int index =  getEditorPickProductList().indexOf(editorPickProduct);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "EditorPickProduct("+editorPickProduct.getId()+") with version='"+editorPickProduct.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getEditorPickProductList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpEditorPickProductList(){
		getEditorPickProductList().clear();
	}
	
	
	


	public  SmartList<TopRatedProduct> getTopRatedProductList(){
		if(this.mTopRatedProductList == null){
			this.mTopRatedProductList = new SmartList<TopRatedProduct>();
			this.mTopRatedProductList.setListInternalName (TOP_RATED_PRODUCT_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mTopRatedProductList;	
	}
	public  void setTopRatedProductList(SmartList<TopRatedProduct> topRatedProductList){
		for( TopRatedProduct topRatedProduct:topRatedProductList){
			topRatedProduct.setCatalog(this);
		}

		this.mTopRatedProductList = topRatedProductList;
		this.mTopRatedProductList.setListInternalName (TOP_RATED_PRODUCT_LIST );
		
	}
	
	public  void addTopRatedProduct(TopRatedProduct topRatedProduct){
		topRatedProduct.setCatalog(this);
		getTopRatedProductList().add(topRatedProduct);
	}
	public  void addTopRatedProductList(SmartList<TopRatedProduct> topRatedProductList){
		for( TopRatedProduct topRatedProduct:topRatedProductList){
			topRatedProduct.setCatalog(this);
		}
		getTopRatedProductList().addAll(topRatedProductList);
	}
	public  void mergeTopRatedProductList(SmartList<TopRatedProduct> topRatedProductList){
		if(topRatedProductList==null){
			return;
		}
		if(topRatedProductList.isEmpty()){
			return;
		}
		addTopRatedProductList( topRatedProductList );
		
	}
	public  TopRatedProduct removeTopRatedProduct(TopRatedProduct topRatedProductIndex){
		
		int index = getTopRatedProductList().indexOf(topRatedProductIndex);
        if(index < 0){
        	String message = "TopRatedProduct("+topRatedProductIndex.getId()+") with version='"+topRatedProductIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        TopRatedProduct topRatedProduct = getTopRatedProductList().get(index);        
        // topRatedProduct.clearCatalog(); //disconnect with Catalog
        topRatedProduct.clearFromAll(); //disconnect with Catalog
		
		boolean result = getTopRatedProductList().planToRemove(topRatedProduct);
        if(!result){
        	String message = "TopRatedProduct("+topRatedProductIndex.getId()+") with version='"+topRatedProductIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return topRatedProduct;
        
	
	}
	//断舍离
	public  void breakWithTopRatedProduct(TopRatedProduct topRatedProduct){
		
		if(topRatedProduct == null){
			return;
		}
		topRatedProduct.setCatalog(null);
		//getTopRatedProductList().remove();
	
	}
	
	public  boolean hasTopRatedProduct(TopRatedProduct topRatedProduct){
	
		return getTopRatedProductList().contains(topRatedProduct);
  
	}
	
	public void copyTopRatedProductFrom(TopRatedProduct topRatedProduct) {

		TopRatedProduct topRatedProductInList = findTheTopRatedProduct(topRatedProduct);
		TopRatedProduct newTopRatedProduct = new TopRatedProduct();
		topRatedProductInList.copyTo(newTopRatedProduct);
		newTopRatedProduct.setVersion(0);//will trigger copy
		getTopRatedProductList().add(newTopRatedProduct);
		addItemToFlexiableObject(COPIED_CHILD, newTopRatedProduct);
	}
	
	public  TopRatedProduct findTheTopRatedProduct(TopRatedProduct topRatedProduct){
		
		int index =  getTopRatedProductList().indexOf(topRatedProduct);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "TopRatedProduct("+topRatedProduct.getId()+") with version='"+topRatedProduct.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getTopRatedProductList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpTopRatedProductList(){
		getTopRatedProductList().clear();
	}
	
	
	


	public  SmartList<RecommandProduct> getRecommandProductList(){
		if(this.mRecommandProductList == null){
			this.mRecommandProductList = new SmartList<RecommandProduct>();
			this.mRecommandProductList.setListInternalName (RECOMMAND_PRODUCT_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mRecommandProductList;	
	}
	public  void setRecommandProductList(SmartList<RecommandProduct> recommandProductList){
		for( RecommandProduct recommandProduct:recommandProductList){
			recommandProduct.setCatalog(this);
		}

		this.mRecommandProductList = recommandProductList;
		this.mRecommandProductList.setListInternalName (RECOMMAND_PRODUCT_LIST );
		
	}
	
	public  void addRecommandProduct(RecommandProduct recommandProduct){
		recommandProduct.setCatalog(this);
		getRecommandProductList().add(recommandProduct);
	}
	public  void addRecommandProductList(SmartList<RecommandProduct> recommandProductList){
		for( RecommandProduct recommandProduct:recommandProductList){
			recommandProduct.setCatalog(this);
		}
		getRecommandProductList().addAll(recommandProductList);
	}
	public  void mergeRecommandProductList(SmartList<RecommandProduct> recommandProductList){
		if(recommandProductList==null){
			return;
		}
		if(recommandProductList.isEmpty()){
			return;
		}
		addRecommandProductList( recommandProductList );
		
	}
	public  RecommandProduct removeRecommandProduct(RecommandProduct recommandProductIndex){
		
		int index = getRecommandProductList().indexOf(recommandProductIndex);
        if(index < 0){
        	String message = "RecommandProduct("+recommandProductIndex.getId()+") with version='"+recommandProductIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        RecommandProduct recommandProduct = getRecommandProductList().get(index);        
        // recommandProduct.clearCatalog(); //disconnect with Catalog
        recommandProduct.clearFromAll(); //disconnect with Catalog
		
		boolean result = getRecommandProductList().planToRemove(recommandProduct);
        if(!result){
        	String message = "RecommandProduct("+recommandProductIndex.getId()+") with version='"+recommandProductIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return recommandProduct;
        
	
	}
	//断舍离
	public  void breakWithRecommandProduct(RecommandProduct recommandProduct){
		
		if(recommandProduct == null){
			return;
		}
		recommandProduct.setCatalog(null);
		//getRecommandProductList().remove();
	
	}
	
	public  boolean hasRecommandProduct(RecommandProduct recommandProduct){
	
		return getRecommandProductList().contains(recommandProduct);
  
	}
	
	public void copyRecommandProductFrom(RecommandProduct recommandProduct) {

		RecommandProduct recommandProductInList = findTheRecommandProduct(recommandProduct);
		RecommandProduct newRecommandProduct = new RecommandProduct();
		recommandProductInList.copyTo(newRecommandProduct);
		newRecommandProduct.setVersion(0);//will trigger copy
		getRecommandProductList().add(newRecommandProduct);
		addItemToFlexiableObject(COPIED_CHILD, newRecommandProduct);
	}
	
	public  RecommandProduct findTheRecommandProduct(RecommandProduct recommandProduct){
		
		int index =  getRecommandProductList().indexOf(recommandProduct);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "RecommandProduct("+recommandProduct.getId()+") with version='"+recommandProduct.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getRecommandProductList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpRecommandProductList(){
		getRecommandProductList().clear();
	}
	
	
	


	public void collectRefercences(BaseEntity owner, List<BaseEntity> entityList, String internalType){

		addToEntityList(this, entityList, getSite(), internalType);
		addToEntityList(this, entityList, getPlatform(), internalType);

		
	}
	
	public List<BaseEntity>  collectRefercencesFromLists(String internalType){
		
		List<BaseEntity> entityList = new ArrayList<BaseEntity>();
		collectFromList(this, entityList, getLevelOneCategoryList(), internalType);
		collectFromList(this, entityList, getProductList(), internalType);
		collectFromList(this, entityList, getNewProductList(), internalType);
		collectFromList(this, entityList, getEditorPickProductList(), internalType);
		collectFromList(this, entityList, getTopRatedProductList(), internalType);
		collectFromList(this, entityList, getRecommandProductList(), internalType);

		return entityList;
	}
	
	public  List<SmartList<?>> getAllRelatedLists() {
		List<SmartList<?>> listOfList = new ArrayList<SmartList<?>>();
		
		listOfList.add( getLevelOneCategoryList());
		listOfList.add( getProductList());
		listOfList.add( getNewProductList());
		listOfList.add( getEditorPickProductList());
		listOfList.add( getTopRatedProductList());
		listOfList.add( getRecommandProductList());
			

		return listOfList;
	}

	
	public List<KeyValuePair> keyValuePairOf(){
		List<KeyValuePair> result =  super.keyValuePairOf();

		appendKeyValuePair(result, ID_PROPERTY, getId());
		appendKeyValuePair(result, NAME_PROPERTY, getName());
		appendKeyValuePair(result, SELLER_ID_PROPERTY, getSellerId());
		appendKeyValuePair(result, SITE_PROPERTY, getSite());
		appendKeyValuePair(result, PLATFORM_PROPERTY, getPlatform());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());
		appendKeyValuePair(result, LEVEL_ONE_CATEGORY_LIST, getLevelOneCategoryList());
		if(!getLevelOneCategoryList().isEmpty()){
			appendKeyValuePair(result, "levelOneCategoryCount", getLevelOneCategoryList().getTotalCount());
			appendKeyValuePair(result, "levelOneCategoryCurrentPageNumber", getLevelOneCategoryList().getCurrentPageNumber());
		}
		appendKeyValuePair(result, PRODUCT_LIST, getProductList());
		if(!getProductList().isEmpty()){
			appendKeyValuePair(result, "productCount", getProductList().getTotalCount());
			appendKeyValuePair(result, "productCurrentPageNumber", getProductList().getCurrentPageNumber());
		}
		appendKeyValuePair(result, NEW_PRODUCT_LIST, getNewProductList());
		if(!getNewProductList().isEmpty()){
			appendKeyValuePair(result, "newProductCount", getNewProductList().getTotalCount());
			appendKeyValuePair(result, "newProductCurrentPageNumber", getNewProductList().getCurrentPageNumber());
		}
		appendKeyValuePair(result, EDITOR_PICK_PRODUCT_LIST, getEditorPickProductList());
		if(!getEditorPickProductList().isEmpty()){
			appendKeyValuePair(result, "editorPickProductCount", getEditorPickProductList().getTotalCount());
			appendKeyValuePair(result, "editorPickProductCurrentPageNumber", getEditorPickProductList().getCurrentPageNumber());
		}
		appendKeyValuePair(result, TOP_RATED_PRODUCT_LIST, getTopRatedProductList());
		if(!getTopRatedProductList().isEmpty()){
			appendKeyValuePair(result, "topRatedProductCount", getTopRatedProductList().getTotalCount());
			appendKeyValuePair(result, "topRatedProductCurrentPageNumber", getTopRatedProductList().getCurrentPageNumber());
		}
		appendKeyValuePair(result, RECOMMAND_PRODUCT_LIST, getRecommandProductList());
		if(!getRecommandProductList().isEmpty()){
			appendKeyValuePair(result, "recommandProductCount", getRecommandProductList().getTotalCount());
			appendKeyValuePair(result, "recommandProductCurrentPageNumber", getRecommandProductList().getCurrentPageNumber());
		}

		
		return result;
	}
	
	
	public BaseEntity copyTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof Catalog){
		
		
			Catalog dest =(Catalog)baseDest;
		
			dest.setId(getId());
			dest.setName(getName());
			dest.setSellerId(getSellerId());
			dest.setSite(getSite());
			dest.setPlatform(getPlatform());
			dest.setVersion(getVersion());
			dest.setLevelOneCategoryList(getLevelOneCategoryList());
			dest.setProductList(getProductList());
			dest.setNewProductList(getNewProductList());
			dest.setEditorPickProductList(getEditorPickProductList());
			dest.setTopRatedProductList(getTopRatedProductList());
			dest.setRecommandProductList(getRecommandProductList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	public BaseEntity mergeDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof Catalog){
		
			
			Catalog dest =(Catalog)baseDest;
		
			dest.mergeId(getId());
			dest.mergeName(getName());
			dest.mergeSellerId(getSellerId());
			dest.mergeSite(getSite());
			dest.mergePlatform(getPlatform());
			dest.mergeVersion(getVersion());
			dest.mergeLevelOneCategoryList(getLevelOneCategoryList());
			dest.mergeProductList(getProductList());
			dest.mergeNewProductList(getNewProductList());
			dest.mergeEditorPickProductList(getEditorPickProductList());
			dest.mergeTopRatedProductList(getTopRatedProductList());
			dest.mergeRecommandProductList(getRecommandProductList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("Catalog{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tname='"+getName()+"';");
		stringBuilder.append("\tsellerId='"+getSellerId()+"';");
		if(getSite() != null ){
 			stringBuilder.append("\tsite='Site("+getSite().getId()+")';");
 		}
		if(getPlatform() != null ){
 			stringBuilder.append("\tplatform='Platform("+getPlatform().getId()+")';");
 		}
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	//provide number calculation function
	

}

