package banking.view;

import java.net.URL;
import java.rmi.RemoteException;
import java.util.ResourceBundle;
import banking.BankImplement;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class Balance implements Initializable{

    @FXML
    private Label name;

    @FXML
    private Label lblbalance;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    	try {
    		BankImplement impl = new BankImplement();
			int balance = impl.check("Myat");
			name.setText("Myat");
			lblbalance.setText(String.valueOf(balance));			
		} catch (RemoteException e) {
			e.printStackTrace();
		}
    }
}
