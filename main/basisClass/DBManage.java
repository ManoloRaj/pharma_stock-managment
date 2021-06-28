package basisClass;

import org.json.JSONArray;
import org.json.JSONObject;
import java.io.FileWriter;
import java.io.IOException;

/**
* Acting on JSON database file to save all data 
 */
@SuppressWarnings("unchecked")
public class DBManage{
  
    private int curent_id;

    private Medicament from_DB = new Medicament();

    public DBManage(){
        this.curent_id = 1;
        System.out.print("DBManage object created successfully...");
    }

    public void insert_in_DB(Medicament to_insert){

        JSONObject jsonObj= new JSONObject();
        
        jsonObj.put("ID", this.curent_id);
        jsonObj.put("Name", to_insert.getName());
        jsonObj.put("Cost", to_insert.getCost());
        jsonObj.put("Remaining number", to_insert.getRemaining_number());
        jsonObj.put("Available", to_insert.getAvailable());

        System.out.println(jsonObj.toString());
        try (FileWriter file = new FileWriter("database/medicament.json")) {
            //We can write any JSONArray or JSONObject instance to the file
            file.write(jsonObj.toString()); 
            file.flush();
 
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.curent_id  = this.curent_id + 1;
    }
    //public Medicament get_from_DB(){
    //    return void;
    //}
}