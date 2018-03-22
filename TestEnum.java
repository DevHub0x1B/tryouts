package projTryouts;

import static java.lang.System.out;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestEnum {

	public static void main(String[] args) {

		// out.println(OLineEnum.getStatus(0));
		// out.println(OLineEnum.getStatus(1));
		// out.println(OLineEnum.getStatusCode(OLineEnum.ONHOLD));
		// out.println(OLineEnum.getStatusCode(OLineEnum.READY));

		String s = "UPSERTITEM|REQ|203fe519-a473-5b7f-bdf2-ef86aa01510a|famprixwms<LF>" + "23005633333|200014|24<CR>";

		// String[] lines = s.split("\\|", -1);
		// for (int i = 0; i< lines.length; ++i){
		// out.print(lines[i]);
		// out.println("---");
		// }

		// String[] f = lines[lines.length-1].split("<LF>", -1);
		// out.println(f[1].trim());

		out.println();
		String[] lines = extractUpsertData(s, "<LF>", "<CR>");
		for (int i = 0; i < lines.length; ++i) {
			out.print(lines[i]);
			out.println("---" + i);
		}

	}

	public static String[] extractUpsertData(String s, String linefeedDelimiter, String carriageRetrunDelimiter) {

		String[] payload = s.split(linefeedDelimiter, -1);
		String[] header = payload[0].split("\\|", -1);

		String[] upsertData = payload[1].split(carriageRetrunDelimiter, -1);
		upsertData = upsertData[0].split("\\|", -1);

		List<String> list = Arrays.asList(header);
		List<String> list2 = Arrays.asList(upsertData);
		List<String> newList = new ArrayList<String>();

		newList.addAll(list);
		newList.addAll(list2);

		return (newList.toArray(new String[newList.size()]));

	}

	public static String extractOrderId(String s) {

		String[] temp = s.split("<LF>", -1);
		temp = temp[1].split("<CR>", -1);

		return temp[0].trim();
	}

	public static String extractCustomerName(String s, String del) {

		String[] temp = s.split(del, -1);

		return temp[0].trim();

	}
}
