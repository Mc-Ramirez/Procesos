package procesos;

/**
 * @author  Felipe Ramirez
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;

public class Child {

	public static void main(String[] args) {
		InputStreamReader in = new InputStreamReader(System.in);
		BufferedReader reader = new BufferedReader(in);
		try {
			String line = "";
			do {
				line = reader.readLine();
				System.out.println(line.toUpperCase());
			} while (!line.equals("fin"));
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("The program does not run well");
		}
	}
}
