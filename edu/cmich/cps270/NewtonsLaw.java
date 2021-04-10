package edu.cmich.cps270;

public class NewtonsLaw {

	public static void main(String[] args) {
		SimNewtonsLawWDifferenceEq(1, 75, 4, -0.4225352113, .1);
	}

	/**
	 * Simulates Newton's Law using a difference equation.
	 *
	 * @param length - the length of the simulation
	 * @param temp_0 - intial temperature
	 * @param temp_e - environment temperature
	 * @param r - heating/cooling rate
	 * @param delta_t - the change in time between each iteration
	 */public static void SimNewtonsLawWDifferenceEq(double length, double temp_0, double temp_e, double r,
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
		for (int i = 0; i <= n; i++) {
			System.out.printf("%.2f %.2f\n", t[i], temp[i]/*, delta_temp[i]*/);
		}
	}
}
	
