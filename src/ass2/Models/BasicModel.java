package ass2.Models;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import ass2.BasicSocialDistanceUtility;

public class BasicModel extends AbstractModel{

	@Override
	public boolean isSafe() {
		return BasicSocialDistanceUtility.isGivenSafe(getDistance(), getDuration(), getExhalationLevel());
	}
}
