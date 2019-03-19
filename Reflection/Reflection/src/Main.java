
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws ClassNotFoundException{
		Object dep=null;
		Class<?> department = null;
		try {
			department = Class.forName("Department");
			dep = setDepartment(department);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("checkkk" + dep.toString());
		analyzeClass("Department");
	}





	public static Object  setDepartment(Class<?> d){
		Class<?> studentClass = null;
		Class<?> courseClass = null;
		ArrayList<Object> students= new ArrayList<Object>();
		Object student = null;
		Method dMethods=null;
		Object[] course = new Object[4];
		try {
			courseClass = Class.forName("Course");
			studentClass = Class.forName("Student");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		Constructor<?> dcons[] = d.getConstructors();
		Constructor<?> scons[] = studentClass.getConstructors();
		Constructor<?> Ccons[] = courseClass.getConstructors();
		try {
			course[0] = Ccons[0].newInstance(100,51221,"matlab");	
			course[1] = Ccons[0].newInstance(90,51451,"boris");
			course[2] = Ccons[0].newInstance(80,55511,"maria");
			course[3] = Ccons[0].newInstance(70,513351,"revital");
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		Object dep = null;

		try {
			int i=0;


			Method sMethod = null;
			try {
				sMethod = studentClass.getDeclaredMethod("addCourse", courseClass);
			} catch (NoSuchMethodException | SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			students.add(scons[0].newInstance("Omri",27));
			sMethod.invoke(students.get(i),course[i]);
			i++;
			students.add(scons[0].newInstance("Ofir",25));
			sMethod.invoke(students.get(i),course[i]);
			i++;
			students.add(scons[0].newInstance("Moshe",19));
			sMethod.invoke(students.get(i),course[i]);
			i++;
			students.add(scons[0].newInstance("avraham",17));
			sMethod.invoke(students.get(i),course[i]);
			i++;
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			try {
				dep = dcons[0].newInstance();
			} catch (InstantiationException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IllegalArgumentException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (InvocationTargetException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			dMethods = d.getDeclaredMethod("addStudent",studentClass);
			for(int j=0;j<students.size();j++){
				try {
					dMethods.invoke(dep, students.get(j));
				} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (NoSuchMethodException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dep;

	}
	public static void analyzeClass(String className) throws ClassNotFoundException{
		Class analayzedClass = null;
		Object analyzed=null;

			analayzedClass = Class.forName(className);
			// get the absolute name of the class
				
						System.out.println("Class Name is: " + analayzedClass.getName());

						// get the simple name of the class (without package info)
						String rentalClassNoPackage = analayzedClass.getSimpleName();
						System.out.println("Class Name without package is: "
								+ rentalClassNoPackage);

						// get the package name of the class
						Package rentalPackage = analayzedClass.getPackage();
						System.out.println("Package Name is: " + rentalPackage);

						// get all the constructors of the class
						Constructor[] constructors = analayzedClass.getConstructors();
						System.out.println("Constructors are: "
								+ Arrays.toString(constructors));
						
						Method[] allmethods = analayzedClass.getMethods();
						System.out.println("Methods are: " + Arrays.toString(allmethods));
						for (Method method : allmethods) {
							System.out.println("method = " + method.getName());
						}
						
						Method[] declaredMethods = analayzedClass.getDeclaredMethods();
						System.out.println("Declared Methods are: "
								+ Arrays.toString(declaredMethods));
						for (Method dmethod : declaredMethods) {
							System.out.println("method = " + dmethod.getName());
						}
						
						Field[] fieldType= analayzedClass.getDeclaredFields();
						 System.out.println("fields");		              
					
						             for(Field field : fieldType){
						             
						 
						                 System.out.println(field.getName()+" "+ field.getType());
						
						             }

						// get constructor with specific argument
						/*Constructor constructor = analayzedClass.getConstructor(Integer.TYPE);

						// initializing an object of the RentCar class
						RentCar rent = (RentCar) constructor.newInstance(455);
						

						// get method with specific name and parameters
						Method oneMethod = analayzedClass.getMethod("computeRentalCost",
								new Class[] { Integer.TYPE });
						System.out.println("Method is: " + oneMethod);

						// call computeRentalCost method with parameter int
						oneMethod.invoke(rent, 4);

						// get all the parameters of computeRentalCost
						Class[] parameterTypes = oneMethod.getParameterTypes();
						System.out.println("Parameter types of "+parameterTypes.toString()+" are: "
								+ Arrays.toString(parameterTypes));

						// get the return type of computeRentalCost
						Class returnType = oneMethod.getReturnType();
						System.out.println("Return type is: " + returnType);

						// gets all the public member fields of the class RentCar
						Field[] fields = analayzedClass.getFields();

						System.out.println("Public Fields are: ");
						for (Field oneField : fields) {
							// get public field name
							Field field = analayzedClass.getField(oneField.getName());
							String fieldname = field.getName();
							System.out.println("Fieldname is: " + fieldname);

							// get public field type
							Object fieldType = field.getType();
							System.out.println("Type of field " + fieldname + " is: "
									+ fieldType);

							// get public field value
							Object value = field.get(rent);
							System.out.println("Value of field " + fieldname + " is: "
									+ value);

						}

						// How to access private member fields of the class

						// getDeclaredField() returns the private field
						Field privateField = RentCar.class.getDeclaredField("type");

						String name = privateField.getName();
						System.out.println("One private Fieldname is: " + name);
						// makes this private field instance accessible
						// for reflection use only, not normal code
						privateField.setAccessible(true);

						// get the value of this private field
						String fieldValue = (String) privateField.get(rent);
						System.out.println("fieldValue = " + fieldValue);*/

		}
}
