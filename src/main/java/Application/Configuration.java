package Application;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import Framework.InputObject;

public class Configuration extends InputObject {

	Double atr1;
	Double atr2;
	Double atr3;
	Double atr4;
	Double atr5;
	Double atr6;
	Double atr7;
	Double atr8;
	
	public List<Configuration> parseListToInputObjects(List<HashMap<String, Double>> inputs) {
		List<Configuration> listInputs = new ArrayList<Configuration>();
		for (HashMap<String,Double> input: inputs){
			Configuration config = new Configuration();
			Set<String> chaves = input.keySet();
			for (String chave : chaves)
			{
				if(chave != null){
					config.setParameter(chave, input.get(chave));
				}				
			}
			listInputs.add(config);
		}
		return listInputs;
	}

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


	@Override
	public String toString() {
		return "Configuration [atr1=" + atr1 + ", atr2=" + atr2 + ", atr3=" + atr3 + ", atr4=" + atr4 + ", atr5=" + atr5
				+ ", atr6=" + atr6 + ", atr7=" + atr7 + ", atr8=" + atr8 + "]";
	}
	
	
}
