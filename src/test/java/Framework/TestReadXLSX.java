package Framework;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;


public class TestReadXLSX{

	@Test
	public void testReadXLSX() throws IOException{
		ReadXLSX r =new ReadXLSX();
		List<HashMap<String,Double>> listInput = r.readXMLFile("C://Users//giovanna//Desktop//mestrado_frameworks//GI//framework//inputsTeste.xlsx", "Input");
		String resultInput = "[{ATR7=0.0, ATR8=0.0, ATR5=4.0, ATR6=1.0, ATR3=0.0, ATR4=1500.0, ATR1=0.0, ATR2=9.0E20}, {ATR7=0.0, ATR8=0.0, ATR5=4.0, ATR6=1.0, ATR3=0.0, ATR4=3000.0, ATR1=0.0, ATR2=9.0E20}, {ATR7=0.0, ATR8=0.0, ATR5=4.0, ATR6=1.0, ATR3=0.0, ATR4=3000.0, ATR1=0.0, ATR2=9.0E20}, {ATR7=0.0, ATR8=0.0, ATR5=4.0, ATR6=1.0, ATR3=0.0, ATR4=3000.0, ATR1=0.0, ATR2=9.0E20}]";
		Assert.assertEquals(resultInput, listInput.toString());

		List<HashMap<String,Double>> listOutput = r.readXMLFile("C://Users//giovanna//Desktop//mestrado_frameworks//GI//framework//inputsTeste.xlsx", "Output");
		String resultOutput = "[{RWYD(03)=1500.0, RWYD(02)=0.0, RWYD(05)=1500.0, RWYD(04)=1500.0, RWYD(01)=5000.0}, {RWYD(03)=3000.0, RWYD(02)=0.0, RWYD(05)=3000.0, RWYD(04)=3000.0, RWYD(01)=5000.0}, {RWYD(03)=3000.0, RWYD(02)=0.0, RWYD(05)=3000.0, RWYD(04)=3000.0, RWYD(01)=5000.0}, {RWYD(03)=3000.0, RWYD(02)=0.0, RWYD(05)=3000.0, RWYD(04)=3000.0, RWYD(01)=5000.0}]";
		Assert.assertEquals(resultOutput, listOutput.toString());
	}
}
