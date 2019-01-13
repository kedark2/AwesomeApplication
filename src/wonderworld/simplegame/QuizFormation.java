/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package wonderworld.simplegame;

import wonderworld.database.DatabaseConnector;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

/**
 *
 * @author kanel
 */
public class QuizFormation {
    private  static String question;
    private  static String option1, option2,option3,option4;
    private  int id;
    private final  DatabaseConnector db ;
    private  String level;

    public QuizFormation(){
        db = new DatabaseConnector();
    }
    public  static void setQuestion(String ques){
        QuizFormation.question = ques;
    }

    public static void setOption1(String option1) {
        QuizFormation.option1 = option1;
    }

    public static void setOption2(String option2) {
        QuizFormation.option2 = option2;
    }

    public static void setOption3(String option3) {
        QuizFormation.option3 = option3;
    }

    public static void setOption4(String option4) {
        QuizFormation.option4 = option4;
    }
    //creating the connection with database. provides url username and password to create connection.
    private  void createConnection(){
        db.connectToDatabase("jdbc:mysql://localhost:8889/quiz_game", "javauser", "javauser");
    }
    //getting the quiz data
    private void gettingTheQuizData(){
        createConnection();
        db.getQuizData(level,id);
    }
    //setting the questions and options to the jlabel
    public  void getQuestion(int id,JLabel ques, JRadioButton opt1,JRadioButton opt2,JRadioButton opt3,JRadioButton opt4){
        this.id = id;
        gettingTheQuizData();        
        ques.setText(question);
        opt1.setText(option1);
        opt2.setText(option2);
        opt3.setText(option3);
        opt4.setText(option4);    
    }
    
    public ArrayList<Integer> randomNumber(){
        ArrayList<Integer> magicNums = new ArrayList<>(); 
        for( int i = 1 ; i< 10; i++) 
            magicNums.add( new Integer( i ) ); 
       return  magicNums;
    }
    
    public void setLevel(String level){
        this.level = level;
    }
    
    public boolean checkAnswers(String answer){
        boolean correct = false;
        ArrayList<String> correctAnswers = DatabaseConnector.checkAnswer();
       for(String ans:correctAnswers){
           if(ans.equals(answer)){
               correct=true;
           }       
       }
    return correct;
    }
            
}
