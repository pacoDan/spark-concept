package controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import entities.Usuario;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class UsuarioController {
	private List<Usuario> usuarios;
	
	public UsuarioController() {
		this.usuarios = new ArrayList<>();
		this.usuarios.add(new Usuario("Juan", 	"Perez", 	"juan07","juan.png"));
		this.usuarios.add(new Usuario("Adrian",	"Magazine", "adrian10","adrian.png"));
		this.usuarios.add(new Usuario("Lelia", 	"Corzo", 	"leli87","lelia.png"));
	}
	
	public ModelAndView usuarios(Request request, Response response) {
		 Map<String, Object> model=new HashMap<>();
		 model.put("usuarios", this.usuarios);
		 model.put("header", "Usuarios");
		 return new ModelAndView(model, "usuarios.hbs");
	}
	
	public ModelAndView crear(Request request, Response response) {
		Map<String, Object> model=new HashMap<>();
		model.put("header", "Nuevo usuario");
		return new ModelAndView(model, "usuario.hbs");
	}
	
	public ModelAndView guardar(Request request, Response response) {
		Map<String, Object> model=new HashMap<>();
		Usuario nuevoUsuario = new Usuario();
		nuevoUsuario.setNombre(request.queryParams("nombre"));
		nuevoUsuario.setApellido(request.queryParams("apellido"));
		nuevoUsuario.setNombreDeUsuario(request.queryParams("nombreDeUsuario"));
		nuevoUsuario.setFotoDePerfil("user.jpg");
		this.usuarios.add(nuevoUsuario);
		model.put("mensaje", "El usuario fue creado correctamente");
		model.put("header", "Nuevo usuario");
		return new ModelAndView(model, "usuarioCreado.hbs");
	}
}
