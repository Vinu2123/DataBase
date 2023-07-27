package sdbms;

import java.util.Scanner;

import cutomexecption.invalidchoiceexception;

public class Solution {

	public static void main(String[] args) {
		System.out.println("Welcome To STudentDatabase ManagementSystem");
		System.out.println("---------------------------");

		Scanner scn=new Scanner(System.in);
		StudentManagementSystem sms=new StudentManagementSystemimpl();

		while(true) {

			System.out.println("1:addstudent\n2:displaystudent");
			System.out.println("3:sisplayallstudents\n4:removestudent");
			System.out.println("5:removeallstudent\n6:updatestudent");
			System.out.println("7:countstudent\n8:sortstudent");
			System.out.println("9:findwithhighestmarks\n10:findwithlowermarks");
			System.out.println("11:exit");

			int choice=scn.nextInt();

			switch(choice) {
			case 1:System.out.println("enter the number of students to add");
			sms.addSTudent();
			break;

			case 2:System.out.println("display number of student");
			sms.displayStudent();
			break;

			case 3:System.out.println("display number of student");
			sms.displayAllStudents();
			break;

			case 4:System.out.println("remove number of student");
			sms.removeStudent();
			break;

			case 5:System.out.println("remove all number of student");
			sms.removeAllStudents();
			break;

			case 6:System.out.println("update number of student");
			sms.updateStudent();
			break;
			
			case 7:System.out.println("count number of student");
    	    sms.countStudents();
    	    break;
    	    
			case 8:System.out.println("sort number of student");
    	    sms.sortStudents();
    	    break;
    	   
			case 9:System.out.println("findwithhigtsh number of student marks");
    	    sms.findStudentWithHighestMarks();
    	    break;
    	    
			case 10:System.out.println("findwithlowest number of student marks");
    	    sms.findStudentWithLowestMarks();
    	    break;
    	    
    	    default :
    	    	try {
    	    		String message="inalid choice kindly enter the rght choice";
    	    		throw new invalidchoiceexception(message);
    	    	}catch(Exception e) {
    	    		System.out.println(e.getMessage());
    	    	}
    	    	
			}
			System.out.println("-----------------");

		}

	}

}
