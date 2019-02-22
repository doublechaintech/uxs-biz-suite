
package com.doublechaintech.uxs;
import java.util.Map;

import com.doublechaintech.uxs.platform.Platform;
import com.doublechaintech.uxs.site.Site;
import com.doublechaintech.uxs.catalog.Catalog;
import com.doublechaintech.uxs.levelonecategory.LevelOneCategory;
import com.doublechaintech.uxs.leveltwocategory.LevelTwoCategory;
import com.doublechaintech.uxs.levelncategory.LevelNCategory;
import com.doublechaintech.uxs.brand.Brand;
import com.doublechaintech.uxs.product.Product;
import com.doublechaintech.uxs.banner.Banner;
import com.doublechaintech.uxs.profile.Profile;
import com.doublechaintech.uxs.useralert.UserAlert;
import com.doublechaintech.uxs.target.Target;
import com.doublechaintech.uxs.rating.Rating;
import com.doublechaintech.uxs.review.Review;
import com.doublechaintech.uxs.blog.Blog;
import com.doublechaintech.uxs.brandfilter.BrandFilter;
import com.doublechaintech.uxs.pricefilter.PriceFilter;
import com.doublechaintech.uxs.categoryfilter.CategoryFilter;
import com.doublechaintech.uxs.newproduct.NewProduct;
import com.doublechaintech.uxs.editorpickproduct.EditorPickProduct;
import com.doublechaintech.uxs.topratedproduct.TopRatedProduct;
import com.doublechaintech.uxs.recommandproduct.RecommandProduct;
import com.doublechaintech.uxs.userdomain.UserDomain;
import com.doublechaintech.uxs.userwhitelist.UserWhiteList;
import com.doublechaintech.uxs.secuser.SecUser;
import com.doublechaintech.uxs.secuserblocking.SecUserBlocking;
import com.doublechaintech.uxs.userapp.UserApp;
import com.doublechaintech.uxs.listaccess.ListAccess;
import com.doublechaintech.uxs.objectaccess.ObjectAccess;
import com.doublechaintech.uxs.loginhistory.LoginHistory;
import com.doublechaintech.uxs.genericform.GenericForm;
import com.doublechaintech.uxs.formmessage.FormMessage;
import com.doublechaintech.uxs.formfieldmessage.FormFieldMessage;
import com.doublechaintech.uxs.formfield.FormField;
import com.doublechaintech.uxs.formaction.FormAction;

public class BeanFactoryImpl{


	public Platform createPlatform(Map<String,Object> options){
		return new Platform();
	}


	public Site createSite(Map<String,Object> options){
		return new Site();
	}


	public Catalog createCatalog(Map<String,Object> options){
		return new Catalog();
	}


	public LevelOneCategory createLevelOneCategory(Map<String,Object> options){
		return new LevelOneCategory();
	}


	public LevelTwoCategory createLevelTwoCategory(Map<String,Object> options){
		return new LevelTwoCategory();
	}


	public LevelNCategory createLevelNCategory(Map<String,Object> options){
		return new LevelNCategory();
	}


	public Brand createBrand(Map<String,Object> options){
		return new Brand();
	}


	public Product createProduct(Map<String,Object> options){
		return new Product();
	}


	public Banner createBanner(Map<String,Object> options){
		return new Banner();
	}


	public Profile createProfile(Map<String,Object> options){
		return new Profile();
	}


	public UserAlert createUserAlert(Map<String,Object> options){
		return new UserAlert();
	}


	public Target createTarget(Map<String,Object> options){
		return new Target();
	}


	public Rating createRating(Map<String,Object> options){
		return new Rating();
	}


	public Review createReview(Map<String,Object> options){
		return new Review();
	}


	public Blog createBlog(Map<String,Object> options){
		return new Blog();
	}


	public BrandFilter createBrandFilter(Map<String,Object> options){
		return new BrandFilter();
	}


	public PriceFilter createPriceFilter(Map<String,Object> options){
		return new PriceFilter();
	}


	public CategoryFilter createCategoryFilter(Map<String,Object> options){
		return new CategoryFilter();
	}


	public NewProduct createNewProduct(Map<String,Object> options){
		return new NewProduct();
	}


	public EditorPickProduct createEditorPickProduct(Map<String,Object> options){
		return new EditorPickProduct();
	}


	public TopRatedProduct createTopRatedProduct(Map<String,Object> options){
		return new TopRatedProduct();
	}


	public RecommandProduct createRecommandProduct(Map<String,Object> options){
		return new RecommandProduct();
	}


	public UserDomain createUserDomain(Map<String,Object> options){
		return new UserDomain();
	}


	public UserWhiteList createUserWhiteList(Map<String,Object> options){
		return new UserWhiteList();
	}


	public SecUser createSecUser(Map<String,Object> options){
		return new SecUser();
	}


	public SecUserBlocking createSecUserBlocking(Map<String,Object> options){
		return new SecUserBlocking();
	}


	public UserApp createUserApp(Map<String,Object> options){
		return new UserApp();
	}


	public ListAccess createListAccess(Map<String,Object> options){
		return new ListAccess();
	}


	public ObjectAccess createObjectAccess(Map<String,Object> options){
		return new ObjectAccess();
	}


	public LoginHistory createLoginHistory(Map<String,Object> options){
		return new LoginHistory();
	}


	public GenericForm createGenericForm(Map<String,Object> options){
		return new GenericForm();
	}


	public FormMessage createFormMessage(Map<String,Object> options){
		return new FormMessage();
	}


	public FormFieldMessage createFormFieldMessage(Map<String,Object> options){
		return new FormFieldMessage();
	}


	public FormField createFormField(Map<String,Object> options){
		return new FormField();
	}


	public FormAction createFormAction(Map<String,Object> options){
		return new FormAction();
	}





}










