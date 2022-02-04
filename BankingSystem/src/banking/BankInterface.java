package banking;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface BankInterface extends Remote {
	int deposit(int depositAmt, String name) throws RemoteException;
	int withdraw(int withdraw, String name) throws RemoteException;
	int check(String name) throws RemoteException;
}