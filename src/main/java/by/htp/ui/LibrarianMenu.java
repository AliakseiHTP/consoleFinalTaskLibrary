package by.htp.ui;

import static by.htp.capabilities.Functionality.printBook;
import static by.htp.capabilities.Functionality.printListBook;

public class LibrarianMenu extends BaseUI {

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
			System.out.println("Wrong choose Try again");
			showMenu();
		}
	}

	private int chooseBook() {
		System.out.println("Enter book id");
		return scanner.nextInt();
	}

}
