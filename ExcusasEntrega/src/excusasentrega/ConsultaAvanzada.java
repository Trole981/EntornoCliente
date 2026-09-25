/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package excusasentrega;

import java.sql.*;
/**
 *
 * @author dam1
 */
public class ConsultaAvanzada {
     public static void main(String[] args) {
        // TODO code application logic here
        Connection connection = null;
        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ejercicio1", "root", "JBESSJ");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);
            
            ResultSet rs = statement.executeQuery("SELECT * FROM excusa_entrega WHERE (nivel_drama>8) AND (credibilidad<3) AND (dias_retraso BETWEEN 2 AND 5) AND (excusa LIKE'%perro%') ORDER BY dias_retraso desc");
            while (rs.next()) { // Leer el ResultSet
                System.out.println("nobre = " + rs.getString("alumno"));
                System.out.println("excusa = " + rs.getString("excusa"));
                System.out.println("Dias de retraso = " + rs.getInt("dias_retraso"));
                System.out.println("nivel_drama = " + rs.getInt("nivel_drama"));
            }
        }catch(SQLException e){
            System.err.println(e.getMessage());
        }finally {
            try {
                if (connection != null) connection.close();
            } catch (SQLException e) {
                System.err.println(e.getMessage()); // Error al cerrar la conexión
            }
        }
     }
}
