package banking.view;

import java.rmi.RemoteException;

import banking.BankImplement;
import banking.BankServer;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Withdraw {
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

	public void withdraw() throws RemoteException {
		int withdrawAmt = Integer.parseInt(amount.getText());
		//BankServer server = new BankServer();
		BankImplement impl = new BankImplement();
		impl.withdraw(withdrawAmt, "Myat");
		message.setText("Successfully Withdraw from your account");
	}
}
