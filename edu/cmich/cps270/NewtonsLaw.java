package edu.cmich.cps270;

/**
 * A class to simulate Newton's Law.
 * 
 * @author stjoh1sr, gupta4a, black9m
 * @since 11 APR 2021
 */

public class NewtonsLaw {

	static double[] tempobject;

	public static void main(String[] args) {
		/*
		 * The rate r for this case was found using the difference equation dT/dt =
		 * r(Temp - Temp_environment).
		 */
		System.out.println("The simulation using difference equation approach");
		SimNewtonsLawWDifferenceEq(2.5, 75, 4, -0.4225352113, .005);

		/*
		 * Using the approach of setting a time large enough to for the bucket to freeze
		 * then using small intervals to get an accurate estimate of when the
		 * temperature hit 32 degrees, we find that it takes about 2.2 hours (132
		 * minutes) for the water in the bucket to freeze.
		 */

		System.out.println("----------------------");

		AnalysticNewtonsLaw(1, 75, 4, -0.4225352113, .1);
	}

	/**
	 * Simulates analytical law using a difference equation.
	 *
	 * @param length  - the length of the simulation
	 * @param temp_0  - intial temperature of the object
	 * @param temp_e  - temperature of the environment
	 * @param r       - heating/cooling rate constant. Positive if heating process,
	 *                and negative if cooling process
	 * @param delta_t - the change in time between each iteration
	 */
	public static void SimNewtonsLawWDifferenceEq(double length, double temp_0, double temp_e, double r,
			double delta_t) {

		int n = (int) Math.ceil(length / delta_t);

		double[] temp = new double[n + 1]; // Array for temperature
		double[] t = new double[n + 1]; // Array for time
		double[] delta_temp = new double[n + 1]; // Array for change in temp.

		temp[0] = temp_0;
		t[0] = 0;

		// Looping through n iterations of temperature change
		for (int i = 1; i <= n; ++i) {
			delta_temp[i] = r * (temp[i - 1] - temp_e) * delta_t;
			temp[i] = temp[i - 1] + delta_temp[i];
			t[i] = t[i - 1] + delta_t;
		}
		// Displaying run results
		System.out.printf("%9s  %9s  \n", "Time(hr)", "Temperature(F)");
		for (int i = 0; i <= n; i++) {
			System.out.printf("%6.2f %10.2f\n", t[i], temp[i]);
		}
		tempobject = temp;
	}

	/**
	 * Simulates Newton's Law using an analytical equation.
	 *
	 * @param length          - the length of the simulation
	 * @param initTemp        - initial temperature of the object
	 * @param envTemp         - temperature of the environment
	 * @param heatingConstant - heating/cooling rate constant. Positive if heating
	 *                        process, and negative if cooling process
	 * @param timeStep        - the change in time between each iteration
	 */
	public static void AnalysticNewtonsLaw(double length, double initTemp, double envTemp, double heatingConstant,
			double timeStep) {
		int n = (int) Math.ceil(length / timeStep);

		double[] tempObject = new double[n + 1];
		double[] t = new double[n + 1];

		tempObject[0] = initTemp;
		t[0] = 0;

		for (int i = 1; i < n + 1; i++) {
			t[i] = t[i - 1] + timeStep;
			tempObject[i] = envTemp + initTemp * Math.exp(heatingConstant * t[i]);

		}

		System.out.printf("%9s  %9s  \n", "Time(hr)", "Temperature(F)");
		for (int i = 0; i < n + 1; i++) {
			System.out.printf("%6.2f %9.2f \n", t[i], tempObject[i]);
		}
		System.out.printf("%9s  %9s  %9s \n", "Newton's", "Analytical", "Difference");
		for (int i = 0; i < n + 1; i++) {
			System.out.printf("%6.2f %9.2f  %9.2f\n", tempobject[i], tempObject[i], tempobject[i] - tempObject[i]);
		}

	}

}