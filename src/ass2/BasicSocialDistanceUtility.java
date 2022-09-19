package ass2;

import java.util.ArrayList;

import gradingTools.comp524f20.assignment1.WekaUtil;
import weka.classifiers.Classifier;

import java.util.List;

import ass2.Factory.SocialDistanceClassifierFactory;

public class BasicSocialDistanceUtility {
	
	private static final int[][] safeCombinations = {{13, 30, 30}, {6, 30, 10}, {27, 30, 50}, {13, 15, 50}, {13, 120, 10}, {27, 120, 30}, {6, 15, 30}};
	private static final String TRUE = "true";
	private static final String FALSE = "false";
	private static String resultAttributeName = "safe";
	private static String[] resultValueNames = {TRUE, FALSE};
	private static String[] featureNames = {"distance", "duration", "exhalation"};
	
	
	/**
	If the combination of the method parameters is safe, based on the given data, the
	function returns true. Otherwise, it returns false.
	 */
	public static boolean isGivenSafe(int distance, int duration, int exhalation) {
		for (int i = 0; i < safeCombinations.length; i ++) {
			int[] combination = safeCombinations[i];
			if (distance == combination[0] && duration == combination[1] && exhalation == combination[2]) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 The function interpolates each of the parameters to a value in Table 2, and determines if the
	 interpolated values are safe based on whether they occur in Table 2. If it is distance, then it
	 is interpolated low. In contract, if it's duration or exhalation, then it is interpolated high.
	 */
	public static boolean isInterpolatedSafe(int distance, int duration, int exhalation) {
		int interpolatedDistance = lowInterpolationHelper(distance, 6, 13, 27);
		int interpolatedDuration = highInterpolationHelper(duration, 15, 30, 120);
		int interpolatedExhalation = highInterpolationHelper(exhalation, 10, 30, 50);
		return isGivenSafe(interpolatedDistance, interpolatedDuration, interpolatedExhalation);
	}
	
	/**
	 The function interpolates each of the parameters to a value in Table 2, and determines if the
	 interpolated values are safe based on whether they occur in Table 2.
	 */
	public static boolean isInterpolatedSafe(int distance, int duration) {
		int exhalation = 30;
		return isInterpolatedSafe(distance, duration, exhalation);
	}
	
	/**
	 The function interpolates each of the parameters to a value in Table 2, and determines if the
	 interpolated values are safe based on whether they occur in Table 2.
	 */
	public static boolean isInterpolatedSafe(int distance) {
		int exhalation = 30;
		return isInterpolatedSafe(distance, exhalation);
	}
	
	/**
	 The function returns true if the combination of these three parameters is safer than at least one of
	 the combinations in the table.
	 */
	public static boolean isDerivedSafe(int distance, int duration, int exhalation) {
		for (int i = 0; i < safeCombinations.length; i ++) {
			int ind1 = 0;
			int ind2 = 1;
			int ind3 = 2;
			if (isSaferThan(distance, duration, exhalation, safeCombinations[i][ind1], safeCombinations[i][ind2], safeCombinations[i][ind3])) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 The function prints the (distance, duration, exhalation level, and safety) tuple, using a comma to
	 separate the elements of the 4 tuple.
	 */
	public static void printGeneratedCombinationDerivedSafety(String ways) {
		boolean isSafe = false;
		int[] generatedValues = generateValuesHelper();
		int distance= generatedValues[0];
		int duration = generatedValues[1];
		int exhalation = generatedValues[2];
		if (ways.equals("inferred")) {
			isSafe = isInferredSafe(distance, duration, exhalation);
		}else {
			isSafe = isDerivedSafe(distance, duration, exhalation);
		}
		printHelper(distance, duration, exhalation, isSafe);		
	}
		
	public static void printGeneratedCombinationDerivedSafety() {
		printGeneratedCombinationDerivedSafety("Derived");
	}
	
	public static int[] generateValuesHelper() {
		int maxDistance = 27;
		int maxDuration = 120;
		int maxExhalation = 50;
		double multiplier = 1.2;
		int distance = (int)(Math.random() * maxDistance * multiplier);
		int duration = (int)(Math.random() * maxDuration * multiplier);
		int exhalation = (int)(Math.random() * maxExhalation * multiplier);
		int[] result = {distance, duration, exhalation};
		return result;
	}
	
	/**
	 For each 3-tuple combination in Table 2, the function adds the Boolean true to create a 4-tuple
	 combination and prints the 4-tuple. Also call printGeneratedCombinationDerivedSafety() ten times.
	 */
	public static void printGivenAndGeneratedCombinationsDerivedSafety(String ways) {
		System.out.println("Distance,Duration,Exhalation,IsSafe");
		for (int i = 0; i < safeCombinations.length; i ++) {
			int[] combination = safeCombinations[i];
			printHelper(combination[0], combination[1], combination[2], true);
		}
		System.out.println("----------------");
		int times = 10;
		for (int i = 0; i < times; i ++) {
			printGeneratedCombinationDerivedSafety(ways);
		}
	}
	
	public static void printGivenAndGeneratedCombinationsDerivedSafety() {
		printGivenAndGeneratedCombinationsDerivedSafety("Derived");
	}
	
	/**
	 The function computes a (possibly empty) list of given safe distance and duration
	 pairs that are associated with an interpolation of the exhalation level in Table 2.
	 If it is exhalation, then it is interpolated high.
	 */
	public static List<Integer[]> generateSafeDistancesAndDurations(int exhalation) {
		int interpolatedExhalation = highInterpolationHelper(exhalation, 10, 30, 50);
		ArrayList<Integer[]> result = new ArrayList<Integer[]>();
		for (int i = 0; i < safeCombinations.length; i ++) {
			if (safeCombinations[i][2] == interpolatedExhalation) {
				Integer[] set = new Integer[]{safeCombinations[i][0], safeCombinations[i][1]};
				result.add(set);
			}
		}
		return result;
	}
	
	/**
	 The function uses the method above to determine the list of safe distances and durations for the 
	 passed exhalation-level and prints the passed
	 exhalation level together with the returned list
	 */
	public static void printSafeDistancesAndDurations(int exhalation) {
		List<Integer[]> result = generateSafeDistancesAndDurations(exhalation);
		System.out.print(exhalation + ",[");
		for (int i = 0; i < result.size(); i ++) {
			System.out.print("{");
			Integer[] set = result.get(i);
			for (int index = 0; index < set.length; index ++) {
				System.out.print(set[index]);
				if (index != set.length - 1) {
					System.out.print(",");
				}
			}
			System.out.print("}");
		}
		System.out.print("]");
		System.out.println();
	}
	
	/**
	 The functions formats the input and prints the output.
	 */
	public static void printHelper(int distance, int duration, int exhalation, boolean isSafe) {
		System.out.println(distance + "," + duration + "," + exhalation + "," + isSafe);
	}
	
	/**
	 The function determines and returns whether a given combination is safer than another given combination.
	 */
	public static boolean isSaferThan(int distance1, int duration1, int exhalation1, int distance2, int duration2, int exhalation2) {
		return distance1 >= distance2 && duration1 <= duration2 && exhalation1 <= exhalation2;
	}
	
	/**
	 low interpolation to a sequence of values is either an element of the sequence or zero. If 
	 it id distance, then it is interpolated low.
	 */
	public static int lowInterpolationHelper(int value, int small, int median, int high) {
		int result = 0;
		if (value < small) {
			result = 0;
		}else if (value > small && value < median) {
			result = small;
		}else if (value > median && value < high) {
			result = median;
		}else if (value > high){
			result = high;
		}else {
			result = value;
		}
		return result;
	}
	
	/**
	 high interpolation to a sequence of values is either an element of the sequence or max integer.
	 If it is duration or exhalation, then it is interpolated high.
	 */
	public static int highInterpolationHelper(int value, int small, int median, int high) {
		int result = 0;
		if (value < small) {
			result = small;
		}else if (value > small && value < median) {
			result = median;
		}else if (value > median && value < high) {
			result = high;
		}else if (value > high) {
			result = Integer.MAX_VALUE;
		}else {
			result = value;
		}
		return result;
	}
	
	public static boolean isInferredSafe(int distance, int duration, int exhalation) {
		Classifier classifier = SocialDistanceClassifierFactory.getSingleton();
		double[] anInputFeatureValues = {distance*1.0, duration*1.0, exhalation*1.0};
		String resultString = WekaUtil.predictString(classifier, featureNames, anInputFeatureValues, resultAttributeName, resultValueNames);
		return TRUE.equals(resultString)?true:false;
	}
	
	public static void printGivenAndGeneratedCombinationsInferredSafety() {
		printGivenAndGeneratedCombinationsDerivedSafety("inferred");
	}
	
	public static int compareSafetyComputations() {
		int correct = 0;
		System.out.println("Distance,Duration,Exhalation,Derived,Inferred");
		for (int i = 0; i < 10; i ++) {
			int[] generatedValues = generateValuesHelper();
			int distance = generatedValues[0];
			int duration = generatedValues[1];
			int exhalation = generatedValues[2];
			boolean inferredSafe = isInferredSafe(distance, duration, exhalation);
			boolean derivedSafe = isDerivedSafe(distance, duration, exhalation);
			System.out.println(distance + "," + duration + "," + exhalation + "," + derivedSafe + "," + inferredSafe);
			if (derivedSafe == inferredSafe) {
				correct ++;
			}
		}
		return correct;
	}
}
