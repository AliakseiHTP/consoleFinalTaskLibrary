package by.htp.ui;

import static by.htp.capabilities.Functionality.printListBook;
import static by.htp.capabilities.Functionality.printBook;

public class UserMenu extends BaseUI {

	void showMenu() {
		System.out.println("-------====Library menu====-------");
		System.out.println("1. Browse a catalog of books");
		System.out.println("2. View the book");
		System.out.println("3. Exit");
		System.out.println("-------====================-------");
		nextStep();
	}

	private void nextStep() {
		super.setChooseOperation(scanner.next());
		switch (getChooseOperation()) {
		case "1":
			printListBook(person);
			subMenu = new SubMenu(this);
			subMenu.showMenu();
			break;
		case "2":
			int id = chooseBook();
			printBook(id, person);
			subMenu = new SubMenu(this);
			subMenu.showMenu();
			break;
		case "3":
			System.exit(0);
			break;
		default:
			System.out.println("-------====Wrong data! Please try again.====-------");
			showMenu();
		}
	}

	private int chooseBook() {
		System.out.println("-------====Please enter id.====-------");
		return scanner.nextInt();
	}

}
