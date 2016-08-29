package Framework;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Oraculo {
	
	List<OraculoSettings> oraculoObject;
	private Reader reader;
	
	public Oraculo createOraculo(){
		return this;
	}
	
	public Oraculo withReaderXLSX(){
		reader = new ReadXLSX();
		return this;	
	}
	
	public void setOraculoSettings(List<OraculoSettings> oraculoObject){
		this.oraculoObject = oraculoObject;
	}
	
//	public List<OraculoExpectedResult> runOraculo(){
//		List<OraculoExpectedResult> list = new ArrayList<OraculoExpectedResult>();
//		for (OraculoSettings o:oraculoObject){
//			OraculoExpectedResult oer;
//			ArrayList<String> inputPathParameters = o.getInputsSettings().getPathParameters();
//			ArrayList<String> oututPathParameters = o.getOutputsSettings().getPathParameters();
//			
//			List<HashMap<String,Double>> listInput = reader.read(inputPathParameters);
//			List<HashMap<String,Double>> listOutput = reader.read(oututPathParameters);
//			
//			oer.setInputs(o.getInputsSettings().parseListToInputObjects(listInput));
//			oer.setOutputs(o.getOutputsSettings().parseListToOutputObjects(listOutput));
//			
//			list.add(oer);
//		}
//		return list;
//	}
	
	public List<OraculoExpectedList> runOraculo( ){
		List<OraculoExpectedList> list = new ArrayList<OraculoExpectedList>();
		for (OraculoSettings o:oraculoObject){
			
			ArrayList<String> inputPathParameters = o.getInputsSettings().getPathParameters();
			ArrayList<String> oututPathParameters = o.getOutputsSettings().getPathParameters();
			
			List<HashMap<String,Double>> listInput = reader.read(inputPathParameters);
			List<HashMap<String,Double>> listOutput = reader.read(oututPathParameters);
			
			OraculoExpectedList oel = new OraculoExpectedList(listInput,listOutput);
			list.add(oel);
		}
		return list;
	}
	
}
