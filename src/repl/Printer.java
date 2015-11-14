package repl;

public class Printer {
	
	protected void welcomeMessage() {
		System.out.println("Commands : ");
		System.out.println("add song <<song name>> : Create a song reqest");
		System.out.println("	Only one song request may be instanciated at a time. You need to commit the request before creating a new one.");
		System.out.println("add information <<column Descriptor>> <<information label>> <<information>> : add information to a song");
		System.out.println("	You can only add information once a song request has been created.");
		System.out.println("commit : Execute a put request in HBase.");
		System.out.println("exit : quit MusicLibrary project.");
		System.out.println("The database to fill follows this pattern : ");
		System.out.println("Key : song name");
		System.out.println("Column descriptors :");
		System.out.println("\t - Song : information labels : ");
		System.out.println("\t\t - Name");
		System.out.println("\t\t - MusicStyle");
		System.out.println("\t\t - Duration");
		System.out.println("\t\t - PathToMP3");
		System.out.println("\t\t - PathToCover");
		System.out.println("\t\t - Score");
		System.out.println("\t\t - ReleaseDate");
		System.out.println("\t - Artist : information labels : ");
		System.out.println("\t\t - Name");
		System.out.println("\t\t - Description");
		System.out.println("\t - Album : information labels : ");
		System.out.println("\t\t - Name");
		System.out.println("\t\t - ReleaseDate");
		System.out.println("\t\t - TrackNumber");
		System.out.print(">");
	}
	
	/********************
	 * SUCCESS MESSAGES *
	 *******************/
	protected void NewSongRequest(String song) {
		System.out.println("A request for the song "+song+" has been created.");
		System.out.print(">");
	}
	
	protected void NewInformationinRequest(String col, String Label, String value) {
		System.out.println("The information "+col+" : "+Label+" : "+value+" has been added to the request.");
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
		System.err.println("A put request is already running.");
		welcomeMessage();
	}
	
	protected void NoExistingSong() {
		System.err.println("No request for a song has been created.");
		welcomeMessage();
	}
	
	protected void MissingArgument() {
		System.err.println("Missing argument.");
		welcomeMessage();
	}
	
	protected void NotReconizedCommand() {
		System.err.println("Unknown command.");
		welcomeMessage();
	}
}
