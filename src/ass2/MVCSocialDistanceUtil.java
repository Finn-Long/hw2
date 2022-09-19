package ass2;

import ass2.Factory.ControllerFactory;
import ass2.Factory.ModelFactory;
import ass2.Factory.ViewFactory;

public class MVCSocialDistanceUtil {
	public static void startSocialDistanceMVC() {
		ModelFactory.getSingleton().addPropertyChangeListener(ViewFactory.getSingleton());
		ControllerFactory.getSingleton().processInput();
	}
}
