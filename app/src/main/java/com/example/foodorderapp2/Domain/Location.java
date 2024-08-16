package com.example.foodorderapp2.Domain;

public class Location {
    private int Id;
    private String Loc;

    public String toString(){
        return Loc;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getLoc() {
        return Loc;
    }

    public void setLoc(String loc) {
        Loc = loc;
    }
}
