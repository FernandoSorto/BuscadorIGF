<%-- 
    Document   : registrarse
    Created on : Nov 11, 2019, 11:30:27 PM
    Author     : Luis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
        <title>Registra tu establecimiento!</title>
    </head>
    <body>
        <nav class="navbar navbar-dark bg-dark">
            <a class="navbar-brand text-light ">Registra tu establecimiento</a>
            <form class="form-inline">
                
                <span class="navbar-text mr-sm-2 text-muted">Buscar repuesto</span>
                <a class="btn btn-outline-success my-2 my-sm-0" href="index.htm">Regresar</a>
            </form>
        </nav>
        <br>
        <div class="container">
            <form>
                <div class="form-group">
                    <label for="nombreEstablecimiento">Nombre</label>
                    <input type="email" class="form-control" id="nombreEstablecimiento" aria-describedby="emailHelp" placeholder="Introduce el nombre">
                </div>
                <div class="form-group">
                    <label for="direccionEstablecimiento">Direccion</label>
                    <input type="email" class="form-control" id="direccionEstablecimiento" aria-describedby="emailHelp" placeholder="Introduce la direccion">
                </div>
                <div class="form-group">
                    <label for="emailEstablecimiento">Correo electronico</label>
                    <input type="email" class="form-control" id="emailEstablecimiento" aria-describedby="emailHelp" placeholder="Enter email">
                </div>
                <div class="form-group">
                    <label for="contraseniaEstablecimiento">Password</label>
                    <input type="password" class="form-control" id="contraseniaEstablecimiento" placeholder="Password">
                </div>
                <button type="submit" class="btn btn-primary">Registrarse</button>
            </form>
        </div>
    </body>
</html>
