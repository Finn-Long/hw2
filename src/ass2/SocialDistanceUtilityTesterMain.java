package ass2;

public class SocialDistanceUtilityTesterMain {
	
	public static void main (String[] args) {
		BasicSocialDistanceUtility.printGivenAndGeneratedCombinationsDerivedSafety();
		BasicSocialDistanceUtility.printGivenAndGeneratedCombinationsInferredSafety();
		int medianExhalation = 30;
		BasicSocialDistanceUtility.printSafeDistancesAndDurations(medianExhalation);
		BasicSocialDistanceUtility.printSafeDistancesAndDurations(medianExhalation - 1);
		BasicSocialDistanceUtility.printSafeDistancesAndDurations(medianExhalation + 2);
	}
}

