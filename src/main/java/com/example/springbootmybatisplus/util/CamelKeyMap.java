package com.example.springbootmybatisplus.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class CamelKeyMap extends HashMap{

	 @Override  
	 public Object put(Object key, Object value) {  
		key = camelCaseName(String.valueOf(key));  
		return super.put(key, value);  
	 } 
	 
	 
	 /**
	  * 转换为驼峰
	  * @param underscoreName
	  * @return
	  */
	 public static String camelCaseName(String underscoreName) {
	 	StringBuilder result = new StringBuilder();
	 	if (underscoreName != null && underscoreName.length() > 0) {
	 		boolean flag = false;
	 		for (int i = 0; i < underscoreName.length(); i++) {
	 			char ch = underscoreName.charAt(i);
	 			if ("_".charAt(0) == ch) {
	 				flag = true;
	 			} else {
	 				if (flag) {
	 					result.append(Character.toUpperCase(ch));
	 					flag = false;
	 				} else {
	 					result.append(ch);
	 				}
	 			}
	 		}
	 	}
	 	return result.toString();
	 }
	 
	 
	 public static void main(String[] args) {
		 CamelKeyMap cm = new CamelKeyMap();
		 SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 long a= System.currentTimeMillis();//获取当前系统时间(毫秒)
		 for (int i=0;i<900;i++){
		    System.out.println("vehicle_info_"+i);
		 }
	     Date now = new Date();
	     System.out.println("当前时间：" + dateFormat.format(now));
		 cm.put("sss", "浏览量");
		 cm.put("details_content", "details_content");
		 System.out.println(cm.get("sss"));
		 System.out.println(cm.get("detailsContent"));
		 System.out.println("当前时间：" + dateFormat.format(now));

		 System.out.print("程序执行时间为：");
		 System.out.println(System.currentTimeMillis()-a+"毫秒");
	}
}



