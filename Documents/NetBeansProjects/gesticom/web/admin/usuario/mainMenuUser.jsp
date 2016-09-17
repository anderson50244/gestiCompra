<%-- 
    Document   : mainMenuUser
    Created on : 18/05/2016, 11:18:13 PM
    Author     : Anderson
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="js/jsMenu.js"></script>
        <title>Crud usuario</title>
    </head>
    <body>
        <div class="container">
            <div class="row-fluid">
                <div class="span12">
                       
                        <ul class="breadcrumb">
                            <li><a href="javascript:mostrarContenidoUser('admin/usuario/frmUsuario');" class="btn">Registrar</a></li>
                            <li><a href="javascript:mostrarContenidoUser('admin/usuario/frmUsuarioEdit');" class="btn">Modificar</a></li>
                            <li class='active'><a href="javascript:mostrarContenidoServlet('UsuarioServlet?Opc=5');" class="btn">Consultar</a></li>
                               
                        </ul>
                </div>

            </div>
            
        </div>
        <br><br>
        <div class="confirm">

       </div>
        <div class="container" id="contenedorUsu" name="contenedorUsu">
            
        </div> 
    </body>
</html>
