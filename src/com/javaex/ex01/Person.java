package com.javaex.ex01;

public class Person {

	private String name;
	private String hp;
	private String office;

	public Person() {
		super();
	}

	public Person(String name, String hp, String office) {
		super();
		this.name = name;
		this.hp = hp;
		this.office = office;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHp() {
		return hp;
	}

	public void setHp(String hp) {
		this.hp = hp;
	}

	public String getOffice() {
		return office;
	}

	public void setOffice(String office) {
		this.office = office;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", hp=" + hp + ", office=" + office + "]";
	}

}
