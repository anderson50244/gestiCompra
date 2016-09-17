/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Anderson
 */
public class TipoUsuario {
    
    
    private String descripcion;
    private int idT;
    
    public TipoUsuario(){
        
    }
    
    public TipoUsuario(String descripcion,int idT){
    
        this.descripcion = descripcion;
        this.idT=idT;
        
    }
    public int getIdT() {
        return idT;
    }

    public void setId(int id) {
        this.idT = idT;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
    
}
