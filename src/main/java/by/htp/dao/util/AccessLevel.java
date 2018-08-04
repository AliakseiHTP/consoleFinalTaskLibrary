package by.htp.dao.util;

public enum AccessLevel {
	USER(1), LIBRARIAN(2);

	private int access;

	private AccessLevel(int access) {
		this.access = access;
	}

	public int getAccessLevel() {
		return access;
	}

	public void setAccessLeve(int access) {
		this.access = access;
	}
}
