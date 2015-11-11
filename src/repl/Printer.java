package repl;

public class Printer {
	
	protected void welcomeMessage() {
		System.out.println("Commands : ");
		System.out.println("add song <<song name>> : Create a song reqest");
		System.out.println("	Only one song request may be instanciated at a time. You need to commit the request before creating a new one.");
		System.out.println("add information <<information label>> <<information>> : add information to a song");
		System.out.println("	You can only add information once a song request has been created.");
		System.out.print(">");
	}
	
	/********************
	 * SUCCESS MESSAGES *
	 *******************/
	protected void NewSongRequest(String song) {
		System.out.println("A request for the song "+song+" has been created.");
		System.out.print(">");
	}
	
	protected void NewInformationinRequest(String col, String value) {
		System.out.println("The information "+col+" : "+value+" has been added to the request.");
		System.out.print(">");
	}
	
	protected void CommitedRequest() {
		System.out.println("The request has been commited.");
		System.out.print(">");
	}
	
	protected void ExitMessage() {
		
	}
	
	/******************
	 * ERROR MESSAGES *
	 *****************/
	protected void ExistingPutRequest() {
		System.out.println("A put request is already running.");
		welcomeMessage();
	}
	
	protected void NoExistingSong() {
		System.out.println("No request for a song has been created.");
		welcomeMessage();
	}
	
	protected void MissingArgument() {
		System.out.println("Missing argument.");
		welcomeMessage();
	}
	
	protected void NotReconizedCommand() {
		System.out.println("Unknown command.");
		welcomeMessage();
	}
}
