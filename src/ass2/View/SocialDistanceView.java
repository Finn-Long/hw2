package ass2.View;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import ass2.Models.SafeModel;

public class SocialDistanceView implements GeneralView{
	public SocialDistanceView() {		
	}
	
	@Override
	public void propertyChange(PropertyChangeEvent event) {
		System.out.println(event);
		if (SafeModel.SAFE == event.getPropertyName()) {
			Boolean isSafe = (Boolean) event.getNewValue();
			System.out.println(String.format(isSafe ? "Safe." : "Not Safe!"));
		}
	}
}
