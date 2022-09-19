package ass2.Weka;

import ass2.BasicSocialDistanceUtility;
import ass2.Factory.SocialDistanceClassifierFactory;
import ass2.Models.AbstractModel;
import weka.classifiers.Classifier;
import gradingTools.comp524f20.assignment1.WekaUtil;

public class InferringModel extends AbstractModel{

	@Override
	public boolean isSafe() {
		return BasicSocialDistanceUtility.isInferredSafe(getDistance(), getDuration(), getExhalationLevel());
	}
}
