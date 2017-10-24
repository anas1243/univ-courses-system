
package testdb;



import java.sql.*;
import java.util.Arrays;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Background;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class Testdb extends Application {
       int id; 
       int id1;
       int id2;
       int codes[];
       int allcodes[] ;
       int r;
       
       String COURSE_NAME_I ; 
        int COURSE_CODE_I ;
    Connection connection;
    PreparedStatement pst ;
    ResultSet rs;
    
    public static void loadDriver(){
        try{
        Class.forName("com.mysql.jdbc.Driver");
        }catch(ClassNotFoundException ex){ 
            System.out.println("DataBasedriver can not be loaded");
        } 
        System.out.println("DataBasedriver loaded  sucessfully");
    }

    

    public static void main(String[] args) throws SQLException {
       
        
        
        
        
        
        launch(args);
        
    }

    

    
    public void start(Stage primaryStage) throws Exception {
         
         
        loadDriver();
         
        
        
       //primaryStage.initStyle(StageStyle.TRANSPARENT);
       
       //main scene
        Group root = new Group();
        Scene scene1 = new Scene(root,320,250,Color.rgb(0, 0, 0, 0.55));
        
        Rectangle background = new Rectangle(320,250);
        
        //studens scene
        
        BorderPane bp1 = new BorderPane();
        GridPane gp1  = new GridPane();
        Scene scene2 = new Scene(bp1,1000,400,Color.rgb(0, 0, 0, 0.55));
        bp1.setStyle("-fx-background-color:rgb(0,0,0,0.55)");
        
        VBox hbox1 = new VBox(7.5);
        
        BorderPane.setMargin(hbox1,new Insets(0,0,0,20));
        
        
        //instractor's scene
        
        BorderPane bp2 = new BorderPane();
        
        GridPane gp2  = new GridPane();
        Scene scene3 = new Scene(bp2,900,300,Color.rgb(0, 0, 0, 0.55));
        VBox hbox2 = new VBox(5);
        bp2.setStyle("-fx-background-color:rgb(0,0,0,0.55)");
        
        BorderPane.setMargin(hbox2,new Insets(0,0,0,20));
        
        
       
        Color foreground = Color.rgb(225,225,225,0.9);
        background.setX(0);
        background.setY(0);
        background.setArcHeight(15);
        background.setArcHeight(15);
        background.setFill(Color.rgb(0,0,0,0.55));
        background.setStroke(foreground);
        background.setWidth(1.5);
        
        VBox vbox = new VBox(5);
        vbox.setPadding(new Insets(10,0,0,10));
        
         Label label = new Label("CONNECTIVITY");
         Label label2 = new Label("");
         
        label.setTextFill(Color.WHITESMOKE);
        label.setFont(new Font("SanSerif",20));
        
        label2.setTextFill(Color.WHITESMOKE);
        label2.setFont(new Font("SanSerif",20));
        
        
        TextField username = new TextField();
        username.setFont(Font.font("SanSerif",20));
        username.setPromptText("username");
        
        PasswordField password = new PasswordField();
        password.setFont(new Font("SanSerif",20));
        password.setPromptText("Password");

        Button btn = new Button("Login");
        btn.setFont(Font.font("SanSerif",15));
        Button btn1 = new Button("Connection");
        btn.setFont(Font.font("SanSerif",15));
        GridPane pane = new GridPane(); 
        pane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5)); 
        pane.setHgap(5.5); 
        pane.setVgap(5.5);
        
        ToggleGroup type = new ToggleGroup();
        
        RadioButton type1 = new RadioButton("Student");
        RadioButton type2 = new RadioButton("Instructor");
        type1.setToggleGroup(type);
        type2.setToggleGroup(type);
