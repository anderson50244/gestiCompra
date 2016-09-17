<%-- 
    Document   : frmTipoUsuario
    Created on : 30/03/2016, 11:04:44 PM
    Author     : Anderson
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" import="DAO.TipoUsuDAO"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Crear tipo de usuario</title>
    </head>
    <body>
        <p>
        <div class="container">
            
            <div class="row-fluid">
                <div class="span8"></div>
                <div class="span4">
                    <form role="form" action="TipoUsuServlet">
                       <%
                        TipoUsuDAO tu = new TipoUsuDAO();
                        
                        %>
                        <div class="form-group">
                            <label for="id">C&oacute;digo</label>
                            <input type="text" class="form-control input-lg" id="numero" name="numero" readonly="" value="<% out.print(tu.nextTipoUsu());  %>">
                        </div>
                        <div class="form-group">
                            <label for="pwd">Descripci&oacute;n</label>
                            <input type="descripcion" class="form-control input-lg" id="descripcion" name="descripcion">
                        </div>
          
                        <div class="form-group">
                            
                        
                        <button type="submit" class="btn btn-default">Guardar</button>
                    </form>
                    
                </div>
                
            </div>
            
        </div>
    </div>    
    </body>
</html>
