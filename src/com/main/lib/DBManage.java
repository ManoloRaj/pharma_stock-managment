package com.main.lib;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class DBManage{
	  
    private int curent_id;

    private Medicament from_DB = new Medicament();
    
    //Variable to use for insert into database
    private JSONArray jsonArray = new JSONArray();
    private FileWriter file ;
    
    //Variable to use for get from database
    private JSONParser parser = new JSONParser();
    private FileReader file1 ;
    
    

    public DBManage() throws IOException{
        this.curent_id = 1;
        
        this.file= new FileWriter("database/medicament.json");
        this.file1 = new FileReader("database/medicament.json");
        
        System.out.println("DBManage object created successfully...");
        
    }

    @SuppressWarnings("deprecation")
	public void insert_in_DB(Medicament to_insert) throws IOException{

    	JSONObject jsonObj_insert= new JSONObject();
        jsonObj_insert.put("ID", this.curent_id);
        jsonObj_insert.put("Name", to_insert.getName());
        jsonObj_insert.put("Cost", to_insert.getCost());
        jsonObj_insert.put("Remaining number", to_insert.getRemaining_number());
        jsonObj_insert.put("Available", to_insert.getAvailable());

        this.jsonArray.add(jsonObj_insert);

        curent_id = curent_id + 1;
        
    }
    public void upload() throws IOException {
    	this.file.write(this.jsonArray.toJSONString());
    	this.file.flush();
    }
    
    
    //Function for get element in database
    public void get_from_DB() throws IOException, ParseException {
    	Object obj = this.parser.parse(file1);
    	JSONArray list = (JSONArray) obj;
    	
    	list.forEach( emp -> parseInfoObject( (JSONObject) emp ) );
   
    }

	private void parseInfoObject(JSONObject emp) {
		// TODO Auto-generated method stub
		JSONObject object = (JSONObject) emp;
        
        //Get employee first name
        String Name = (String) object.get("Name");    
        System.out.println(Name);
         
        //Get employee last name
        Double Cost = (Double) object.get("Cost");  
        System.out.println(Cost);
         
	}
    
}