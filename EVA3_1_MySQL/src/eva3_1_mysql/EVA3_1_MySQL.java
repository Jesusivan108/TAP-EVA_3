/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package eva3_1_mysql;

import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.PreparedStatement;

/**
 *
 * @author Jesús
 */
public class EVA3_1_MySQL {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Connection connection = null;
       
        try {
            // TODO code application logic here
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EVA3_1_MySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
            //Vamos a crear la conexión:
            String url = "jdbc:mysql://Localhost:3306/sakila";
        try {
            connection = DriverManager.getConnection(url, "root", "gamj700502-9z8");
        } catch (SQLException ex) {
            Logger.getLogger(EVA3_1_MySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
  
        
        try{
           // Statement statement = connection.createStatement();
           // ResultSet resu;
            //resu = statement.executeQuery("select actor_id, first_name, last_name " + "from actor limit 10");
                String consulta = "Select actor_id, first_name, last_name " + "from actor where actor_id =?;";
                 
               PreparedStatement pState = connection.prepareStatement(consulta);
               pState.setInt(1, 189);
               ResultSet resu;
               resu = pState.executeQuery();
                       
                        int actorId;
            String firstName, lastName;
            while(resu.next()){
                actorId = resu.getInt("actor_id");
                        firstName = resu.getString("first_name");
                        lastName = resu.getString("last_name");
                        System.out.println("Actor: " + actorId);
                        System.out.println("Nombre: " + firstName);
                        System.out.println("Apellido: " + lastName);
            }
            /**String insertar = "insert into actor(first_name,last_name) " + "values( ?,?);";
            PreparedStatement pSinsert = connection.prepareStatement(insertar);
            pSinsert.setString(1, "PEDRO");
            pSinsert.setString(2, "PARAMO");
            pSinsert.execute();*/
            
                      /*String update = "update actor " + " set first_name = ?, last_name = ? " + "where actor_id = ?;";
            PreparedStatement pSUpdate = connection.prepareStatement(update);
            pSUpdate.setString(1, "JUANELIO");
            pSUpdate.setString(2, "PARAMO");
            pSUpdate.setInt(3, 158);
            pSUpdate.execute();*/
            
            
                      String delete = "delete from actor " + "where actor_id = ?;";
            PreparedStatement pSDelete = connection.prepareStatement(delete);
            pSDelete.setInt(1, 202);
            pSDelete.execute();
            
        }catch(SQLException ex){
          ex.printStackTrace();
        }
    }
    
}  
