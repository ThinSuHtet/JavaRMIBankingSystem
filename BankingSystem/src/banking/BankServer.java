package banking;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import banking.model.JDBCUtils;

public class BankServer {

	JDBCUtils jdbc = new JDBCUtils();
	
	public BankServer() throws RemoteException {
		super();
	}

	public static void main(String[] args) throws RemoteException, MalformedURLException {
		try {
			Registry registry = LocateRegistry.createRegistry(1099);
			System.out.println("Server is waiting");
			registry.rebind("server", new BankImplement());
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
}
