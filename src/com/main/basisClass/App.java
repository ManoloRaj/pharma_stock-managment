package com.main.basisClass;

import java.io.IOException;

import org.json.simple.parser.ParseException;

import com.main.lib.DBManage;
import com.main.lib.Medicament;

public class App {

	public static void main(String[] args) throws IOException, ParseException {
		// TODO Auto-generated method stub
	      Medicament paracetamol = new Medicament("Paracetamol", 200, 20, true);
	      Medicament amoxicillin = new Medicament("Amoxicillin", 1500, 30, true);

	      DBManage db_manager = new DBManage();
	      
	      db_manager.insert_in_DB(paracetamol);
	      db_manager.insert_in_DB(amoxicillin);
	      db_manager.insert_in_DB(amoxicillin);
	      
	      System.out.println("\n");
	      
	      db_manager.upload();
	      db_manager.get_from_DB();
	}

}
