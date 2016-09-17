package conexion;
import DAO.UsuarioDAO;
import java.sql.*;

public class Conexion {

    private String user;
    private String password;
    private String db;
    private String servidor;
    private String url;
    Connection conn;
    private Statement st;
    private ResultSet rs;
    final static int SELECT = 1;
    final static int UPDATE = 2;
    static String error = "";

     public Conexion() {
       
    }
    public Conexion(String usuario, String pass, String servidor, String db) {
        this.user = usuario;
        this.servidor = servidor;
        this.password = pass;
        this.db = db;
        this.url = "jdbc:mysql://" + this.servidor + "/" + this.db;
    }

   

    public String conectar() {
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/compras","root", "root");
            Conexion.error = "Conexion base de datos. Exitosa";
        } catch (Exception e) {
            Conexion.error = "Fallo en la conexiòn " + e.getMessage();
        }
       
        return Conexion.error;
    }

    private java.sql.ResultSet ejecutarSelect(String sql) {
        try {
            this.st = conn.createStatement();
            this.rs = this.st.executeQuery(sql);
        } catch (SQLException sqlE) {
            this.rs = null;
            Conexion.error = "Error en la consulta " + sqlE.getMessage();
        }finally{
            //cerrarStatement();
        }
        return this.rs;
    }
    
    private void cerrarStatement(){
        try{
            if (st != null)
                st.close();
        }catch(SQLException sqlE){
            Conexion.error = "Error al cerrar el statement " + sqlE.getMessage();
        }
    }
   
    private int ejecutarUpdate(String sql){
        int res = -1;
        try{
            st = conn.createStatement();
            res = st.executeUpdate(sql);
        }catch(SQLException sqlE){
            Conexion.error = "Error al ejecutar la consulta: " + sql + "\n " + sqlE.getMessage();
        }finally{
            cerrarStatement();
        }
        return res;
    }

    public Object ejecutarConsulta(int tipo, String sql) {
        Object res = null;
        switch (tipo) {
            case 0:
                res = ejecutarSelect(sql);
                break;
            case 1:
                res = ejecutarUpdate(sql);
                break;
        }
        System.out.println(res);
        return res;
    }

    public void cerrarConexion() {
        try {
            if (this.conn != null) {
                this.conn.close();
            }
        } catch (SQLException sqlE) {
            Conexion.error = "Error al cerrar la conexión " + sqlE.getMessage();
        }

    }
    
   
}
