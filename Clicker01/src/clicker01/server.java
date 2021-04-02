/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clicker01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Vues
 */
public class server {
    static String database="jdbc:postgresql://localhost:5432/clicker";
    static String username="postgres";
    static String password="admin";
    static Connection c;
    static int s;
    
        public static Connection connect() throws ClassNotFoundException{
            
            try{
                Class.forName("org.postgresql.Driver");
                c = DriverManager.getConnection(database,username,password);
                System.out.println("Connected to database");
                return c;
            }catch(SQLException e){
                System.out.print("Cannot connect to database, error:"+e+"\n");
            }
        return null;
        }
        
        public static Connection getScore() throws SQLException{
            String sql ="SELECT * FROM bestclicker ORDER BY score DESC LIMIT 3";
            PreparedStatement pStatement = c.prepareStatement(sql);
            ResultSet rs = null;
            
            while(rs.next()){
                
            }
            
            pStatement.close();
            return null;
        }
        
        public static Connection insertScore(String name, String score) throws SQLException{
            s = Integer.parseInt(score);
            String sql ="INSERT INTO bestclicker(name, score) VALUES(?, ?)";
            PreparedStatement pStatement = c.prepareStatement(sql);
            pStatement.setString(1, name);
            pStatement.setInt(2, s);
            System.out.println("Infomation added to database");
            pStatement.executeUpdate();
            pStatement.close();
            return null;
        }
        
        
}
