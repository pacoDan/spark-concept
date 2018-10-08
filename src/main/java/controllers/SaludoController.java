package controllers;

import java.util.HashMap;
import java.util.Map;

import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class SaludoController {
	
	public ModelAndView saludar(Request request, Response response) {
		 Map<String, Object> model=new HashMap<>();
		 model.put("nombreDeLaPersona", request.params("nombre"));
		 return new ModelAndView(model, "saludo.hbs");
	}
	
}
