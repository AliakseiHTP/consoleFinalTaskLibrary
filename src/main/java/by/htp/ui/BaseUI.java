package by.htp.ui;

import java.util.Scanner;

import by.htp.entity.Person;

public abstract class BaseUI {
	private String chooseOperation;
	protected Scanner scanner;
	protected static Person person;
	protected UserMenu userMenu;
	protected LibrarianMenu librarianMenu;
	protected SubMenu subMenu;

	public BaseUI() {
		scanner = new Scanner(System.in);
	}

	abstract void showMenu();

	public String getChooseOperation() {
		return chooseOperation;
	}

	public void setChooseOperation(String chooseOperation) {
		this.chooseOperation = chooseOperation;
	}
}
