package com.example.sciencebook;
import java.sql.*;
public class Stages {
    private int TotalPoints = 0;
    public int getTotal(){
        return TotalPoints;
    }
    private void getTotalPoints(){
        try (Connection connection  =DriverManager.getConnection("jdbc:mysql://10.121.46.34:3306/sciencebook", "root", "anasriad123");
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM Questions")){
             while (resultSet.next()){
                 TotalPoints+= resultSet.getInt("Points");
             }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public String grabQuestions(int key) {
        String question = null;
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://192.168.1.108:3306/sciencebook", "root", "anasriad123");
             PreparedStatement QuestionQuest = connection.prepareStatement("SELECT Quests\n" +
                     "FROM Questions\n" +
                     "WHERE Entry=?")){
            QuestionQuest.setInt(1, key);
            ResultSet resultSet = QuestionQuest.executeQuery();
            if (resultSet.next()){
                question = resultSet.getString("Quests");
            }
            resultSet.close();
        } catch (Exception e) {
            question = e.getMessage();
        }
        return question;
    }
    public int QuantifyQuestions() {
        int i = 0;
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://192.168.1.108:3306/sciencebook", "root", "anasriad123");
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM Questions")) {
            while (resultSet.next()) {
                i++;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        getTotalPoints();
        return i;
    }
    public String checkAnswer(String answer, int key){
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://192.168.1.108:3306/sciencebook", "root", "anasriad123");
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT Answers\n" +
                     "FROM Questions\n" +
                     "WHERE Entry=?"))
             {
            preparedStatement.setInt(1, key);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.getString("Answers").equalsIgnoreCase(answer)){
                resultSet.close();
                TotalPoints+= Integer.parseInt(resultSet.getString("Points"));
                return resultSet.getString("Points");
            }
            else {
                resultSet.close();
                return "0";
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
}
