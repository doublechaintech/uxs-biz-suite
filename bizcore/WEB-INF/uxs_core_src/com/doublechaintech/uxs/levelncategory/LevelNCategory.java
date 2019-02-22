
package com.doublechaintech.uxs.levelncategory;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.math.BigDecimal;
import com.terapico.caf.DateTime;
import com.doublechaintech.uxs.BaseEntity;
import com.doublechaintech.uxs.SmartList;
import com.doublechaintech.uxs.KeyValuePair;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.doublechaintech.uxs.leveltwocategory.LevelTwoCategory;
import com.doublechaintech.uxs.product.Product;
import com.doublechaintech.uxs.editorpickproduct.EditorPickProduct;
import com.doublechaintech.uxs.newproduct.NewProduct;
import com.doublechaintech.uxs.topratedproduct.TopRatedProduct;
import com.doublechaintech.uxs.recommandproduct.RecommandProduct;

@JsonSerialize(using = LevelNCategorySerializer.class)
public class LevelNCategory extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String PARENT_CATEGORY_PROPERTY       = "parentCategory"    ;
	public static final String NAME_PROPERTY                  = "name"              ;
	public static final String VERSION_PROPERTY               = "version"           ;

	public static final String PRODUCT_LIST                             = "productList"       ;
	public static final String NEW_PRODUCT_LIST                         = "newProductList"    ;
	public static final String EDITOR_PICK_PRODUCT_LIST                 = "editorPickProductList";
	public static final String TOP_RATED_PRODUCT_LIST                   = "topRatedProductList";
	public static final String RECOMMAND_PRODUCT_LIST                   = "recommandProductList";

	public static final String INTERNAL_TYPE="LevelNCategory";
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
	protected		LevelTwoCategory    	mParentCategory     ;
	protected		String              	mName               ;
	protected		int                 	mVersion            ;
	
	
	protected		SmartList<Product>  	mProductList        ;
	protected		SmartList<NewProduct>	mNewProductList     ;
	protected		SmartList<EditorPickProduct>	mEditorPickProductList;
	protected		SmartList<TopRatedProduct>	mTopRatedProductList;
	protected		SmartList<RecommandProduct>	mRecommandProductList;
	
		
	public 	LevelNCategory(){
		//lazy load for all the properties
	}
	//disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){
		setParentCategory( null );

		this.changed = true;
	}
	
	public 	LevelNCategory(LevelTwoCategory parentCategory, String name)
	{
		setParentCategory(parentCategory);
		setName(name);

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
			
			
			


	
	
	
	public void setId(String id){
		this.mId = trimString(id);;
	}
	public String getId(){
		return this.mId;
	}
	public LevelNCategory updateId(String id){
		this.mId = trimString(id);;
		this.changed = true;
		return this;
	}
	
	
	public void setParentCategory(LevelTwoCategory parentCategory){
		this.mParentCategory = parentCategory;;
	}
	public LevelTwoCategory getParentCategory(){
		return this.mParentCategory;
	}
	public LevelNCategory updateParentCategory(LevelTwoCategory parentCategory){
		this.mParentCategory = parentCategory;;
		this.changed = true;
		return this;
	}
	
	
	public void clearParentCategory(){
		setParentCategory ( null );
		this.changed = true;
	}
	
	public void setName(String name){
		this.mName = trimString(name);;
	}
	public String getName(){
		return this.mName;
	}
	public LevelNCategory updateName(String name){
		this.mName = trimString(name);;
		this.changed = true;
		return this;
	}
	
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	public LevelNCategory updateVersion(int version){
		this.mVersion = version;;
		this.changed = true;
		return this;
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
			product.setParentCategory(this);
		}

		this.mProductList = productList;
		this.mProductList.setListInternalName (PRODUCT_LIST );
		
	}
	
	public  void addProduct(Product product){
		product.setParentCategory(this);
		getProductList().add(product);
	}
	public  void addProductList(SmartList<Product> productList){
		for( Product product:productList){
			product.setParentCategory(this);
		}
		getProductList().addAll(productList);
	}
	
	public  Product removeProduct(Product productIndex){
		
		int index = getProductList().indexOf(productIndex);
        if(index < 0){
        	String message = "Product("+productIndex.getId()+") with version='"+productIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        Product product = getProductList().get(index);        
        // product.clearParentCategory(); //disconnect with ParentCategory
        product.clearFromAll(); //disconnect with ParentCategory
		
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
		product.setParentCategory(null);
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
			newProduct.setParentCategory(this);
		}

		this.mNewProductList = newProductList;
		this.mNewProductList.setListInternalName (NEW_PRODUCT_LIST );
		
	}
	
	public  void addNewProduct(NewProduct newProduct){
		newProduct.setParentCategory(this);
		getNewProductList().add(newProduct);
	}
	public  void addNewProductList(SmartList<NewProduct> newProductList){
		for( NewProduct newProduct:newProductList){
			newProduct.setParentCategory(this);
		}
		getNewProductList().addAll(newProductList);
	}
	
	public  NewProduct removeNewProduct(NewProduct newProductIndex){
		
		int index = getNewProductList().indexOf(newProductIndex);
        if(index < 0){
        	String message = "NewProduct("+newProductIndex.getId()+") with version='"+newProductIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        NewProduct newProduct = getNewProductList().get(index);        
        // newProduct.clearParentCategory(); //disconnect with ParentCategory
        newProduct.clearFromAll(); //disconnect with ParentCategory
		
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
		newProduct.setParentCategory(null);
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
			editorPickProduct.setParentCategory(this);
		}

		this.mEditorPickProductList = editorPickProductList;
		this.mEditorPickProductList.setListInternalName (EDITOR_PICK_PRODUCT_LIST );
		
	}
	
	public  void addEditorPickProduct(EditorPickProduct editorPickProduct){
		editorPickProduct.setParentCategory(this);
		getEditorPickProductList().add(editorPickProduct);
	}
	public  void addEditorPickProductList(SmartList<EditorPickProduct> editorPickProductList){
		for( EditorPickProduct editorPickProduct:editorPickProductList){
			editorPickProduct.setParentCategory(this);
		}
		getEditorPickProductList().addAll(editorPickProductList);
	}
	
	public  EditorPickProduct removeEditorPickProduct(EditorPickProduct editorPickProductIndex){
		
		int index = getEditorPickProductList().indexOf(editorPickProductIndex);
        if(index < 0){
        	String message = "EditorPickProduct("+editorPickProductIndex.getId()+") with version='"+editorPickProductIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        EditorPickProduct editorPickProduct = getEditorPickProductList().get(index);        
        // editorPickProduct.clearParentCategory(); //disconnect with ParentCategory
        editorPickProduct.clearFromAll(); //disconnect with ParentCategory
		
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
		editorPickProduct.setParentCategory(null);
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
			topRatedProduct.setParentCategory(this);
		}

		this.mTopRatedProductList = topRatedProductList;
		this.mTopRatedProductList.setListInternalName (TOP_RATED_PRODUCT_LIST );
		
	}
	
	public  void addTopRatedProduct(TopRatedProduct topRatedProduct){
		topRatedProduct.setParentCategory(this);
		getTopRatedProductList().add(topRatedProduct);
	}
	public  void addTopRatedProductList(SmartList<TopRatedProduct> topRatedProductList){
		for( TopRatedProduct topRatedProduct:topRatedProductList){
			topRatedProduct.setParentCategory(this);
		}
		getTopRatedProductList().addAll(topRatedProductList);
	}
	
	public  TopRatedProduct removeTopRatedProduct(TopRatedProduct topRatedProductIndex){
		
		int index = getTopRatedProductList().indexOf(topRatedProductIndex);
        if(index < 0){
        	String message = "TopRatedProduct("+topRatedProductIndex.getId()+") with version='"+topRatedProductIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        TopRatedProduct topRatedProduct = getTopRatedProductList().get(index);        
        // topRatedProduct.clearParentCategory(); //disconnect with ParentCategory
        topRatedProduct.clearFromAll(); //disconnect with ParentCategory
		
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
		topRatedProduct.setParentCategory(null);
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
			recommandProduct.setParentCategory(this);
		}

		this.mRecommandProductList = recommandProductList;
		this.mRecommandProductList.setListInternalName (RECOMMAND_PRODUCT_LIST );
		
	}
	
	public  void addRecommandProduct(RecommandProduct recommandProduct){
		recommandProduct.setParentCategory(this);
		getRecommandProductList().add(recommandProduct);
	}
	public  void addRecommandProductList(SmartList<RecommandProduct> recommandProductList){
		for( RecommandProduct recommandProduct:recommandProductList){
			recommandProduct.setParentCategory(this);
		}
		getRecommandProductList().addAll(recommandProductList);
	}
	
	public  RecommandProduct removeRecommandProduct(RecommandProduct recommandProductIndex){
		
		int index = getRecommandProductList().indexOf(recommandProductIndex);
        if(index < 0){
        	String message = "RecommandProduct("+recommandProductIndex.getId()+") with version='"+recommandProductIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        RecommandProduct recommandProduct = getRecommandProductList().get(index);        
        // recommandProduct.clearParentCategory(); //disconnect with ParentCategory
        recommandProduct.clearFromAll(); //disconnect with ParentCategory
		
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
		recommandProduct.setParentCategory(null);
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

		addToEntityList(this, entityList, getParentCategory(), internalType);

		
	}
	
	public List<BaseEntity>  collectRefercencesFromLists(String internalType){
		
		List<BaseEntity> entityList = new ArrayList<BaseEntity>();
		collectFromList(this, entityList, getProductList(), internalType);
		collectFromList(this, entityList, getNewProductList(), internalType);
		collectFromList(this, entityList, getEditorPickProductList(), internalType);
		collectFromList(this, entityList, getTopRatedProductList(), internalType);
		collectFromList(this, entityList, getRecommandProductList(), internalType);

		return entityList;
	}
	
	public  List<SmartList<?>> getAllRelatedLists() {
		List<SmartList<?>> listOfList = new ArrayList<SmartList<?>>();
		
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
		appendKeyValuePair(result, PARENT_CATEGORY_PROPERTY, getParentCategory());
		appendKeyValuePair(result, NAME_PROPERTY, getName());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());
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
		
		
		if(baseDest instanceof LevelNCategory){
		
		
			LevelNCategory dest =(LevelNCategory)baseDest;
		
			dest.setId(getId());
			dest.setParentCategory(getParentCategory());
			dest.setName(getName());
			dest.setVersion(getVersion());
			dest.setProductList(getProductList());
			dest.setNewProductList(getNewProductList());
			dest.setEditorPickProductList(getEditorPickProductList());
			dest.setTopRatedProductList(getTopRatedProductList());
			dest.setRecommandProductList(getRecommandProductList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("LevelNCategory{");
		stringBuilder.append("\tid='"+getId()+"';");
		if(getParentCategory() != null ){
 			stringBuilder.append("\tparentCategory='LevelTwoCategory("+getParentCategory().getId()+")';");
 		}
		stringBuilder.append("\tname='"+getName()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	//provide number calculation function
	

}

