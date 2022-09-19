package ass2.Models;
import ass2.BasicSocialDistanceUtility;

public class InterpolatingModel extends AbstractModel{

	@Override
	public boolean isSafe() {
		return BasicSocialDistanceUtility.isInterpolatedSafe(getDistance(), getDuration(), getExhalationLevel());
	}

}
