package com.example.model;

public class Student {

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNpm() {
		return npm;
	}
	public void setNpm(String npm) {
		this.npm = npm;
	}
	public double getGpa() {
		return gpa;
	}
	public void setGpa(double gpa) {
		this.gpa = gpa;
	}
	public Student(String name, String npm, double gpa) {
		super();
		this.name = name;
		this.npm = npm;
		this.gpa = gpa;
	}
	String name;
	String npm;
	double gpa;
}
