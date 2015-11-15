package repl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//import controller.HBaseFunctions;

/**
 * REPL
 * add functions fill a music class instance
 * commit function create a HBase put request
 * 
 * All instruction using HBase are commented. Our HBase is not functionnal for now.
 * 
 * @author parrie
 *
 */
public class CLI {

	private Music song;

	private Printer view;
	
	//private HBaseFunctions database;

	private BufferedReader input;

	private int exitsignal;

	private String[] songInformationLabels = { "name", "style",
			"duration", "pathtomp3", "pathtocover", "score", "releasedate" };
	private String[] artistInformationLabels = { "name", "birthday", "biography" };
	private String[] albumInformationLabels = { "name", "style", "releasedate",
			"tracknumber" };

	public CLI() {
		view = new Printer();
		input = new BufferedReader(new InputStreamReader(System.in));
		exitsignal = 0;
		song = new Music();
		//database.initHabse();
	}

	/**
	 * Checks that the information given fit our database
	 * 
	 * @param columnDescriptor
	 *            columndescriptor of the input
	 * @param informationLabel
	 *            informationLabel of the input
	 * @return True if the information fit the database, else false
	 */
	private Boolean checkInformation(String columnDescriptor,
			String informationLabel) {
		if (columnDescriptor.compareTo("song") == 0) {
			for (String label : songInformationLabels) {
				if (informationLabel.compareTo(label) == 0)
					return true;
			}
		}

		if (columnDescriptor.compareTo("artist") == 0) {
			for (String label : artistInformationLabels) {
				if (informationLabel.compareTo(label) == 0)
					return true;
			}
		}

		if (columnDescriptor.compareTo("album") == 0) {
			for (String label : albumInformationLabels) {
				if (informationLabel.compareTo(label) == 0)
					return true;
			}
		}

		return false;
	}

	/**
	 * Add the informationValue in the class music in function of the column descriptor and information label
	 * @param columnDescriptor 
	 * @param informationLabel
	 * @param informationValue
	 */
	private void fillSongInformation(String columnDescriptor,
			String informationLabel, String informationValue) {
		if (columnDescriptor.compareTo("song") == 0) 
		{
			for (int i = 0; i < songInformationLabels.length; i++) 
			{
				if (informationLabel.compareTo(songInformationLabels[i]) == 0) 
				{
					switch (i) {
					case 0:
						if (song.getSongName() != "")
							view.AlreadyRegisteredValue();
						song.setSongName(informationValue);
						break;
						
					case 1:
						if (song.getSongStyle() != "")
							view.AlreadyRegisteredValue();
						song.setSongStyle(informationValue);
						break;
						
					case 2:
						if (song.getSongDuration() != "")
							view.AlreadyRegisteredValue();
						song.setSongDuration(informationValue);
						break;
					
					case 3:
						if (song.getSongPath() != "")
							view.AlreadyRegisteredValue();
						song.setSongPath(informationValue);
						break;
						
					case 4:
						if (song.getSongJacketPath() != "")
							view.AlreadyRegisteredValue();
						song.setSongJacketPath(informationValue);
						break;
						
					case 5:
						if (song.getSongMark() != "")
							view.AlreadyRegisteredValue();
						song.setSongMark(informationValue);
						break;
						
					case 6:
						if (song.getSongDate() != "")
							view.AlreadyRegisteredValue();
						song.setSongDate(informationValue);
						break;
					}
					return;
				}
			}
		}
		
		if (columnDescriptor.compareTo("artist") == 0) 
		{
			for (int i = 0; i < artistInformationLabels.length; i++) 
			{
				if (informationLabel.compareTo(artistInformationLabels[i]) == 0)
				{
					switch(i) {
					case 0: 
						if (song.getArtistName() != "")
							view.AlreadyRegisteredValue();
						song.setArtistName(informationValue);
						break;
						
					case 1: 
						if (song.getArtistBday() != "")
							view.AlreadyRegisteredValue();
						song.setArtistBday(informationValue);
						break;
						
					case 2: 
						if (song.getArtistBio() != "")
							view.AlreadyRegisteredValue();
						song.setArtistBio(informationValue);
						break;
					}
					return;
				}
			}
		}
		
		if (columnDescriptor.compareTo("album") == 0)
		{
			for (int i = 0; i <albumInformationLabels.length; i++)
			{
				if (informationLabel.compareTo(albumInformationLabels[i]) == 0)
				{
					switch (i) {
					case 0: 
						if (song.getAlbumName() != "")
							view.AlreadyRegisteredValue();
						song.setAlbumName(informationValue);
						break;
						
					case 1: 
						if (song.getAlbumStyle() != "")
							view.AlreadyRegisteredValue();
						song.setAlbumStyle(informationValue);
						break;
						
					case 2: 
						if (song.getAlbumDate() != "")
							view.AlreadyRegisteredValue();
						song.setAlbumDate(informationValue);
						break;
						
					case 3: 
						if (song.getAlbumTrackNumber() != "")
							view.AlreadyRegisteredValue();
						song.setAlbumTrackNumber(informationValue);
						break;
					}
					return;
				}
			}
		}
	}

	/**
	 * Fill the information value of our table.
	 * 
	 * @param input
	 *            Contains the ColumnDescriptor, information label and
	 *            information to use to fill the put request. The function
	 *            handles the removal of "information "
	 */
	private void addInformationToSong(String input) {
		// remove "information " from the command
		input = input.substring(12);

		String[] indexes = input.split(" ");

		if (indexes.length >= 3) {
			if (checkInformation(indexes[0], indexes[1]) == true) {
				if (indexes.length > 3)
					for (int i = 3; i < indexes.length; i++) {
						indexes[2] = indexes[2].concat(" "+indexes[i]);
					}
				
				fillSongInformation(indexes[0], indexes[1], indexes[2]);

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
	 * 
	 * Actually useless, unless you want to add "add ..." commands
	 * 
	 * @param input
	 *            Command entered by the user
	 */
	private void addToPull(String input) {
		// remove "add " from the command
		input = input.substring(4);

		// Add information to a song only if a song is being registered
		if (input.contains("information "))
			addInformationToSong(input);
	}

	/**
	 * Request the put object to commit its values
	 * 
	 * -> A COMPLETER
	 */
	private void performCommit() {
		/**
		 * add a control if informations are empty
		 */
		//database.saveMusic(song);
		view.CommitedRequest(song.getSongInfos(), song.getArtistInfos(), song.getAlbumInfos());
		song = new Music();
	}

	/**
	 * Evaluate the first word of the input and acts accordingly
	 * 
	 * @param input
	 *            the input.
	 */
	private void eval(String input) {
		input = input.toLowerCase();

		if (input.contains("add ")) {
			addToPull(input);
			return;
		}

		if (input.contains("commit")) {
			performCommit();
			return;
		} 

		if (input.contains("exit")) {
			exitsignal = 1;
			view.ExitMessage();
			return;
		}

		view.NotReconizedCommand();
	}
	
	/**
	 * Execution loop
	 */
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