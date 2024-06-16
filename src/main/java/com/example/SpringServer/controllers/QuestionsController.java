package com.example.SpringServer.controllers;

import com.example.SpringServer.*;
import com.example.SpringServer.entity.Question;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;

@Controller
public class QuestionsController {
    @GetMapping("/questions")
    public String getQuestionForm(Model model){
        model.addAttribute("head", "Дайте ответы на вопросы");
        List<Question> questions = new LinkedList<>();
        List<String> names = new QuestionsText().getQuestions();
        for (int i = 0; i < names.size(); i++){
            questions.add(new Question(names.get(i), i * 5));
        }
        model.addAttribute("questions", questions);
        return "questions";
    }
    @PostMapping("/answers")
    public String getAnswersForm(Model model, HttpServletRequest request){
        Iterator<String> iter = request.getParameterNames().asIterator();
        List<KeyValuePair<String, Integer>> questionAnswersList = new LinkedList<>();
        while(iter.hasNext()){
            String param = iter.next();
            questionAnswersList.add(new KeyValuePair<>(param, Integer.parseInt(request.getParameter(param))));
        }
        if (questionAnswersList.size() < 10){
            return getQuestionForm(model);
        }
        model.addAttribute("head", "Ваш результат!!!");

        Results results = new Results(questionAnswersList);
        System.out.println(results.getJsonResults());
        String currentURL = "http://127.0.0.1:5000/predict";
        try {
            URL url = new URL(currentURL);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);
            OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream());
            writer.write(results.getJsonResults());
            writer.flush();
            System.out.println(connection.getResponseMessage());
            // Считываем ответ от сервера
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line = "";
            StringBuilder response = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                response.append(line);
                System.out.println(line);
            }
            String[] str = response.toString().replace("\"", "").split("~");
            reader.close();
            try {
                model.addAttribute("result", new Categories().getCategories().get(Integer.parseInt(str[0])));
                model.addAttribute("result1", new Categories().getCategories().get(Integer.parseInt(str[1])));
                model.addAttribute("result2", new Categories().getCategories().get(Integer.parseInt(str[2])));
                model.addAttribute("target", str[0]);
            }
            catch (Exception ex){
                return "Error 500" + ex.getMessage();
            }
            model.addAttribute("addedAnswers", results.getJsonResults());
        }
        catch (Exception ex){
            return ex.getMessage();
        }
        return "answer";
    }
    @PostMapping("/addTestData")
    public String addDataToNN(HttpServletRequest request, Model model){
        Iterator<String> iterator = request.getParameterNames().asIterator();
        String results = Results.getJsonResultsWithTarget(request.getParameter("answersText"), request.getParameter("target"));
        System.out.println(results);
        String currentURL = "http://127.0.0.1:5000/addToLearn";
        try {
            URL url = new URL(currentURL);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);
            OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream());
            writer.write(results);
            writer.flush();
            System.out.println(connection.getResponseMessage());
            // Считываем ответ от сервера
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line = "";
            StringBuilder response = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();
        }
        catch (Exception ex){
            return ex.getMessage();
        }

        return "home";
    }
}
