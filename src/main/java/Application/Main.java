package Application;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.Assert;

import Framework.InputsSettings;
import Framework.Oraculo;
import Framework.OraculoExpectedList;
import Framework.OraculoSettings;
import Framework.OutputsSettings;

public class Main {
	 public static void main(String[] args) {
	
	InputApp input1 = new InputApp("C://Users//giovanna//Desktop//mestrado_frameworks//GI//framework//inputsTeste.xlsx", "Input");
	OutputApp output1 = new OutputApp("C://Users//giovanna//Desktop//mestrado_frameworks//GI//framework//inputsTeste.xlsx", "Output");
	OraculoSettings initialSettings = new AppOraculoSettings(input1, output1);
	ArrayList<OraculoSettings> aos = new ArrayList<OraculoSettings>();
	aos.add(initialSettings);
	Oraculo o = new Oraculo().createOraculo().withReaderXLSX();
	o.setOraculoSettings(aos);
	
	List<OraculoExpectedList> list = o.runOraculo();
	
	for(OraculoExpectedList oe:list){
		System.out.println("Lista I"+oe.getListInput().toString());
		System.out.println("Lista O"+oe.getListOutput().toString());
	}
	System.out.println("Size"+list.size() +list.toString());
	
	List<AppExpectedResult> listAER = new ArrayList<AppExpectedResult>();
	
	for (OraculoExpectedList l : list){
		AppExpectedResult aer = new AppExpectedResult();
		List<Configuration> listConfiguration = new ArrayList<Configuration>();
		List<Result> listResult = new ArrayList<Result>();
		Configuration c = new Configuration();
		Result r = new Result();
		listConfiguration = c.parseListToInputObjects(l.getListInput());
		listResult = r.parseListToOutputObjects(l.getListOutput());
		aer.listConfiguration = listConfiguration;
		aer.listResult = listResult;
		listAER.add(aer);	
	}
	
	for(AppExpectedResult ae:listAER){
		System.out.println("Lista Configs");
		for(Configuration c:ae.listConfiguration){
			System.out.println("config:"+c.toString());
		}
		for(Result r:ae.listResult){
			System.out.println("result:"+r.toString());
		}
	}
	
	System.out.println("fim");
	

	 }
}
