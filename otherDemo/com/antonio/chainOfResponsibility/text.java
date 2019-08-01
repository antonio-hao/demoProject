package com.antonio.chainOfResponsibility;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class text {
	
	

	public static void main(String[] args) {
//		List<User> userList = new ArrayList<User>();
//		User user1 = new User(1,"小米1",174);
//		userList.add(user1);
//		User user2 = new User(2,"小米2",176);
//		userList.add(user2);
//		User user3 = new User(3,"小米3",175);
//		userList.add(user3);
//		User user4 = new User(4,"小米4",174);
//		userList.add(user4);
//		
//		Map<String, List<User>> splitClass = splitClass(userList);
//		
//		for(String classid:splitClass.keySet()){
//			System.out.println("------"+ classid+ "-------");
//			List<User> list = splitClass.get(classid);
//			for(User user : list){
//				System.out.println(user.getClassid() + "--" + user.getUserName()+ "---"+  user.getUserID());
//			}
//			System.out.println("分班结束");
//		}
		
//		User user1 = new User(1,"red apple1" ,1);
//		User user2 = new User(2,"red apple2" ,2);
//		changeUser(user1, user2);
//		System.out.println(user1.getUserName()+" " + user1.getUserID());
//		System.out.println(user2.getUserName()+" " + user2.getUserID());

	}
	
	public static Map<String,List<User>> splitClass(List<User> userList){
		Map<String,List<User>> userMap = new HashMap<String,List<User>>();		
		for(User user : userList){
			String userClassId = String.valueOf(user.getClassid());
			if(userMap.keySet().contains(userClassId)){
				userMap.get(userClassId).add(user);
			}else{
				List<User> splitUserList = new ArrayList<User>();
				splitUserList.add(user);
				userMap.put(userClassId, splitUserList);
			}
		}		
		return userMap;
	}
	
	public static void changeUser(User user1,User user2){
		System.out.println("1."+ user1.getUserName()+" " +user2.getUserName());
		user1= user2;
		System.out.println("2."+ user1.getUserName()+" " +user2.getUserName());
		user2=user1;
		System.out.println("3."+ user1.getUserName()+" " +user2.getUserName());
		user1.setUserName("blue apple");
		System.out.println("4."+ user1.getUserName()+" " +user2.getUserName());
	}

}
