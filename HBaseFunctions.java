package controller;

import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.client.HBaseAdmin;
import org.apache.hadoop.hbase.TableName;

public class HBaseFunctions {
	/**
	 * Avant le REPL, initialisation
	 */
	
	//Configuration 
	Configuration config = HBaseConfiguration.create();
	
	//HbaseAdmin
	HBaseAdmin admin = new HBaseAdmin(config);
	
	//Instantiating table
	HTableDescriptor tableDescriptor = new TableDescriptor(TableName.valueOf("musicLibraryTable"));
	
	//Adding families
	HColumnDescriptor artistDescriptor = new HColumnDescriptor("artistInfo");
	HColumnDescriptor musicDescriptor = new HColumnDescriptor("musifInfo");
	tableDescriptor.addFamily(artistDescriptor);
	tableDescriptor.addFamily(musicDescriptor);
	
	//Add columns
	admin.addColumn("name", artistDescriptor);
	admin.addColumn("birthDate", artistDescriptor);
	admin.addColumn("style", artistDescriptor);
	admin.addColumn("biography", artistDescriptor);
	
	admin.addColumn("hdfsPathMusic", musicDescriptor);
	admin.addColumn("hdfsPathCover", musicDescriptor);
	admin.addColumn("mark", musicDescriptor);
	
	//Execute the table through admin
	admin.createTable(tableDescriptor);
	
	/**
	 * Ajout infos
	 */
	//Configuration
    Configuration config = HBaseConfiguration.create();

    // Instantiating HTable class
    HTable hTable = new HTable(config, "musicLibraryTable");

    // Instantiating Put class. "zzz" = row name
    Put p = new Put(Bytes.toBytes("zzz")); 

    //Adding artist info
    p.add(Bytes.toBytes("artistInfo"),
    		Bytes.toBytes("name"),Bytes.toBytes("xxx"));

    p.add(Bytes.toBytes("artistInfo"),
    		Bytes.toBytes("birthDate"),Bytes.toBytes("xx-xx-xxxx"));

    p.add(Bytes.toBytes("artistInfo"),Bytes.toBytes("style"),
    		Bytes.toBytes("xxx"));

    p.add(Bytes.toBytes("artistInfo"),Bytes.toBytes("biography"),
    		Bytes.toBytes("xxx"));
    
    //Adding music info
    p.add(Bytes.toBytes("musifInfo"),
    		Bytes.toBytes("hdfsPathMusic"),Bytes.toBytes("/xxx/xxx"));
    
    p.add(Bytes.toBytes("musifInfo"),
    	    Bytes.toBytes("hdfsPathCover"),Bytes.toBytes("/xxx/xxx"));
    
    p.add(Bytes.toBytes("musifInfo"),
    	    Bytes.toBytes("mark"),Bytes.toBytes("12"));
      
    // Saving to the HTable.
    hTable.put(p);
      
    // closing HTable
    hTable.close();
    
}
