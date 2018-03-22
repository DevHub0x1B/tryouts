

package projTryouts;

import static java.lang.System.out;

public class OrderTelegramTokinzer {
	
//	private String telegramString = "ORDER|REQ|203fe519-a473-4b7c-bdf2-ef86aa01510a|famprixwms<LF>7454445551|123|1000|5555544| 001|99999.99| ABC Pharmacy|200|052217|D|5|20|T|SH02|000000000937087|5555555|55555<LF>"
//			+ "OLINE|REQ|203fe519-a473-4b7c-bdf2-ef86aa01510b1234|7454445551| ITEM DESC 1 |10|AFRAME| 23001000190<LF>"
//			+ "OLINE|REQ|203fe519-a473-4b7c-bdf2-ef86aa01510c1235|7454445551| ITEM DESC 2 |5| AFRAME|23001000200<LF>"
//			+ "OLINE|REQ|203fe519-a473-4b7c-bdf2-ef86aa01510d|1236|7454445551| ITEM DESC 3 |12|MANUAL| MAN03<LF>"
//			+ "OLINE|REQ|203fe519-a473-4b7c-bdf2-ef86aa01510e1237|7454445551| ITEM DESC 4  |23| MANUAL| MAN04<LF>"
//			+ "OLINE|REQ|203fe519-a473-4b7c-bdf2-ef86aa01510f|1238|7454445551| ITEM DESC 5|6| MANUAL| MAN06<CR>";
	
	private String orderHeader; //return telegram header only
	private String order; //return the order only
	private String[] orderLines; //return order lines only
	private String[] telegramPayload; //return the whole telegram message
	
	public OrderTelegramTokinzer(String s){
		if(s != null || s.length() != 0)			
			telegramTokinzer(s);
	}//
	
	public void telegramTokinzer(String telegramString) {
		
		// \\u000D -> carriage return (\\r)
		// \\u000A -> line feed (\\n)
		
		String lineFeed = "<LF>";
		String carriageReturn = "<CR>";
		String lineFeedUnicode = "\\u000A";
		String carriageReturnUnicode = "\\u000D";
		
		
		String[] telegramLines = telegramString.split(lineFeed, -1); //testing environment
		
		if(telegramLines[telegramLines.length-1].endsWith(carriageReturn)  ){			
			telegramLines[telegramLines.length-1].replaceAll(carriageReturn, "");			
			telegramLines[telegramLines.length-1] = telegramLines[telegramLines.length-1].split(carriageReturn)[0];	
		}
		
		if(telegramLines.length == 1){
			telegramLines = telegramString.split(lineFeedUnicode, -1); //production environment
			telegramLines[telegramLines.length-1].replaceAll(carriageReturnUnicode, "");			
			telegramLines[telegramLines.length-1] = telegramLines[telegramLines.length-1].split(carriageReturn)[0];			
		}
		
		setOrderHeader(telegramLines[0]);
		setOrder(telegramLines[1]);
		setOrderLines(telegramLines);
		setTelegramPayload(telegramLines);	
		
	}//
	
	
	public String getOrderHeader() {
		return orderHeader;
	}
	
	public void setOrderHeader(String orderHeader) {
		this.orderHeader = orderHeader;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	public String[] getOrderLines() {
		return orderLines;
	}

	public void setOrderLines(String[] Lines) {
		
		orderLines = new String[Lines.length-2];		
		
		for(int i = 2, j = 0; i < Lines.length; ++i, ++j){
			orderLines[j] = Lines[i]; 
			//out.println(orderLines[j]);
		}		
	}

	public String[] getTelegramPayload() {
		return telegramPayload;
	}


	public void setTelegramPayload(String[] telegramPayload) {
		this.telegramPayload = telegramPayload;
	}
	
	public static void main(String [] args){
		
		 String telegramString = "ORDER|REQ|203fe519-a473-4b7c-bdf2-ef86aa01510a|famprixwms<LF>7454445551|123|1000|5555544| 001|99999.99| ABC Pharmacy|200|052217|D|5|20|T|SH02|000000000937087|5555555|55555<LF>"
		+ "OLINE|REQ|203fe519-a473-4b7c-bdf2-ef86aa01510b1234|7454445551| ITEM DESC 1 |10|AFRAME| 23001000190<LF>"
		+ "OLINE|REQ|203fe519-a473-4b7c-bdf2-ef86aa01510c1235|7454445551| ITEM DESC 2 |5| AFRAME|23001000200<LF>"
		+ "OLINE|REQ|203fe519-a473-4b7c-bdf2-ef86aa01510d|1236|7454445551| ITEM DESC 3 |12|MANUAL| MAN03<LF>"
		+ "OLINE|REQ|203fe519-a473-4b7c-bdf2-ef86aa01510e1237|7454445551| ITEM DESC 4  |23| MANUAL| MAN04<LF>"
		+ "OLINE|REQ|203fe519-a473-4b7c-bdf2-ef86aa01510f|1238|7454445551| ITEM DESC 5|6| MANUAL| MAN06<CR>";
		
		 if(telegramString != null || telegramString.length() != 0)
		 {
		out.println(new OrderTelegramTokinzer(telegramString).getOrderHeader());
		out.println(new OrderTelegramTokinzer(telegramString).getOrder());
		
		OrderTelegramTokinzer x = new OrderTelegramTokinzer(telegramString);
		
		String [] lines = x.getOrderLines();
		
		for(int i = 0; i < lines.length; ++i){
			
			//orderLines[j] = Lines[i]; 
			out.println(lines[i]);
			
		}	
		 }
	}
	
}
