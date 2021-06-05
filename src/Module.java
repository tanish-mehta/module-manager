public class Module {

	private int year;

	private byte term;

	private ModuleDescriptor module;

	private StudentRecord[] records;

	private double finalAverageGrade;

	public Module(int year, byte term, ModuleDescriptor module){
		this.year=year;
		this.term=term;
		this.module=module;
	}

	public void setStudentRecords(StudentRecord[] records){
		this.records=records;
	}

	//calculate the final average grade of students in a module
	public void calculateFinalAverageGrade(){
		double sum=0.0;
		for(int i=0;i<records.length;i++){
			sum=sum+records[i].getFinalScore();
		}
		this.finalAverageGrade=sum/records.length;
	}

	/**
	 * @return The final average grade of students in a module.
	 */
	public double getFinalAverageGrade(){
		calculateFinalAverageGrade();
		return finalAverageGrade;
	}

	/**
	 * @return The module descriptor of the module.
	 */
	public ModuleDescriptor getModule(){
		return module;
	}

	/**
	 * @return The year of the module.
	 */
	public int getYear(){
		return year;
	}

	/**
	 * @return The term of the module.
	 */
	public byte getTerm(){
		return term;
	}

	public String toString(){
		return "| Year: "+year+" | Term: "+term+" | Module Descriptor Code: "+module.getCode()+" | Final Average Score: "+finalAverageGrade+" |";
	}

}
