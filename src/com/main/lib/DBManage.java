package com.main.lib;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class DBManage{
	  
    private int curent_id;

    private Medicament from_DB = new Medicament();
    
    private JSONObject jsonObj_insert= new JSONObject();
    
    private JSONParser parser = new JSONParser();
    
    private FileWriter file ;

    public DBManage() throws IOException{
        this.curent_id = 1;
        
        this.file= new FileWriter("database/medicament.json");
        
        
        System.out.println("DBManage object created successfully...");
        
    }

    @SuppressWarnings("deprecation")
	public void insert_in_DB(Medicament to_insert) throws IOException{

        this.jsonObj_insert.put("ID", this.curent_id);
        this.jsonObj_insert.put("Name", to_insert.getName());
        this.jsonObj_insert.put("Cost", to_insert.getCost());
        this.jsonObj_insert.put("Remaining number", to_insert.getRemaining_number());
        this.jsonObj_insert.put("Available", to_insert.getAvailable());

        System.out.println(jsonObj_insert.toJSONString());

        //We can write any JSONArray or JSONObject instance to the file
        this.file.write(this.jsonObj_insert.toJSONString()+"\n"); 
        this.file.flush();
        
        curent_id = curent_id + 1;
        
    }
    
    
    
    
    public void get_from_DB() throws FileNotFoundException, IOException, ParseException{

            Object obj = parser.parse(new FileReader("database/medicament.json"));

            JSONObject jsonObject =  new JSONObject();

            String ID = (String) jsonObject.get("ID");
            System.out.println(ID);

            String Name = (String) jsonObject.get("Name");
            System.out.println(Name);

            String Remaining_nb = (String) jsonObject.get("Remaining number");
            System.out.println(Remaining_nb);

            String Available = (String) jsonObject.get("Available");
            System.out.println(Available);
        
   
    }
    
}