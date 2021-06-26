import org.json.JSONArray;
import org.json.JSONObject;
import java.io.FileWriter;
import java.io.IOException;

/**
* Acting on JSON database file to save all data 
 */

public class DBManage{

    private JSONObject jsonObj= new JSONObject();

    private FileWriter file = new FileWriter("medicament.json");
  
    private int curent_id;

    private Medicament from_DB = new Medicament();

    public DBManage(){
        this.curent_id = 1;
        System.out.print("DBManage object created successfully...");
    }

    public void insert_in_DB(Medicament to_insert){
        this.jsonObj.put("ID", this.curent_id);
        this.jsonObj.put("Name", to_insert.getName());
        this.jsonObj.put("Cost", to_insert.getCost());
        this.jsonObj.put("Remaining number", to_insert.getRemaining());
        this.jsonObj.put("Available", to_insert.getAvailable());
        this.curent_id ++;
    }
    //public Medicament get_from_DB(){
    //    return void;
    //}
}