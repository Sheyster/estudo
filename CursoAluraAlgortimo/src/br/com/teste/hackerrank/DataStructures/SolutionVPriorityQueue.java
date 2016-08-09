package br.com.teste.hackerrank.DataStructures;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class SolutionVPriorityQueue {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int totalEvents = Integer.parseInt(in.nextLine());
		PriorityQueue<Student> data = new PriorityQueue<Student>(3, new Comparator<Student>() {
			@Override
			public int compare(Student s1, Student s2) {
				if (s1.getCgpa() == s2.getCgpa()) {
					if (s1.getFname().equals(s2.getFname())) {
						return (s1.getToken() < s2.getToken()) ? -1 : 1;
					} else {
						return s1.getFname().compareTo(s2.getFname());
					}
				} else {
					return (s2.getCgpa() > s1.getCgpa()) ? 1 : -1;
				}
			}
		});
		while (totalEvents > 0) {
			String event = in.next();
			switch (event) {
			case "ENTER":
				String name = in.next();
				double cgpa = in.nextDouble();
				int token = in.nextInt();
				data.offer(new Student(token, name, cgpa));
				break;
			case "SERVED":
				data.poll();
			}
			totalEvents--;
		}
		if (data.isEmpty())
			System.out.println("EMPTY");
		else {
			while (!data.isEmpty()) {
				Student st = data.poll();
				System.out.println(st.getFname());
			}
		}
		in.close();
	}
}

class Student implements Comparable<Student>, Comparator<Student> {
	private int token;
	private String fname;
	private double cgpa;

	public Student() {
		super();
		this.token = -1;
		this.fname = null;
		this.cgpa = -1;
	}

	public Student(String fname, double cgpa, int token) {
		super();
		this.token = token;
		this.fname = fname;
		this.cgpa = cgpa;
	}

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
				return token;
			}
		}
	}

	public int compare(Student s1, Student s2) {
		return s1.compareTo(s2);
	}
}