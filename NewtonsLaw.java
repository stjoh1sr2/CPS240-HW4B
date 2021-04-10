package edu.cmich.cps270;

public class NewtonsLaw {

	

	public static void main(String[] args) {
		newtonsLaw(1, 75, 4, -1.0/142.0 ,6);

		System.out.println("----------------------");
		
		AnalysticewtonsLaw(1, 75, 4, -1.0/142.0 ,6);
	}

	




	public static double newtonsLaw(double length, double initTemp, double envTemp, double heatingConstatnt, double timeStep) { 
		int n = (int) Math.ceil(length * 60 /timeStep);

		double[] tempObject = new double[n+1];
		double[] t = new double[n+1];
		
		tempObject[0] = initTemp;
		t[0] = 0;
		
		for (int i = 1; i < n+1 ; i++) {
			double delta_t = heatingConstatnt * (tempObject[i-1] - envTemp) * timeStep;
			tempObject[i] = tempObject[i-1] + delta_t;
			t[i] = t[i-1] + timeStep;
		}
		
		System.out.println();
		for (int i = 0; i < n + 1 ; i++) {
			System.out.printf("%9.2f %9.2f \n", t[i] /60, tempObject[i]);
		}
		return tempObject[n];
	}
	
	
	public static double AnalysticewtonsLaw(double length, double initTemp, double envTemp, double heatingConstatnt, double timeStep) { 
		int n = (int) Math.ceil(length * 60 /timeStep);

		double[] tempObject = new double[n+1];
		double[] t = new double[n+1];
		
		tempObject[0] = initTemp;
		t[0] = 0;
		
		for (int i = 1; i < n+1 ; i++) {
			t[i] = t[i-1] + timeStep;
			tempObject[i] = envTemp + initTemp * Math.exp(heatingConstatnt * t[i]);
			
		}
		
		System.out.println();
		for (int i = 0; i < n + 1 ; i++) {
			System.out.printf("%9.2f %9.2f \n", t[i] /60, tempObject[i]);
		}
		return tempObject[n];
	}
	



}
