package banking.view;

import java.rmi.RemoteException;

import banking.BankImplement;
import banking.BankServer;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Deposit {

	@FXML
	private TextField amount;
	@FXML
	private TextField password;
	@FXML
	private Label message;
	
	public void cancel() {
		amount.clear();
		password.clear();
	}
	
	public void deposit() throws RemoteException {
		int depositAmt = Integer.parseInt(amount.getText());
		//BankServer server = new BankServer();
		BankImplement impl = new BankImplement();
		impl.deposit(depositAmt, "Myat");
		message.setText("Successfully Deposited to your account");
	}
}
