<%-- 
    Document   : menu
    Created on : 07-oct-2016, 19:56:30
    Author     : ley
--%>
<header>
<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container-fluid">
<!--        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href='${home}'>Inicio</a>
        </div>-->
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li class="active"><a href="${home}">Inicio</a></li>
                <li><a href="#">Acerca</a></li>
                <li><a href="#">Contacto</a></li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">Administración <b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li><a href='#'>Gestionar privilegios</a></li>
                        <li class="divider"></li>
                        <li class="dropdown-header">Gestionar Usuarios</li>
                        <li><a href='#'>Insertar</a></li>
                        <li><a href='#'>Editar</a></li> 
                        <li><a href='${home}/user'>Listar</a></li>
                        <li class="divider"></li>
                    </ul>
                </li>               
            </ul>
        </div><!--/.nav-collapse -->
    </div>
</nav>
</header>
