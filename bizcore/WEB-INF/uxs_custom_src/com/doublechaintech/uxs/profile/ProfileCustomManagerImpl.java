

/*

这里面放置你需要定制的行为，可以增加方法，也可以重写原来的方法，主要是增加新的约束和关联。
注意，在同名方法里面一定要使用super来调用，不然将会出现缓冲出溢出的问题Stack Overflow。
这个类讲在第一次生成，此后这些文件不会被覆盖，如果名字发生了变更，则需要手动删除，修改本类来适应新的模型变更，
这个类已经被配置到了相应的Spring配置文件 WEB-INF/uxs_custom_src/META-INF/uxs_custom.xml 中，
所以直接在里面重写或者增加新的方法将会修改客户的行为

*/


package com.doublechaintech.uxs.profile;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.http.client.ClientProtocolException;

import com.doublechaintech.uxs.UxsUserContext;
import com.terapico.uccaf.BaseUserContext;
import com.terapico.utils.RestUtil;


public class ProfileCustomManagerImpl extends ProfileManagerImpl{
	@Override
	public Object checkAccess(BaseUserContext baseUserContext, String methodName, Object[] parameters)
			throws IllegalAccessException {
	
		
		return accessOK();
		
		//return super.checkAccess(baseUserContext, methodName, parameters);
	}
	
	public Profile home(UxsUserContext userContext, String profileId) throws Exception {
		
		
		String tokens[]=this.tokens().allTokens().toArray();
		
		List<Profile> profileList = this.loadProfileListFromDifferentServices(userContext, new String[] {"cms","ugc","pim"}, profileId, tokens);
		
		
		return mergeProfileFromMicroservices( userContext, profileList);
		
		
		
	}
	
	
	protected String packTokens(String[] tokensExpr) {
		return String.join(";", tokensExpr);
	}
	protected<T> T loadRemoteObject(UxsUserContext userContext, String serviceName,String ProfileId, String[] tokensExpr, Class<?>clazz) throws ClientProtocolException, IOException {
		String url = "https://demo.doublechaintech.com/"+serviceName+"/profileManager/loadProfile/"+ProfileId+"/"+packTokens(tokensExpr)+"/";
		
		
		userContext.log("load data from :"+ url);
		
		Object object= RestUtil.remoteGetObject(userContext.tokenId(), url, clazz);
		T Profile =(T)object ;
		return Profile;
	}
	
	protected List<Profile> loadProfileListFromDifferentServices(UxsUserContext userContext,String[] serviceList,String ProfileId, String[] tokensExpr)
			throws ClientProtocolException, IOException{
		
		 List<Profile> profileList = new ArrayList<Profile>();

		 Stream.of(serviceList).forEach(serviceName->{
			
			try {
				Profile profile = loadRemoteProfile(userContext,serviceName,ProfileId,tokensExpr);
				
				userContext.log("load profile "+ profile);
				
				
				profileList.add(profile);
			} catch (ClientProtocolException e) {
				
			} catch (IOException e) {
				
			}
			

		 });
		 
		 userContext.log(profileList.stream().map(item->item.getId()).collect(Collectors.joining(";")));
		 
		 return profileList;
		 
	}
	
	
	protected Profile mergeProfilesFromMicroservice(UxsUserContext userContext,Profile profileDest, Profile profileSrc) {
	
		profileSrc.mergeDataTo(profileDest);
		return profileDest;
		
		
	}
	protected Profile mergeProfileFromMicroservices(UxsUserContext userContext,List<Profile> ProfileList) {
		Profile profile = new Profile();
		
		ProfileList.stream().forEach(srcProfile->{
			mergeProfilesFromMicroservice(userContext,profile,srcProfile);
		});
		
		
		return profile;
		
		
	}
	protected Profile loadRemoteProfile(UxsUserContext userContext, String serviceName,String ProfileId, String[] tokensExpr) throws ClientProtocolException, IOException {
		return this.loadRemoteObject(userContext, serviceName, ProfileId, tokensExpr, Profile.class);
	}


}

