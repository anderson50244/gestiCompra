/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;


import conexion.Conexion;
import static java.lang.System.out;
import java.util.ArrayList;
import modelo.TipoUsuario;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
/**
 *
 * @author Anderson
 */
public class TipoUsuDAO {
    
     public void insertar(String descripcion,int numero){
        
        Conexion conex= new Conexion();
        conex.conectar();
        String sql="insert into tipo_usuario(id_tiu,descripcion_tiu)values("+numero+",'"+descripcion+"')";
        int res = (Integer) conex.ejecutarConsulta(1, sql);
        conex.cerrarConexion();
    }
     
     public String  nextTipoUsu(){
         String cadena="";
         Conexion conex = new Conexion();
         conex.conectar();
         String sql="select max(id_tiu),descripcion_tiu from tipo_usuario";
       
         try {
             
             java.sql.ResultSet res = (java.sql.ResultSet) conex.ejecutarConsulta(0, sql);
            
             
             while(res.next()){
                 
                 TipoUsuario tiu = new TipoUsuario(res.getString("descripcion_tiu"),res.getInt(1));
                 System.out.println(tiu.getIdT());
                 int cod=res.getInt(1)+1;
                
                 cadena =String.valueOf(cod);
             }
             res.close();
             conex.cerrarConexion();
             return cadena;
             
             
         } catch (java.sql.SQLException sqlE) {
             return ("Error en el resultado" + sqlE.getMessage()); 
         }
         
             
         
     }
    
}
