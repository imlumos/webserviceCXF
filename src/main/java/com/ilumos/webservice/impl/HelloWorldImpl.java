package com.ilumos.webservice.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.ilumos.entity.Role;
import com.ilumos.entity.User;
import com.ilumos.webservice.HelloWorld;

@Service("helloWorld")
public class HelloWorldImpl implements HelloWorld{

	public String say(String str) {
		
		return "Hello "+str;
	}

	public List<Role> getRoleByUser(User user) {
		List<Role> roleList = new ArrayList<Role>();
		if(user != null){
			if(user.getUserName().equals("zhangsan") && user.getPassword().equals("123456")){
				roleList.add(new Role(1,"�����ܼ�"));
				roleList.add(new Role(2,"�ܹ�ʦ"));
			}
			if(user.getUserName().equals("lisi") && user.getPassword().equals("123456")){
				roleList.add(new Role(3,"����Ա"));
			}
			return roleList;
		}
		return null;
	}

	public Map<String, List<Role>> getRoles() {
		Map<String,List<Role>> map = new HashMap<String, List<Role>>();
		List<Role> roleList1 = new ArrayList<Role>();
		roleList1.add(new Role(1,"�����ܼ�"));
		roleList1.add(new Role(2,"�ܹ�ʦ"));
		map.put("zhangsan", roleList1);
		List<Role> roleList2 = new ArrayList<Role>();
		roleList2.add(new Role(3,"����Ա"));
		map.put("lisi", roleList2);
		return map;
	}

	public List<User> initKey(List<User> list) {
		List<User> resultList = new ArrayList<User>();
		for(int i=0;i<list.size();i++){
			User user = list.get(i);
			if(user.getUserName().equals("����")){
				user.setPassword("zhangsan");
				resultList.add(user);
			}
			if(user.getUserName().equals("����")){
				user.setPassword("lisi");
				resultList.add(user);
			}
			if(user.getUserName().equals("����")){
				user.setPassword("wangwu");
				resultList.add(user);
			}
		}
		return resultList;
	}

	public List<User> testMap(Map<String, User> map) {
		List<User> uList = new ArrayList<User>();
		Iterator<Entry<String, User>> iterator = map.entrySet().iterator();
		while(iterator.hasNext()){
			Entry<String, User> entry = iterator.next();
			uList.add(entry.getValue());
		}
		return uList;
	}

	public String testSet(Set<Integer> set) {
		String result = "�Թ�Ⱥ���У�";
		Iterator<Integer> iterator = set.iterator();
		while(iterator.hasNext()){
			Integer number = iterator.next();
			if(number==1){
				result += "������";
			}
			if(number==2){
				result += "���ġ�";
			}
			if(number==3){
				result += "���塢";
			}
		}
		return result;
	}

}
