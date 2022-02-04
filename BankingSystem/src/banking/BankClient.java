package banking;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import banking.model.Navigators;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BankClient extends Application{

	public static void main(String[] args) throws RemoteException, NotBoundException, MalformedURLException {
		Registry registry = LocateRegistry.getRegistry();
		System.out.println("Client is waving");
		//BankInterface intf = (BankInterface) registry.lookup("server");		
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/banking/view/Main.fxml"));
			Scene scene = new Scene(root,600,400);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}		
	}
}
