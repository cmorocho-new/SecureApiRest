<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>CRUD Usuarios</title>
	
	<link type="text/css" rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/static/style.css">
	
	<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script type="text/javascript" src="https://cdn.jsdelivr.net/npm/vue@2/dist/vue.js"></script>
</head>
<body>

	<div id="app-api-test">
		<a href="${pageContext.request.contextPath}/logout">SALIR</a>
	  	<button id="show-modal" @click="crearUsuario()">NUEVO</button>
	  	<div v-if="mostrar" style="background: gray;">
	  		<h3 v-if="esEditar">EDITAR USUARIO</h3>
	  		<h3 v-else> CREAR USUARIO</h3>
            <label for="nombre">Nombre:</label>
            <input type="text" name="nombre" size="200" v-model="usuario.nombre" style="width: 200px;"/>
            <br>
	  		<label for="email">Email:</label>
            <input type="email" name="email" size="100" v-model="usuario.email" style="width: 200px;"/>
            <br>
            <label for="password">Password:</label>
            <input type="password" name="password" size="100" v-model="usuario.pssword" style="width: 200px;"/>
            <br> <br>
            <button @click="guardarUsuario()">GUARDAR</button>
            <button @click="mostrar = false">CANCELAR</button>
	  	</div>
		<h2>Usuarios</h2> 
		<button @click="buscarUsuarios()">LISTAR</button>
		<input v-model="criterio" @keyup.enter="buscarUsuarios" style="height: 22px; width: 250px;">
		<table style="width: 50%;">
		  <tr>
		  	<th width="10%">Action</th>
		  	<th width="5%">Index</th>
		    <th width="40%">Nombre</th>
		    <th width="20%">Email</th>
		    <th width="20%">Pasword</th>
		  </tr>
		  <tr v-for="(usuario, index) in usuarios">
		  	<td width="10%">
		  	 	<i class="material-icons" @click="eliminarUsuario(usuario.id)">delete</i>
                <i class="material-icons" @click="editarUsuario(usuario.id)">edit</i>
		  	</td>
		    <td width="5%"> 
		      	<span v-html="index + 1"></span>
		    </td>
		    <td width="40%">
		    	<span v-html="usuario.nombre"></span>	
		    </td>
		    <td width="20%">
		    	<span v-html="usuario.email"></span>
		    </td>
		    <td width="20%">
		    	<span v-html="usuario.pssword"></span>
		    </td>
		  </tr>
		</table>
	</div>
</body>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/main.js"></script>
</html>