package procesos;

/**
 * @author  Felipe Ramirez
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.nio.charset.Charset;
import java.util.Optional;

public class Father {
	static File path = new File("./bin/ejercicio2_Mayusculas");
	private final static String ENTER = "\n";

	public static void main(String[] args) throws IOException {

		Process capitalLetters = new ProcessBuilder("java", "-jar", "Child.jar").directory(path).start();
		OutputStream dos = capitalLetters.getOutputStream();
		InputStream uno = capitalLetters.getInputStream();

		System.out.println("Write the text you want to change to uppercase: ");

		try (InputStreamReader stream = new InputStreamReader(System.in, Charset.forName("UTF-8"));
				BufferedReader obj1 = new BufferedReader(stream);
				BufferedReader obj = new BufferedReader(new InputStreamReader(uno));

				PrintStream obj3 = new PrintStream(dos)) {
			String line = "";
			do {
				line = obj1.readLine();
				obj3.print((line + ENTER));
				obj3.flush();
				String lineOk = obj.readLine();
				System.out.println(lineOk);
			} while (!line.equals("fin"));
			if (capitalLetters.waitFor() == 0) {
				System.out.println("The process was completed correctly");
			} else
				System.err.println("Process error");
		} catch (Exception e) {
		}
	}
}
