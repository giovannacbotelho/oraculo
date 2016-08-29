package Application;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import Framework.OutputObject;

public class Result extends OutputObject {
	Double rwyd1;
	Double rwyd2;
	Double rwyd3;
	Double rwyd4;
	Double rwyd5;
	
	public void setParameter(String parameter, Double value) {
		Class<?> clazz = this.getClass();	
		try {
			String fieldName = parameter.toLowerCase();
			Field field = clazz.getDeclaredField(fieldName);
			field.setAccessible(true);
			field.set(this, value);

		} catch (NoSuchFieldException e) {
			clazz = clazz.getSuperclass();
		} catch (Exception e) {
			throw new IllegalStateException(e);
		}	
	}
	
	public List<Result> parseListToOutputObjects(List<HashMap<String, Double>> outputs) {
		List<Result> listInputs = new ArrayList<Result>();
		for (HashMap<String,Double> output: outputs){
			Result config = new Result();
			Set<String> chaves = output.keySet();
			for (String chave : chaves)
			{
				if(chave != null){
					config.setParameter(chave, output.get(chave));
				}				
			}
			listInputs.add(config);
		}
		return listInputs;
	}

	@Override
	public String toString() {
		return "Result [rwyd1=" + rwyd1 + ", rwyd2=" + rwyd2 + ", rwyd3=" + rwyd3 + ", rwyd4=" + rwyd4 + ", rwyd5="
				+ rwyd5 + "]";
	}
	
	
}
