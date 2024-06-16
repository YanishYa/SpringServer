package com.example.SpringServer;

import java.util.LinkedList;
import java.util.List;

public class QuestionsText {
    List<String> questionsText = new LinkedList<String>();
    public QuestionsText(){
        questionsText.add("Насколько вы хотели бы провести время в местах по уходу за собой?"); //0
        questionsText.add("Насколько вы хотели бы активно провести время?"); //1
        questionsText.add("Насколько вы хотели бы провести время с друзьями?"); //2
        questionsText.add("Насколько сильно вы хотели бы поесть?"); //3
        questionsText.add("Насколько вам важно, чтобы дети могли отдохнуть с вами?"); //4
        questionsText.add("Насколько вы хотели бы посетить какое-нибудь мероприятие?"); //5
        questionsText.add("Насколько много средств вы готовы потратить?"); //6
        questionsText.add("Насколько много времени вы можете выделить для развлечений?"); //7
        questionsText.add("Насколько бы вы хотели посетить какие-либо знаковые места?"); //8
        questionsText.add("Насколько бы вы хотели провести время в месте, связанном с водой?"); //9

    }
    public List<String> getQuestions(){
        return questionsText;
    }
}
