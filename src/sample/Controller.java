package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.*;
import java.util.*;

public class Controller {

   static ArrayList<Container> RetrevingList= new ArrayList<>();

    File file=new File("data.text");



@FXML
 TextField websitetext ;
@FXML
TextField passwordtext ;

       public void add() throws  IOException{

            String x=websitetext.getText();
            String y=passwordtext.getText();

           String s="\n"+x+","+y;

            BufferedWriter bf=new BufferedWriter(new FileWriter(file,true));
            bf.write(s);
            bf.close();
            FileRead();

       }



        @FXML TextArea area;




    private ArrayList<String> Stringlist=new ArrayList<>();


   void Populatinglistview(){

       for (String s:Stringlist
            ) {
           area.appendText(s);
       }

   }









   public  void
   FileRead() throws IOException{





       Container temp=null;

        Scanner in=null;

        try{
            in=new Scanner(file);

            in.useDelimiter(",");

            while(in.hasNextLine()){

                temp=new Container(null,null);

                temp.setWebsite(in.next());

                in.skip(in.delimiter());

                temp.setPassword(in.nextLine());

              RetrevingList.add(temp);
              Stringlist.add(temp.getWebsite()+"    "+ temp.getPassword()+"\n");


            }

            Populatinglistview();


        }
         finally{
                in.close();



        }

    }












    @FXML
    private TextField searchtextfield;

       @FXML
    private TextField searchpass;

        public void search(){


            System.out.println(RetrevingList);



            String s=searchtextfield.getText();
            searchpass.clear();

            for (int i = 0; i <RetrevingList.size(); i++) {

              String p=  RetrevingList.get(i).getWebsite();

              if(s.equals(p)){
                  searchpass.setText(RetrevingList.get(i).getPassword());
                  break;
              }

            }



        }
























    @FXML
    private TextField namefield;
    @FXML
    private TextField passwordfield;
    @FXML
    private Button Login;


    public void onButtonclick() throws IOException {

        String name=namefield.getText().trim();
        String pass=passwordfield.getText().trim();

        String password="1";
         String username="1";

        if(password.equals(pass) && username.equals(name)){



            namefield.clear();
            passwordfield.clear();
            Login.setStyle("-fx-border-color: #008000; ");

            Parent blah = FXMLLoader.load(getClass().getResource("App.fxml"));
            Scene scene = new Scene(blah);
            Stage appStage = new Stage();
            appStage.setTitle("PasswordApp");
            appStage.setScene(scene);

            appStage.show();

            FileRead();




        }else{
            Login.setStyle("-fx-border-color: #ff0000; ");
            namefield.clear();
            passwordfield.clear();

        }
    }


}
