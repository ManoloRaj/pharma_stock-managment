package basisClass;

public class Main {

   public static void main (String[] args){

      Medicament med = new Medicament("Paracetamol", 200, 20, true);
   	System.out.println("Nom : " +med.getName() + " --- Prix : "+med.getCost()+" Ar");

      DBManage db_manager = new DBManage();
      db_manager.insert_in_DB(med);
   }
}