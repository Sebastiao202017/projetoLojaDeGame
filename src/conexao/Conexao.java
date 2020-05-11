
package conexao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    static String status = "Conexao com banco de dados realizada com sucesso!";
    public static Connection conectar(){
     Connection con = null;
        try{
           Class.forName("com.mysql.jdbc.Driver");
           String url = "jdbc:mysql://localhost/empresa_games";
           con = DriverManager.getConnection(url,"root","");
           System.out.println(status);
        }catch(ClassNotFoundException | SQLException e){
            System.out.println(e.getMessage());
        }
        return con;
    }
}

