/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package wonderworld.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import wonderworld.simplegame.QuizFormation;

/**
 *
 * @author kanel
 */
public class DatabaseConnector {
    private static PreparedStatement statemt;
    private static ResultSet resultst;
    private static Statement stmt;
//    private Connection con;
    private static String url;
    private static String user;
    private static String password;
    
    //this function creates the connection between our program and the database and returns the connection
    private static Connection createConnection() throws SQLException {
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DatabaseConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;    
    }
    //this function sets the values required to establish the connection to the database
    public  void connectToDatabase(String url, String user, String password){
        DatabaseConnector.url        = url;
        DatabaseConnector.password   = password;
        DatabaseConnector.user       = user;    
    }
    
    public boolean checkAccount(){
        boolean check = false;
        return check;
    }
    //this function looks into the login_detail database and if the provided information manch then returns the true
    public boolean checkLoginDetail(String username, String password){
        
        String query = "select * from login_detail where user_name=? and password =?";
        boolean checking = false;
        try {
            statemt = createConnection().prepareStatement(query); 
            statemt.setString(1, username);
            statemt.setString(2, password);
            resultst = statemt.executeQuery();
            if(resultst.next()){
                checking = true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
        return checking;        
    }
    
    public boolean usernameExists(String username){
        boolean exists = false;
        String checkIfUsernameExists = "select * from login_detail where user_name=?";
        try {
 
            statemt = createConnection().prepareStatement(checkIfUsernameExists);
            statemt.setString(1,username);
            resultst = statemt.executeQuery();
            if(resultst.next()){
                exists = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
        return exists;    
    }
    //now i am going to make the function to put the values from register form to the database.
    
    public void registerAccount(String username,String name, String address,String phone,String email, String password){
        String query = "insert into login_detail values(?,?)";
        String put = "insert into user_detail values(?,?,?,?,?)";
        
        try{
            statemt = createConnection().prepareStatement(put);
            statemt.setString(1, username);
            statemt.setString(2,name);
            statemt.setString(3,address);
            statemt.setString(4,phone);
            statemt.setString(5,email);
            statemt.executeUpdate();
            statemt =  createConnection().prepareStatement(query);
            statemt.setString(1,username);
            statemt.setString(2, password);
            statemt.executeUpdate();                    
            JOptionPane.showMessageDialog(null, "Successfully Registered your account.");   

        }catch(SQLException e){
            e.printStackTrace();
        }
    
    }
    public void getQuizData(String level,int id){
        String query = "select * from  "+level+" where id=?";
        try { 
            statemt =  createConnection().prepareStatement(query);           
            statemt.setInt(1, id);
            resultst = statemt.executeQuery();
            if(resultst.next()){
                QuizFormation.setQuestion(resultst.getString("question"));
                QuizFormation.setOption1(resultst.getString("option1"));
                QuizFormation.setOption2(resultst.getString("option2"));
                QuizFormation.setOption3(resultst.getString("option3"));
                QuizFormation.setOption4(resultst.getString("option4"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public static ArrayList<String> checkAnswer(){
        ArrayList<String> correctAnswers = new ArrayList<>();
        try {
            String query = "select * from correct_answers";
            stmt =  (Statement) createConnection().createStatement();
            resultst = stmt.executeQuery(query);
            while(resultst.next()){
                correctAnswers.add(resultst.getString("correct_answers"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
        return correctAnswers;
    }
    
    
}
