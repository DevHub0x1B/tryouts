package projTryouts;

import static java.lang.System.out; 

public class OrderLineExtractor {

	public OrderLineExtractor( String orderString){
		
		out.println(extractOrderLine(orderString) );
	}
	
	public String extractOrderLine(String rawOrderLineString){
		
		String orderLine;
		
		orderLine = rawOrderLineString.split("\\|", -1)[3].trim();
		//orderLine = orderLine.substring(orderLine.length()-4).trim();
		
		
		return orderLine;
		
	}
	
	
//	public static void main(String[] args){
//		
//		String s = "OLINE|REQ|203fe519-a473-4b7c-bdf2-ef86aa01510e|1237|7454445551| ITEM DESC 4  |23| MANUAL| MAN04<LF>";
//		String s2 = "OLINE|REQ|203fe519-a473-4b7c-bdf2-ef86aa01510f|1238|7454445551| ITEM DESC 5|6| MANUAL| MAN06<CR>";
//		
//		new OrderLineExtractor(s);
//		new OrderLineExtractor(s2);
//		
//	}//
	
	
}
