package repl;

import java.util.Scanner;
import hbaseCommands.HBase;

public class Controller {
	
	private static Boolean simpleMode = true;
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		HBase.initHbase();
		displayMan();
		readCommand(scanner.nextLine());
		
	    scanner.close();
	    System.exit(0);
	}
	
	public static void displayMan(){
		System.out.println("Welcome to the music library");
		System.out.println("Activate simple mode: simple");
		System.out.println("In this mode, you'll be guided to add a new song");
		System.out.println("Activate command mode: command");
		System.out.println("In this mode, you have to use the commands to add a song");
		System.out.print("> ");
	}
	
	public static void readCommand(String command){
		if(command.contains("simple"))
			simpleRepl();
		if(command.contains("command"))
			commandRepl();
	}
	
	public static void simpleRepl(){
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Simple mode activated");
		System.out.print("> ");
		while(!scanner.nextLine().contentEquals("quit")){
			
		}
		
		scanner.close();
	    System.exit(0);
	}
	
	public static void commandRepl(){
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Command mode activated");
		System.out.print("> ");
		while(!scanner.nextLine().contentEquals("quit")){
			
		}
		
		scanner.close();
	    System.exit(0);
	}

}
