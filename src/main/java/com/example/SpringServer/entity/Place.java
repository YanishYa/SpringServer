package com.example.SpringServer.entity;

import jakarta.persistence.*;

@Entity
@Table(name="appDB.place")
public class Place {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int id;
    private String name;
    public Place(String name){
        this.name = name;
    }

    public Place(){
        this.name = "NULL";
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }
}
