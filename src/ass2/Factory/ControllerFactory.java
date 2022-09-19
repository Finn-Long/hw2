package ass2.Factory;

import ass2.SocialDistanceController;

public class ControllerFactory {
	static SocialDistanceController socialDistanceController;
	
	public static SocialDistanceController getSingleton() {
		if (socialDistanceController == null) {
			socialDistanceController = new SocialDistanceController();
		}
		return socialDistanceController;
	}
	
	public static void setSingleton(SocialDistanceController newController) {
		socialDistanceController = newController;
	}
}
