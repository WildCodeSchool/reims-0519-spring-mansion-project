package com.wildcodeschool.reims0519springmansionproject.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.server.ResponseStatusException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

@Controller
@ResponseBody

public class ControllerEnd{
    private final static String DB_URL = "jdbc:mysql://localhost:3306/mansion_project?serverTimezone=GMT";
    private final static String DB_USER = "javaclues";
    private final static String DB_PASSWORD = "Wcsmansion2019!";
 
    @GetMapping("/score")
    public List<Score> getScore (){
        try(
            Connection connection = DriverManager.getConnection(
                DB_URL, DB_USER, DB_PASSWORD
            );
            PreparedStatement statement = connection.prepareStatement(
            "SELECT * FROM score"
            );
        )
        {
        try(
            ResultSet resultSet = statement.executeQuery();
        ) 
        {    List<Score> score = new ArrayList<Score>();

            while(resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int time = resultSet.getInt("time");
                int Score = resultSet.getInt("score");
                score.add(new Score(id, name, time, Score));
            }
        
            return score;
            }
        }
        catch (SQLException e) {
            throw new ResponseStatusException(
                HttpStatus.INTERNAL_SERVER_ERROR, "", e
            );
}
    
    }
        class Score {

            private int id;
            private String name;
            private int time;
            private int score;
    
            public Score(int id, String name, int time, int score) {
                this.id = id;
                this.name = name;
                this.time = time;
                this.score = score;
            }
    
            public int getId() {
                return id;
            }
    
            public String getName() {
                return name;
            }
    
            public int getTime() {
                return time;
            }
    
            public int getScore() {
                return score;
            }
    }
        
    }