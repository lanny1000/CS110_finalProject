import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Scanner;

public class DataAnalysis4 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		boolean cholesterol = false;
		boolean smoke = false;
		String response = null;
		String units = null;
		String category = null;
		double bmi = 0;
		float weight = 0;
		float height = 0;
		DecimalFormat rnd = new DecimalFormat("#.##");
		rnd.setRoundingMode(RoundingMode.CEILING);
		
		System.out.println("Do you smoke? (respond with: yes or no)");
		response = in.nextLine();
		if (response.equalsIgnoreCase("yes")) {
			smoke = true;
		}
		else if (response.equalsIgnoreCase("no")) {
			smoke = false;
		}
		
		System.out.println("Does your family have a history of high cholesterol? (respond with: yes or no)");
		response = in.nextLine();
		if (response.equalsIgnoreCase("yes")) {
			cholesterol = true;
		}
		else if (response.equalsIgnoreCase("no")) {
			cholesterol = false;
		}
		
		System.out.println("Would you like to input [m]etric or [i]mperial units? (respond with the letter: m or i)");
		units = in.nextLine();
		
		if (units.equalsIgnoreCase("m")) {
			System.out.println("What is your weight in kilograms?");
			weight = in.nextFloat();

			System.out.println("What is your height in meters?");
			height = in.nextFloat();
		}
		
		else if (units.equalsIgnoreCase("i")) {
			System.out.println("What is your weight in pounds?");
			weight = in.nextFloat();

			System.out.println("What is your height in inches?");
			height = in.nextFloat();
		}
		
		bmi = calcBmi(units, weight, height);
		
		category = evaluateBmi(bmi);
		
		if (category.equals("normal weight")) {
			System.out.println("Your bmi is: " + rnd.format(bmi) + "." + " You have a " + category + ".");
		}
		
		else {
			System.out.println("Your bmi is: " + rnd.format(bmi) + "." + " You are " + category + ".");
		}
		
		analyzeData(smoke, cholesterol, bmi);
		
		in.close();
	}
	
	public static double calcBmi(String units, float weight, float height) {
		double bmi = 0;
		
		if (units.equalsIgnoreCase("m")) {
			bmi = (weight)/(Math.pow(height, 2));
		}
		else if (units.equalsIgnoreCase("i")) {
			bmi = (weight)/(Math.pow(height, 2)) * 703;
		}
		
		return bmi;
		
	}
	
	public static String evaluateBmi(double bmi) {
		String category = null;
		
		if (bmi <= 18.5f) {
			category = "underweight";
		}
		else if (bmi > 18.5f && bmi <= 24.9f) {
			category = "normal weight";
		}
		else if (bmi >= 25f && bmi <= 29.9f) {
			category = "overweight";
		}
		else {
			category = "obese";
		}
		return category;
	}
	
	public static void analyzeData(boolean smoke, boolean cholesterol, double bmi) {
		if (smoke == true && cholesterol == false && bmi <= 18.5) {
			System.out.println("According to the Centers for Disease Control (CDC), smoking "
					+ "can lead to coronary heart disease, among numerous other significant "
					+ "health complications. Visit: https://www.cdc.gov, for more resources.");
		}
	}
}