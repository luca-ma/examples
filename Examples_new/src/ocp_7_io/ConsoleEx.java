package ocp_7_io;

import java.io.Console;
import java.io.IOException;

public class ConsoleEx {

	public static void main(String args[]) throws IOException {
		Console console = System.console();
		String name = "";
		while (name.trim().equals("")) {
		name = console.readLine("What is your name?");
		console.printf(name);
		}
		}
}
