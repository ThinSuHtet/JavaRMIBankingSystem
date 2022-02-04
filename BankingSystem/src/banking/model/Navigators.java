package banking.model;

public enum Navigators {
	Home("Home.fxml"),
	Deposit("Deposit.fxml"),
	Withdraw("Withdraw.fxml"),
	Balance("Balance.fxml"),
	SignOut("SignOut.fxml");
	
	private String viewName;
	
	private Navigators(String viewName) {
		this.viewName = viewName;
	}
	
	public String getViewName() {
		return viewName;
	}
}
