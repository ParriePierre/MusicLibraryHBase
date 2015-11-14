package repl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CLI {

	// Un objet contenant la requette put
	private Object request;

	private Printer view;

	private BufferedReader input;

	private int SpaceLocation;
	private int secondSpaceLocation;
	private String columnDescriptor;
	private String informationLabel;
	private String informationValue;

	private int exitsignal;

	public CLI() {
		view = new Printer();
		input = new BufferedReader(new InputStreamReader(System.in));
		SpaceLocation = -1;
		secondSpaceLocation = -1;
		columnDescriptor = "";
		informationLabel = "";
		informationValue = "";
		exitsignal = 0;
	}

	/**
	 * Handles a song request creation. 
	 * @param input
	 *            Contains the name of the song. The function handles the
	 *            suppresion of the word "song "
	 *            
	 *      -> A COMPLETER
	 */
	private void createSong(String input) {
		// remove "song " from the command
		// Only the song name remains
		input = input.substring(4);

		/**
		 * Create put request where song name is input
		 */

		view.NewSongRequest(input);
	}
	
	/**
	 * Fill the information value of our table.
	 * @param input Contains the ColumnDescriptor, information label and information to use to fill the put request. The function handles the removal of "information "
	 * 
	 *    -> A COMPLETER
	 */
	private void addInformationToSong(String input)
	{
		String tmp;
		
		//remove "information " from the command
		input = input.substring(11);
		
		//Obtain column name and information
		SpaceLocation = input.indexOf(' ');
		
		if(SpaceLocation != -1)
		{
			columnDescriptor = input.substring(0, SpaceLocation);
			
			tmp = input.substring(SpaceLocation + 1);
			secondSpaceLocation = tmp.indexOf(" ");
			
			if(SpaceLocation != -1)
			{
				informationLabel = tmp.substring(0, secondSpaceLocation);
				informationValue = tmp.substring(secondSpaceLocation + 1);
				
				/**
				 * Add to put request informations where col is the column and info the data
				 */
				
				SpaceLocation = -1;
				columnDescriptor = "";
				informationLabel = "";
				informationValue = "";
				
				view.NewSongRequest(input);
			} else {
				view.MissingArgument();
			}
		} else {
			view.MissingArgument();
		}
	}
	
	/**
	 * Handles all the treatment if the input has "add" word.
	 * @param input Command entered by the user
	 */
	private void addToPull(String input)
	{
		//remove "add " from the command
		input = input.substring(4);
		
		//Add a new song only if a song is not being registered
		if(input.contains("song ") && request == null)
		{
			createSong(input);
		} else if (input.contains("song ") && request != null) {
			view.ExistingPutRequest();
		}
		
		//Add information to a song only if a song is being registered
		if(input.contains("information ") && request != null)
		{
			addInformationToSong(input);
		} else if (input.contains("information ") && request == null) {
			view.NoExistingSong();
		}
	}
	
	/**
	 * Request the put object to commit its values
	 * 
	 * 		-> A COMPLETER
	 */
	private void performCommit()
	{
		/**
		 * Commit the put request
		 */

		view.CommitedRequest();
	}
	
	/**
	 * Evaluate the first word of the input and acts accordingly
	 * @param input the input.
	 */
	private void eval(String input) {
		// Determined the type of command

		if (input.contains("add ")) {
			addToPull(input);
			return;
		}

		// Commit the request only if it has been instanciated
		/**
		 * add a control if informations are empty
		 */
		if (input.contains("commit") && request != null) {
			performCommit();
		} else if (input.contains("commit") && request == null) {
			view.NoExistingSong();
			return;
		}

		if (input.contains("exit")) {
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