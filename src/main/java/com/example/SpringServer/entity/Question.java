package com.example.SpringServer.entity;

import com.example.SpringServer.Answer;

import java.util.LinkedList;
import java.util.List;

public class Question {
    String name;
    public Answer[] answers;
    public Question(String name, int id){
        this.name = name;
        this.answers = new Answer[5];
        for (int i = 0; i < 5; i++){
            answers[i] =new Answer(name, id+=1, i+1);
        }

    }
    public String getName(){
        return name;
    }

    public Answer[] getAnswers(){
        return answers;
    }
}
