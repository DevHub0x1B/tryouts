package projTryouts;

import static java.lang.System.out;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;

public class TelegramDelimiters {

	private String lineFeed;
	private String carriageReturn;
	private String fileLocation;

	
	public TelegramDelimiters() {

		try {		
			
			URL absoluteFilePath = TelegramDelimiters.class.getResource("delimiters.csv");
			this.fileLocation = Paths.get(absoluteFilePath.toURI()).toFile().toString();
			this.parseCsvFile();
			
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
	}

	public void setLineFeed(String linefeed) {
		lineFeed = linefeed;
	}

	public String getLineFeed() {
		return lineFeed;
	}

	public void setCarriageReturn(String cr) {
		carriageReturn = cr;

	}

	public String getCarriageReturn() {
		return carriageReturn;
	}

	// CSV File Location
	public void setCsvFileLocation(String s) {
		fileLocation = s;
	}

	public String getCsvFileLocation() {
		return fileLocation;
	}

	private void parseCsvFile() {

		BufferedReader br = null;
		String line = "";
		String delimiter = ",";
		String[] values = null;

		try {

			br = new BufferedReader(new FileReader(this.getCsvFileLocation()));

			while ((line = br.readLine()) != null) {
				values = line.split(delimiter);
			} // end of While

			if (values != null) {
				setLineFeed(values[0]);
				setCarriageReturn(values[1]);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			if (br != null) {

				try {
					br.close();

				} catch (IOException e) {
					e.printStackTrace();
				}

			}
		}

	}// end of parseCsvFile method
		
	
	public static void main(String[] args) {

		TelegramDelimiters p = new TelegramDelimiters();

		out.println(p.getCarriageReturn());
		out.println(p.getLineFeed());

	}

}
