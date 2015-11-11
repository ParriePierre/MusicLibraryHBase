package repl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CLI {
	
	//Un objet contenant la requette put
	private Object request;
	
	private Printer view;
	
	private BufferedReader input;
	
	private int SpaceLocation;
	private String col;
	private String info;
	
	private int exitsignal;
	
	public CLI() {
		view = new Printer();
		input = new BufferedReader(new InputStreamReader(System.in));
		SpaceLocation = -1;
		col ="";
		info ="";
		exitsignal = 0;
	}
	
	public void eval(String input) {
		//Determined the type of command
		
		if(input.contains("add "))
		{
			//remove "add " from the command
			input = input.substring(4);
			
			//Add a new song only if a song is not being registered
			if(input.contains("song ") && request == null)
			{
				//remove "song " from the command
				//Only the song name remains
				input = input.substring(4);
				
				/**
				 * Create put request where song name is input
				 */
				
				view.NewSongRequest(input);
				return;
			} else if (input.contains("song ") && request != null) {
				view.ExistingPutRequest();
				return;
			}
			
			//Add information to a song only if a song is being registered
			if(input.contains("information ") && request != null)
			{
				//remove "information " from the command
				input = input.substring(11);
				
				//Obtain column name and information
				SpaceLocation = input.indexOf(' ');
				
				if(SpaceLocation != -1)
				{
					col = input.substring(0, SpaceLocation);
					info = input.substring(SpaceLocation+1);
				
					/**
					 * Add to put request informations where col is the column and info the data
					 */
					
					SpaceLocation = -1;
					col = "";
					info = "";
					
					view.NewSongRequest(input);
					return;
				} else {
					view.MissingArgument();
					return;
				}
			} else if (input.contains("song ") && request == null) {
				view.NoExistingSong();
				return;
			}
			
		} 
		
		//Commit the request nly if it has been instanciated
		/**
		 * add a control if informations are empty 
		 */
		if(input.contains("commit") && request != null)
		{
			/**
			 * Commit the put request
			 */
			
			view.CommitedRequest();
			return;
		} else if (input.contains("commit") && request == null) {
			view.NoExistingSong();
			return;
		}
		
		if(input.contains("exit"))
		{
			exitsignal = 1;
			view.ExitMessage();
			return;
		}
		
		view.NotReconizedCommand();
	}
	
	public void loop() {
		do {
			try {
				eval(input.readLine());
			} catch (IOException e) {
				System.err.print("Broken reader.");
			}
		} while (exitsignal == 0);
	}
}