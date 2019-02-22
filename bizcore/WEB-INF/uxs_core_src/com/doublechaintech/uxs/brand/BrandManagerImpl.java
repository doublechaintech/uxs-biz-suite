
package com.doublechaintech.uxs.brand;

import java.util.Date;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.math.BigDecimal;
import com.terapico.caf.DateTime;
import com.doublechaintech.uxs.BaseEntity;


import com.doublechaintech.uxs.Message;
import com.doublechaintech.uxs.SmartList;
import com.doublechaintech.uxs.MultipleAccessKey;

import com.doublechaintech.uxs.UxsUserContext;
//import com.doublechaintech.uxs.BaseManagerImpl;
import com.doublechaintech.uxs.UxsCheckerManager;
import com.doublechaintech.uxs.CustomUxsCheckerManager;

import com.doublechaintech.uxs.product.Product;
import com.doublechaintech.uxs.editorpickproduct.EditorPickProduct;
import com.doublechaintech.uxs.newproduct.NewProduct;
import com.doublechaintech.uxs.platform.Platform;
import com.doublechaintech.uxs.topratedproduct.TopRatedProduct;
import com.doublechaintech.uxs.recommandproduct.RecommandProduct;

import com.doublechaintech.uxs.platform.CandidatePlatform;

import com.doublechaintech.uxs.brand.Brand;
import com.doublechaintech.uxs.catalog.Catalog;
import com.doublechaintech.uxs.levelncategory.LevelNCategory;
import com.doublechaintech.uxs.profile.Profile;
import com.doublechaintech.uxs.platform.Platform;






public class BrandManagerImpl extends CustomUxsCheckerManager implements BrandManager {
	
