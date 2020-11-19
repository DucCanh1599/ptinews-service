package ptinews.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SpaceCleaner {

	private static void readFile() {
		try {
			File file = new File("D://java-web//ptinews//src//main//java//ptinews//model//utils//FILE.txt");
			Scanner myReader = new Scanner(file);
			String out = "";
			while (myReader.hasNextLine()) {
				String data = myReader.nextLine();
				data.replaceAll("\\s+"," ");
				out += data;
			}
			System.out.println(out);
			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void main(String[] args) {
		readFile();
	}
}
