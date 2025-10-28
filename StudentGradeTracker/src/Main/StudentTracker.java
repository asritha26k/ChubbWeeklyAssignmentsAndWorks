package Main;

import java.util.HashMap;
import java.util.Scanner;

import Exceptions.InvalidMarksException;
import Exceptions.StudentAlreadyExistingException;
import Exceptions.StudentNotFoundException;
import GradesManagement.GradesManagementSystem;
import GradesManagement.ManagementSystem;
import Person.Student;

public class StudentTracker {

	public static void main(String[] args) throws InvalidMarksException {
		GradesManagementSystem system = new ManagementSystem();

		try {
			Student s1 = new Student(1, "Asritha", "10th");
			Student s2 = new Student(2, "Rahul", "8th");

			system.addStudent(s1);
			system.addStudent(s2);

			HashMap<String, Integer> marks1 = new HashMap<>();
			marks1.put("Maths", 92);
			marks1.put("Science", 88);
			marks1.put("English", 85);
			system.EnterMarks(s1, marks1);

			HashMap<String, Integer> marks2 = new HashMap<>();
			marks2.put("Maths", 70);
			marks2.put("Science", 65);
			marks2.put("English", 72);
			system.EnterMarks(s2, marks2);

			System.out.println("Asritha's overall grade: " + system.getOverAllGrade(s1));
			System.out.println("Rahul's Science grade: " + system.getSubjectGrade(s2, "Science"));

			system.ChangeMarks(s2, "Science", 80);
			System.out.println("Rahul's updated Science grade: " + system.getSubjectGrade(s2, "Science"));

		} catch (StudentAlreadyExistingException | StudentNotFoundException e) {
			System.out.println("Error: " + e.getMessage());
		}
// with scanner class input 
		GradesManagementSystem sys = new ManagementSystem();
		Scanner sc = new Scanner(System.in);

		try {
			System.out.print("Enter number of students: ");
			int n = sc.nextInt();
			sc.nextLine();

			for (int i = 0; i < n; i++) {
				System.out.println("\nEnter details for student " + (i + 1));
				System.out.print("ID: ");
				int id = sc.nextInt();
				sc.nextLine();
				System.out.print("Name: ");
				String name = sc.nextLine();
				System.out.print("Class: ");
				String gradeClass = sc.nextLine();

				Student s = new Student(id, name, gradeClass);
				sys.addStudent(s);

				System.out.print("Enter number of subjects: ");
				int subCount = sc.nextInt();
				sc.nextLine();

				HashMap<String, Integer> marks = new HashMap<>();
				for (int j = 0; j < subCount; j++) {
					System.out.print("Subject name: ");
					String subject = sc.nextLine();
					System.out.print("Marks for " + subject + ": ");
					int marksValue = sc.nextInt();
					sc.nextLine();
					marks.put(subject, marksValue);
				}

				sys.EnterMarks(s, marks);
			}

			System.out.println("\n--- Grade Information ---");
			System.out.print("Enter student name to view overall grade: ");
			String studentName = sc.nextLine();

			Student found = null;
			for (Student s : ((ManagementSystem) sys).register.keySet()) {
				if (s.Personname.equalsIgnoreCase(studentName)) {
					found = s;
					break;
				}
			}

			if (found != null) {
				System.out.println("Overall Grade: " + sys.getOverAllGrade(found));

				System.out.print("Enter subject name to view subject grade: ");
				String subject = sc.nextLine();
				System.out.println(subject + " Grade: " + sys.getSubjectGrade(found, subject));

				System.out.print("Do you want to change marks? (yes/no): ");
				String choice = sc.nextLine();
				if (choice.equalsIgnoreCase("yes")) {
					System.out.print("Enter subject to change: ");
					String sub = sc.nextLine();
					System.out.print("Enter new marks: ");
					int newMarks = sc.nextInt();
					sc.nextLine();
					sys.ChangeMarks(found, sub, newMarks);
					System.out.println("Updated " + sub + " Grade: " + sys.getSubjectGrade(found, sub));
				}
			} else {
				System.out.println("Student not found.");
			}

		} catch (StudentAlreadyExistingException | StudentNotFoundException e) {
			System.out.println("Error: " + e.getMessage());
		} finally {
			sc.close();
		}
	}

}

/*
 * Enter number of students: 2
 * 
 * Enter details for student 1 ID: 1 Name: Asritha Class: 10th Enter number of
 * subjects: 3 Subject name: Maths Marks for Maths: 92 Subject name: Science
 * Marks for Science: 88 Subject name: English Marks for English: 85
 * 
 * Enter details for student 2 ID: 2 Name: Rahul Class: 8th Enter number of
 * subjects: 3 Subject name: Maths Marks for Maths: 70 Subject name: Science
 * Marks for Science: 65 Subject name: English Marks for English: 72
 */
