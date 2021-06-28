package basisClass;
/**
*Class that implement Medicament
 */
public class Medicament{

    private String name;
    private double cost;
    private int remaining_number;
    private boolean available;

    public Medicament(){
        this.name = "Nothing";
        this.cost = 0;
        this.remaining_number = 0;
        this.available = false;
    }
    public Medicament(String name, double cost, int remaining_number, boolean available){
        this.name = name;
        this.cost = cost;
        this.remaining_number = remaining_number;
        this.available = available;
    }


    //Getter and setter methods
    public String getName(){
        return this.name;
    }
    public double getCost(){
        return this.cost;
    }
    public int getRemaining_number(){
        return this.remaining_number;
    }
    public boolean getAvailable(){
        return this.available;
    }

    public void setCost(String name){
        this.name = name;
    }
    public void setRemaining_number(int remaining_number){
        this.remaining_number = remaining_number;
    }
    public void setAvailable(boolean available){
        this.available = available;
    }
}