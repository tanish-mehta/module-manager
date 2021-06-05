import java.lang.*;
import java.util.*;
public class Student {

	private int id;

	private String name;

	private char gender;

	private double gpa;

	private StudentRecord[] records;

	public String printTranscript() {

		//create arraylists to store records term-wise
		ArrayList<StudentRecord> studentModulesYear1Term1 = new ArrayList<StudentRecord>();
		ArrayList<StudentRecord> studentModulesYear1Term2 = new ArrayList<StudentRecord>();
		ArrayList<StudentRecord> studentModulesYear2Term1 = new ArrayList<StudentRecord>();
		ArrayList<StudentRecord> studentModulesYear2Term2 = new ArrayList<StudentRecord>();

		//sort records into term-wise arraylists
		for(int i=0;i<records.length;i++){
			if(records[i].getModule().getYear()==2019){
				if(records[i].getModule().getTerm()==1){
					studentModulesYear1Term1.add(records[i]);
				}
				else{
					studentModulesYear1Term2.add(records[i]);
				}
			}
			else{
				if(records[i].getModule().getTerm()==1){
					studentModulesYear2Term1.add(records[i]);
				}
				else{
					studentModulesYear2Term2.add(records[i]);
				}
		  }
	  }

		//create StringBuffer to allow correct formatting of the transcript
	  StringBuffer studentModulesY1T1=new StringBuffer("");
		if(studentModulesYear1Term1.size()>0){
			for(int i=0;i<studentModulesYear1Term1.size();i++){
				studentModulesY1T1.append(studentModulesYear1Term1.get(i));
			}
		}

		StringBuffer studentModulesY1T2=new StringBuffer("");
		if(studentModulesYear1Term2.size()>0){
			studentModulesY1T2.append("\n");
			for(int i=0;i<studentModulesYear1Term2.size();i++){
				studentModulesY1T2.append(studentModulesYear1Term2.get(i));
			}
		}

		StringBuffer studentModulesY2T1=new StringBuffer("");
		if(studentModulesYear2Term1.size()>0){
			studentModulesY2T1.append("\n");
			for(int i=0;i<studentModulesYear2Term1.size();i++){
				studentModulesY2T1.append(studentModulesYear2Term1.get(i));
			}
		}

		StringBuffer studentModulesY2T2=new StringBuffer("");
		if(studentModulesYear2Term2.size()>0){
			studentModulesY2T2.append("\n");
			for(int i=0;i<studentModulesYear2Term2.size();i++){
				studentModulesY2T2.append(studentModulesYear2Term2.get(i));
			}
		}

		//get the GPA of the student to be included in the transcript
		this.gpa=calculateGpa();

		return "University of Knowledge - Official Transcript\n\n\nID:"+id+"\nName: "+name+"\nGPA: "+gpa+"\n\n"+studentModulesY1T1+studentModulesY1T2+studentModulesY2T1+studentModulesY2T2;
	}

	//constructor for Student object
	public Student(int id, String name, char gender){
		//check if id and name is null
		if(id==0 || name.isEmpty()){
			System.out.println("ERROR: Student id or student name is null");
			System.exit(0);
		}

		//check if gender values are correct
		if(gender!='X' && gender!='F' && gender!='M' && gender!='\u0000' ){
			System.out.println("ERROR: Student gender values are incorrect");
			System.exit(0);
		}

		this.id=id;
		this.name=name;
		this.gender=gender;
	}

	//store the student records belonging to the particular student
	public void setStudentRecords(StudentRecord[] records){
		this.records=records;

		//check if a student has multiple records in the same module
		int count=0;
		for(int i=0; i<records.length; i++){
			for(int j=0; j<records.length; j++){
				if(records[i].getModule()==records[j].getModule()){
					count++;
				}
			}
			if(count>1){
				System.out.println("ERROR: Multiple student records in a module for a single student");
				System.exit(0);
			}
			count=0;
		}
	}

	/**
	 * @return The GPA of a student after calculating.
	 */
	public double calculateGpa(){
		double sum=0.0;
		for(int i=0;i<records.length;i++){
			sum=sum+records[i].getFinalScore();
		}
		return sum/records.length;
	}

	/**
	 * @return The GPA of a student.
	 */
	public double getGpa(){
		return gpa;
	}

	/**
	 * @return The ID of a student.
	 */
	public int getId(){
		return id;
	}

	/**
	 * @return The name of a student.
	 */
	public String getName(){
		return name;
	}

	/**
	 * @return The gender of a student.
	 */
	public char getGender(){
		return gender;
	}
}
