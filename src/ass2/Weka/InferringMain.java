package ass2.Weka;

import ass2.MVCSocialDistanceUtil;
import ass2.Factory.ModelFactory;

public class InferringMain {
	public static void main( String [] args) {
		ModelFactory.setSingleton(new InferringModel());
		MVCSocialDistanceUtil.startSocialDistanceMVC();
	}
}