// Place nodes in the pane 
        pane.add(label, 0, 0); 
        pane.add(label2, 0, 1);
        pane.add(username, 0, 2); 
        pane.add(password, 0, 3); 
        pane.add(type1, 0, 4); 
        pane.add(type2, 0, 4); 
        pane.add(btn1, 0, 5); 
        pane.add(btn, 0, 5); 

        GridPane.setHalignment(btn, HPos.LEFT);
        GridPane.setHalignment(btn1, HPos.RIGHT);
        GridPane.setHalignment(type1, HPos.LEFT);
        GridPane.setHalignment(type2, HPos.CENTER);
        root.getChildren().addAll(background,pane);
        primaryStage.setScene(scene1); 
        
        
        
        

        btn1.setOnAction(e ->{
                try{
                    connection = (Connection)DriverManager.getConnection("jdbc:mysql://localhost/ComputerScience","root", "");
                    label.setTextFill(Color.YELLOW);
                    label.setText("connected !");
                }catch(SQLException sE){
                    label.setTextFill(Color.RED);
             label.setText("connection problem !!");
             
        } 
        
        }
        );
        
        btn.setOnAction(e ->{
                try{
                     String query ="Select * from users where userName=? and password=? ";
                     pst = connection.prepareStatement(query);
                     pst.setString(1, username.getText());
                     pst.setString(2, password.getText());
                     rs=pst.executeQuery();
                     boolean x =rs.next();
                     id = rs.getInt("ID");
                     
                     if(x && type1.isSelected() ){
                         if(id >=100 && id < 200 ) {
                         
                         primaryStage.setScene(scene2);
                         
                         }else if(id >=200 && id < 300 ){
                             
                            label2.setText("select your type carefully !!");
                            label2.setTextFill(Color.RED);
                         
                         }
                     
                        }
                     else if(x && type2.isSelected()){
                         
                         if(id >=200 && id < 300 ) {
                         
                         primaryStage.setScene(scene3);
                         
                         }else if(id >=100 && id < 200 ){
                             
                            label2.setText("select your type carefully !!");
                            label2.setTextFill(Color.RED);
                         }
                         
                         
                     }
                        pst.close();
                         rs.close();
                    
                }catch(SQLException loginEX){
                    
             label.setText("Login Failed !!");
             label.setTextFill(Color.RED);
                                           
                }
             }
        ); 
        
        
 //students page
 
        gp1.setPadding(new Insets(20, 20, 20, 20)); 
        gp1.setHgap(5.5); 
        gp1.setVgap(5.5);
