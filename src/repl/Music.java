package repl;

public class Music {
	
	private String songName = "";
	private String songStyle = "";
	private String songDuration = "";
	private String songPath = "";
	private String songJacketPath = "";
	private String songMark = "";
	private String songDate = "";
	
	private String artistName = "";
	private String artistBday = "";
	private String artistBio = "";
	
	private String albumName = "";
	private String albumStyle = "";
	private String albumDate = "";
	private String albumTrackNumber = "";
	
	public Music(){
		super();
	}
	
	/**
	 * 
	 * @return songInfos
	 */
	public String getSongInfos(){
		
		String songInfos = "Song infos:";

		songInfos = songInfos.concat("\nName: "+this.songName);
		songInfos = songInfos.concat("\nDate: "+this.songDate);
		songInfos = songInfos.concat("\nDuration: "+this.songDuration);
		songInfos = songInfos.concat("\nStyle: "+this.songStyle);
		songInfos = songInfos.concat("\nMark: "+this.songMark);
		songInfos = songInfos.concat("\nPath: "+this.songPath);
		songInfos = songInfos.concat("\nJacket path: "+this.songJacketPath);
		
		return songInfos;
	}
	
	/**
	 * 
	 * @return artist Infos
	 */
	public String getArtistInfos(){
		
		String artistInfos = "Artist infos";
		
		artistInfos = artistInfos.concat("\nName: "+this.artistName);
		artistInfos = artistInfos.concat("\nBday: "+this.artistBday);
		artistInfos = artistInfos.concat("\nBio: "+this.artistBio);
		
		return artistInfos;
	}
	
	/**
	 * @return Album infos
	 */
	public String getAlbumInfos(){
		
		String albumInfos = "Album infos:";
		
<<<<<<< Updated upstream
		albumInfos = albumInfos.concat("\nName: "+this.albumName);
		albumInfos = albumInfos.concat("\nStyle: "+this.albumStyle);
		albumInfos = albumInfos.concat("\nDate: "+this.albumDate);
=======
<<<<<<< HEAD
		albumInfos = albumInfos.concat("Name: "+this.albumName);
		albumInfos = albumInfos.concat("Style: "+this.albumStyle);
		albumInfos = albumInfos.concat("Date: "+this.albumDate);
=======
		albumInfos = albumInfos.concat("\nName: "+this.albumName);
		albumInfos = albumInfos.concat("\nStyle: "+this.albumStyle);
		albumInfos = albumInfos.concat("\nDate: "+this.albumDate);
>>>>>>> origin/master
>>>>>>> Stashed changes
		
		return albumInfos;
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
