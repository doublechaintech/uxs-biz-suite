
package com.doublechaintech.uxs;
import java.util.HashMap;
import java.util.Map;

public class CustomRelation extends BaseRelation{

	protected void prepareRelation()
	{
		super.prepareRelation();
		//Uncomment to make any change to the relation type
		//replaceGenericRelation("Product"                               , BaseRelation.TRUST_CHAIN_ALL, "platform");
		//replaceGenericRelation("Banner"                                , BaseRelation.TRUST_CHAIN_ALL, "platform");
		//replaceGenericRelation("Profile"                               , BaseRelation.TRUST_CHAIN_ALL, "platform");
		//replaceGenericRelation("Target"                                , BaseRelation.TRUST_CHAIN_ALL, "profile");
		//replaceGenericRelation("Target"                                , BaseRelation.TRUST_CHAIN_ALL, "banner");
		//replaceGenericRelation("Rating"                                , BaseRelation.TRUST_CHAIN_ALL, "user");
		//replaceGenericRelation("Rating"                                , BaseRelation.TRUST_CHAIN_ALL, "product");
		//replaceGenericRelation("Review"                                , BaseRelation.TRUST_CHAIN_ALL, "user");
		//replaceGenericRelation("Review"                                , BaseRelation.TRUST_CHAIN_ALL, "product");
		//replaceGenericRelation("Blog"                                  , BaseRelation.TRUST_CHAIN_ALL, "user");
		//replaceGenericRelation("Blog"                                  , BaseRelation.TRUST_CHAIN_ALL, "product");
		//replaceGenericRelation("UserWhiteList"                         , BaseRelation.TRUST_CHAIN_ALL, "domain");
		//replaceGenericRelation("SecUser"                               , BaseRelation.TRUST_CHAIN_ALL, "domain");
		//replaceGenericRelation("UserApp"                               , BaseRelation.TRUST_CHAIN_ALL, "secUser");
		//replaceGenericRelation("ListAccess"                            , BaseRelation.TRUST_CHAIN_ALL, "app");
		//replaceGenericRelation("ObjectAccess"                          , BaseRelation.TRUST_CHAIN_ALL, "app");
		//replaceGenericRelation("LoginHistory"                          , BaseRelation.TRUST_CHAIN_ALL, "secUser");
		//replaceGenericRelation("FormMessage"                           , BaseRelation.TRUST_CHAIN_ALL, "form");
		//replaceGenericRelation("FormFieldMessage"                      , BaseRelation.TRUST_CHAIN_ALL, "form");
		//replaceGenericRelation("FormField"                             , BaseRelation.TRUST_CHAIN_ALL, "form");
		//replaceGenericRelation("FormAction"                            , BaseRelation.TRUST_CHAIN_ALL, "form");

	}
	
	protected void prepareRelationIndex()
	{
		super.prepareRelationIndex();
		/*
		
		Note: you could delete some of the possible relations if you do not want it.
		Just uncomment the definition line and replaceRelationIndex line to replace existing one.
		
		*/
		//String [] productRelatedObjectNames = {"platform:Platform"};
		//replaceRelationIndex("Product",productRelatedObjectNames);

		//String [] bannerRelatedObjectNames = {"platform:Platform"};
		//replaceRelationIndex("Banner",bannerRelatedObjectNames);

		//String [] profileRelatedObjectNames = {"platform:Platform"};
		//replaceRelationIndex("Profile",profileRelatedObjectNames);

		//String [] targetRelatedObjectNames = {"profile:Profile","banner:Banner"};
		//replaceRelationIndex("Target",targetRelatedObjectNames);

		//String [] ratingRelatedObjectNames = {"user:Profile","product:Product"};
		//replaceRelationIndex("Rating",ratingRelatedObjectNames);

		//String [] reviewRelatedObjectNames = {"user:Profile","product:Product"};
		//replaceRelationIndex("Review",reviewRelatedObjectNames);

		//String [] blogRelatedObjectNames = {"user:Profile","product:Product"};
		//replaceRelationIndex("Blog",blogRelatedObjectNames);

		//String [] userWhiteListRelatedObjectNames = {"domain:UserDomain"};
		//replaceRelationIndex("UserWhiteList",userWhiteListRelatedObjectNames);

		//String [] secUserRelatedObjectNames = {"domain:UserDomain"};
		//replaceRelationIndex("SecUser",secUserRelatedObjectNames);

		//String [] userAppRelatedObjectNames = {"sec_user:SecUser"};
		//replaceRelationIndex("UserApp",userAppRelatedObjectNames);

		//String [] listAccessRelatedObjectNames = {"app:UserApp"};
		//replaceRelationIndex("ListAccess",listAccessRelatedObjectNames);

		//String [] objectAccessRelatedObjectNames = {"app:UserApp"};
		//replaceRelationIndex("ObjectAccess",objectAccessRelatedObjectNames);

		//String [] loginHistoryRelatedObjectNames = {"sec_user:SecUser"};
		//replaceRelationIndex("LoginHistory",loginHistoryRelatedObjectNames);

		//String [] formMessageRelatedObjectNames = {"form:GenericForm"};
		//replaceRelationIndex("FormMessage",formMessageRelatedObjectNames);

		//String [] formFieldMessageRelatedObjectNames = {"form:GenericForm"};
		//replaceRelationIndex("FormFieldMessage",formFieldMessageRelatedObjectNames);

		//String [] formFieldRelatedObjectNames = {"form:GenericForm"};
		//replaceRelationIndex("FormField",formFieldRelatedObjectNames);

		//String [] formActionRelatedObjectNames = {"form:GenericForm"};
		//replaceRelationIndex("FormAction",formActionRelatedObjectNames);

		
		
	
	}
	
	
	@Override
	public String getRelation(String fromType, String fromId, String targetField, String targetId)
	{

		String relation = super.getRelation(fromType, fromId, targetField, targetId);
		if(relation == null){
			throw new IllegalArgumentException("Not able to find any relation to the target type: "+ targetField);
		}
		return relation;
		
	}

}













