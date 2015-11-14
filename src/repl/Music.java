package repl;

public class Music {
	
	private static Music instance = null;
	
	private String songName;
	private String songStyle;
	private String songDuration;
	private String songPath;
	private String songJacketPath;
	private String songMark;
	private String songDate;
	
	private String artistName;
	private String artistBday;
	private String artistBio;
	
	private String albumName;
	private String albumStyle;
	private String albumDate;
	private String albumTrackNumber;
	
	private Music(){
		super();
	}
	
	/**
	* @return une instance de Music
	*/
	public static Music instance(){
		if(instance==null)
			instance = new Music();
		return instance;
	}
	
	/**
	 * Display song infos
	 */
	public void displaySong(){
		System.out.print("Song infos:");
		System.out.print("Name: "+this.songName);
		System.out.print("Date: "+this.songDate);
		System.out.print("Duration: "+this.songDuration);
		System.out.print("Style: "+this.songStyle);
		System.out.print("Mark: "+this.songMark);
		System.out.print("Path: "+this.songPath);
		System.out.print("Jacket path: "+this.songJacketPath);
	}
	
	/**
	 * Display artist infos
	 */
	public void displayArtis(){
		System.out.print("Artist infos:");
		System.out.print("Name: "+this.artistName);
		System.out.print("Bday: "+this.artistBday);
		System.out.print("Bio: "+this.artistBio);
	}
	
	/**
	 * Display album infos
	 */
	public void displayAlbum(){
		System.out.print("Album infos:");
		System.out.print("Name: "+this.albumName);
		System.out.print("Style: "+this.albumStyle);
		System.out.print("Date: "+this.albumDate);
	}
	
	/**
	 * Getters & Setters
	 */
	public String getSongName() {
		return songName;
	}

	public void setSongName(String songName) {
		this.songName = songName;
	}

	public String getSongStyle() {
		return songStyle;
	}

	public void setSongStyle(String songStyle) {
		this.songStyle = songStyle;
	}

	public String getSongDuration() {
		return songDuration;
	}

	public void setSongDuration(String songDuration) {
		this.songDuration = songDuration;
	}

	public String getSongPath() {
		return songPath;
	}

	public void setSongPath(String songPath) {
		this.songPath = songPath;
	}

	public String getSongJacketPath() {
		return songJacketPath;
	}

	public void setSongJacketPath(String songJacketPath) {
		this.songJacketPath = songJacketPath;
	}

	public String getSongMark() {
		return songMark;
	}

	public void setSongMark(String songMark) {
		this.songMark = songMark;
	}

	public String getSongDate() {
		return songDate;
	}

	public void setSongDate(String songDate) {
		this.songDate = songDate;
	}

	public String getArtistName() {
		return artistName;
	}

	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}

	public String getArtistBday() {
		return artistBday;
	}

	public void setArtistBday(String artistBday) {
		this.artistBday = artistBday;
	}

	public String getArtistBio() {
		return artistBio;
	}

	public void setArtistBio(String artistBio) {
		this.artistBio = artistBio;
	}

	public String getAlbumName() {
		return albumName;
	}

	public void setAlbumName(String albumName) {
		this.albumName = albumName;
	}

	public String getAlbumStyle() {
		return albumStyle;
	}

	public void setAlbumStyle(String albumStyle) {
		this.albumStyle = albumStyle;
	}

	public String getAlbumDate() {
		return albumDate;
	}

	public void setAlbumDate(String albumDate) {
		this.albumDate = albumDate;
	}

	public String getAlbumTrackNumber() {
		return albumTrackNumber;
	}

	public void setAlbumTrackNumber(String albumTrackNumber) {
		this.albumTrackNumber = albumTrackNumber;
	}
}
