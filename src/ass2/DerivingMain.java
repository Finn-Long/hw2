package ass2;

import ass2.Factory.ModelFactory;
import ass2.Models.DerivingModel;

public class DerivingMain{
	public static void main (String [] args) {
		ModelFactory.setSingleton(new DerivingModel());
		MVCSocialDistanceUtil.startSocialDistanceMVC();
	}
}