// Place nodes in the pane 
           Label lab1 = new Label("FUll Name:-");
           lab1.setTextFill(Color.WHITESMOKE);
           lab1.setFont(new Font("SanSerif",20));
           
        gp1.add(lab1, 0, 0); 
        TextField name_s = new TextField();
        gp1.add(name_s, 1, 0);

         Label lab2 =  new Label("ID:-");
         lab2.setTextFill(Color.WHITESMOKE);
         lab2.setFont(new Font("SanSerif",20));
        gp1.add(lab2, 0, 1);
        TextField ID_s = new TextField();
        gp1.add(ID_s, 1, 1);
            
        
        Label lab3 = new Label("Grade:-");
        lab3.setTextFill(Color.WHITESMOKE);
        lab3.setFont(new Font("SanSerif",20));
        gp1.add(lab3, 0, 2);
        TextField grade_s = new TextField();
        gp1.add(grade_s, 1, 2);
        
        
        Label lab4 = new Label("Enrolled Courses:-");
        lab4.setTextFill(Color.WHITESMOKE);
        lab4.setFont(new Font("SanSerif",20));
        gp1.add(lab4, 0, 3); 
        Label courses_s = new Label();
        gp1.add(courses_s, 1, 3);
        Button show_info= new Button("SHOW INFO"); 
        gp1.add(show_info, 1, 4);

        gp1.setHalignment(show_info, HPos.RIGHT);       
        
        TextField course_code = new TextField();
        Button enroll = new Button("ENROLL");
        Button all_courses_B = new Button("SHOW ALL COURSES");
        Label all_courses_T = new Label();
        
        Label lab5 = new Label("ENROLL IN A COURSE :- ");
        lab5.setTextFill(Color.WHITE);
        lab5.setFont(new Font("SanSerif",25));
        
        Label lab6 = new Label("all department courses");
        lab6.setTextFill(Color.WHITESMOKE);
        lab6.setFont(new Font("SanSerif",20));
        
        Label lab7 = new Label("Enter course code");
        lab7.setTextFill(Color.WHITESMOKE);
        lab7.setFont(new Font("SanSerif",20));
        
        Label label8 = new Label("");
        label8.setTextFill(Color.WHITESMOKE);
       label8.setFont(new Font("SanSerif",20));
        
        
        
        
        
        
        
        
        
        hbox1.getChildren().addAll(lab5,lab6,all_courses_T,all_courses_B,lab7,course_code,enroll,label8);
        
        bp1.setLeft(hbox1);
        bp1.setCenter(gp1);
        
        
        //handel student page
        
        
        
        //logout handle
        
        Button logout_s= new Button("logout"); 
        gp1.add(logout_s, 1, 5);

        gp1.setHalignment(logout_s, HPos.RIGHT);     
        
        
        logout_s.setOnAction(logout_ss ->{
        
                primaryStage.setScene(scene1);
        
            });
    
        //show all courses handle
        
        all_courses_B.setOnAction(e->{
            try{
            String query2 = "select c_ID from courses";
         pst = connection.prepareStatement(query2);
                     
                     rs=pst.executeQuery();
                     
                     allcodes = new int[13];
                      
                     int j=0;
                     while(rs.next()){
                         
                         allcodes[j] = rs.getInt("c_ID");
                            j++;
                     }
                     
                      for(int code:allcodes){
                          if(code!=0)
                            all_courses_T.setText(all_courses_T.getText()+"-"+code);
                      }
                      
                      all_courses_T.setFont(Font.font("SanSerif",20));
                      all_courses_T.setTextFill(Color.WHITESMOKE);
                      
            }catch(SQLException e3){
            
            
                }
        });
        show_info.setOnAction(e->{
        try{
          String query1 = "select * from students where usr_ID1 = ?";
          pst = connection.prepareStatement(query1);
                     pst.setInt(1,id);
                     rs=pst.executeQuery();
                     rs.next();
                
                 
         id1 = rs.getInt("ID_1");
        ID_s.setFont(Font.font("SanSerif",20));
        ID_s.setPromptText(Integer.toString(id));
        
        name_s.setFont(Font.font("SanSerif",20));
        name_s.setPromptText(rs.getString("name")+" " +rs.getString("lastname"));
        
        grade_s.setFont(Font.font("SanSerif",20));
        grade_s.setPromptText(rs.getString("grade"));
        
        
        String query11 = "select * from studentscourses where ID_11 = ?";
                     
          pst = connection.prepareStatement(query11);
                     pst.setInt(1,id1);
                     rs=pst.executeQuery();
                     
                     codes = new int[10];
                     int i=0;
                     while(rs.next()){
                         
                         
                         codes[i] = rs.getInt("C_ID1");
                         
                            i++;
                     }
                     /*
                     i=0;
                     String codess="";
                     while(codes[i] != 0){
                     
                     codess.concat(Integer.toString(codes[i]));
                     i++;
                     }*/
                     //String codess = codes.toString();
                     
                      courses_s.setFont(Font.font("SanSerif",20));
                      courses_s.setTextFill(Color.WHITESMOKE);
                     // courses_s.setText(Arrays.toString(codes));
                      for(int code:codes){
                          if(code!=0)
                            courses_s.setText(courses_s.getText()+"-"+code);
                      }
                      
        }catch(SQLException e1){
        
            System.out.println("error !!!");
        
            }
        
        });
        
        //enroll handle
        
        enroll.setOnAction(enrllHandle ->{
            try{
                if(course_code.getLength()== 0){
                
                label8.setText("type course code first !!!");
                label8.setTextFill(Color.RED);
                
                }else{
                
           int input_code_s = Integer.parseInt(course_code.getText());
           
           
           String query15 ="Select * from studentscourses where ID_11=? and C_ID1=?";
                     pst = connection.prepareStatement(query15);
                     
                     pst.setInt(1,id1);
                     pst.setInt(2,input_code_s);
                     rs=pst.executeQuery();
                     
                     boolean flag = rs.next();
                     if(flag){
                         
                         label8.setText("Want to take it agian !!!");
                         label8.setTextFill(Color.YELLOW);
                        }else{
                                
     if(input_code_s ==303 || input_code_s ==305 || input_code_s ==301||input_code_s ==302||input_code_s ==308||input_code_s ==300)
            {    
                label8.setTextFill(Color.BLUE);
                         label8.setFont(new Font("SanSerif",20));
                         label8.setText("registration complete\nbest wishes");
                         
                         //and enroll in this course!
                         
                         
                            
                       String query_ins = "INSERT INTO studentscourses (ID_11, C_ID1 ,gpa ) VALUES ( ? , ? , ? )";
                       
                       pst = connection.prepareStatement(query_ins);
                     
                     pst.setInt(1,id1);
                     pst.setInt(2,input_code_s);
                     pst.setString(3,"H");
                      pst.execute();
                      
                           
                
            }
     else if(input_code_s ==304 || input_code_s ==306 || input_code_s ==307||input_code_s ==309){
            
                if(input_code_s ==304){
                    r = 0;
                for(int u=0;u<=(codes.length -1);u++){
                        
                    if(codes[u]==302){
                        r=1;
                    }          
            }
                if(r==1){
                label8.setTextFill(Color.BLUE);
                 label8.setText("registration complete\nbest wishes");
                 
                 
                  String query_ins1 = "INSERT INTO studentscourses (ID_11, C_ID1 ,gpa ) VALUES ( ? , ? , ? )";
                       
                       pst = connection.prepareStatement(query_ins1);
                     
                     pst.setInt(1,id1);
                     pst.setInt(2,input_code_s);
                     pst.setString(3,"H");
                      pst.execute();
                 
                }else{
                    label8.setTextFill(Color.RED);
                    label8.setText("you must take discrete 302");
                }
                    
                }
                else if(input_code_s ==306){
                            
                 r = 0;
                for(int u=0;u<=(codes.length -1);u++){
                        
                    if(codes[u]==301){
                        r=1;
                    }          
            }
                if(r==1){
                label8.setTextFill(Color.BLUE);
                 label8.setText("registration complete\nbest wishes");
                 
                 String query_ins2 = "INSERT INTO studentscourses (ID_11, C_ID1 ,gpa ) VALUES ( ? , ? , ? )";
                       
                       pst = connection.prepareStatement(query_ins2);
                     
                     pst.setInt(1,id1);
                     pst.setInt(2,input_code_s);
                     pst.setString(3,"H");
                      pst.execute();
                 
                }else{
                    label8.setTextFill(Color.RED);
                    label8.setText("you must take java 301");
                    
                }
                
                }
                else if(input_code_s ==307){
                
                 r = 0;
                for(int u=0;u<=(codes.length -1);u++){
                        
                    if(codes[u]==305){
                        r=1;
                    }          
            }
                if(r==1){
                label8.setTextFill(Color.BLUE);
                 label8.setText("registration complete\nbest wishes");
                 
                 String query_ins4 = "INSERT INTO studentscourses (ID_11, C_ID1 ,gpa ) VALUES ( ? , ? , ? )";
                       
                       pst = connection.prepareStatement(query_ins4);
                     
                     pst.setInt(1,id1);
                     pst.setInt(2,input_code_s);
                     pst.setString(3,"H");
                      pst.execute();
                 
                }else{
                    label8.setTextFill(Color.RED);
                    label8.setText("you must take OS 305");
                }
                        
                }
                else if(input_code_s ==309){
                
                     r = 0;
                for(int u=0;u<=(codes.length -1);u++){
                        
                    if(codes[u]==308){
                        r=1;
                    }          
            }
                if(r==1){
                label8.setTextFill(Color.BLUE);
                 label8.setText("registration complete\nbest wishes");
                 
                 String query_ins5 = "INSERT INTO studentscourses (ID_11, C_ID1 ,gpa ) VALUES ( ? , ? , ? )";
                       
                       pst = connection.prepareStatement(query_ins5);
                     
                     pst.setInt(1,id1);
                     pst.setInt(2,input_code_s);
                     pst.setString(3,"H");
                      pst.execute();
                 
                }else{
                    label8.setTextFill(Color.RED);
                    label8.setText("you must take ML 308");
                }
                
                }
     }else{
         label8.setTextFill(Color.YELLOW);
            label8.setText("enter a correct code hoss !!");
        }
              
                     }
                }
                     
           
            }catch(SQLException enrollex){
            
            
            System.out.println("query problem or something");
            System.err.println(enrollex);
            
            }
        
        });
        
           //INSTRUCTOR PAGEEEEEEEE
        
        gp2.setPadding(new Insets(20, 20, 20, 20)); 
        gp2.setHgap(5.5); 
        gp2.setVgap(5.5);
