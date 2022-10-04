
package connection;
import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    Connection connection;
    static String bd = "railway";
    static String port = "6351";
    static String login = "root";
    static String password = "J5eFLUs6KTF8GUmgnAP5";
    static String ip = "containers-us-west-63.railway.app";

    public DBConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://"+DBConnection.ip + ":"+ DBConnection.port + "/"+DBConnection.bd;
            connection = DriverManager.getConnection(url, DBConnection.login, this.password);
            System.out.println("Conexión establecida");
        } catch (Exception ex) {
            System.out.println("Error en la conexión"+ex);
        }
    }
    public Connection getConnection(){
        return connection;
    }
    
    public void desconectar(){
        connection = null;
    }
    
    
}
