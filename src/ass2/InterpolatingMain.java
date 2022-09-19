package ass2;

import ass2.Factory.ModelFactory;
import ass2.Models.InterpolatingModel;

public class InterpolatingMain {
	public static void main (String [] args) {
		ModelFactory.setSingleton(new InterpolatingModel());
		MVCSocialDistanceUtil.startSocialDistanceMVC();
	}
}
