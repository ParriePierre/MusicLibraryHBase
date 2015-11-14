package repl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CLI {

	// Un objet contenant la requette put
	private Music song;

	private Printer view;

	private BufferedReader input;

	private int exitsignal;
	
	private String[] songInformationLabels = {"name", "musicstyle", "duration", "pathtomp3", "pathtocover","score", "releasedate"};
	private String[] artistInformationLabels = {"name", "description"};
	private String[] albumInformationLabels = {"name", "releasedate", "tracknumber"};

	public CLI() {
		view = new Printer();
		input = new BufferedReader(new InputStreamReader(System.in));
		exitsignal = 0;
		song = null;
	}

	/**
	 * Handles a song request creation. 
	 * @param input
	 *            Contains the name of the song. The function handles the
	 *            suppresion of the word "song "
	 */
	private void createSong(String input) {
		// remove "song " from the command
		// Only the song name remains
		input = input.substring(4);
		
		if(!input.isEmpty())
		{
			song = new Music();

			view.NewSongRequest(input);
		} else {
			view.MissingArgument();
		}
	}
	
	/**
	 * CHecks that the information given fit our database
	 * @param columnDescriptor	columndescriptor of the input
	 * @param informationLabel	informationLabel of the input
	 * @return True if the information fit the database, else false
	 */
	private Boolean checkInformation(String columnDescriptor, String informationLabel)
	{
		if(columnDescriptor.compareTo("songinfo") == 0)
		{
			for (String label : songInformationLabels) {
				if(informationLabel.compareTo(label) == 0)
					return true;
			}
		}
		
		if(columnDescriptor.compareTo("artist") == 0)
		{
			for (String label : artistInformationLabels) {
				if(informationLabel.compareTo(label) == 0)
					return true;
			}
		}
		
		if(columnDescriptor.compareTo("album") == 0)
		{
			for (String label : albumInformationLabels) {
				if(informationLabel.compareTo(label) == 0)
					return true;
			}
		}
			
		return false;
	}
	
	/**
	 * Fill the information value of our table.
	 * @param input Contains the ColumnDescriptor, information label and information to use to fill the put request. The function handles the removal of "information "
	 * 
	 *    -> A COMPLETER
	 */
	private void addInformationToSong(String input)
	{
		//remove "information " from the command
		input = input.substring(12);

		String[] indexes = input.split(" ");
		
		if(indexes.length >= 3)
		{
			if(checkInformation(indexes[0], indexes[1]) == true)
			{
				if(indexes.length > 3 )
					for (int i=3; i< indexes.length; i++) {
						indexes[2] = indexes[2].concat(indexes[i]);
					}
				
				/**
				 * Add to put request informations where col is the column and info the data
				 */
				
				view.NewInformationinRequest(indexes[0], indexes[1], indexes[2]);
			} else {
				view.InvalidIdentifiers();
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
		if(input.contains("song ") && song == null)
		{
			createSong(input);
		} else if (input.contains("song ") && song != null) {
			view.ExistingPutRequest();
		}
		
		//Add information to a song only if a song is being registered
		if(input.contains("information ") && song != null)
		{
			addInformationToSong(input);
		} else if (input.contains("information ") && song == null) {
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
		song = null;
		view.CommitedRequest();
	}
	
	/**
	 * Evaluate the first word of the input and acts accordingly
	 * @param input the input.
	 */
	private void eval(String input) {
		input = input.toLowerCase();
		
		if (input.contains("add ")) {
			addToPull(input);
			return;
		}

		// Commit the request only if it has been instanciated
		/**
		 * add a control if informations are empty
		 */
		if (input.contains("commit") && song != null) {
			performCommit();
			return;
		} else if (input.contains("commit") &&  song == null) {
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
		view.welcomeMessage();
		do {
			try {
				eval(input.readLine());
			} catch (IOException e) {
				System.err.print("Broken reader.");
			}
		} while (exitsignal == 0);
	}
}