package projTryouts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class test {

	private List<String> orderUpdateTokenizer(String telegramString, String lineFeed, String carriageReturn) {

		List<String> tokenz = new ArrayList<String>();

		// split upon linefeed delimiter
		String[] s = telegramString.split(lineFeed, -1);

		String[] telegramData = s[1].split(carriageReturn, -1);

		tokenz.addAll(Arrays.asList(s[0].split("\\|", -1)));
		tokenz.addAll(Arrays.asList(telegramData[0].split("\\|", -1)));

		return tokenz;

	}

	public test(String s) {

		for (String e : this.orderUpdateTokenizer(s, "<LF>", "<CR>"))
			System.out.println(e);

	}

	public static void main(String[] args) {

		String s = "ORUPDT|REQ|203fe519-a473-5b7f-bdf2-ef86aa01510a|famprixwms<LF>7454445551|1234|IBUPROFEN |MANUAL|10|MAN005<CR>";
		new test(s);

	}

}