	private static final String SERVICE_TYPE = "Brand";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws BrandManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new BrandManagerException(message);

	}
	
	

 	protected Brand saveBrand(UxsUserContext userContext, Brand brand, String [] tokensExpr) throws Exception{	
 		//return getBrandDAO().save(brand, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveBrand(userContext, brand, tokens);
 	}
 	
 	protected Brand saveBrandDetail(UxsUserContext userContext, Brand brand) throws Exception{	

 		
 		return saveBrand(userContext, brand, allTokens());
 	}
 	
 	public Brand loadBrand(UxsUserContext userContext, String brandId, String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfBrand(brandId);
		userContext.getChecker().throwExceptionIfHasErrors( BrandManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		Brand brand = loadBrand( userContext, brandId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,brand, tokens);
 	}
 	
 	
 	 public Brand searchBrand(UxsUserContext userContext, String brandId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfBrand(brandId);
		userContext.getChecker().throwExceptionIfHasErrors( BrandManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		Brand brand = loadBrand( userContext, brandId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,brand, tokens);
 	}
 	
 	

 	protected Brand present(UxsUserContext userContext, Brand brand, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,brand,tokens);
		
		
		Brand  brandToPresent = userContext.getDAOGroup().getBrandDAO().present(brand, tokens);
		
		List<BaseEntity> entityListToNaming = brandToPresent.collectRefercencesFromLists();
		userContext.getDAOGroup().getBrandDAO().alias(entityListToNaming);
		
		return  brandToPresent;
		
		
	}
 
 	
 	
 	public Brand loadBrandDetail(UxsUserContext userContext, String brandId) throws Exception{	
 		Brand brand = loadBrand( userContext, brandId, allTokens());
 		return present(userContext,brand, allTokens());
		
 	}
 	
 	public Object view(UxsUserContext userContext, String brandId) throws Exception{	
 		Brand brand = loadBrand( userContext, brandId, viewTokens());
 		return present(userContext,brand, allTokens());
		
 	}
 	protected Brand saveBrand(UxsUserContext userContext, Brand brand, Map<String,Object>tokens) throws Exception{	
 		return userContext.getDAOGroup().getBrandDAO().save(brand, tokens);
 	}
 	protected Brand loadBrand(UxsUserContext userContext, String brandId, Map<String,Object>tokens) throws Exception{	
		userContext.getChecker().checkIdOfBrand(brandId);
		userContext.getChecker().throwExceptionIfHasErrors( BrandManagerException.class);

 
 		return userContext.getDAOGroup().getBrandDAO().load(brandId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(UxsUserContext userContext, Brand brand, Map<String, Object> tokens){
		super.addActions(userContext, brand, tokens);
		
		addAction(userContext, brand, tokens,"@create","createBrand","createBrand/","main","primary");
		addAction(userContext, brand, tokens,"@update","updateBrand","updateBrand/"+brand.getId()+"/","main","primary");
		addAction(userContext, brand, tokens,"@copy","cloneBrand","cloneBrand/"+brand.getId()+"/","main","primary");
		
		addAction(userContext, brand, tokens,"brand.transfer_to_platform","transferToAnotherPlatform","transferToAnotherPlatform/"+brand.getId()+"/","main","primary");
		addAction(userContext, brand, tokens,"brand.addProduct","addProduct","addProduct/"+brand.getId()+"/","productList","primary");
		addAction(userContext, brand, tokens,"brand.removeProduct","removeProduct","removeProduct/"+brand.getId()+"/","productList","primary");
		addAction(userContext, brand, tokens,"brand.updateProduct","updateProduct","updateProduct/"+brand.getId()+"/","productList","primary");
		addAction(userContext, brand, tokens,"brand.copyProductFrom","copyProductFrom","copyProductFrom/"+brand.getId()+"/","productList","primary");
		addAction(userContext, brand, tokens,"brand.addNewProduct","addNewProduct","addNewProduct/"+brand.getId()+"/","newProductList","primary");
		addAction(userContext, brand, tokens,"brand.removeNewProduct","removeNewProduct","removeNewProduct/"+brand.getId()+"/","newProductList","primary");
		addAction(userContext, brand, tokens,"brand.updateNewProduct","updateNewProduct","updateNewProduct/"+brand.getId()+"/","newProductList","primary");
		addAction(userContext, brand, tokens,"brand.copyNewProductFrom","copyNewProductFrom","copyNewProductFrom/"+brand.getId()+"/","newProductList","primary");
		addAction(userContext, brand, tokens,"brand.addEditorPickProduct","addEditorPickProduct","addEditorPickProduct/"+brand.getId()+"/","editorPickProductList","primary");
		addAction(userContext, brand, tokens,"brand.removeEditorPickProduct","removeEditorPickProduct","removeEditorPickProduct/"+brand.getId()+"/","editorPickProductList","primary");
		addAction(userContext, brand, tokens,"brand.updateEditorPickProduct","updateEditorPickProduct","updateEditorPickProduct/"+brand.getId()+"/","editorPickProductList","primary");
		addAction(userContext, brand, tokens,"brand.copyEditorPickProductFrom","copyEditorPickProductFrom","copyEditorPickProductFrom/"+brand.getId()+"/","editorPickProductList","primary");
		addAction(userContext, brand, tokens,"brand.addTopRatedProduct","addTopRatedProduct","addTopRatedProduct/"+brand.getId()+"/","topRatedProductList","primary");
		addAction(userContext, brand, tokens,"brand.removeTopRatedProduct","removeTopRatedProduct","removeTopRatedProduct/"+brand.getId()+"/","topRatedProductList","primary");
		addAction(userContext, brand, tokens,"brand.updateTopRatedProduct","updateTopRatedProduct","updateTopRatedProduct/"+brand.getId()+"/","topRatedProductList","primary");
		addAction(userContext, brand, tokens,"brand.copyTopRatedProductFrom","copyTopRatedProductFrom","copyTopRatedProductFrom/"+brand.getId()+"/","topRatedProductList","primary");
		addAction(userContext, brand, tokens,"brand.addRecommandProduct","addRecommandProduct","addRecommandProduct/"+brand.getId()+"/","recommandProductList","primary");
		addAction(userContext, brand, tokens,"brand.removeRecommandProduct","removeRecommandProduct","removeRecommandProduct/"+brand.getId()+"/","recommandProductList","primary");
		addAction(userContext, brand, tokens,"brand.updateRecommandProduct","updateRecommandProduct","updateRecommandProduct/"+brand.getId()+"/","recommandProductList","primary");
		addAction(userContext, brand, tokens,"brand.copyRecommandProductFrom","copyRecommandProductFrom","copyRecommandProductFrom/"+brand.getId()+"/","recommandProductList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(UxsUserContext userContext, Brand brand, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public Brand createBrand(UxsUserContext userContext,String brandName, String logo, String remark, String platformId) throws Exception
	{
		
		

		

		userContext.getChecker().checkBrandNameOfBrand(brandName);
		userContext.getChecker().checkLogoOfBrand(logo);
		userContext.getChecker().checkRemarkOfBrand(remark);
	
		userContext.getChecker().throwExceptionIfHasErrors(BrandManagerException.class);


		Brand brand=createNewBrand();	

		brand.setBrandName(brandName);
		brand.setLogo(logo);
		brand.setRemark(remark);
			
		Platform platform = loadPlatform(userContext, platformId,emptyOptions());
		brand.setPlatform(platform);
		
		

		brand = saveBrand(userContext, brand, emptyOptions());
		
		onNewInstanceCreated(userContext, brand);
		return brand;

		
	}
	protected Brand createNewBrand() 
	{
		
		return new Brand();		
	}
	
	protected void checkParamsForUpdatingBrand(UxsUserContext userContext,String brandId, int brandVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		userContext.getChecker().checkIdOfBrand(brandId);
		userContext.getChecker().checkVersionOfBrand( brandVersion);
		

		if(Brand.BRAND_NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkBrandNameOfBrand(parseString(newValueExpr));
		}
		if(Brand.LOGO_PROPERTY.equals(property)){
			userContext.getChecker().checkLogoOfBrand(parseString(newValueExpr));
		}
		if(Brand.REMARK_PROPERTY.equals(property)){
			userContext.getChecker().checkRemarkOfBrand(parseString(newValueExpr));
		}		

		
	
		userContext.getChecker().throwExceptionIfHasErrors(BrandManagerException.class);
	
		
	}
	
	
	
	public Brand clone(UxsUserContext userContext, String fromBrandId) throws Exception{
		
		return userContext.getDAOGroup().getBrandDAO().clone(fromBrandId, this.allTokens());
	}
	
	public Brand internalSaveBrand(UxsUserContext userContext, Brand brand) throws Exception 
	{
		return internalSaveBrand(userContext, brand, allTokens());

	}
	public Brand internalSaveBrand(UxsUserContext userContext, Brand brand, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingBrand(userContext, brandId, brandVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(brand){ 
			//will be good when the brand loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Brand.
			
			
			brand = saveBrand(userContext, brand, options);
			return brand;
			
		}

	}
	
	public Brand updateBrand(UxsUserContext userContext,String brandId, int brandVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingBrand(userContext, brandId, brandVersion, property, newValueExpr, tokensExpr);
		
		
		
		Brand brand = loadBrand(userContext, brandId, allTokens());
		if(brand.getVersion() != brandVersion){
			String message = "The target version("+brand.getVersion()+") is not equals to version("+brandVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(brand){ 
			//will be good when the brand loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Brand.
			
			brand.changeProperty(property, newValueExpr);
			brand = saveBrand(userContext, brand, tokens().done());
			return present(userContext,brand, mergedAllTokens(tokensExpr));
			//return saveBrand(userContext, brand, tokens().done());
		}

	}
	
	public Brand updateBrandProperty(UxsUserContext userContext,String brandId, int brandVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingBrand(userContext, brandId, brandVersion, property, newValueExpr, tokensExpr);
		
		Brand brand = loadBrand(userContext, brandId, allTokens());
		if(brand.getVersion() != brandVersion){
			String message = "The target version("+brand.getVersion()+") is not equals to version("+brandVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(brand){ 
			//will be good when the brand loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Brand.
			
			brand.changeProperty(property, newValueExpr);
			
			brand = saveBrand(userContext, brand, tokens().done());
			return present(userContext,brand, mergedAllTokens(tokensExpr));
			//return saveBrand(userContext, brand, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected BrandTokens tokens(){
		return BrandTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return BrandTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortProductListWith("id","desc")
		.sortNewProductListWith("id","desc")
		.sortEditorPickProductListWith("id","desc")
		.sortTopRatedProductListWith("id","desc")
		.sortRecommandProductListWith("id","desc")
		.done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return BrandTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherPlatform(UxsUserContext userContext, String brandId, String anotherPlatformId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfBrand(brandId);
 		userContext.getChecker().checkIdOfPlatform(anotherPlatformId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(BrandManagerException.class);
 		
 	}
 	public Brand transferToAnotherPlatform(UxsUserContext userContext, String brandId, String anotherPlatformId) throws Exception
 	{
 		checkParamsForTransferingAnotherPlatform(userContext, brandId,anotherPlatformId);
 
		Brand brand = loadBrand(userContext, brandId, allTokens());	
		synchronized(brand){
			//will be good when the brand loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			Platform platform = loadPlatform(userContext, anotherPlatformId, emptyOptions());		
			brand.updatePlatform(platform);		
			brand = saveBrand(userContext, brand, emptyOptions());
			
			return present(userContext,brand, allTokens());
			
		}

 	}
 	
	 	
 	
 	
	public CandidatePlatform requestCandidatePlatform(UxsUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidatePlatform result = new CandidatePlatform();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("name");
		
		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<Platform> candidateList = userContext.getDAOGroup().getPlatformDAO().requestCandidatePlatformForBrand(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 //--------------------------------------------------------------
	
	 	
 	protected Platform loadPlatform(UxsUserContext userContext, String newPlatformId, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getPlatformDAO().load(newPlatformId, options);
 	}
 	
 	
 	
	
	//--------------------------------------------------------------

	public void delete(UxsUserContext userContext, String brandId, int brandVersion) throws Exception {
		//deleteInternal(userContext, brandId, brandVersion);		
	}
	protected void deleteInternal(UxsUserContext userContext,
			String brandId, int brandVersion) throws Exception{
			
		userContext.getDAOGroup().getBrandDAO().delete(brandId, brandVersion);
	}
	
	public Brand forgetByAll(UxsUserContext userContext, String brandId, int brandVersion) throws Exception {
		return forgetByAllInternal(userContext, brandId, brandVersion);		
	}
	protected Brand forgetByAllInternal(UxsUserContext userContext,
			String brandId, int brandVersion) throws Exception{
			
		return userContext.getDAOGroup().getBrandDAO().disconnectFromAll(brandId, brandVersion);
	}
	

	
	public int deleteAll(UxsUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new BrandManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(UxsUserContext userContext) throws Exception{
		return userContext.getDAOGroup().getBrandDAO().deleteAll();
	}


	//disconnect Brand with parent_category in Product
	protected Brand breakWithProductByParentCategory(UxsUserContext userContext, String brandId, String parentCategoryId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Brand brand = loadBrand(userContext, brandId, allTokens());

			synchronized(brand){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getBrandDAO().planToRemoveProductListWithParentCategory(brand, parentCategoryId, this.emptyOptions());

				brand = saveBrand(userContext, brand, tokens().withProductList().done());
				return brand;
			}
	}
	//disconnect Brand with catalog in Product
	protected Brand breakWithProductByCatalog(UxsUserContext userContext, String brandId, String catalogId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Brand brand = loadBrand(userContext, brandId, allTokens());

			synchronized(brand){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getBrandDAO().planToRemoveProductListWithCatalog(brand, catalogId, this.emptyOptions());

				brand = saveBrand(userContext, brand, tokens().withProductList().done());
				return brand;
			}
	}
	//disconnect Brand with platform in Product
	protected Brand breakWithProductByPlatform(UxsUserContext userContext, String brandId, String platformId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Brand brand = loadBrand(userContext, brandId, allTokens());

			synchronized(brand){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getBrandDAO().planToRemoveProductListWithPlatform(brand, platformId, this.emptyOptions());

				brand = saveBrand(userContext, brand, tokens().withProductList().done());
				return brand;
			}
	}
	//disconnect Brand with parent_category in NewProduct
	protected Brand breakWithNewProductByParentCategory(UxsUserContext userContext, String brandId, String parentCategoryId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Brand brand = loadBrand(userContext, brandId, allTokens());

			synchronized(brand){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getBrandDAO().planToRemoveNewProductListWithParentCategory(brand, parentCategoryId, this.emptyOptions());

				brand = saveBrand(userContext, brand, tokens().withNewProductList().done());
				return brand;
			}
	}
	//disconnect Brand with catalog in NewProduct
	protected Brand breakWithNewProductByCatalog(UxsUserContext userContext, String brandId, String catalogId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Brand brand = loadBrand(userContext, brandId, allTokens());

			synchronized(brand){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getBrandDAO().planToRemoveNewProductListWithCatalog(brand, catalogId, this.emptyOptions());

				brand = saveBrand(userContext, brand, tokens().withNewProductList().done());
				return brand;
			}
	}
	//disconnect Brand with profile in NewProduct
	protected Brand breakWithNewProductByProfile(UxsUserContext userContext, String brandId, String profileId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Brand brand = loadBrand(userContext, brandId, allTokens());

			synchronized(brand){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getBrandDAO().planToRemoveNewProductListWithProfile(brand, profileId, this.emptyOptions());

				brand = saveBrand(userContext, brand, tokens().withNewProductList().done());
				return brand;
			}
	}
	//disconnect Brand with platform in NewProduct
	protected Brand breakWithNewProductByPlatform(UxsUserContext userContext, String brandId, String platformId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Brand brand = loadBrand(userContext, brandId, allTokens());

			synchronized(brand){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getBrandDAO().planToRemoveNewProductListWithPlatform(brand, platformId, this.emptyOptions());

				brand = saveBrand(userContext, brand, tokens().withNewProductList().done());
				return brand;
			}
	}
	//disconnect Brand with parent_category in EditorPickProduct
	protected Brand breakWithEditorPickProductByParentCategory(UxsUserContext userContext, String brandId, String parentCategoryId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Brand brand = loadBrand(userContext, brandId, allTokens());

			synchronized(brand){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getBrandDAO().planToRemoveEditorPickProductListWithParentCategory(brand, parentCategoryId, this.emptyOptions());

				brand = saveBrand(userContext, brand, tokens().withEditorPickProductList().done());
				return brand;
			}
	}
	//disconnect Brand with catalog in EditorPickProduct
	protected Brand breakWithEditorPickProductByCatalog(UxsUserContext userContext, String brandId, String catalogId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Brand brand = loadBrand(userContext, brandId, allTokens());

			synchronized(brand){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getBrandDAO().planToRemoveEditorPickProductListWithCatalog(brand, catalogId, this.emptyOptions());

				brand = saveBrand(userContext, brand, tokens().withEditorPickProductList().done());
				return brand;
			}
	}
	//disconnect Brand with profile in EditorPickProduct
	protected Brand breakWithEditorPickProductByProfile(UxsUserContext userContext, String brandId, String profileId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Brand brand = loadBrand(userContext, brandId, allTokens());

			synchronized(brand){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getBrandDAO().planToRemoveEditorPickProductListWithProfile(brand, profileId, this.emptyOptions());

				brand = saveBrand(userContext, brand, tokens().withEditorPickProductList().done());
				return brand;
			}
	}
	//disconnect Brand with platform in EditorPickProduct
	protected Brand breakWithEditorPickProductByPlatform(UxsUserContext userContext, String brandId, String platformId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Brand brand = loadBrand(userContext, brandId, allTokens());

			synchronized(brand){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getBrandDAO().planToRemoveEditorPickProductListWithPlatform(brand, platformId, this.emptyOptions());

				brand = saveBrand(userContext, brand, tokens().withEditorPickProductList().done());
				return brand;
			}
	}
	//disconnect Brand with parent_category in TopRatedProduct
	protected Brand breakWithTopRatedProductByParentCategory(UxsUserContext userContext, String brandId, String parentCategoryId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Brand brand = loadBrand(userContext, brandId, allTokens());

			synchronized(brand){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getBrandDAO().planToRemoveTopRatedProductListWithParentCategory(brand, parentCategoryId, this.emptyOptions());

				brand = saveBrand(userContext, brand, tokens().withTopRatedProductList().done());
				return brand;
			}
	}
	//disconnect Brand with catalog in TopRatedProduct
	protected Brand breakWithTopRatedProductByCatalog(UxsUserContext userContext, String brandId, String catalogId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Brand brand = loadBrand(userContext, brandId, allTokens());

			synchronized(brand){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getBrandDAO().planToRemoveTopRatedProductListWithCatalog(brand, catalogId, this.emptyOptions());

				brand = saveBrand(userContext, brand, tokens().withTopRatedProductList().done());
				return brand;
			}
	}
	//disconnect Brand with profile in TopRatedProduct
	protected Brand breakWithTopRatedProductByProfile(UxsUserContext userContext, String brandId, String profileId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Brand brand = loadBrand(userContext, brandId, allTokens());

			synchronized(brand){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getBrandDAO().planToRemoveTopRatedProductListWithProfile(brand, profileId, this.emptyOptions());

				brand = saveBrand(userContext, brand, tokens().withTopRatedProductList().done());
				return brand;
			}
	}
	//disconnect Brand with platform in TopRatedProduct
	protected Brand breakWithTopRatedProductByPlatform(UxsUserContext userContext, String brandId, String platformId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Brand brand = loadBrand(userContext, brandId, allTokens());

			synchronized(brand){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getBrandDAO().planToRemoveTopRatedProductListWithPlatform(brand, platformId, this.emptyOptions());

				brand = saveBrand(userContext, brand, tokens().withTopRatedProductList().done());
				return brand;
			}
	}
	//disconnect Brand with parent_category in RecommandProduct
	protected Brand breakWithRecommandProductByParentCategory(UxsUserContext userContext, String brandId, String parentCategoryId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Brand brand = loadBrand(userContext, brandId, allTokens());

			synchronized(brand){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getBrandDAO().planToRemoveRecommandProductListWithParentCategory(brand, parentCategoryId, this.emptyOptions());

				brand = saveBrand(userContext, brand, tokens().withRecommandProductList().done());
				return brand;
			}
	}
	//disconnect Brand with catalog in RecommandProduct
	protected Brand breakWithRecommandProductByCatalog(UxsUserContext userContext, String brandId, String catalogId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Brand brand = loadBrand(userContext, brandId, allTokens());

			synchronized(brand){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getBrandDAO().planToRemoveRecommandProductListWithCatalog(brand, catalogId, this.emptyOptions());

				brand = saveBrand(userContext, brand, tokens().withRecommandProductList().done());
				return brand;
			}
	}
	//disconnect Brand with profile in RecommandProduct
	protected Brand breakWithRecommandProductByProfile(UxsUserContext userContext, String brandId, String profileId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Brand brand = loadBrand(userContext, brandId, allTokens());

			synchronized(brand){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getBrandDAO().planToRemoveRecommandProductListWithProfile(brand, profileId, this.emptyOptions());

				brand = saveBrand(userContext, brand, tokens().withRecommandProductList().done());
				return brand;
			}
	}
	//disconnect Brand with platform in RecommandProduct
	protected Brand breakWithRecommandProductByPlatform(UxsUserContext userContext, String brandId, String platformId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Brand brand = loadBrand(userContext, brandId, allTokens());

			synchronized(brand){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getBrandDAO().planToRemoveRecommandProductListWithPlatform(brand, platformId, this.emptyOptions());

				brand = saveBrand(userContext, brand, tokens().withRecommandProductList().done());
				return brand;
			}
	}
	
	
	
	
	

	protected void checkParamsForAddingProduct(UxsUserContext userContext, String brandId, String name, String parentCategoryId, String productCoverImage, String origin, String catalogId, String remark, String platformId,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfBrand(brandId);

		
		userContext.getChecker().checkNameOfProduct(name);
		
		userContext.getChecker().checkParentCategoryIdOfProduct(parentCategoryId);
		
		userContext.getChecker().checkProductCoverImageOfProduct(productCoverImage);
		
		userContext.getChecker().checkOriginOfProduct(origin);
		
		userContext.getChecker().checkCatalogIdOfProduct(catalogId);
		
		userContext.getChecker().checkRemarkOfProduct(remark);
		
		userContext.getChecker().checkPlatformIdOfProduct(platformId);
	
		userContext.getChecker().throwExceptionIfHasErrors(BrandManagerException.class);

	
	}
	public  Brand addProduct(UxsUserContext userContext, String brandId, String name, String parentCategoryId, String productCoverImage, String origin, String catalogId, String remark, String platformId, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingProduct(userContext,brandId,name, parentCategoryId, productCoverImage, origin, catalogId, remark, platformId,tokensExpr);
		
		Product product = createProduct(userContext,name, parentCategoryId, productCoverImage, origin, catalogId, remark, platformId);
		
		Brand brand = loadBrand(userContext, brandId, allTokens());
		synchronized(brand){ 
			//Will be good when the brand loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			brand.addProduct( product );		
			brand = saveBrand(userContext, brand, tokens().withProductList().done());
			
			userContext.getManagerGroup().getProductManager().onNewInstanceCreated(userContext, product);
			return present(userContext,brand, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingProductProperties(UxsUserContext userContext, String brandId,String id,String name,String productCoverImage,String origin,String remark,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfBrand(brandId);
		userContext.getChecker().checkIdOfProduct(id);
		
		userContext.getChecker().checkNameOfProduct( name);
		userContext.getChecker().checkProductCoverImageOfProduct( productCoverImage);
		userContext.getChecker().checkOriginOfProduct( origin);
		userContext.getChecker().checkRemarkOfProduct( remark);

		userContext.getChecker().throwExceptionIfHasErrors(BrandManagerException.class);
		
	}
	public  Brand updateProductProperties(UxsUserContext userContext, String brandId, String id,String name,String productCoverImage,String origin,String remark, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingProductProperties(userContext,brandId,id,name,productCoverImage,origin,remark,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withProductListList()
				.searchProductListWith(Product.ID_PROPERTY, "is", id).done();
		
		Brand brandToUpdate = loadBrand(userContext, brandId, options);
		
		if(brandToUpdate.getProductList().isEmpty()){
			throw new BrandManagerException("Product is NOT FOUND with id: '"+id+"'");
		}
		
		Product item = brandToUpdate.getProductList().first();
		
		item.updateName( name );
		item.updateProductCoverImage( productCoverImage );
		item.updateOrigin( origin );
		item.updateRemark( remark );

		
		//checkParamsForAddingProduct(userContext,brandId,name, code, used,tokensExpr);
		Brand brand = saveBrand(userContext, brandToUpdate, tokens().withProductList().done());
		synchronized(brand){ 
			return present(userContext,brand, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected Product createProduct(UxsUserContext userContext, String name, String parentCategoryId, String productCoverImage, String origin, String catalogId, String remark, String platformId) throws Exception{

		Product product = new Product();
		
		
		product.setName(name);		
		LevelNCategory  parentCategory = new LevelNCategory();
		parentCategory.setId(parentCategoryId);		
		product.setParentCategory(parentCategory);		
		product.setProductCoverImage(productCoverImage);		
		product.setOrigin(origin);		
		Catalog  catalog = new Catalog();
		catalog.setId(catalogId);		
		product.setCatalog(catalog);		
		product.setRemark(remark);		
		product.setLastUpdateTime(userContext.now());		
		Platform  platform = new Platform();
		platform.setId(platformId);		
		product.setPlatform(platform);
	
		
		return product;
	
		
	}
	
	protected Product createIndexedProduct(String id, int version){

		Product product = new Product();
		product.setId(id);
		product.setVersion(version);
		return product;			
		
	}
	
	protected void checkParamsForRemovingProductList(UxsUserContext userContext, String brandId, 
			String productIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfBrand(brandId);
		for(String productId: productIds){
			userContext.getChecker().checkIdOfProduct(productId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(BrandManagerException.class);
		
	}
	public  Brand removeProductList(UxsUserContext userContext, String brandId, 
			String productIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingProductList(userContext, brandId,  productIds, tokensExpr);
			
			
			Brand brand = loadBrand(userContext, brandId, allTokens());
			synchronized(brand){ 
				//Will be good when the brand loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getBrandDAO().planToRemoveProductList(brand, productIds, allTokens());
				brand = saveBrand(userContext, brand, tokens().withProductList().done());
				deleteRelationListInGraph(userContext, brand.getProductList());
				return present(userContext,brand, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingProduct(UxsUserContext userContext, String brandId, 
		String productId, int productVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfBrand( brandId);
		userContext.getChecker().checkIdOfProduct(productId);
		userContext.getChecker().checkVersionOfProduct(productVersion);
		userContext.getChecker().throwExceptionIfHasErrors(BrandManagerException.class);
	
	}
	public  Brand removeProduct(UxsUserContext userContext, String brandId, 
		String productId, int productVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingProduct(userContext,brandId, productId, productVersion,tokensExpr);
		
		Product product = createIndexedProduct(productId, productVersion);
		Brand brand = loadBrand(userContext, brandId, allTokens());
		synchronized(brand){ 
			//Will be good when the brand loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			brand.removeProduct( product );		
			brand = saveBrand(userContext, brand, tokens().withProductList().done());
			deleteRelationInGraph(userContext, product);
			return present(userContext,brand, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingProduct(UxsUserContext userContext, String brandId, 
		String productId, int productVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfBrand( brandId);
		userContext.getChecker().checkIdOfProduct(productId);
		userContext.getChecker().checkVersionOfProduct(productVersion);
		userContext.getChecker().throwExceptionIfHasErrors(BrandManagerException.class);
	
	}
	public  Brand copyProductFrom(UxsUserContext userContext, String brandId, 
		String productId, int productVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingProduct(userContext,brandId, productId, productVersion,tokensExpr);
		
		Product product = createIndexedProduct(productId, productVersion);
		Brand brand = loadBrand(userContext, brandId, allTokens());
		synchronized(brand){ 
			//Will be good when the brand loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			product.updateLastUpdateTime(userContext.now());
			
			brand.copyProductFrom( product );		
			brand = saveBrand(userContext, brand, tokens().withProductList().done());
			
			userContext.getManagerGroup().getProductManager().onNewInstanceCreated(userContext, (Product)brand.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,brand, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingProduct(UxsUserContext userContext, String brandId, String productId, int productVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfBrand(brandId);
		userContext.getChecker().checkIdOfProduct(productId);
		userContext.getChecker().checkVersionOfProduct(productVersion);
		

		if(Product.NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkNameOfProduct(parseString(newValueExpr));
		}
		
		if(Product.PRODUCT_COVER_IMAGE_PROPERTY.equals(property)){
			userContext.getChecker().checkProductCoverImageOfProduct(parseString(newValueExpr));
		}
		
		if(Product.ORIGIN_PROPERTY.equals(property)){
			userContext.getChecker().checkOriginOfProduct(parseString(newValueExpr));
		}
		
		if(Product.REMARK_PROPERTY.equals(property)){
			userContext.getChecker().checkRemarkOfProduct(parseString(newValueExpr));
		}
		
	
		userContext.getChecker().throwExceptionIfHasErrors(BrandManagerException.class);
	
	}
	
	public  Brand updateProduct(UxsUserContext userContext, String brandId, String productId, int productVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingProduct(userContext, brandId, productId, productVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withProductList().searchProductListWith(Product.ID_PROPERTY, "eq", productId).done();
		
		
		
		Brand brand = loadBrand(userContext, brandId, loadTokens);
		
		synchronized(brand){ 
			//Will be good when the brand loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//brand.removeProduct( product );	
			//make changes to AcceleraterAccount.
			Product productIndex = createIndexedProduct(productId, productVersion);
		
			Product product = brand.findTheProduct(productIndex);
			if(product == null){
				throw new BrandManagerException(product+" is NOT FOUND" );
			}
			
			product.changeProperty(property, newValueExpr);
			product.updateLastUpdateTime(userContext.now());
			brand = saveBrand(userContext, brand, tokens().withProductList().done());
			return present(userContext,brand, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	protected void checkParamsForAddingNewProduct(UxsUserContext userContext, String brandId, String name, String parentCategoryId, String productCoverImage, String origin, String catalogId, String profileId, String remark, String platformId,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfBrand(brandId);

		
		userContext.getChecker().checkNameOfNewProduct(name);
		
		userContext.getChecker().checkParentCategoryIdOfNewProduct(parentCategoryId);
		
		userContext.getChecker().checkProductCoverImageOfNewProduct(productCoverImage);
		
		userContext.getChecker().checkOriginOfNewProduct(origin);
		
		userContext.getChecker().checkCatalogIdOfNewProduct(catalogId);
		
		userContext.getChecker().checkProfileIdOfNewProduct(profileId);
		
		userContext.getChecker().checkRemarkOfNewProduct(remark);
		
		userContext.getChecker().checkPlatformIdOfNewProduct(platformId);
	
		userContext.getChecker().throwExceptionIfHasErrors(BrandManagerException.class);

	
	}
	public  Brand addNewProduct(UxsUserContext userContext, String brandId, String name, String parentCategoryId, String productCoverImage, String origin, String catalogId, String profileId, String remark, String platformId, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingNewProduct(userContext,brandId,name, parentCategoryId, productCoverImage, origin, catalogId, profileId, remark, platformId,tokensExpr);
		
		NewProduct newProduct = createNewProduct(userContext,name, parentCategoryId, productCoverImage, origin, catalogId, profileId, remark, platformId);
		
		Brand brand = loadBrand(userContext, brandId, allTokens());
		synchronized(brand){ 
			//Will be good when the brand loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			brand.addNewProduct( newProduct );		
			brand = saveBrand(userContext, brand, tokens().withNewProductList().done());
			
			userContext.getManagerGroup().getNewProductManager().onNewInstanceCreated(userContext, newProduct);
			return present(userContext,brand, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingNewProductProperties(UxsUserContext userContext, String brandId,String id,String name,String productCoverImage,String origin,String remark,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfBrand(brandId);
		userContext.getChecker().checkIdOfNewProduct(id);
		
		userContext.getChecker().checkNameOfNewProduct( name);
		userContext.getChecker().checkProductCoverImageOfNewProduct( productCoverImage);
		userContext.getChecker().checkOriginOfNewProduct( origin);
		userContext.getChecker().checkRemarkOfNewProduct( remark);

		userContext.getChecker().throwExceptionIfHasErrors(BrandManagerException.class);
		
	}
	public  Brand updateNewProductProperties(UxsUserContext userContext, String brandId, String id,String name,String productCoverImage,String origin,String remark, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingNewProductProperties(userContext,brandId,id,name,productCoverImage,origin,remark,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withNewProductListList()
				.searchNewProductListWith(NewProduct.ID_PROPERTY, "is", id).done();
		
		Brand brandToUpdate = loadBrand(userContext, brandId, options);
		
		if(brandToUpdate.getNewProductList().isEmpty()){
			throw new BrandManagerException("NewProduct is NOT FOUND with id: '"+id+"'");
		}
		
		NewProduct item = brandToUpdate.getNewProductList().first();
		
		item.updateName( name );
		item.updateProductCoverImage( productCoverImage );
		item.updateOrigin( origin );
		item.updateRemark( remark );

		
		//checkParamsForAddingNewProduct(userContext,brandId,name, code, used,tokensExpr);
		Brand brand = saveBrand(userContext, brandToUpdate, tokens().withNewProductList().done());
		synchronized(brand){ 
			return present(userContext,brand, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected NewProduct createNewProduct(UxsUserContext userContext, String name, String parentCategoryId, String productCoverImage, String origin, String catalogId, String profileId, String remark, String platformId) throws Exception{

		NewProduct newProduct = new NewProduct();
		
		
		newProduct.setName(name);		
		LevelNCategory  parentCategory = new LevelNCategory();
		parentCategory.setId(parentCategoryId);		
		newProduct.setParentCategory(parentCategory);		
		newProduct.setProductCoverImage(productCoverImage);		
		newProduct.setOrigin(origin);		
		Catalog  catalog = new Catalog();
		catalog.setId(catalogId);		
		newProduct.setCatalog(catalog);		
		Profile  profile = new Profile();
		profile.setId(profileId);		
		newProduct.setProfile(profile);		
		newProduct.setRemark(remark);		
		newProduct.setLastUpdateTime(userContext.now());		
		Platform  platform = new Platform();
		platform.setId(platformId);		
		newProduct.setPlatform(platform);
	
		
		return newProduct;
	
		
	}
	
	protected NewProduct createIndexedNewProduct(String id, int version){

		NewProduct newProduct = new NewProduct();
		newProduct.setId(id);
		newProduct.setVersion(version);
		return newProduct;			
		
	}
	
	protected void checkParamsForRemovingNewProductList(UxsUserContext userContext, String brandId, 
			String newProductIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfBrand(brandId);
		for(String newProductId: newProductIds){
			userContext.getChecker().checkIdOfNewProduct(newProductId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(BrandManagerException.class);
		
	}
	public  Brand removeNewProductList(UxsUserContext userContext, String brandId, 
			String newProductIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingNewProductList(userContext, brandId,  newProductIds, tokensExpr);
			
			
			Brand brand = loadBrand(userContext, brandId, allTokens());
			synchronized(brand){ 
				//Will be good when the brand loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getBrandDAO().planToRemoveNewProductList(brand, newProductIds, allTokens());
				brand = saveBrand(userContext, brand, tokens().withNewProductList().done());
				deleteRelationListInGraph(userContext, brand.getNewProductList());
				return present(userContext,brand, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingNewProduct(UxsUserContext userContext, String brandId, 
		String newProductId, int newProductVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfBrand( brandId);
		userContext.getChecker().checkIdOfNewProduct(newProductId);
		userContext.getChecker().checkVersionOfNewProduct(newProductVersion);
		userContext.getChecker().throwExceptionIfHasErrors(BrandManagerException.class);
	
	}
	public  Brand removeNewProduct(UxsUserContext userContext, String brandId, 
		String newProductId, int newProductVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingNewProduct(userContext,brandId, newProductId, newProductVersion,tokensExpr);
		
		NewProduct newProduct = createIndexedNewProduct(newProductId, newProductVersion);
		Brand brand = loadBrand(userContext, brandId, allTokens());
		synchronized(brand){ 
			//Will be good when the brand loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			brand.removeNewProduct( newProduct );		
			brand = saveBrand(userContext, brand, tokens().withNewProductList().done());
			deleteRelationInGraph(userContext, newProduct);
			return present(userContext,brand, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingNewProduct(UxsUserContext userContext, String brandId, 
		String newProductId, int newProductVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfBrand( brandId);
		userContext.getChecker().checkIdOfNewProduct(newProductId);
		userContext.getChecker().checkVersionOfNewProduct(newProductVersion);
		userContext.getChecker().throwExceptionIfHasErrors(BrandManagerException.class);
	
	}
	public  Brand copyNewProductFrom(UxsUserContext userContext, String brandId, 
		String newProductId, int newProductVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingNewProduct(userContext,brandId, newProductId, newProductVersion,tokensExpr);
		
		NewProduct newProduct = createIndexedNewProduct(newProductId, newProductVersion);
		Brand brand = loadBrand(userContext, brandId, allTokens());
		synchronized(brand){ 
			//Will be good when the brand loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			newProduct.updateLastUpdateTime(userContext.now());
			
			brand.copyNewProductFrom( newProduct );		
			brand = saveBrand(userContext, brand, tokens().withNewProductList().done());
			
			userContext.getManagerGroup().getNewProductManager().onNewInstanceCreated(userContext, (NewProduct)brand.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,brand, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingNewProduct(UxsUserContext userContext, String brandId, String newProductId, int newProductVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfBrand(brandId);
		userContext.getChecker().checkIdOfNewProduct(newProductId);
		userContext.getChecker().checkVersionOfNewProduct(newProductVersion);
		

		if(NewProduct.NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkNameOfNewProduct(parseString(newValueExpr));
		}
		
		if(NewProduct.PRODUCT_COVER_IMAGE_PROPERTY.equals(property)){
			userContext.getChecker().checkProductCoverImageOfNewProduct(parseString(newValueExpr));
		}
		
		if(NewProduct.ORIGIN_PROPERTY.equals(property)){
			userContext.getChecker().checkOriginOfNewProduct(parseString(newValueExpr));
		}
		
		if(NewProduct.REMARK_PROPERTY.equals(property)){
			userContext.getChecker().checkRemarkOfNewProduct(parseString(newValueExpr));
		}
		
	
		userContext.getChecker().throwExceptionIfHasErrors(BrandManagerException.class);
	
	}
	
	public  Brand updateNewProduct(UxsUserContext userContext, String brandId, String newProductId, int newProductVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingNewProduct(userContext, brandId, newProductId, newProductVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withNewProductList().searchNewProductListWith(NewProduct.ID_PROPERTY, "eq", newProductId).done();
		
		
		
		Brand brand = loadBrand(userContext, brandId, loadTokens);
		
		synchronized(brand){ 
			//Will be good when the brand loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//brand.removeNewProduct( newProduct );	
			//make changes to AcceleraterAccount.
			NewProduct newProductIndex = createIndexedNewProduct(newProductId, newProductVersion);
		
			NewProduct newProduct = brand.findTheNewProduct(newProductIndex);
			if(newProduct == null){
				throw new BrandManagerException(newProduct+" is NOT FOUND" );
			}
			
			newProduct.changeProperty(property, newValueExpr);
			newProduct.updateLastUpdateTime(userContext.now());
			brand = saveBrand(userContext, brand, tokens().withNewProductList().done());
			return present(userContext,brand, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	protected void checkParamsForAddingEditorPickProduct(UxsUserContext userContext, String brandId, String name, String parentCategoryId, String productCoverImage, String origin, String catalogId, String profileId, String remark, String platformId,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfBrand(brandId);

		
		userContext.getChecker().checkNameOfEditorPickProduct(name);
		
		userContext.getChecker().checkParentCategoryIdOfEditorPickProduct(parentCategoryId);
		
		userContext.getChecker().checkProductCoverImageOfEditorPickProduct(productCoverImage);
		
		userContext.getChecker().checkOriginOfEditorPickProduct(origin);
		
		userContext.getChecker().checkCatalogIdOfEditorPickProduct(catalogId);
		
		userContext.getChecker().checkProfileIdOfEditorPickProduct(profileId);
		
		userContext.getChecker().checkRemarkOfEditorPickProduct(remark);
		
		userContext.getChecker().checkPlatformIdOfEditorPickProduct(platformId);
	
		userContext.getChecker().throwExceptionIfHasErrors(BrandManagerException.class);

	
	}
	public  Brand addEditorPickProduct(UxsUserContext userContext, String brandId, String name, String parentCategoryId, String productCoverImage, String origin, String catalogId, String profileId, String remark, String platformId, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingEditorPickProduct(userContext,brandId,name, parentCategoryId, productCoverImage, origin, catalogId, profileId, remark, platformId,tokensExpr);
		
		EditorPickProduct editorPickProduct = createEditorPickProduct(userContext,name, parentCategoryId, productCoverImage, origin, catalogId, profileId, remark, platformId);
		
		Brand brand = loadBrand(userContext, brandId, allTokens());
		synchronized(brand){ 
			//Will be good when the brand loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			brand.addEditorPickProduct( editorPickProduct );		
			brand = saveBrand(userContext, brand, tokens().withEditorPickProductList().done());
			
			userContext.getManagerGroup().getEditorPickProductManager().onNewInstanceCreated(userContext, editorPickProduct);
			return present(userContext,brand, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingEditorPickProductProperties(UxsUserContext userContext, String brandId,String id,String name,String productCoverImage,String origin,String remark,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfBrand(brandId);
		userContext.getChecker().checkIdOfEditorPickProduct(id);
		
		userContext.getChecker().checkNameOfEditorPickProduct( name);
		userContext.getChecker().checkProductCoverImageOfEditorPickProduct( productCoverImage);
		userContext.getChecker().checkOriginOfEditorPickProduct( origin);
		userContext.getChecker().checkRemarkOfEditorPickProduct( remark);

		userContext.getChecker().throwExceptionIfHasErrors(BrandManagerException.class);
		
	}
	public  Brand updateEditorPickProductProperties(UxsUserContext userContext, String brandId, String id,String name,String productCoverImage,String origin,String remark, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingEditorPickProductProperties(userContext,brandId,id,name,productCoverImage,origin,remark,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withEditorPickProductListList()
				.searchEditorPickProductListWith(EditorPickProduct.ID_PROPERTY, "is", id).done();
		
		Brand brandToUpdate = loadBrand(userContext, brandId, options);
		
		if(brandToUpdate.getEditorPickProductList().isEmpty()){
			throw new BrandManagerException("EditorPickProduct is NOT FOUND with id: '"+id+"'");
		}
		
		EditorPickProduct item = brandToUpdate.getEditorPickProductList().first();
		
		item.updateName( name );
		item.updateProductCoverImage( productCoverImage );
		item.updateOrigin( origin );
		item.updateRemark( remark );

		
		//checkParamsForAddingEditorPickProduct(userContext,brandId,name, code, used,tokensExpr);
		Brand brand = saveBrand(userContext, brandToUpdate, tokens().withEditorPickProductList().done());
		synchronized(brand){ 
			return present(userContext,brand, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected EditorPickProduct createEditorPickProduct(UxsUserContext userContext, String name, String parentCategoryId, String productCoverImage, String origin, String catalogId, String profileId, String remark, String platformId) throws Exception{

		EditorPickProduct editorPickProduct = new EditorPickProduct();
		
		
		editorPickProduct.setName(name);		
		LevelNCategory  parentCategory = new LevelNCategory();
		parentCategory.setId(parentCategoryId);		
		editorPickProduct.setParentCategory(parentCategory);		
		editorPickProduct.setProductCoverImage(productCoverImage);		
		editorPickProduct.setOrigin(origin);		
		Catalog  catalog = new Catalog();
		catalog.setId(catalogId);		
		editorPickProduct.setCatalog(catalog);		
		Profile  profile = new Profile();
		profile.setId(profileId);		
		editorPickProduct.setProfile(profile);		
		editorPickProduct.setRemark(remark);		
		editorPickProduct.setLastUpdateTime(userContext.now());		
		Platform  platform = new Platform();
		platform.setId(platformId);		
		editorPickProduct.setPlatform(platform);
	
		
		return editorPickProduct;
	
		
	}
	
	protected EditorPickProduct createIndexedEditorPickProduct(String id, int version){

		EditorPickProduct editorPickProduct = new EditorPickProduct();
		editorPickProduct.setId(id);
		editorPickProduct.setVersion(version);
		return editorPickProduct;			
		
	}
	
	protected void checkParamsForRemovingEditorPickProductList(UxsUserContext userContext, String brandId, 
			String editorPickProductIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfBrand(brandId);
		for(String editorPickProductId: editorPickProductIds){
			userContext.getChecker().checkIdOfEditorPickProduct(editorPickProductId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(BrandManagerException.class);
		
	}
	public  Brand removeEditorPickProductList(UxsUserContext userContext, String brandId, 
			String editorPickProductIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingEditorPickProductList(userContext, brandId,  editorPickProductIds, tokensExpr);
			
			
			Brand brand = loadBrand(userContext, brandId, allTokens());
			synchronized(brand){ 
				//Will be good when the brand loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getBrandDAO().planToRemoveEditorPickProductList(brand, editorPickProductIds, allTokens());
				brand = saveBrand(userContext, brand, tokens().withEditorPickProductList().done());
				deleteRelationListInGraph(userContext, brand.getEditorPickProductList());
				return present(userContext,brand, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingEditorPickProduct(UxsUserContext userContext, String brandId, 
		String editorPickProductId, int editorPickProductVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfBrand( brandId);
		userContext.getChecker().checkIdOfEditorPickProduct(editorPickProductId);
		userContext.getChecker().checkVersionOfEditorPickProduct(editorPickProductVersion);
		userContext.getChecker().throwExceptionIfHasErrors(BrandManagerException.class);
	
	}
	public  Brand removeEditorPickProduct(UxsUserContext userContext, String brandId, 
		String editorPickProductId, int editorPickProductVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingEditorPickProduct(userContext,brandId, editorPickProductId, editorPickProductVersion,tokensExpr);
		
		EditorPickProduct editorPickProduct = createIndexedEditorPickProduct(editorPickProductId, editorPickProductVersion);
		Brand brand = loadBrand(userContext, brandId, allTokens());
		synchronized(brand){ 
			//Will be good when the brand loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			brand.removeEditorPickProduct( editorPickProduct );		
			brand = saveBrand(userContext, brand, tokens().withEditorPickProductList().done());
			deleteRelationInGraph(userContext, editorPickProduct);
			return present(userContext,brand, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingEditorPickProduct(UxsUserContext userContext, String brandId, 
		String editorPickProductId, int editorPickProductVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfBrand( brandId);
		userContext.getChecker().checkIdOfEditorPickProduct(editorPickProductId);
		userContext.getChecker().checkVersionOfEditorPickProduct(editorPickProductVersion);
		userContext.getChecker().throwExceptionIfHasErrors(BrandManagerException.class);
	
	}
	public  Brand copyEditorPickProductFrom(UxsUserContext userContext, String brandId, 
		String editorPickProductId, int editorPickProductVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingEditorPickProduct(userContext,brandId, editorPickProductId, editorPickProductVersion,tokensExpr);
		
		EditorPickProduct editorPickProduct = createIndexedEditorPickProduct(editorPickProductId, editorPickProductVersion);
		Brand brand = loadBrand(userContext, brandId, allTokens());
		synchronized(brand){ 
			//Will be good when the brand loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			editorPickProduct.updateLastUpdateTime(userContext.now());
			
			brand.copyEditorPickProductFrom( editorPickProduct );		
			brand = saveBrand(userContext, brand, tokens().withEditorPickProductList().done());
			
			userContext.getManagerGroup().getEditorPickProductManager().onNewInstanceCreated(userContext, (EditorPickProduct)brand.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,brand, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingEditorPickProduct(UxsUserContext userContext, String brandId, String editorPickProductId, int editorPickProductVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfBrand(brandId);
		userContext.getChecker().checkIdOfEditorPickProduct(editorPickProductId);
		userContext.getChecker().checkVersionOfEditorPickProduct(editorPickProductVersion);
		

		if(EditorPickProduct.NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkNameOfEditorPickProduct(parseString(newValueExpr));
		}
		
		if(EditorPickProduct.PRODUCT_COVER_IMAGE_PROPERTY.equals(property)){
			userContext.getChecker().checkProductCoverImageOfEditorPickProduct(parseString(newValueExpr));
		}
		
		if(EditorPickProduct.ORIGIN_PROPERTY.equals(property)){
			userContext.getChecker().checkOriginOfEditorPickProduct(parseString(newValueExpr));
		}
		
		if(EditorPickProduct.REMARK_PROPERTY.equals(property)){
			userContext.getChecker().checkRemarkOfEditorPickProduct(parseString(newValueExpr));
		}
		
	
		userContext.getChecker().throwExceptionIfHasErrors(BrandManagerException.class);
	
	}
	
	public  Brand updateEditorPickProduct(UxsUserContext userContext, String brandId, String editorPickProductId, int editorPickProductVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingEditorPickProduct(userContext, brandId, editorPickProductId, editorPickProductVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withEditorPickProductList().searchEditorPickProductListWith(EditorPickProduct.ID_PROPERTY, "eq", editorPickProductId).done();
		
		
		
		Brand brand = loadBrand(userContext, brandId, loadTokens);
		
		synchronized(brand){ 
			//Will be good when the brand loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//brand.removeEditorPickProduct( editorPickProduct );	
			//make changes to AcceleraterAccount.
			EditorPickProduct editorPickProductIndex = createIndexedEditorPickProduct(editorPickProductId, editorPickProductVersion);
		
			EditorPickProduct editorPickProduct = brand.findTheEditorPickProduct(editorPickProductIndex);
			if(editorPickProduct == null){
				throw new BrandManagerException(editorPickProduct+" is NOT FOUND" );
			}
			
			editorPickProduct.changeProperty(property, newValueExpr);
			editorPickProduct.updateLastUpdateTime(userContext.now());
			brand = saveBrand(userContext, brand, tokens().withEditorPickProductList().done());
			return present(userContext,brand, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	protected void checkParamsForAddingTopRatedProduct(UxsUserContext userContext, String brandId, String name, String parentCategoryId, String productCoverImage, String origin, String catalogId, String remark, String profileId, String platformId,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfBrand(brandId);

		
		userContext.getChecker().checkNameOfTopRatedProduct(name);
		
		userContext.getChecker().checkParentCategoryIdOfTopRatedProduct(parentCategoryId);
		
		userContext.getChecker().checkProductCoverImageOfTopRatedProduct(productCoverImage);
		
		userContext.getChecker().checkOriginOfTopRatedProduct(origin);
		
		userContext.getChecker().checkCatalogIdOfTopRatedProduct(catalogId);
		
		userContext.getChecker().checkRemarkOfTopRatedProduct(remark);
		
		userContext.getChecker().checkProfileIdOfTopRatedProduct(profileId);
		
		userContext.getChecker().checkPlatformIdOfTopRatedProduct(platformId);
	
		userContext.getChecker().throwExceptionIfHasErrors(BrandManagerException.class);

	
	}
	public  Brand addTopRatedProduct(UxsUserContext userContext, String brandId, String name, String parentCategoryId, String productCoverImage, String origin, String catalogId, String remark, String profileId, String platformId, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingTopRatedProduct(userContext,brandId,name, parentCategoryId, productCoverImage, origin, catalogId, remark, profileId, platformId,tokensExpr);
		
		TopRatedProduct topRatedProduct = createTopRatedProduct(userContext,name, parentCategoryId, productCoverImage, origin, catalogId, remark, profileId, platformId);
		
		Brand brand = loadBrand(userContext, brandId, allTokens());
		synchronized(brand){ 
			//Will be good when the brand loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			brand.addTopRatedProduct( topRatedProduct );		
			brand = saveBrand(userContext, brand, tokens().withTopRatedProductList().done());
			
			userContext.getManagerGroup().getTopRatedProductManager().onNewInstanceCreated(userContext, topRatedProduct);
			return present(userContext,brand, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingTopRatedProductProperties(UxsUserContext userContext, String brandId,String id,String name,String productCoverImage,String origin,String remark,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfBrand(brandId);
		userContext.getChecker().checkIdOfTopRatedProduct(id);
		
		userContext.getChecker().checkNameOfTopRatedProduct( name);
		userContext.getChecker().checkProductCoverImageOfTopRatedProduct( productCoverImage);
		userContext.getChecker().checkOriginOfTopRatedProduct( origin);
		userContext.getChecker().checkRemarkOfTopRatedProduct( remark);

		userContext.getChecker().throwExceptionIfHasErrors(BrandManagerException.class);
		
	}
	public  Brand updateTopRatedProductProperties(UxsUserContext userContext, String brandId, String id,String name,String productCoverImage,String origin,String remark, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingTopRatedProductProperties(userContext,brandId,id,name,productCoverImage,origin,remark,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withTopRatedProductListList()
				.searchTopRatedProductListWith(TopRatedProduct.ID_PROPERTY, "is", id).done();
		
		Brand brandToUpdate = loadBrand(userContext, brandId, options);
		
		if(brandToUpdate.getTopRatedProductList().isEmpty()){
			throw new BrandManagerException("TopRatedProduct is NOT FOUND with id: '"+id+"'");
		}
		
		TopRatedProduct item = brandToUpdate.getTopRatedProductList().first();
		
		item.updateName( name );
		item.updateProductCoverImage( productCoverImage );
		item.updateOrigin( origin );
		item.updateRemark( remark );

		
		//checkParamsForAddingTopRatedProduct(userContext,brandId,name, code, used,tokensExpr);
		Brand brand = saveBrand(userContext, brandToUpdate, tokens().withTopRatedProductList().done());
		synchronized(brand){ 
			return present(userContext,brand, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected TopRatedProduct createTopRatedProduct(UxsUserContext userContext, String name, String parentCategoryId, String productCoverImage, String origin, String catalogId, String remark, String profileId, String platformId) throws Exception{

		TopRatedProduct topRatedProduct = new TopRatedProduct();
		
		
		topRatedProduct.setName(name);		
		LevelNCategory  parentCategory = new LevelNCategory();
		parentCategory.setId(parentCategoryId);		
		topRatedProduct.setParentCategory(parentCategory);		
		topRatedProduct.setProductCoverImage(productCoverImage);		
		topRatedProduct.setOrigin(origin);		
		Catalog  catalog = new Catalog();
		catalog.setId(catalogId);		
		topRatedProduct.setCatalog(catalog);		
		topRatedProduct.setRemark(remark);		
		topRatedProduct.setLastUpdateTime(userContext.now());		
		Profile  profile = new Profile();
		profile.setId(profileId);		
		topRatedProduct.setProfile(profile);		
		Platform  platform = new Platform();
		platform.setId(platformId);		
		topRatedProduct.setPlatform(platform);
	
		
		return topRatedProduct;
	
		
	}
	
	protected TopRatedProduct createIndexedTopRatedProduct(String id, int version){

		TopRatedProduct topRatedProduct = new TopRatedProduct();
		topRatedProduct.setId(id);
		topRatedProduct.setVersion(version);
		return topRatedProduct;			
		
	}
	
	protected void checkParamsForRemovingTopRatedProductList(UxsUserContext userContext, String brandId, 
			String topRatedProductIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfBrand(brandId);
		for(String topRatedProductId: topRatedProductIds){
			userContext.getChecker().checkIdOfTopRatedProduct(topRatedProductId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(BrandManagerException.class);
		
	}
	public  Brand removeTopRatedProductList(UxsUserContext userContext, String brandId, 
			String topRatedProductIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingTopRatedProductList(userContext, brandId,  topRatedProductIds, tokensExpr);
			
			
			Brand brand = loadBrand(userContext, brandId, allTokens());
			synchronized(brand){ 
				//Will be good when the brand loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getBrandDAO().planToRemoveTopRatedProductList(brand, topRatedProductIds, allTokens());
				brand = saveBrand(userContext, brand, tokens().withTopRatedProductList().done());
				deleteRelationListInGraph(userContext, brand.getTopRatedProductList());
				return present(userContext,brand, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingTopRatedProduct(UxsUserContext userContext, String brandId, 
		String topRatedProductId, int topRatedProductVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfBrand( brandId);
		userContext.getChecker().checkIdOfTopRatedProduct(topRatedProductId);
		userContext.getChecker().checkVersionOfTopRatedProduct(topRatedProductVersion);
		userContext.getChecker().throwExceptionIfHasErrors(BrandManagerException.class);
	
	}
	public  Brand removeTopRatedProduct(UxsUserContext userContext, String brandId, 
		String topRatedProductId, int topRatedProductVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingTopRatedProduct(userContext,brandId, topRatedProductId, topRatedProductVersion,tokensExpr);
		
		TopRatedProduct topRatedProduct = createIndexedTopRatedProduct(topRatedProductId, topRatedProductVersion);
		Brand brand = loadBrand(userContext, brandId, allTokens());
		synchronized(brand){ 
			//Will be good when the brand loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			brand.removeTopRatedProduct( topRatedProduct );		
			brand = saveBrand(userContext, brand, tokens().withTopRatedProductList().done());
			deleteRelationInGraph(userContext, topRatedProduct);
			return present(userContext,brand, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingTopRatedProduct(UxsUserContext userContext, String brandId, 
		String topRatedProductId, int topRatedProductVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfBrand( brandId);
		userContext.getChecker().checkIdOfTopRatedProduct(topRatedProductId);
		userContext.getChecker().checkVersionOfTopRatedProduct(topRatedProductVersion);
		userContext.getChecker().throwExceptionIfHasErrors(BrandManagerException.class);
	
	}
	public  Brand copyTopRatedProductFrom(UxsUserContext userContext, String brandId, 
		String topRatedProductId, int topRatedProductVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingTopRatedProduct(userContext,brandId, topRatedProductId, topRatedProductVersion,tokensExpr);
		
		TopRatedProduct topRatedProduct = createIndexedTopRatedProduct(topRatedProductId, topRatedProductVersion);
		Brand brand = loadBrand(userContext, brandId, allTokens());
		synchronized(brand){ 
			//Will be good when the brand loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			topRatedProduct.updateLastUpdateTime(userContext.now());
			
			brand.copyTopRatedProductFrom( topRatedProduct );		
			brand = saveBrand(userContext, brand, tokens().withTopRatedProductList().done());
			
			userContext.getManagerGroup().getTopRatedProductManager().onNewInstanceCreated(userContext, (TopRatedProduct)brand.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,brand, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingTopRatedProduct(UxsUserContext userContext, String brandId, String topRatedProductId, int topRatedProductVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfBrand(brandId);
		userContext.getChecker().checkIdOfTopRatedProduct(topRatedProductId);
		userContext.getChecker().checkVersionOfTopRatedProduct(topRatedProductVersion);
		

		if(TopRatedProduct.NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkNameOfTopRatedProduct(parseString(newValueExpr));
		}
		
		if(TopRatedProduct.PRODUCT_COVER_IMAGE_PROPERTY.equals(property)){
			userContext.getChecker().checkProductCoverImageOfTopRatedProduct(parseString(newValueExpr));
		}
		
		if(TopRatedProduct.ORIGIN_PROPERTY.equals(property)){
			userContext.getChecker().checkOriginOfTopRatedProduct(parseString(newValueExpr));
		}
		
		if(TopRatedProduct.REMARK_PROPERTY.equals(property)){
			userContext.getChecker().checkRemarkOfTopRatedProduct(parseString(newValueExpr));
		}
		
	
		userContext.getChecker().throwExceptionIfHasErrors(BrandManagerException.class);
	
	}
	
	public  Brand updateTopRatedProduct(UxsUserContext userContext, String brandId, String topRatedProductId, int topRatedProductVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingTopRatedProduct(userContext, brandId, topRatedProductId, topRatedProductVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withTopRatedProductList().searchTopRatedProductListWith(TopRatedProduct.ID_PROPERTY, "eq", topRatedProductId).done();
		
		
		
		Brand brand = loadBrand(userContext, brandId, loadTokens);
		
		synchronized(brand){ 
			//Will be good when the brand loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//brand.removeTopRatedProduct( topRatedProduct );	
			//make changes to AcceleraterAccount.
			TopRatedProduct topRatedProductIndex = createIndexedTopRatedProduct(topRatedProductId, topRatedProductVersion);
		
			TopRatedProduct topRatedProduct = brand.findTheTopRatedProduct(topRatedProductIndex);
			if(topRatedProduct == null){
				throw new BrandManagerException(topRatedProduct+" is NOT FOUND" );
			}
			
			topRatedProduct.changeProperty(property, newValueExpr);
			topRatedProduct.updateLastUpdateTime(userContext.now());
			brand = saveBrand(userContext, brand, tokens().withTopRatedProductList().done());
			return present(userContext,brand, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	protected void checkParamsForAddingRecommandProduct(UxsUserContext userContext, String brandId, String name, String parentCategoryId, String productCoverImage, String origin, String catalogId, String remark, String profileId, String platformId,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfBrand(brandId);

		
		userContext.getChecker().checkNameOfRecommandProduct(name);
		
		userContext.getChecker().checkParentCategoryIdOfRecommandProduct(parentCategoryId);
		
		userContext.getChecker().checkProductCoverImageOfRecommandProduct(productCoverImage);
		
		userContext.getChecker().checkOriginOfRecommandProduct(origin);
		
		userContext.getChecker().checkCatalogIdOfRecommandProduct(catalogId);
		
		userContext.getChecker().checkRemarkOfRecommandProduct(remark);
		
		userContext.getChecker().checkProfileIdOfRecommandProduct(profileId);
		
		userContext.getChecker().checkPlatformIdOfRecommandProduct(platformId);
	
		userContext.getChecker().throwExceptionIfHasErrors(BrandManagerException.class);

	
	}
	public  Brand addRecommandProduct(UxsUserContext userContext, String brandId, String name, String parentCategoryId, String productCoverImage, String origin, String catalogId, String remark, String profileId, String platformId, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingRecommandProduct(userContext,brandId,name, parentCategoryId, productCoverImage, origin, catalogId, remark, profileId, platformId,tokensExpr);
		
		RecommandProduct recommandProduct = createRecommandProduct(userContext,name, parentCategoryId, productCoverImage, origin, catalogId, remark, profileId, platformId);
		
		Brand brand = loadBrand(userContext, brandId, allTokens());
		synchronized(brand){ 
			//Will be good when the brand loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			brand.addRecommandProduct( recommandProduct );		
			brand = saveBrand(userContext, brand, tokens().withRecommandProductList().done());
			
			userContext.getManagerGroup().getRecommandProductManager().onNewInstanceCreated(userContext, recommandProduct);
			return present(userContext,brand, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingRecommandProductProperties(UxsUserContext userContext, String brandId,String id,String name,String productCoverImage,String origin,String remark,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfBrand(brandId);
		userContext.getChecker().checkIdOfRecommandProduct(id);
		
		userContext.getChecker().checkNameOfRecommandProduct( name);
		userContext.getChecker().checkProductCoverImageOfRecommandProduct( productCoverImage);
		userContext.getChecker().checkOriginOfRecommandProduct( origin);
		userContext.getChecker().checkRemarkOfRecommandProduct( remark);

		userContext.getChecker().throwExceptionIfHasErrors(BrandManagerException.class);
		
	}
	public  Brand updateRecommandProductProperties(UxsUserContext userContext, String brandId, String id,String name,String productCoverImage,String origin,String remark, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingRecommandProductProperties(userContext,brandId,id,name,productCoverImage,origin,remark,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withRecommandProductListList()
				.searchRecommandProductListWith(RecommandProduct.ID_PROPERTY, "is", id).done();
		
		Brand brandToUpdate = loadBrand(userContext, brandId, options);
		
		if(brandToUpdate.getRecommandProductList().isEmpty()){
			throw new BrandManagerException("RecommandProduct is NOT FOUND with id: '"+id+"'");
		}
		
		RecommandProduct item = brandToUpdate.getRecommandProductList().first();
		
		item.updateName( name );
		item.updateProductCoverImage( productCoverImage );
		item.updateOrigin( origin );
		item.updateRemark( remark );

		
		//checkParamsForAddingRecommandProduct(userContext,brandId,name, code, used,tokensExpr);
		Brand brand = saveBrand(userContext, brandToUpdate, tokens().withRecommandProductList().done());
		synchronized(brand){ 
			return present(userContext,brand, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected RecommandProduct createRecommandProduct(UxsUserContext userContext, String name, String parentCategoryId, String productCoverImage, String origin, String catalogId, String remark, String profileId, String platformId) throws Exception{

		RecommandProduct recommandProduct = new RecommandProduct();
		
		
		recommandProduct.setName(name);		
		LevelNCategory  parentCategory = new LevelNCategory();
		parentCategory.setId(parentCategoryId);		
		recommandProduct.setParentCategory(parentCategory);		
		recommandProduct.setProductCoverImage(productCoverImage);		
		recommandProduct.setOrigin(origin);		
		Catalog  catalog = new Catalog();
		catalog.setId(catalogId);		
		recommandProduct.setCatalog(catalog);		
		recommandProduct.setRemark(remark);		
		recommandProduct.setLastUpdateTime(userContext.now());		
		Profile  profile = new Profile();
		profile.setId(profileId);		
		recommandProduct.setProfile(profile);		
		Platform  platform = new Platform();
		platform.setId(platformId);		
		recommandProduct.setPlatform(platform);
	
		
		return recommandProduct;
	
		
	}
	
	protected RecommandProduct createIndexedRecommandProduct(String id, int version){

		RecommandProduct recommandProduct = new RecommandProduct();
		recommandProduct.setId(id);
		recommandProduct.setVersion(version);
		return recommandProduct;			
		
	}
	
	protected void checkParamsForRemovingRecommandProductList(UxsUserContext userContext, String brandId, 
			String recommandProductIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfBrand(brandId);
		for(String recommandProductId: recommandProductIds){
			userContext.getChecker().checkIdOfRecommandProduct(recommandProductId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(BrandManagerException.class);
		
	}
	public  Brand removeRecommandProductList(UxsUserContext userContext, String brandId, 
			String recommandProductIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingRecommandProductList(userContext, brandId,  recommandProductIds, tokensExpr);
			
			
			Brand brand = loadBrand(userContext, brandId, allTokens());
			synchronized(brand){ 
				//Will be good when the brand loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getBrandDAO().planToRemoveRecommandProductList(brand, recommandProductIds, allTokens());
				brand = saveBrand(userContext, brand, tokens().withRecommandProductList().done());
				deleteRelationListInGraph(userContext, brand.getRecommandProductList());
				return present(userContext,brand, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingRecommandProduct(UxsUserContext userContext, String brandId, 
		String recommandProductId, int recommandProductVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfBrand( brandId);
		userContext.getChecker().checkIdOfRecommandProduct(recommandProductId);
		userContext.getChecker().checkVersionOfRecommandProduct(recommandProductVersion);
		userContext.getChecker().throwExceptionIfHasErrors(BrandManagerException.class);
	
	}
	public  Brand removeRecommandProduct(UxsUserContext userContext, String brandId, 
		String recommandProductId, int recommandProductVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingRecommandProduct(userContext,brandId, recommandProductId, recommandProductVersion,tokensExpr);
		
		RecommandProduct recommandProduct = createIndexedRecommandProduct(recommandProductId, recommandProductVersion);
		Brand brand = loadBrand(userContext, brandId, allTokens());
		synchronized(brand){ 
			//Will be good when the brand loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			brand.removeRecommandProduct( recommandProduct );		
			brand = saveBrand(userContext, brand, tokens().withRecommandProductList().done());
			deleteRelationInGraph(userContext, recommandProduct);
			return present(userContext,brand, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingRecommandProduct(UxsUserContext userContext, String brandId, 
		String recommandProductId, int recommandProductVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfBrand( brandId);
		userContext.getChecker().checkIdOfRecommandProduct(recommandProductId);
		userContext.getChecker().checkVersionOfRecommandProduct(recommandProductVersion);
		userContext.getChecker().throwExceptionIfHasErrors(BrandManagerException.class);
	
	}
	public  Brand copyRecommandProductFrom(UxsUserContext userContext, String brandId, 
		String recommandProductId, int recommandProductVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingRecommandProduct(userContext,brandId, recommandProductId, recommandProductVersion,tokensExpr);
		
		RecommandProduct recommandProduct = createIndexedRecommandProduct(recommandProductId, recommandProductVersion);
		Brand brand = loadBrand(userContext, brandId, allTokens());
		synchronized(brand){ 
			//Will be good when the brand loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			recommandProduct.updateLastUpdateTime(userContext.now());
			
			brand.copyRecommandProductFrom( recommandProduct );		
			brand = saveBrand(userContext, brand, tokens().withRecommandProductList().done());
			
			userContext.getManagerGroup().getRecommandProductManager().onNewInstanceCreated(userContext, (RecommandProduct)brand.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,brand, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingRecommandProduct(UxsUserContext userContext, String brandId, String recommandProductId, int recommandProductVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfBrand(brandId);
		userContext.getChecker().checkIdOfRecommandProduct(recommandProductId);
		userContext.getChecker().checkVersionOfRecommandProduct(recommandProductVersion);
		

		if(RecommandProduct.NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkNameOfRecommandProduct(parseString(newValueExpr));
		}
		
		if(RecommandProduct.PRODUCT_COVER_IMAGE_PROPERTY.equals(property)){
			userContext.getChecker().checkProductCoverImageOfRecommandProduct(parseString(newValueExpr));
		}
		
		if(RecommandProduct.ORIGIN_PROPERTY.equals(property)){
			userContext.getChecker().checkOriginOfRecommandProduct(parseString(newValueExpr));
		}
		
		if(RecommandProduct.REMARK_PROPERTY.equals(property)){
			userContext.getChecker().checkRemarkOfRecommandProduct(parseString(newValueExpr));
		}
		
	
		userContext.getChecker().throwExceptionIfHasErrors(BrandManagerException.class);
	
	}
	
	public  Brand updateRecommandProduct(UxsUserContext userContext, String brandId, String recommandProductId, int recommandProductVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingRecommandProduct(userContext, brandId, recommandProductId, recommandProductVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withRecommandProductList().searchRecommandProductListWith(RecommandProduct.ID_PROPERTY, "eq", recommandProductId).done();
		
		
		
		Brand brand = loadBrand(userContext, brandId, loadTokens);
		
		synchronized(brand){ 
			//Will be good when the brand loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//brand.removeRecommandProduct( recommandProduct );	
			//make changes to AcceleraterAccount.
			RecommandProduct recommandProductIndex = createIndexedRecommandProduct(recommandProductId, recommandProductVersion);
		
			RecommandProduct recommandProduct = brand.findTheRecommandProduct(recommandProductIndex);
			if(recommandProduct == null){
				throw new BrandManagerException(recommandProduct+" is NOT FOUND" );
			}
			
			recommandProduct.changeProperty(property, newValueExpr);
			recommandProduct.updateLastUpdateTime(userContext.now());
			brand = saveBrand(userContext, brand, tokens().withRecommandProductList().done());
			return present(userContext,brand, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	public void onNewInstanceCreated(UxsUserContext userContext, Brand newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


