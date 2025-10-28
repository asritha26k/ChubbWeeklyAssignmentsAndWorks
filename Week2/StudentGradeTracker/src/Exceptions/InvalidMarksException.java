package Exceptions;

public class InvalidMarksException extends Exception {
	public InvalidMarksException(String msg) {
		super(msg);
	}

}
/*
BusinessException (base class)
│
├── InvalidMarksException
│     └── NegativeMarksException
│     └── MarksOutOfRangeException
│
├── InvalidGradeException
│
├── StudentNotFoundException
│
└── DuplicateStudentException


*/