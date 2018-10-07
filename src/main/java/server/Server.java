package server;

import spark.Spark;
import spark.debug.DebugScreen;

public class Server {
	public static void main(String[] args) {
		Spark.port(9000);
		
		Spark.get("/", (req,res) -> "Hola mundo");
		
		Spark.get("/saludo/:nombre", (req,res) -> "Hola "+req.params("nombre"));
		
		Spark.get("/saludo/*/:nombre", (req,res) -> "Hola "+req.splat()[0]+" "+req.params("nombre"));
		
		Spark.get("/saludo", (req,res) -> "Hola "+req.queryParams("nombre")+" "+req.queryParams("apellido"));
		
		DebugScreen.enableDebugScreen();
	}
}
