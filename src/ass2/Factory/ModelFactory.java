package ass2.Factory;

import ass2.Models.AbstractModel;
import ass2.Models.BasicModel;
import ass2.Models.SafeModel;

public class ModelFactory {
	static SafeModel model;
	
	public static SafeModel getSingleton() {
		if (model == null) {
			model = new BasicModel();
		}
		return model;
	}
	
	public static void setSingleton(SafeModel newModel) {
		model = newModel;
	}
}
