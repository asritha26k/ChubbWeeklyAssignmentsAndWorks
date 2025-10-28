package Person;

import java.util.Objects;

public class Teacher extends Individual {

	public Teacher(int id, String Personname, String className) {
		super(id, Personname, className);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Student))
			return false;
		Student s = (Student) o;
		return id == s.id && Objects.equals(Personname, s.Personname);
	}

	@Override
	public int hashCode() {
		return Objects.hash(Personname, id);
	}

	@Override
	public String toString() {
		return Personname + " (" + id + ")";
	}

}
