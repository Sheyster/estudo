package br.com.teste.hackerrank.DataStructures;

import java.util.Scanner;
import java.util.TreeSet;

public class SolutionVPriorityQueue {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int totalEvents = Integer.parseInt(in.nextLine());
		TreeSet<Student> t = new TreeSet<Student>();
		while (totalEvents > 0) {
			String op = in.next();

			if (op.equalsIgnoreCase("ENTER")) {
				String name = in.next();
				double cgpa = in.nextDouble();
				int token = in.nextInt();
				t.add(new Student(token, name, cgpa));
			} else if (op.equalsIgnoreCase("SERVED")) {
				if (t.size() > 0) {
					Student s = t.first();
					t.remove(s);
				}
			}
			totalEvents--;
		}
		if (t.size() == 0) {
			System.out.println("EMPTY");
		}
		for (Student student : t) {
			System.out.println(student.getFname());
		}
		in.close();
	}
}

class Student {
	private int token;
	private String fname;
	private double cgpa;

	public Student(int id, String fname, double cgpa) {
		super();
		this.token = id;
		this.fname = fname;
		this.cgpa = cgpa;
	}

	public int getToken() {
		return token;
	}

	public String getFname() {
		return fname;
	}

	public double getCgpa() {
		return cgpa;
	}

	public int compareTo(Student student2) {
		if (this.getCgpa() > student2.getCgpa())
			return -1; // before
		else if (this.getCgpa() < student2.getCgpa())
			return 1; // after
		else { // gpa draw
			if (!this.getFname().equals(this.getFname())) // diff names
				return this.getFname().compareTo(student2.getFname());
			else { // same names
				int token = this.getToken() < student2.getToken() ? this.getToken() : student2.getToken();
				return this.getToken() - student2.getToken();
			}
		}
	}

	public int compare(Student s1, Student s2) {
		return s1.compareTo(s2);
	}
}
