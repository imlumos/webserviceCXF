package com.ilumos.webservice;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.jws.WebService;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.ilumos.adapter.MapAdapter;
import com.ilumos.entity.Role;
import com.ilumos.entity.User;

@WebService
public interface HelloWorld {
	
	public String say(String str);
	
	public List<Role> getRoleByUser(User user);
	
	@XmlJavaTypeAdapter(MapAdapter.class)
	public Map<String, List<Role>> getRoles();
	
	public List<User> initKey(List<User> list);
	
	public List<User> testMap(Map<String, User> map);
	
	public String testSet(Set<Integer> set);

}
