package Framework;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public interface Reader {
	public List<HashMap<String,Double>> read(ArrayList<String> parameters);
}
