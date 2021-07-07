package com.main.lib;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class DBManage{
	  
    private int curent_id;

    private ArrayList <Medicament> data_from_DB =new ArrayList();
    
    public ArrayList<Medicament> getDataFrom_DB() {
		return data_from_DB;
	}

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
    public void loadFromDB() throws IOException, ParseException {
    	Object obj = this.parser.parse(file1);
    	JSONArray list = (JSONArray) obj;
    	
    	list.forEach( emp -> parseInfoObject( (JSONObject) emp ) );
    	
    }

	private void parseInfoObject(JSONObject emp) {
		
		
		// TODO Auto-generated method stub
		JSONObject object = (JSONObject) emp;
        
		int ID =  (int)(long)object.get("ID");  
        //System.out.println(ID);
        
		String name = (String) object.get("Name");    
        //System.out.println(name);
        
        Double cost = (Double) object.get("Cost");  
        //System.out.println(cost);
        
        int remaining_number =  (int)(long)object.get("Remaining number");  
        //System.out.println(remaining_number);
        
        boolean available =  (boolean) object.get("Available");    
        //System.out.println(available);
        
        System.out.println("\n");
        
        this.data_from_DB.add(new Medicament(name, cost, remaining_number,available));
	}
	
	
    
}