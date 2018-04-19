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
				roleList.add(new Role(1,"技术总监"));
				roleList.add(new Role(2,"架构师"));
			}
			if(user.getUserName().equals("lisi") && user.getPassword().equals("123456")){
				roleList.add(new Role(3,"程序员"));
			}
			return roleList;
		}
		return null;
	}

	public Map<String, List<Role>> getRoles() {
		Map<String,List<Role>> map = new HashMap<String, List<Role>>();
		List<Role> roleList1 = new ArrayList<Role>();
		roleList1.add(new Role(1,"技术总监"));
		roleList1.add(new Role(2,"架构师"));
		map.put("zhangsan", roleList1);
		List<Role> roleList2 = new ArrayList<Role>();
		roleList2.add(new Role(3,"程序员"));
		map.put("lisi", roleList2);
		return map;
	}

	public List<User> initKey(List<User> list) {
		List<User> resultList = new ArrayList<User>();
		for(int i=0;i<list.size();i++){
			User user = list.get(i);
			if(user.getUserName().equals("张三")){
				user.setPassword("zhangsan");
				resultList.add(user);
			}
			if(user.getUserName().equals("李四")){
				user.setPassword("lisi");
				resultList.add(user);
			}
			if(user.getUserName().equals("王五")){
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
		String result = "吃瓜群众有：";
		Iterator<Integer> iterator = set.iterator();
		while(iterator.hasNext()){
			Integer number = iterator.next();
			if(number==1){
				result += "张三、";
			}
			if(number==2){
				result += "李四、";
			}
			if(number==3){
				result += "王五、";
			}
		}
		return result;
	}

}
