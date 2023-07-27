package customsorting;

import java.util.Comparator;
import sdbms.Student;
public  class SortStudentById implements Comparator<Student> {

	public int compare(Student x,Student y) {
		return x.getId().compareTo(y.getId());
	}
}
//X---->object to be inserted   y id alerdy existing object
///for dtoring comparision we use compare to() present in String class
