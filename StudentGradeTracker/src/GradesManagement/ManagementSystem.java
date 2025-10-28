package GradesManagement;

import java.util.HashMap;

import Exceptions.InvalidMarksException;
import Exceptions.StudentAlreadyExistingException;
import Exceptions.StudentNotFoundException;
import Person.Student;

public class ManagementSystem implements GradesManagementSystem {
	Student student;
	public HashMap<Student, HashMap<String, Integer>> register = new HashMap<>();

	public ManagementSystem() {
	}

	public void addStudent(Student student) throws StudentAlreadyExistingException {
		if (register.containsKey(student)) {
			throw new StudentAlreadyExistingException(student.Personname + " Student already exists");
		} else {
			// Fixed: changed 'null' to 'new HashMap<>()' to avoid NullPointerException when
			// adding marks later
			register.put(student, new HashMap<>());
			System.out.println("Added student");
		}
	}

	public void EnterMarks(Student student, HashMap<String, Integer> inputMarks) throws StudentNotFoundException {
		if (!register.containsKey(student)) {
			throw new StudentNotFoundException(student.Personname + " Student dont exists");
		} else {
			register.put(student, inputMarks);
			System.out.println("entered marks");
		}

	}

	public void ChangeMarks(Student student, String subject, int marks)
			throws InvalidMarksException, StudentNotFoundException {
		if (!register.containsKey(student)) {
			throw new StudentNotFoundException(student.Personname + " Student dont exists");
		}
		if (marks > 100 || marks < 0) {
			throw new InvalidMarksException("Invalid marks");
		}
		register.get(student).put(subject, marks);
		System.out.println("changed marks");
	}

	public String getOverAllGrade(Student student) {
		HashMap<String, Integer> marks = register.get(student);
		if (marks == null || marks.isEmpty()) {
			return "No marks available";
		}

		int total = 0;
		for (int m : marks.values()) {
			total += m;
		}
		double avg = total / (double) marks.size();

		if (avg >= 90)
			return "A+";
		else if (avg >= 80)
			return "A";
		else if (avg >= 70)
			return "B";
		else if (avg >= 60)
			return "C";
		else if (avg >= 50)
			return "D";
		else
			return "F";

	}

	public String getSubjectGrade(Student student, String subject) {
		HashMap<String, Integer> marks = register.get(student);
		if (marks == null || !marks.containsKey(subject)) {
			return "No marks found for " + subject;
		}

		int m = marks.get(subject);
		if (m >= 90)
			return "A+";
		else if (m >= 80)
			return "A";
		else if (m >= 70)
			return "B";
		else if (m >= 60)
			return "C";
		else if (m >= 50)
			return "D";
		else
			return "F";

	}

}
