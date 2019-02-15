
package com.doublechaintech.uxs;
import java.util.Map;

import com.doublechaintech.uxs.platform.Platform;
import com.doublechaintech.uxs.product.Product;
import com.doublechaintech.uxs.banner.Banner;
import com.doublechaintech.uxs.profile.Profile;
import com.doublechaintech.uxs.target.Target;
import com.doublechaintech.uxs.rating.Rating;
import com.doublechaintech.uxs.review.Review;
import com.doublechaintech.uxs.blog.Blog;
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


	public Product createProduct(Map<String,Object> options){
		return new Product();
	}


	public Banner createBanner(Map<String,Object> options){
		return new Banner();
	}


	public Profile createProfile(Map<String,Object> options){
		return new Profile();
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










