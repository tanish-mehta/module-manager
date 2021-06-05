import java.lang.*;
public class StudentRecord {

	private Student student;

	private Module module;

	private double[] marks;

	private double finalScore;

	private Boolean isAboveAverage;

	//constructor for StudentRecord objects
	public StudentRecord(Student student, Module module, double[] marks){

		//check if marks are between 0 and 100
		for(double i: marks){
			if(i>=100.0 || i<=0.0){
				System.exit(0);
			}
		}
		this.student=student;
		this.module=module;
		this.marks=marks;
		this.finalScore=calculateFinalScore();
	}

	/**
	 * @return The final score of a student in a module after calculating it.
	 */
	public double calculateFinalScore(){
		double[] weights=module.getModule().getContinuousAssignmentWeights();
		double sum=0.0;
		for(int i=0; i<marks.length; i++){
			sum=sum+(marks[i]*weights[i]);
		}
		if(sum<=0 || sum>=100){
			System.out.println("ERROR: Final Score is out of range");
			System.exit(0);
		}
		return sum;
	}

	//calculate whether the student has achieved a grade that is higher than the average grade in the module.
	public void calculateIsAboveAverage(){
		if(finalScore>module.getFinalAverageGrade()){
			isAboveAverage=true;
		}
		else{
			isAboveAverage=false;
		}
	}

	/**
	 * @return The final score of a student in a module.
	 */
	public double getFinalScore(){
		return finalScore;
	}

	/**
	 * @return The module to which the student record is of.
	 */
	public Module getModule(){
		return module;
	}

	/**
	 * @return The student to which the student record is of.
	 */
	public Student getStudent(){
		return student;
	}

	public String toString(){
		return "| "+getModule().getYear()+" | "+getModule().getTerm()+" | "+getModule().getModule().getCode()+" | "+getFinalScore()+" |\n";
	}
}
