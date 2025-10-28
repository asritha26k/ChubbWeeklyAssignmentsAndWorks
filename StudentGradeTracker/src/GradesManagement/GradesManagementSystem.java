package GradesManagement;

import java.util.HashMap;

import Exceptions.InvalidMarksException;
import Exceptions.StudentAlreadyExistingException;
import Exceptions.StudentNotFoundException;
import Person.Student;

public interface GradesManagementSystem {

	void addStudent(Student student) throws StudentAlreadyExistingException;

	void EnterMarks(Student student, HashMap<String, Integer> inputMarks) throws StudentNotFoundException;

	void ChangeMarks(Student student, String subject, int marks) throws StudentNotFoundException, InvalidMarksException;

	String getOverAllGrade(Student student) throws StudentNotFoundException;

	String getSubjectGrade(Student student, String subject) throws StudentNotFoundException;
}
