package com.example.SpringServer;

import jakarta.persistence.Entity;

import java.util.LinkedList;
import java.util.List;


public class Answer {
    public String name;
    public int id;
    public int num;
    public Answer(String name, int id, int num){
        this.id = id;
        this.name = name;
        this.num = num;
    }
    public String getName(){
        return name;
    }
    public int getId(){
        return id;
    }
    public String getNum(){
        return Integer.toString(num);
    }
}
