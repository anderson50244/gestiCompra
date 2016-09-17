/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import conexion.Conexion;
import static java.lang.System.out;
import java.util.ArrayList;
import modelo.Usuario;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.TipoUsuario;
import modelo.Usuario;

/**
 *
 * @author Anderson
 */
public class UsuarioDAO {

    public String sql;

    public void insertar(String id, String nombre, String telefono, String direcc, String email, String pass,int tipoU) {

        Conexion conex = new Conexion();
        conex.conectar();
        sql = "insert into usuario(usu_id,usu_nombre,usu_telefono,usu_direccion,usu_email,usu_contrasena,id_tipo_usu)"
                + "values('" + id + "','" + nombre + "','" + telefono + "','" + direcc + "','" + email + "','" + pass + "',"+tipoU+")";

        int res = (Integer) conex.ejecutarConsulta(1, sql);
        conex.cerrarConexion();
    }

    public int siExist(String id, String email) {

        Conexion conex = new Conexion();
        conex.conectar();
        sql = "select count(usu_id) from usuario where usu_email='" + email + "' and usu_id='" + id + "'";

        int exist = 0;
        try {
            java.sql.ResultSet res = (java.sql.ResultSet) conex.ejecutarConsulta(0, sql);

            res.next();
            exist = res.getInt(1);
            return exist;

        } catch (Exception sqlE) {
            return exist;
        }

    }

    public String datosUsuario(String id) {

        Conexion conex = new Conexion();
        conex.conectar();
        sql = "select usu_id,usu_nombre,usu_telefono,usu_direccion,usu_email,usu_contrasena,descripcion_tiu,id_tipo_usu from usuario "
                + "inner join tipo_usuario on id_tiu =id_tipo_usu where usu_id ='" + id + "'";

        try {
            java.sql.ResultSet res = (java.sql.ResultSet) conex.ejecutarConsulta(0, sql);
            res.next();
            Usuario usu = new Usuario(res.getString("usu_id"), res.getString("usu_nombre"), res.getString("usu_telefono"), res.getString("usu_direccion"), res.getString("usu_email"), res.getString("usu_contrasena"),Integer.parseInt(res.getString("id_tipo_usu")));

            String cadena = usu.getNombre() + "," + usu.getTelefono() + "," + usu.getDireccion() + "," + usu.getEmail()+","+res.getString("descripcion_tiu")+","+res.getString(8);

            res.close();
            conex.cerrarConexion();
            return cadena;

        } catch (Exception e) {
            return "";
        }

    }

    public void modificar(String id, String nombre, String telefono, String direcc, String email,int tipoU) {

        Conexion conex = new Conexion();
        conex.conectar();

        sql = "update usuario set usu_nombre='" + nombre + "',usu_telefono='" + telefono + "',usu_direccion='" + direcc + "',usu_email='" + email + "',id_tipo_usu="+tipoU+" where usu_id='" + id + "'";
        
        int res = (Integer) conex.ejecutarConsulta(1, sql);
        conex.cerrarConexion();

    }

    public ArrayList<TipoUsuario> carga_tipoUsu() {

        Conexion conex = new Conexion();
        conex.conectar();
        ArrayList<TipoUsuario> tipoUs = new ArrayList<TipoUsuario>();
        TipoUsuario TipoUsu = new TipoUsuario();
        sql = "select id_tiu,descripcion_tiu from tipo_usuario";
        java.sql.ResultSet res = (java.sql.ResultSet) conex.ejecutarConsulta(0, sql);

        try {
           int i=0;
            while (res.next()) {

                TipoUsuario tiu = new TipoUsuario(res.getString("descripcion_tiu"), Integer.parseInt(res.getString("id_tiu")));

                TipoUsu.setId(Integer.parseInt(res.getString("id_tiu")));
                TipoUsu.setDescripcion(res.getString("descripcion_tiu"));
                
                tipoUs.add(i, tiu);
                i++;
            }
             res.close();
            conex.cerrarConexion();
        }catch(SQLException e){
        
            e.getStackTrace();
        } 
     
        return  tipoUs;
    }
    
    public ArrayList<Usuario> listaUsuarios(){
    
        Conexion conex = new Conexion();
        conex.conectar();
        ArrayList<Usuario> lista = new ArrayList<Usuario>();
        
        sql = "select usu_id,usu_nombre,usu_telefono,usu_direccion,usu_email,usu_contrasena,descripcion_tiu,id_tipo_usu from usuario "
                + "inner join tipo_usuario on id_tiu =id_tipo_usu";
         java.sql.ResultSet res = (java.sql.ResultSet) conex.ejecutarConsulta(0, sql);
        try {
           
             int i=0;
           
            while(res.next()){
                Usuario usua = new Usuario();
                usua.setId(res.getString("usu_id"));
                usua.setNombre(res.getString("usu_nombre"));
                usua.setTelefono(res.getString("usu_telefono"));
                usua.setDireccion(res.getString("usu_direccion"));
                usua.setEmail(res.getString("usu_email"));
                usua.setContrasena(res.getString("usu_contrasena"));
                usua.setTipoUsu(Integer.parseInt(res.getString("id_tipo_usu")));
                usua.setDescripcion(res.getString("descripcion_tiu"));
                lista.add(i,usua);

                i++;
            
            }
            
            res.close();
            conex.cerrarConexion();
        } catch (SQLException e) {
            e.getStackTrace();
        }
        return lista;
    }
    
    public void eliminarUsu(String id){
        
        Conexion conex = new Conexion();
        conex.conectar();
        
        sql = "delete from usuario where usu_id='"+id+"'";
       
       int res = (Integer) conex.ejecutarConsulta(1, sql);
        conex.cerrarConexion();
    }

    //@Override
    //public String eliminar(){
    //return "";
    //}
    
}
