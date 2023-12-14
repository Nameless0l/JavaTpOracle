import java.sql.*;

public class ConnectOracle
{


  public static void main(String args[])
  {


    String drop1 = "DROP TABLE X1";
    String drop2 = "DROP TABLE X2";
    String drop3 = "DROP TABLE X3";

    String request = "create table X1(name VARCHAR(255))" ;
    String request1 = "create table X2 (name VARCHAR(255))";
    String request2 = "create table X3(name VARCHAR(255))" ;
    String procedure1 = "" ;
    // String dropStrigger = "DROP TRIGGER trigger_x3;";
    String Procedure = "CREATE OR REPLACE PROCEDURE copy_to_x3 AS BEGIN   INSERT INTO X3 (name)  VALUES ('je suis mbassi');END;";
    String trigger = "CREATE OR REPLACE TRIGGER trigger_x2   AFTER INSERT ON X1 FOR EACH ROW BEGIN INSERT INTO X2 (name)  VALUES (:NEW.name); sys.dbms_session.sleep(60);copy_to_x3 ;END;";
    String sql = "INSERT INTO X1 VALUES ('je suis la dee qui va etr');";
    // String triggerProcedure = "CREATE OR REPLACE TRIGGER trigger_x3   AFTER INSERT ON X2  BEGIN copy_to_x3 END;";
    String slct = "SELECT * FROM X3 ;";




    


    // String Procedure = "CREATE OR REPLACE PROCEDURE copy_to_x3 AS BEGIN DBMS_LOCK.SLEEP(60); INSERT INTO X3(name) SELECT name FROM X2 ;COMMIT ;END;";
    // String trigger = "CREATE OR REPLACE TRIGGER trigger_x2   AFTER INSERT ON X1 FOR EACH ROW BEGIN INSERT INTO X2   (name)  VALUES (:NEW.name); copy_to_x3 ;END;";


    try
    {

      //étape 1: charger la classe de driver

      //étape 2: créer l'objet de connexion
      Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","root");
       Statement stm =  con.createStatement();
       stm.executeUpdate(drop1);
       stm.executeUpdate(drop2);
       stm.executeUpdate(drop3);
       stm.executeUpdate(request);
       stm.executeUpdate(request1);
       stm.executeUpdate(request2);
      //  stm.executeUpdate(Procedure);
      //  stm.executeUpdate(trigger);
      //  stm.executeUpdate(sql);
       stm.close();
       System.out.println("Le trigger a été crée avec succés!");
      System.out.println("tout va bien");

      con.close();
    }
    catch(Exception e){ 
      System.out.println(e); 
      
    }

     
  }
}

