package Application;
import Framework.InputsSettings;
import Framework.OraculoSettings;
import Framework.OutputsSettings;

public class AppOraculoSettings implements OraculoSettings {
	InputApp inputSettings;
	OutputApp outputSettings;
	
	AppOraculoSettings(InputApp pathInput, OutputApp pathOutput){
		this.inputSettings = pathInput;
		this.outputSettings = pathOutput;
	}
	
	@Override
	public InputsSettings getInputsSettings() {
		return inputSettings;
	}

	@Override
	public OutputsSettings getOutputsSettings() {
		return outputSettings;
	}

}
