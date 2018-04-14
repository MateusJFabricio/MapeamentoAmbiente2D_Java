package AutoMap.Application;
import AutoMap.Controller.ControllerConexao;
import AutoMap.views.viewMain;

public class Main {
	private static ControllerConexao controller;
	public static viewMain telaPrincipal;
	public static void main(String[] args) {
		
		//Cria a Controller
		controller = new ControllerConexao();
		
		telaPrincipal = new viewMain(controller);
		telaPrincipal.show();

	}

}
