package ass2;

import java.util.Scanner;

import ass2.Factory.ModelFactory;

public class SocialDistanceController {
	public SocialDistanceController() {
	}
	
	public void processInput() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter data regarding your guest interaction.");
		for (;;) {
			int distance = getNextInt("Distance", scanner);
			if (distance < 0) {
				break;
			}
			int duration = getNextInt("Duration?", scanner);
			if (duration < 0) {
				break;
			}
			int exhalation = getNextInt("Exhalation Level?", scanner);
			if (exhalation < 0) {
				break;
			}
			ModelFactory.getSingleton().setValues(distance, duration, exhalation);
		}
		System.out.println("Quitting");
	}
	
	private int getNextInt(String prompt, Scanner scanner) {
		System.out.println(prompt);
		return scanner.nextInt();
	}
}
