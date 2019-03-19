import java.util.ArrayList;

public class Student extends Person{
	
	private double Avg;
	private ArrayList<Course> Courses; 
	
	public Student(String name, int age) {
		super(name, age);
		this.Courses = new ArrayList<Course>();
		// TODO Auto-generated constructor stub
	}
/*	public Student(String name, int age,ArrayList<Course> courses) {
		super(name, age);
		this.Courses = courses;
		// TODO Auto-generated constructor stub
	}*/
	public double getAvg() {
		return Avg;
	}
	public void setAvg(double avg) {
		Avg = avg;
	}
	public ArrayList<Course> getCourses() {
		return Courses;
	}
	public void setCourses(ArrayList<Course> courses) {
		Courses = courses;
		calcAvg();
	}
	public void addCourse(Course course){
		this.Courses.add(course);
		calcAvg();
	}
	@Override
	public String toString() {
		return "Student [Avg=" + Avg + ", Courses=" + Courses + ", toString()=" + super.toString() + "]";
	}
	public void calcAvg(){
	int sum = 0;
	for(Course courses: this.Courses){
		sum+= courses.getGrade();
	}
	this.Avg=sum/this.Courses.size(); 
	}

}
