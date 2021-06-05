import java.lang.*;
import java.util.*;
public class University {

	private ModuleDescriptor[] moduleDescriptors;

	private Student[] students;

	private Module[] modules;

	/**
	 * @return The number of students registered in the system.
	 */
	public int getTotalNumberStudents() {
		int numberOfStudents=students.length;
		return numberOfStudents;
	}

	/**
	 * @return The student with the highest GPA.
	 */
	public Student getBestStudent() {
		int numberOfStudents=getTotalNumberStudents();
		int max=0;
		for(int i=0;i<numberOfStudents;i++){
			if(students[i].getGpa()>students[max].getGpa()){
				max=i;
			}
		}
		return students[max];
	}

	/**
	 * @return The module with the highest average score.
	 */
	public Module getBestModule() {
		int max=0;
		for(int i=0;i<modules.length;i++){
			if(modules[i].getFinalAverageGrade()>modules[max].getFinalAverageGrade()){
				max=i;
			}
		}
		return modules[max];
	}

	//Constructor for a University object
	public University(ModuleDescriptor[] moduleDescriptors,Student[] students,Module[] modules){
		this.moduleDescriptors=moduleDescriptors;
		this.students=students;
		this.modules=modules;
	}

	public static void main(String[] args) {

		//create module descriptor objects and add them to an array
		ModuleDescriptor moduleDescriptor0=new ModuleDescriptor("ECM0002", "Real World Mathematics", new double[]{0.1,0.3,0.6});
		ModuleDescriptor moduleDescriptor1=new ModuleDescriptor("ECM1400", "Programming", new double[]{0.25,0.25,0.25,0.25});
		ModuleDescriptor moduleDescriptor2=new ModuleDescriptor("ECM1406", "Data Structures", new double[]{0.25,0.25,0.5});
		ModuleDescriptor moduleDescriptor3=new ModuleDescriptor("ECM1410", "Object-Oriented Programming", new double[]{0.2,0.3,0.5});
		ModuleDescriptor moduleDescriptor4=new ModuleDescriptor("BEM2027", "Information Systems", new double[]{0.1,0.3,0.3,0.3});
		ModuleDescriptor moduleDescriptor5=new ModuleDescriptor("PHY2023", "Thermal Physics", new double[]{0.4,0.6});
		ModuleDescriptor[] moduleDescriptors=new ModuleDescriptor[6];
		moduleDescriptors[0]=moduleDescriptor0;
		moduleDescriptors[1]=moduleDescriptor1;
		moduleDescriptors[2]=moduleDescriptor2;
		moduleDescriptors[3]=moduleDescriptor3;
		moduleDescriptors[4]=moduleDescriptor4;
		moduleDescriptors[5]=moduleDescriptor5;

		//check if module descriptor codes are unique
		int count=0;
		for(int i=0; i<moduleDescriptors.length; i++){
			for(int j=0; j<moduleDescriptors.length; j++){
				if(moduleDescriptors[i].getCode().equals(moduleDescriptors[j].getCode())){
					count++;
				}
			}
			if(count>1){
				System.out.println("ERROR: Module codes are not unique");
				System.exit(0);
			}
			count=0;
		}

		//create student objects and add them to an array
		Student[] students=new Student[10];
		Student student0=new Student(1000,"Ana",'F');
		Student student1=new Student(1001,"Oliver",'M');
		Student student2=new Student(1002,"Mary",'F');
		Student student3=new Student(1003,"John",'M');
		Student student4=new Student(1004,"Noah",'M');
		Student student5=new Student(1005,"Chico",'M');
		Student student6=new Student(1006,"Maria",'F');
		Student student7=new Student(1007,"Mark",'X');
		Student student8=new Student(1008,"Lia",'F');
		Student student9=new Student(1009,"Rachel",'F');
		students[0]=student0;
		students[1]=student1;
		students[2]=student2;
		students[3]=student3;
		students[4]=student4;
		students[5]=student5;
		students[6]=student6;
		students[7]=student7;
		students[8]=student8;
		students[9]=student9;

		//check if student ID is unique
		count=0;
		for(int i=0; i<students.length; i++){
			for(int j=0; j<students.length; j++){
				if(students[i].getId()==students[j].getId()){
					count++;
				}
			}
			if(count>1){
				System.out.println("ERROR: Student ids are not unique");
				System.exit(0);
			}
			count=0;
		}

		//create module objects and them to an array
		Module module0=new Module(2019,(byte)1,moduleDescriptor1);
		Module module1=new Module(2019,(byte)1,moduleDescriptor5);
		Module module2=new Module(2019,(byte)2,moduleDescriptor4);
		Module module3=new Module(2019,(byte)2,moduleDescriptor1);
		Module module4=new Module(2020,(byte)1,moduleDescriptor2);
		Module module5=new Module(2020,(byte)1,moduleDescriptor3);
		Module module6=new Module(2020,(byte)2,moduleDescriptor0);
		Module[] modules=new Module[7];
		modules[0]=module0;
		modules[1]=module1;
		modules[2]=module2;
		modules[3]=module3;
		modules[4]=module4;
		modules[5]=module5;
		modules[6]=module6;

		//check if there is only one instance of a module
		count=0;
		for(int i=0; i<modules.length; i++){
			for(int j=0; j<modules.length; j++){
				if(modules[i].getYear()==modules[j].getYear() && modules[i].getTerm()==modules[j].getTerm() && modules[i].getModule().equals(modules[j].getModule())){
					count++;
				}
			}
			if(count>1){
				System.out.println("ERROR: There are multiple instances of one module");
				System.exit(0);
			}
			count=0;
		}

		//create student record objects
		StudentRecord studentRecord0=new StudentRecord(student0, module0, new double[]{9.0,10.0,10.0,10.0});
		StudentRecord studentRecord1=new StudentRecord(student1, module0, new double[]{8.0,8.0,8.0,9.0});
		StudentRecord studentRecord2=new StudentRecord(student2, module0, new double[]{5.0,5.0,6.0,5.0});
		StudentRecord studentRecord3=new StudentRecord(student3, module0, new double[]{6.0,4.0,7.0,9.0});
		StudentRecord studentRecord4=new StudentRecord(student4, module0, new double[]{10.0,9.0,10.0,9.0});

		StudentRecord studentRecord5=new StudentRecord(student5, module1, new double[]{9.0,9.0});
		StudentRecord studentRecord6=new StudentRecord(student6, module1, new double[]{6.0,9.0});
		StudentRecord studentRecord7=new StudentRecord(student7, module1, new double[]{5.0,6.0});
		StudentRecord studentRecord8=new StudentRecord(student8, module1, new double[]{9.0,7.0});
		StudentRecord studentRecord9=new StudentRecord(student9, module1, new double[]{8.0,5.0});

		StudentRecord studentRecord10=new StudentRecord(student0, module2, new double[]{10.0,10.0,9.5,10.0});
		StudentRecord studentRecord11=new StudentRecord(student1, module2, new double[]{7.0,8.5,8.2,8.0});
		StudentRecord studentRecord12=new StudentRecord(student2, module2, new double[]{6.5,7.0,5.5,8.5});
		StudentRecord studentRecord13=new StudentRecord(student3, module2, new double[]{5.5,5.0,6.5,7.0});
		StudentRecord studentRecord14=new StudentRecord(student4, module2, new double[]{7.0,5.0,8.0,6.0});

		StudentRecord studentRecord15=new StudentRecord(student5, module3, new double[]{9.0,10.0,10.0,10.0});
		StudentRecord studentRecord16=new StudentRecord(student6, module3, new double[]{8.0,8.0,8.0,9.0});
		StudentRecord studentRecord17=new StudentRecord(student7, module3, new double[]{5.0,5.0,6.0,5.0});
		StudentRecord studentRecord18=new StudentRecord(student8, module3, new double[]{6.0,4.0,7.0,9.0});
		StudentRecord studentRecord19=new StudentRecord(student9, module3, new double[]{10.0,9.0,8.0,9.0});

		StudentRecord studentRecord20=new StudentRecord(student0, module4, new double[]{10.0,10.0,10.0});
		StudentRecord studentRecord21=new StudentRecord(student1, module4, new double[]{8.0,7.5,7.5});
		StudentRecord studentRecord22=new StudentRecord(student2, module4, new double[]{9.0,7.0,7.0});
		StudentRecord studentRecord23=new StudentRecord(student3, module4, new double[]{9.0,8.0,7.0});
		StudentRecord studentRecord24=new StudentRecord(student4, module4, new double[]{2.0,7.0,7.0});
		StudentRecord studentRecord25=new StudentRecord(student5, module4, new double[]{10.0,10.0,10.0});
		StudentRecord studentRecord26=new StudentRecord(student6, module4, new double[]{8.0,7.5,7.5});
		StudentRecord studentRecord27=new StudentRecord(student7, module4, new double[]{10.0,10.0,10.0});
		StudentRecord studentRecord28=new StudentRecord(student8, module4, new double[]{9.0,8.0,7.0});
		StudentRecord studentRecord29=new StudentRecord(student9, module4, new double[]{8.0,9.0,10.0});

		StudentRecord studentRecord30=new StudentRecord(student0, module5, new double[]{10.0,9.0,10.0});
		StudentRecord studentRecord31=new StudentRecord(student1, module5, new double[]{8.5,9,7.5});
		StudentRecord studentRecord32=new StudentRecord(student2, module5, new double[]{10.0,10.0,5.5});
		StudentRecord studentRecord33=new StudentRecord(student3, module5, new double[]{7.0,7.0,7.0});
		StudentRecord studentRecord34=new StudentRecord(student4, module5, new double[]{5.0,6.0,10.0});

		StudentRecord studentRecord35=new StudentRecord(student5, module6, new double[]{8.0,9.0,8.0});
		StudentRecord studentRecord36=new StudentRecord(student6, module6, new double[]{6.5,9.0,9.5});
		StudentRecord studentRecord37=new StudentRecord(student7, module6, new double[]{8.5,10.0,8.5});
		StudentRecord studentRecord38=new StudentRecord(student8, module6, new double[]{7.5,8.0,10.0});
		StudentRecord studentRecord39=new StudentRecord(student9, module6, new double[]{10.0,6.0,10.0});

		//arrays of student records are passed into each respective student
		students[0].setStudentRecords(new StudentRecord[]{studentRecord0,studentRecord10,studentRecord20,studentRecord30});
		students[1].setStudentRecords(new StudentRecord[]{studentRecord1,studentRecord11,studentRecord21,studentRecord31});
		students[2].setStudentRecords(new StudentRecord[]{studentRecord2,studentRecord12,studentRecord22,studentRecord32});
		students[3].setStudentRecords(new StudentRecord[]{studentRecord3,studentRecord13,studentRecord23,studentRecord33});
		students[4].setStudentRecords(new StudentRecord[]{studentRecord4,studentRecord14,studentRecord24,studentRecord34});
		students[5].setStudentRecords(new StudentRecord[]{studentRecord5,studentRecord15,studentRecord25,studentRecord35});
		students[6].setStudentRecords(new StudentRecord[]{studentRecord6,studentRecord16,studentRecord26,studentRecord36});
		students[7].setStudentRecords(new StudentRecord[]{studentRecord7,studentRecord17,studentRecord27,studentRecord37});
		students[8].setStudentRecords(new StudentRecord[]{studentRecord8,studentRecord18,studentRecord28,studentRecord38});
		students[9].setStudentRecords(new StudentRecord[]{studentRecord9,studentRecord19,studentRecord29,studentRecord39});

		//arrays of student records are passed into each respective module
		modules[0].setStudentRecords(new StudentRecord[]{studentRecord0,studentRecord1,studentRecord2,studentRecord3,studentRecord4});
		modules[1].setStudentRecords(new StudentRecord[]{studentRecord5,studentRecord6,studentRecord7,studentRecord8,studentRecord9});
		modules[2].setStudentRecords(new StudentRecord[]{studentRecord10,studentRecord11,studentRecord12,studentRecord13,studentRecord14});
		modules[3].setStudentRecords(new StudentRecord[]{studentRecord15,studentRecord16,studentRecord17,studentRecord18,studentRecord19});
		modules[4].setStudentRecords(new StudentRecord[]{studentRecord20,studentRecord21,studentRecord22,studentRecord23,studentRecord24,studentRecord25,studentRecord26,studentRecord27,studentRecord28,studentRecord29});
		modules[5].setStudentRecords(new StudentRecord[]{studentRecord30,studentRecord31,studentRecord32,studentRecord33,studentRecord34});
		modules[6].setStudentRecords(new StudentRecord[]{studentRecord35,studentRecord36,studentRecord37,studentRecord38,studentRecord39});

		//creating university object
		University university=new University(moduleDescriptors,students,modules);

		// Print Reports
		System.out.println("The UoK has " + university.getTotalNumberStudents() + " students.");

		// best module
		System.out.println("The best module is:");
		System.out.println(university.getBestModule());

		// best student
		System.out.println("The best student is:");
		System.out.println(university.getBestStudent().printTranscript());
	}
}
