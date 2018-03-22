package projTryouts;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;



public class ServerSide {
	
	 ServerSocket serverSock;
	List<Socket> acceptedSockets;
	 final int SERVER_PORT = 10003;
	

	ServerSide(){
		
		
	}
	
	
	public static void main(String[] c){
		
//		
//		String s = "0000002";
//		String s1 = "66Manual1";
//		String s2 = "12558963";
//		
//		String stringNumber = "";
//		long actualNumber = 0;
//		
//		if(NumberUtils.isNumber(s) ) {
//			actualNumber = Long.parseLong(s);
//			System.out.println(String.valueOf(actualNumber) );
//		}
//		
//		//System.out.println(actualNumber);
//		
//		if(NumberUtils.isNumber(s1)){
//			actualNumber = Long.parseLong(s1);			
//			System.out.println("parse"  + String.valueOf(actualNumber));
//		}
//		
//		if(NumberUtils.isNumber(s2)){
//			actualNumber = Long.parseLong(s2);
//			System.out.println("parsing: " + String.valueOf(actualNumber));
//			
//		}


//		String tele = "���� ����'���������� ����'������UPSERTITEM|REQ|2017-10-27-15.39.18.263-GORLL|U005956<LF>R10-401-001|I|3|77<CR>";
//		System.out.println(tele.replaceAll("[^\\x20-\\x7e]", "").replaceAll("\'", "").trim() );
//
		String telegramData = "FTACK|REQ|203fe519-a473-5b7f-bdf2-ef86aa01510a|familiprix<LF>G100155|7454445551<CR>";
		System.out.println(telegramData);
		System.out.println(extractToteBarcode(telegramData));
		System.out.println(extractOrderId(telegramData));
		
		
	}

	public static String extractToteBarcode(String telegram){
		String barcode =  "";
		String telegramData = telegram.split("<LF>", -1)[1];
		barcode = telegramData.split("\\|", -1)[0].trim();
		return barcode;
	}//


	public static String extractOrderId(String telegram){

		String orderId = "";
		String telegramData = telegram.split("<LF>", -1)[1];
		orderId = telegramData.split("\\|", -1)[1].trim();
		orderId = orderId.split("<CR>", -1)[0].trim();
		return orderId;

	}//
	
}
