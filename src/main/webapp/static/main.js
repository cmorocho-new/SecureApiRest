/**
 * 
 */

var app = new Vue({
  el: '#app-api-test',
  data: {
	mostrar: false,
	esEditar: false,
	
	criterio: "",
    usuarios: [],
	usuario: {}
  },
  methods: {
	
	crearUsuario(){
		this.usuario = {};
		this.mostrar = true;
		this.esEditar = false;
	},
	
	guardarUsuario(){
		$.ajax({
		  type: "POST",
		  url: '/AppTestApi/api/usuarios/crearEditar',
		  data: JSON.stringify(this.usuario),
		  contentType: 'application/json'
		}).done((data) => {
			if(data.codigo == "200"){
				this.mostrar = false
				this.buscarUsuarios()
			}else{
				alert(data)
			}
		}).fail((ex) => {
			alert(ex)
		})
	},
	
	editarUsuario(idUsuario){
		$.get(`/AppTestApi/api/usuarios/buscar/${idUsuario}`)
		.done((data) => {
			if(data.codigo == "200"){
				this.usuario = data.resultado
				this.mostrar = true;
				this.esEditar = true;
			}else{
				alert(data)
			}
		}).fail((ex) => {
			alert(ex)
		})
	},
	
	eliminarUsuario(idUsuario){
		$.ajax({
		  type: "DELETE",
		  url: `/AppTestApi/api/usuarios/eliminar/${idUsuario}`,
		}).done((data) => {
			if(data.codigo == "200"){
				this.buscarUsuarios()
			}else{
				alert(data)
			}
		}).fail((ex) => {
			alert(ex)
		})
	},
	
	buscarUsuarios(){
		$.get('/AppTestApi/api/usuarios/listar', {
	        criterio: this.criterio
	    }).done((data) => {
			if(data.codigo == "200"){
				this.usuarios = data.resultado
			}else{
				alert(data)
			}
		}).fail((ex) => {
			alert(ex)
		})
	}
  },
  created(){
	this.buscarUsuarios();
  }
})