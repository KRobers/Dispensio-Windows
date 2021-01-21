package sample;

import javafx.beans.property.SimpleStringProperty;

public class table {

    private SimpleStringProperty maandagTable;
    private SimpleStringProperty dindagTable;
    private SimpleStringProperty woensdagTable;
    private SimpleStringProperty donderdagTable;
    private SimpleStringProperty vrijdagTable;
    private SimpleStringProperty zaterdagTable;
    private SimpleStringProperty zondagTable;

    public table(String maandagTable, String dinsdagTable, String woensdagTable, String donderdagTable, String vrijdagTable, String zaterdagTable, String zondagTable){
        this.maandagTable = new SimpleStringProperty(maandagTable);
        this.dindagTable = new SimpleStringProperty(dinsdagTable);
        this.woensdagTable = new SimpleStringProperty(woensdagTable);
        this.donderdagTable = new SimpleStringProperty(donderdagTable);
        this.vrijdagTable = new SimpleStringProperty(vrijdagTable);
        this.zaterdagTable = new SimpleStringProperty(zaterdagTable);
        this.zondagTable = new SimpleStringProperty(zondagTable);
    }

    public String getmaandag(){
        return maandagTable.get();
    }
    public void setmaandag(String maandagTable){
        this.maandagTable = new SimpleStringProperty(maandagTable);
    }

    public String getdinsdag(){
        return dindagTable.get();
    }
    public void setdinsdag(String dinsdagTable){
        this.dindagTable = new SimpleStringProperty(dinsdagTable);
    }

    public String getwoensdag(){
        return woensdagTable.get();
    }
    public void setwoensdag(String woensdagTable){
        this.woensdagTable = new SimpleStringProperty(woensdagTable);
    }

    public String getdonderdag(){
        return donderdagTable.get();
    }
    public void setdonderdag(String donderdagTable){
        this.donderdagTable = new SimpleStringProperty(donderdagTable);
    }

    public String getvrijdag(){
        return vrijdagTable.get();
    }
    public void setvrijdag(String vrijdagTable){
        this.vrijdagTable = new SimpleStringProperty(vrijdagTable);
    }

    public String getzaterdag(){
        return zaterdagTable.get();
    }
    public void setzaterdag(String zaterdagTable){
        this.zaterdagTable = new SimpleStringProperty(zaterdagTable);
    }

    public String getzondag(){
        return zondagTable.get();
    }
    public void setzondag(String zondagTable){
        this.zondagTable = new SimpleStringProperty(zondagTable);
    }
}
