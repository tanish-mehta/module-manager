import java.lang.*;

public class ModuleDescriptor {

	private String code;

	private String name;

	private double[] continuousAssignmentWeights;

	public ModuleDescriptor(String code, String name, double[] continuousAssignmentWeights){

		//check that the sum of weights is equal to 1 & weights are non-negative
		double sum=0;
		for(double i:continuousAssignmentWeights){
			if(i<0.0){
				System.out.println("ERROR: Continuous Assignment Weights are less than zero");
				System.exit(0);
			}
			sum+=i;
		}
		if(sum!=1.0){
			System.out.println("ERROR: Continuous Assignment Weights do not add up to 1");
			System.exit(0);
		}

		//check if the module code or name is empty
		if(code.isEmpty() || name.isEmpty()){
			System.out.println("ERROR: The module code or module name is null");
			System.exit(0);
		}

		this.code=code;
		this.name=name;
		this.continuousAssignmentWeights=continuousAssignmentWeights;
	}

	/**
	 * @return The code of a module descriptor.
	 */
	public String getCode(){
		return code;
	}

	/**
	 * @return The name of a module descriptor.
	 */
	public String getName(){
		return name;
	}

	/**
	 * @return The continuous assignment weights of a module descriptor.
	 */
	public double[] getContinuousAssignmentWeights(){
		return continuousAssignmentWeights;
	}
}
