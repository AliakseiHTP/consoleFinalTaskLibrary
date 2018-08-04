package by.htp.ui;

import static by.htp.capabilities.Functionality.authorization;

public class MenuAuthorization extends BaseUI{
	
	private String login;
	private String password;
	
	public void showMenu() {
		System.out.println("-------====Welcome! Please log in.====-------");
		System.out.println("-------=============Login:============-------");
		setLogin(scanner.next());
		System.out.println("-------===========Password:===========-------");
		setPassword(scanner.next());
		setPerson(login, password);
		showNextMenu();
	}
	
	private void setLogin(String login) {
		this.login = login;
	}
	
	private void setPassword(String password) {
		this.password = password;
	}
	
	private void  setPerson (String login,String password) {
		person = authorization(login, password);
		System.out.println(person);
	}
	
	private void showNextMenu() {
		switch (person.getAccessLevel()) {
		case 1:
			userMenu=new UserMenu();
			userMenu.showMenu();
			break;
		case 2:
			librarianMenu=new LibrarianMenu();
			librarianMenu.showMenu();
			break;
		case 3:
			System.exit(0);
			break;
		default:
			System.out.println("-------====Wrong data! Please try again.====-------");
			showMenu();
		}
	}
}
