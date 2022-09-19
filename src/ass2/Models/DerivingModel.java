package ass2.Models;
import ass2.BasicSocialDistanceUtility;

public class DerivingModel extends AbstractModel{

	@Override
	public boolean isSafe() {
		return BasicSocialDistanceUtility.isDerivedSafe(getDistance(), getDuration(), getExhalationLevel());
	}

}
