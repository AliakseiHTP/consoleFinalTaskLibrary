package by.htp.ui;

public class SubMenu extends BaseUI {
	BaseUI baseUI;

	public SubMenu() {
		super();
	}

	public SubMenu(BaseUI baseUI) {
		super();
		this.baseUI = baseUI;
	}

	@Override
	void showMenu() {
		System.out.println("-------====Please choose one variant====-------");
		System.out.println("1. Back");
		System.out.println("2. Exit");
		System.out.println("-------=================================-------");
		nextStep();
	}

	public void showReceivedMenu() {

		baseUI.showMenu();

	}

	private void nextStep() {
		super.setChooseOperation(scanner.next());
		switch (getChooseOperation()) {
		case "1":
			showReceivedMenu();
			break;
		case "2":
			System.exit(0);
			break;
		default:
			System.out.println("-------====Wrong data! Please try again.====-------");
			showMenu();
		}
	}

}
