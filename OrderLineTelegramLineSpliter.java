package projTryouts;

import java.util.ArrayList;
import java.util.List;

public class OrderLineTelegramLineSpliter {

	private String[] orderLines;
	private String delimiter;
	private List<String[]> orderLinesTokenz;

	public OrderLineTelegramLineSpliter(String[] orderLines, String delimiter) {
		if (orderLines != null || orderLines.length != 0) {
			this.orderLines = orderLines;
			this.delimiter = delimiter;
			orderLinesTokenz = new ArrayList<String[]>();
			orderLineTokenizer();
		}
	}

	private void orderLineTokenizer() {

		if (delimiter.equals("|"))
			delimiter = "\\|";
		for (int i = 0; i < orderLines.length; ++i) {

			String[] lines = orderLines[i].split(delimiter, -1);
			this.orderLinesTokenz.add(lines);

		}
	}

	public ArrayList<String[]> getOrderLineTokenz() {

		return (ArrayList<String[]>) orderLinesTokenz;
	}

	public static void main(String[] args) {

		String[] s = { "OLINE|REQ|203fe519-a473-4b7c-bdf2-ef86aa01510b|1234|7454445551| ITEM DESC 1 |10|23001000190",
				"OLINE|REQ|203fe519-a473-4b7c-bdf2-ef86aa01510c|1235|7454445551| ITEM DESC 2 |5 |23001000200",
				"OLINE|REQ|203fe519-a473-4b7c-bdf2-ef86aa01510d|1236|7454445551| ITEM DESC 3 |12|MAN03",
				"OLINE|REQ|203fe519-a473-4b7c-bdf2-ef86aa01510e|1237|7454445551| ITEM DESC 4 |23|MAN04",
				"OLINE|REQ|203fe519-a473-4b7c-bdf2-ef86aa01510f|1238|7454445551| ITEM DESC 5 |6 |MAN06", };

		OrderLineTelegramLineSpliter x = new OrderLineTelegramLineSpliter(s, "|");

		ArrayList<String[]> y = x.getOrderLineTokenz();
		for (int i = 0; i < y.size(); ++i) {
			
			String[] z = y.get(i);
			for(int u = 0; u<z.length; ++u)
				System.out.println((z[u]).trim());
			System.out.println("-----------");
		}

	}

}
