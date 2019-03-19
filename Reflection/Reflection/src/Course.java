
public class Course {
	private int Grade;
	private int Id;
	private String Name;
	
	public Course(int grade, int id, String name) {
		super();
		Grade = grade;
		Id = id;
		Name = name;
	}

	public int getGrade() {
		return Grade;
	}

	public void setGrade(int grade) {
		Grade = grade;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	@Override
	public String toString() {
		return "Course [Grade=" + Grade + ", Id=" + Id + ", Name=" + Name + "]";
	}
	
	
	
}
