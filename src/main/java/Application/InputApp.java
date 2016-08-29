package Application;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import Framework.InputObject;
import Framework.InputsSettings;

public class InputApp implements InputsSettings {
	String xlsxPath;
	String sheetName;

	public InputApp(String xlsxPath, String sheetName) {
		super();
		this.xlsxPath = xlsxPath;
		this.sheetName = sheetName;
	}

	@Override
	public ArrayList<String> getPathParameters() {
		ArrayList<String> parameters = new ArrayList<String>();
		parameters.add(xlsxPath);
		parameters.add(sheetName);
		return parameters;
	}
}
