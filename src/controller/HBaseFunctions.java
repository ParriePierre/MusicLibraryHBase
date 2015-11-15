package controller;
import repl.Music;

import java.io.IOException;
import java.math.BigInteger;
import java.security.SecureRandom;

import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.client.HBaseAdmin;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.util.Bytes;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.conf.Configuration;

public class HBaseFunctions {
	/**
	 * Avant le REPL, initialisation
	 */
	public String initHabse() {
		//Failure
		String failureStatus = null;
		
		//Configuration 
		Configuration configuration = HBaseConfiguration.create();
		
		//HbaseAdmin
		HBaseAdmin admin = new HBaseAdmin(configuration);
		
		//Instantiating table
		HTableDescriptor tableDescriptor = new TableDescriptor(TableName.valueOf("musicLibraryTable"));
		
		//Creating families
		HColumnDescriptor musicDescriptor = new HColumnDescriptor("musifInfo");
		HColumnDescriptor artistDescriptor = new HColumnDescriptor("artistInfo");
		HColumnDescriptor albumDescriptor = new HColumnDescriptor("albumfInfo");
		
		//Adding families
		tableDescriptor.addFamily(artistDescriptor);
		tableDescriptor.addFamily(musicDescriptor);
		tableDescriptor.addFamily(albumDescriptor);
		
		//Add columns to music descriptor
		admin.addColumn("songName", musicDescriptor);
		admin.addColumn("songStyle", musicDescriptor);
		admin.addColumn("songDuration", musicDescriptor);
		admin.addColumn("songPath", musicDescriptor);
		admin.addColumn("songJacketPath", musicDescriptor);
		admin.addColumn("songMark", musicDescriptor);
		admin.addColumn("songDate", musicDescriptor);
		
		//Add columns to artist descriptor
		admin.addColumn("artistName", artistDescriptor);
		admin.addColumn("artistBio", artistDescriptor);
		
		//Add columns to album descriptor
		admin.addColumn("albumName", albumDescriptor);
		admin.addColumn("albumStyle", albumDescriptor);
		admin.addColumn("albumDate", albumDescriptor);
		admin.addColumn("albumTrackNumber", albumDescriptor);
		
		//Execute the table
		try{
			admin.createTable(tableDescriptor);
	    }
	    catch(IOException ex){
	    	failureStatus = "An error occured during the creation of the table.";
	    }
		finally{
  	    	return failureStatus;
  	    }
	}
		
		/**
		 * Ajout infos
		 */
	public String saveMusic(Music myMusic){
		String failureStatus = null;
		
		//Configuration 
		Configuration configuration = HBaseConfiguration.create();
		
	    // Instantiating HTable class
	    HTable hTable = new HTable(configuration, "musicLibraryTable");
	    
	    //Random row key
	    SecureRandom random = new SecureRandom();
	    
	    // Instantiating Put class.
	    Put p = new Put(Bytes.toBytes(new BigInteger(130, random).toString(32))); 
	    
	    //Adding music info
	    p.add(Bytes.toBytes("musifInfo"),
	    		Bytes.toBytes("songName"),Bytes.toBytes(myMusic.getSongName()));
	    p.add(Bytes.toBytes("musifInfo"),
	    		Bytes.toBytes("songStyle"),Bytes.toBytes(myMusic.getSongStyle()));
	    p.add(Bytes.toBytes("musifInfo"),
	    		Bytes.toBytes("songDuration"),Bytes.toBytes(myMusic.getSongDuration()));
	    p.add(Bytes.toBytes("musifInfo"),
	    		Bytes.toBytes("songPath"),Bytes.toBytes(myMusic.getSongPath()));
	    p.add(Bytes.toBytes("musifInfo"),
	    		Bytes.toBytes("songJacketPath"),Bytes.toBytes(myMusic.getSongJacketPath()));
	    p.add(Bytes.toBytes("musifInfo"),
	    		Bytes.toBytes("songMark"),Bytes.toBytes(myMusic.getSongMark()));
	    p.add(Bytes.toBytes("musifInfo"),
	    		Bytes.toBytes("songDate"),Bytes.toBytes(myMusic.getSongDate()));
	    
	    //Adding artist info
	    p.add(Bytes.toBytes("artistInfo"),
	    		Bytes.toBytes("artistName"),Bytes.toBytes(myMusic.getArtistName()));
	    p.add(Bytes.toBytes("artistInfo"),
	    		Bytes.toBytes("artistBio"),Bytes.toBytes(myMusic.getArtistBio()));
	    
	    //Adding album infos
	    p.add(Bytes.toBytes("albumInfo"),
	    		Bytes.toBytes("albumName"),Bytes.toBytes(myMusic.getAlbumName()));
	    p.add(Bytes.toBytes("albumInfo"),
	    		Bytes.toBytes("albumStyle"),Bytes.toBytes(myMusic.getAlbumStyle()));
	    p.add(Bytes.toBytes("albumInfo"),
	    		Bytes.toBytes("albumDate"),Bytes.toBytes(myMusic.getAlbumDate()));
	    p.add(Bytes.toBytes("albumInfo"),
	    		Bytes.toBytes("albumTrackNumber"),Bytes.toBytes(myMusic.getAlbumTrackNumber()));
	
	    //Saving to the HTable.
  		try{
  			hTable.close();
  	    }
  	    catch(IOException ex){
  	    	failureStatus = "An error occured while adding the song.";
  	    }
  		finally{
  	    	return failureStatus;
  	    }
  		
  		//Closing the htable
  		try{
  			hTable.close();
  	    }
  	    catch(IOException ex){
  	    	failureStatus = "An error occured during the HTable closing.";
  	    }
  		finally{
  	    	return failureStatus;
  	    }
	}
}
