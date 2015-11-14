package controller;

import repl.CLI;

public class StartREPL {

	public static void main(String[] args) {
		CLI repl = new CLI();
		repl.loop();
	}

}
