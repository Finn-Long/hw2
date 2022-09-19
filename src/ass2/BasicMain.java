package ass2;

import ass2.Factory.ModelFactory;
import ass2.Models.BasicModel;

public class BasicMain {
	public static void main (String [] args) {
		ModelFactory.setSingleton(new BasicModel());
		MVCSocialDistanceUtil.startSocialDistanceMVC();
	}
}
