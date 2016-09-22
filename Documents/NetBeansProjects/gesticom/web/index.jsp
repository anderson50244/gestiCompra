<%-- 
    Document   : index
    Created on : 16/03/2016, 11:01:45 PM
    Author     : Anderson
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        
        <script src="css/bootstrap/js/jquery.js"></script>
        <script src="css/bootstrap/js/bootstrap.js"></script>
      
        <link rel="stylesheet" href="css/bootstrap/css/bootstrap.min.css" >
        <link rel="stylesheet" type="text/css" href="css/bootstrap/css/bootstrap.css">
	<meta name='viewport' content='width=device-width, initial-scale=1.0'>
	<link rel="stylesheet" type="text/css" href="css/bootstrap/css/bootstrap-responsive.css">
        <title>Login</title>
        
    </head>
    <body>
        <div class="container">
            <div class="page-header"><h1>Gesti&oacute;n de compras</h1></div>
            <div class='row'>
                <div class="span3">&nbsp;</div>
                
                <div class="span6">
                <fieldset class="arrow">
                    <legend class="active">Iniciar sesi&oacute;n</legend>
                    <form>
                         
                        <div class="form-group">
                           
                            <label for="correo">Correo electronico</label>
                            <input type="email" name="email" id="email" class="form-control">
                            <label for="psw">Contrase&ntilde;a</label>
                            <input type="password" name="psw" id="psw" class="form-control">    
                                
                            
                        </div>
                           
                    </form>
                </fieldset>
                </div>
                
                <div class="span3">&nbsp;</div>
            </div>
            <div class="row">
                 <div class="span3">&nbsp;</div>
                <div class="span6">
                     <button name="btnok" id="btnok" class="btn btn-primary">Entrar</button>
                </div>
                <div class="span3">&nbsp;</div>
               
            </div>
        </div>
    </body>
</html>
