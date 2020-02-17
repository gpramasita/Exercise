package com.pegadaian.exercise.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserRequest;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Service;

import com.pegadaian.exercise.model.User;

@Service
public class UserService extends OidcUserService{
	@Autowired
	private UserRepository userRepo;
	
//	public List<Object[]> findByEmail(String email){
//		List<Object[]> emailList = userRepo.findByEmail(email);
//		if(emailList.size()>0) {
//			return emailList;
//		}else {
//			return new ArrayList<Object[]>();
//		}
//	}
	
	Date date = Date.from(Instant.now());  
	DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
	 
	
	@Override
	public OidcUser loadUser(OidcUserRequest userRequest) throws OAuth2AuthenticationException {
		System.out.print("Hello");
		OidcUser oidcUser = super.loadUser(userRequest);
		Map attr = oidcUser.getAttributes();
		
		System.out.print(attr);
//		System.out.print(attr2);
		User usr = new User();
		
		String strDate = dateFormat.format(date);
		System.out.print("Test"+strDate);
	
//		usr = (User) userRepo.findByEmail(usr.getEmail());
//		if (usr == null) {
			usr.setEmail((String)attr.get("email"));
			usr.setNama((String) attr.get("name"));
			usr.setLast_access(strDate);
			
			userRepo.save(usr);
//		} else {
//			usr.setNama((String) attr.get("name"));
//		}
		
		return super.loadUser(userRequest);
	}
}
