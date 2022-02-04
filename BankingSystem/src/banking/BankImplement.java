package banking;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import banking.model.JDBCUtils;

public class BankImplement extends UnicastRemoteObject implements BankInterface {

	private static final long serialVersionUID = 1L;
	JDBCUtils jdbc = new JDBCUtils();
	
	public BankImplement() throws RemoteException {
		super();
	}

	@Override
	public int deposit(int depositAmt, String name) throws RemoteException {
		int amount = jdbc.select(name);
		int balance = amount + depositAmt;
		jdbc.update(balance, name);
		return 1;
	}

	@Override
	public int withdraw(int withdrawAmt, String name) throws RemoteException {
		int amount = jdbc.select(name);
		if(withdrawAmt > amount) {
			System.err.print("Your Balance is low.\nCannot perform this operation!!!");
			return -1;
		}else {
			int balance = amount - withdrawAmt;
			jdbc.update(balance, name);
		}
		return 1;
	}

	@Override
	public int check(String name) throws RemoteException {
		return jdbc.select(name);
	}

}
