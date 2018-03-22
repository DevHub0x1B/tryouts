package projTryouts;

import java.util.HashMap;
import java.util.Map;

public enum OLineEnum {
	
	
	ONHOLD(0), READY(1);
	
	private int status;
	private static Map<Integer, String> statusMap = new HashMap<Integer, String>();   
	
	OLineEnum(int s){
		status = s;	
	}
		

	public static void setStatus(){
		statusMap.put(0, OLineEnum.ONHOLD.toString());
		statusMap.put(1, OLineEnum.READY.toString());
	}
	
	public static int getStatusCode(OLineEnum ole){
		if(statusMap.isEmpty()) setStatus();
		int code = 0;
		
		if(ole.equals(ONHOLD))
			code = 0;
		else if(ole.equals(READY))
			code = 1;
		else code = -1;
		
		return code;
	}
	
	public static String getStatus(int s){		
		if(statusMap.isEmpty()) setStatus();		
		String status = "";
		
		switch(s){
		case 0: status = statusMap.get(s).toString(); break;		
		case 1: status = statusMap.get(s).toString(); break;
		default: status = "";
		};		
		
		return status;
		
	}	
	
	
}
