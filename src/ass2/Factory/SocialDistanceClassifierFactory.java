package ass2.Factory;
import gradingTools.comp524f20.assignment1.WekaUtil;
import weka.classifiers.Classifier;
import weka.classifiers.trees.J48;

public class SocialDistanceClassifierFactory {
	static Classifier aClassifier;
	
	public static Classifier getSingleton() {
		if (aClassifier == null) {
			aClassifier = new J48();
		}
		String aWekaFile = "SafeSocialization.txt";
		WekaUtil.buildTreeModel(aClassifier, aWekaFile);
		return aClassifier;
	}
	
	public static void setSingleton(Classifier newClassifier) {
		aClassifier = newClassifier;
	}
}
