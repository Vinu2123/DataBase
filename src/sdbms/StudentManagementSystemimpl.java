package sdbms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import customsorting.SortSTudentByAge;
import customsorting.SortStudentById;
import customsorting.SortStudentbyName;
import customsorting.sortStudentMarks;
import cutomexecption.StudentNotFounException;


public class StudentManagementSystemimpl implements StudentManagementSystem{

	Scanner scan=new Scanner(System.in);
	Map<String,Student> db =new LinkedHashMap<String,Student>();


	@Override
	public void addSTudent() {
		System.out.println("enter the age:");//accepting age
		int age=scan.nextInt();

		System.out.println("enter the name:");//acepting name
		String name=scan.next();

		System.out.println("enter the marks");//acepting marks
		int marks=scan.nextInt();


		Student std=new Student( age, name, marks);
		db.put(std.getId(),std);
		System.out.println("your student id is "+std.getId());
	}

	@Override
	public void displayStudent() { 
		System.out.println(" enter Student id");
		String id=scan.next();//scan.next().toUpperCase;
		id=id.toUpperCase();

		if(db.containsKey(id)) {
			Student std=db.get(id);//getting the student object

			System.out.println("Student details");
			System.out.println("------------------");
			System.out.println("ID:"+std.getId());
			System.out.println("AGE:"+std.getAge());
			System.out.println("NAME:"+std.getName());
			System.out.println("MARKS:"+std.getMarks());

		}
		else {
			try {
				String message="Student with id:"+id+"not found";
				throw new StudentNotFounException(message);
			}catch(Exception e){
				System.out.println(e.getMessage());
			}
		}
	}



	@Override
	public void displayAllStudents() {
		if(db.size()>0) {
			System.out.println("student records are as follows");
			System.out.println("------------------------------");
			Set<String> keys=db.keySet();
			for (String key:keys) {
				System.out.println(db.get(key));
			}
		}
		else {
			try {
				String message="no sufficient student records to ";
				throw new StudentNotFounException(message);
			}catch(Exception e){
				System.out.println(e.getMessage());
			}
		}

	}


	@Override
	public void removeStudent() {
		System.out.println("Enter the student id");
		String id=scan.next().toUpperCase();
		if(db.containsKey(id)) {
			System.out.println("Sudent record found");
			System.out.println(db.get(id));
			db.remove(id);
			System.out.println("Student Id REmove SUcceseFUlly");

		}
		else {
			try {
				String message ="Student id "+id+"not present to remove";
				throw new  StudentNotFounException(message);
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

	@Override
	public void removeAllStudents() {
		if(db.size()>0) {
			System.out.println("student records are as follows"+db.size());
			db.clear();
			System.out.println("all students records deleted sussfully");

		}
		else {
			try {
				String message="no sufficient student records to remove ";
				throw new StudentNotFounException(message);
			}catch(Exception e){
				System.out.println(e.getMessage());
			}
		}

	}


	@Override
	public void updateStudent() {
		System.out.println("Enter the STudent id");
		String  id=scan.next().toUpperCase();

		if(db.containsKey(id)) {
			Student std=db.get(id);

			System.out.println("1:Update age\n2:update name\n:3update marks\n4:ENter choice");
			int choice=scan.nextInt();
			switch(choice) {
			case 1:
			{
				System.out.println("enter age to update");
				int age=scan.nextInt();
				std.setAge(age);
				System.out.println("AGe updated sussfully");
			}
			break;

			case 2:		{
				System.out.println("enter name to update");
				String name=scan.next();
				std.setName(name);
				System.out.println("name updated sussfully");
			}
			break;
			
			case 3:      	{
				System.out.println("enter marks to update");
				int marks=scan.nextInt();
				std.setMarks(marks);
				System.out.println("name updated sussfully");
			}
			break;
            default :
            	System.out.println("invalid choice");
			}


		}
	}

	@Override
	public void countStudents() {
		System.out.println("number of student records"+db.size());
	}

	@Override
	public void sortStudents() {
		
		if(!db.isEmpty()) {
       //converting map into set using keyset()
		Set<String> keys=db.keySet();
		
		//creating th list object to store the map values
		List<Student> l=new ArrayList<Student>();
		
		//traversing the keys
		for(String key: keys) {
			l.add(db.get(key));//putting student object and storing it in the list
		}
		System.out.println("1: Sort student by id\2:sort student by name\n3:sort student by age\n4:sort student by marks");
		System.out.println("Enter the choice");
		int choice =scan.nextInt();
		switch(choice) {
		case 1: 
			Collections.sort(l,new SortStudentById());
			for(Student s: l) {
				System.out.println(s);
			}break;
		case 2: Collections.sort(l,new SortStudentbyName());
		for(Student s: l) {
			System.out.println(s);
		}break;
		case 3: Collections.sort(l,new SortSTudentByAge());
		for(Student s: l) {
			System.out.println(s);
		}break;
//		case 4:Collections.sort(l,sortStudentMarks());
//		
		}
		//private static void display(l<student> l){
		 //for (Student s: list){
		  //sysout(s)
		
		
//				
		}else {
			try {
				String message="no sufficient student records to remove ";
				throw new StudentNotFounException(message);
			}catch(Exception e){
				System.out.println(e.getMessage());
			}
			
		}
	}

	@Override
	public void findStudentWithHighestMarks() {
       Set<String> keys=db.keySet();
       List<Student> list=new ArrayList<Student>();
       for (String key:keys) {
    	   list.add(db.get(key)); 
       }
       Collections.sort(list,new sortStudentMarks());
       System.out.println("student with higest marks");
       System.out.println((list.get(list.size()-1)));
	}

	@Override
	public void findStudentWithLowestMarks() {
		       Set<String> keys=db.keySet();
		       List<Student> list=new ArrayList<Student>();
		       for (String key:keys) {
		    	   list.add(db.get(key)); 
		       }
		       Collections.sort(list,new sortStudentMarks());
		       System.out.println("student with lowest marks");
		       System.out.println((list.get(0)));
	}


}
