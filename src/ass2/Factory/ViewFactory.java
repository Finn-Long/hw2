package ass2.Factory;

import ass2.View.GeneralView;
import ass2.View.SocialDistanceView;

public class ViewFactory {
	static GeneralView socialDistanceView;
	
	public static GeneralView getSingleton() {
		if (socialDistanceView == null) {
			socialDistanceView = new SocialDistanceView();
		}
		return socialDistanceView;
	}
	
	public static void setSingleton(GeneralView newView) {
		socialDistanceView = newView;
	}
}
