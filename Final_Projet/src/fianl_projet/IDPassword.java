package fianl_projet;

import java.util.*;

public class IDPassword {
	HashMap <String,String> loginInfo = new HashMap<String,String>();
	
	IDPassword(){
		loginInfo.put("Evans", "123");
		//loginInfo.put("Dimitri", "123");
		//loginInfo.put("Evano", "123");
	}
	
	protected HashMap getLoginInfo(){
		return loginInfo;
	}
}
