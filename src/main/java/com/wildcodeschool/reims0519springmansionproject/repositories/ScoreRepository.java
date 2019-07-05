package com.wildcodeschool.reims0519springmansionproject.repositories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.wildcodeschool.reims0519springmansionproject.entities.Score;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class ScoreRepository {
    private final static String DB_URL = "jdbc:mysql://localhost:3306/mansion_project?serverTimezone=GMT";
    private final static String DB_USER = "javaclues";
    private final static String DB_PASSWORD = "Wcsmansion2019!";

    public static List<Score> selectAll() {
        try (
            Connection connection = DriverManager.getConnection(
                DB_URL, DB_USER, DB_PASSWORD
            );
            PreparedStatement statement = connection.prepareStatement(
                "SELECT * FROM score"
            );
        ) {
            try (
                ResultSet resultSet = statement.executeQuery();
            ) {
                ArrayList<Score> scores = new ArrayList<Score>();
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    long time = resultSet.getLong("time");
                    scores.add(new Score(id, name, time));
                }
                return scores;
            }
        } catch (SQLException e) {
            throw new ResponseStatusException(
                HttpStatus.INTERNAL_SERVER_ERROR, "", e
            );
        }
    }

    public static int insert(
        String name,
        long time
    ) {
        try (
            Connection connection = DriverManager.getConnection(
                DB_URL, DB_USER, DB_PASSWORD
            );
            PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO score (name, time) VALUES (?, ?)",
                Statement.RETURN_GENERATED_KEYS
            );
        ) {
            statement.setString(1, name);
            statement.setLong(2, time);

            if (statement.executeUpdate() != 1) {
                throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR, "failed to insert data"
                );
            }

            try (
                ResultSet generatedKeys = statement.getGeneratedKeys();
            ) {
                if (generatedKeys.next()) {
                    return generatedKeys.getInt(1);
                }
                else {
                    throw new ResponseStatusException(
                        HttpStatus.INTERNAL_SERVER_ERROR, "failed to get inserted id"
                    );
                }
            }
        } 
        catch (SQLException e) {
            throw new ResponseStatusException(
                HttpStatus.INTERNAL_SERVER_ERROR, "", e
            );
        }
    }

    public static Score selectById(int id) {
        try (
            Connection connection = DriverManager.getConnection(
                DB_URL, DB_USER, DB_PASSWORD
            );
            PreparedStatement statement = connection.prepareStatement(
                "SELECT * FROM score WHERE id=?"
            );
        ) {
            statement.setInt(1, id);
            try (
                ResultSet resultSet = statement.executeQuery();
            ) {
                if (resultSet.next()) {
                    String name = resultSet.getString("name");
                    long time = resultSet.getLong("time");
                    return new Score(id, name, time);
                }
                else {
                    throw new ResponseStatusException(
                        HttpStatus.INTERNAL_SERVER_ERROR, "unknown id in table score"
                    );
                }
            }
        } 
        catch (SQLException e) {
            throw new ResponseStatusException(
                HttpStatus.INTERNAL_SERVER_ERROR, "", e
            );
        }
    }
}