/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication;

import java.sql.*;

public class JavaApplication
{
  public static void main(String[] args)
  {
    try
    {
        // initialise database connection
        String myDriver = "com.mysql.cj.jdbc.Driver";
        String myUrl = "jdbc:mysql://localhost:3306/demo";
      
        Class.forName(myDriver);
        Connection conn = DriverManager.getConnection(myUrl, "tomtom", "tomtom");
      
        String query = "SELECT * FROM insects LEFT OUTER JOIN flying ON insects.InsectID = flying.InsectsID UNION SELECT * FROM insects RIGHT OUTER JOIN flying ON insects.InsectID = flying.InsectsID WHERE insects.InsectID IS NULL;";

        try (Statement st = conn.createStatement()) 
        {
            ResultSet rs = st.executeQuery(query);
            
            while (rs.next())
            {
                int idInsect = rs.getInt("InsectID");
                String insectName = rs.getString("InsectName");
                int species = rs.getInt("Species");
                int idFlying = rs.getInt("FlyingID");
                int idInsectFlying = rs.getInt("InsectsID");
                String flyingName = rs.getString("FlyingName");
                int wings = rs.getInt("Wings");
             
                System.out.format("%s, %s, %s, %s, %s, %s, %s\n", idInsect, insectName, species, idFlying, idInsectFlying, flyingName, wings);
            } 
        }
    }
    catch (ClassNotFoundException | SQLException e)
    {
      System.err.println("SQL exception!");
      System.err.println(e.getMessage());
    }
  }

    static String main(int i) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

