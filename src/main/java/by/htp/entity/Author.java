package by.htp.entity;

import java.sql.Date;
import java.util.Calendar;

import by.htp.entity.Author;

public class Author {
	private int id;
	private String name;
	private String surName;
	private Calendar birthDay;

	public Author() {
		super();
	}

	public Author(String name, String surName, Calendar birthDay) {
		super();
		this.name = name;
		this.surName = surName;
		this.birthDay = birthDay;
	}

	public Calendar setTime(int year, int month, int day) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(year, month - 1, day);
		return calendar;
	}

	public void setBirthDay(Date date) {

		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		this.birthDay = cal;
	}

	public Date getDateBirthday() {
		Date date = new Date(birthDay.getTimeInMillis());
		return date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurName() {
		return surName;
	}

	public void setSurName(String surName) {
		this.surName = surName;
	}

	public Calendar getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(int year, int month, int day) {
		this.birthDay = setTime(year, month, day);
		;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Author other = (Author) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return name + " " + surName + " " + getDateBirthday();
	}
}
