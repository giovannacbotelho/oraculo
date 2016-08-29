package Framework;

import java.util.HashMap;
import java.util.List;

public class OraculoExpectedList {
	
	List<HashMap<String,Double>> listInput;
	List<HashMap<String,Double>> listOutput;
	public List<HashMap<String, Double>> getListInput() {
		return listInput;
	}

	public void setListInput(List<HashMap<String, Double>> listInput) {
		this.listInput = listInput;
	}

	public List<HashMap<String, Double>> getListOutput() {
		return listOutput;
	}

	public void setListOutput(List<HashMap<String, Double>> listOutput) {
		this.listOutput = listOutput;
	}
	
	public OraculoExpectedList(List<HashMap<String, Double>> listInput, List<HashMap<String, Double>> listOutput) {
		this.listInput = listInput;
		this.listOutput = listOutput;
	}
	
	
	
	
//	protected List<InputObject> inputs;
//	protected List<OutputObject> outputs;
//	public void setInputs(List<InputObject> inputs);
//	public void setOutputs(List<OutputObject> outputs);
	//public void trataListInputOutput(List<HashMap<String,Double>> inputs,List<HashMap<String,Double>> outputs);
	
}