// Place nodes in the pane 
        
        Label lab8 = new Label("PERSONAL INFO :-");
        lab8.setTextFill(Color.WHITE);
        lab8.setFont(new Font("SanSerif",25));
        gp2.add(lab8, 0, 0);
        
        
        Label lab9 = new Label("name:");
        lab9.setTextFill(Color.WHITESMOKE);
        lab9.setFont(new Font("SanSerif",20));
        gp2.add(lab9, 0, 1); 
        
        TextField name_i = new TextField();
        gp2.add(name_i, 1, 1);
        
        
          Label lab10 =new Label("id:");
          lab10.setTextFill(Color.WHITESMOKE);
          lab10.setFont(new Font("SanSerif",20));
          
        gp2.add(lab10, 0, 2);
        
        TextField ID_i = new TextField();
        gp2.add(ID_i, 1, 2);
        
        Label lab11 =new Label("courses you teach:");
        lab11.setTextFill(Color.WHITESMOKE);
         lab11.setFont(new Font("SanSerif",20));
         
        gp2.add(lab11, 0, 3); 
        
        Label courses_i = new Label();
        gp2.add(courses_i, 1, 3);
        Button show_info_i= new Button("SHOW INFO"); 
        gp2.add(show_info_i, 1, 4);

        gp2.setHalignment(show_info_i, HPos.RIGHT);
        
        Button logout_i= new Button("logout"); 
        gp2.add(logout_i, 1, 5);

        gp2.setHalignment(show_info_i, HPos.LEFT);     
        
        
        logout_i.setOnAction(logout_ii ->{
        
                primaryStage.setScene(scene1);
        
            });
       
        
        
        
        
        
        
        
        
        
         TextField course_code_i = new TextField();
        course_code_i.setFont(Font.font("SanSerif",20));
        course_code_i.setPromptText("COURSE CODE");
        
        
        
        
        TextField course_name_i = new TextField();
        course_name_i.setFont(Font.font("SanSerif",20));
        course_name_i.setPromptText("COURSE NAME");
        
        
        Button launch = new Button("LAUNCH");
        
        Label lab12 = new Label("LAUNCH A NEW COURSE :- "); 
        lab12.setTextFill(Color.WHITE);
         lab12.setFont(new Font("SanSerif",25));
         
         Label label9 = new Label("");
        
                
        hbox2.getChildren().addAll(lab12,course_name_i,course_code_i,launch,label9);
        
        
        
        show_info_i.setOnAction(eInst->{
        
            try{
            
                String query15 ="Select * from instructors where usr_ID2=?";
                     pst = connection.prepareStatement(query15);
                     pst.setInt(1,id);
                     rs=pst.executeQuery();
                     rs.next();
                     
                     
                     id2 = rs.getInt("ID_2");
                     
                     name_i.setFont(Font.font("SanSerif",20));
                     name_i.setPromptText(rs.getString("name")+" "+rs.getString("lastname"));
                     
                     
                     
                     ID_i.setFont(Font.font("SanSerif",20));
                     ID_i.setPromptText(Integer.toString(id));
                     
                     
                     
                     
                    String query30 = "select * from courses where instructor = ?";
                    pst = connection.prepareStatement(query30);
                     pst.setInt(1,id2);
                     rs=pst.executeQuery();
                     
                     //////////////
                     
                     int codes1[] = new int[10];
                     int k=0;
                     while(rs.next()){
                     
                         codes1[k] = rs.getInt("C_ID");
                            k++;
                     }
                     
                     for(int code:codes1){
                          if(code!=0)
                            courses_i.setText(courses_i.getText()+"-"+code);
                      }
                
                     
                     courses_i.setFont(Font.font("SanSerif",20));
                      courses_i.setTextFill(Color.WHITESMOKE);
                     
            }catch(SQLException fg){
            
                System.out.println("cannot query the dataBase  !!!");
            
            }
               
       });
        
        launch.setOnAction(e ->{
        try{
        String qu = "select c_ID from courses";
         pst = connection.prepareStatement(qu);
                     
                     rs=pst.executeQuery();
                     
                  int   allcodesss[] = new int[13];
                      
                     int j=0;
                     while(rs.next()){
                         
                         allcodesss[j] = rs.getInt("c_ID");
                            j++;
                     }
                
         COURSE_NAME_I = course_name_i.getText();
        // COURSE_CODE_I = Integer.parseInt(course_code_i.getText());
         
         if(COURSE_NAME_I.length()==0 || course_code_i.getText().length() == 0){
             
                label9.setFont(Font.font("SanSerif",20));
                 
                 label8.setTextFill(Color.YELLOW);
                label9.setText("enter code and name carfully");
         }else{
         
         int t=0;
        for(int i = 0;i<13;i++){
            if(allcodesss[i]== Integer.parseInt(course_code_i.getText())){
                t=1;}
                }
                
        if(t==1){
        
               label9.setFont(Font.font("SanSerif",20));
                label9.setTextFill(Color.RED);
                label9.setText("this code is already reserved !!");
            
        
            }else{
        
                label9.setFont(Font.font("SanSerif",20));
                label9.setTextFill(Color.BLUE);
                label9.setText("the course has been published\n we are waiting for the great effort !");
                
                String query_ins10 = "INSERT INTO courses (c_ID, c_name ,instructor ) VALUES ( ? , ? , ? )";
                       
                       pst = connection.prepareStatement(query_ins10);
                     
                     pst.setInt(1,Integer.parseInt(course_code_i.getText()));
                     pst.setString(2,COURSE_NAME_I);
                     pst.setInt(3,id2);
                      pst.execute();
        }
        
         }
        
        }catch(SQLException eii){
                
                System.out.println("erroor bro");
                
                } });
    
    
        bp2.setLeft(hbox2);
        bp2.setCenter(gp2);
        
        
        
      
        
         primaryStage.show();
    }
    
}
