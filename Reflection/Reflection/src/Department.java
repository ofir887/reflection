import java.util.ArrayList;

public class Department {
	private ArrayList<Student> Students;
	
	public Department() {
		super();
		Students = new ArrayList<>();
	}
	public Department(ArrayList<Student> students) {
		super();
		Students = students;
	}
	public void addStudent(Student student){
		if(student != null){
			this.Students.add(student);
		}
			
	}
	@Override
	public String toString() {
		return "Class [Students=" + Students  + "]";
	}
	
	
}
