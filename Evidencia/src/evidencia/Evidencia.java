/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package evidencia;

/**
 *
 * @author usuario
 */
import java.sql.*; 
public class Evidencia {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        String usuario = "root";
        String password = "";
        String url = "jdbc:mysql://localhost:3306/citas_manicure";
        Connection conexion;
        Statement statement;
        ResultSet rs;        
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            System.getLogger(Evidencia.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        
        try {
            conexion = DriverManager.getConnection(url,usuario,password);
            statement = conexion.createStatement();
            statement.executeUpdate("INSERT INTO CLIENTES (ID_CLIENTE,NOMBRE,TELEFONO,CORREO) VALUES('2457','Nelly','32323232','FFF@FFF')");
            rs = statement.executeQuery("SELECT * FROM CLIENTES");
            rs.next();
            do{
                System.out.println(rs.getInt("id_cliente")+" : "+rs.getString("nombre"));
            }while(rs.next());
            //****Inicio módulo actualizar
            statement.executeUpdate("UPDATE CLIENTES SET NOMBRE = 'CLARA TOVAR' WHERE ID_CLIENTE = '4567'");
            System.out.println("--> Módulo Actualizar : El registro ha sido modificado.");
        
        
        } catch (SQLException ex) {
            System.getLogger(Evidencia.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }
    
}
