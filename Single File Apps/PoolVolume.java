import java.io.*;
import java.util.*;

//or not so simple...
public class PoolVolume {

	public static Map<String,String> mPoolMenu = new HashMap<>();
	public static List<String> stringsToPrint = new ArrayList<>();
	public static BufferedReader mReader = new BufferedReader(new InputStreamReader(System.in));
	public static final double GALLONSPERCUFOOT = 7.5;

	public static void main(String args[]) {

		runPoolVolume();

	}

	public static void createPoolMenu(){
		mPoolMenu.put("Rectangular","enter rectangular if you have a rectangular pool & want the volume.");
		mPoolMenu.put("Circular","enter circular if you have a circular pool & want the volume.");
		mPoolMenu.put("Quit","quit the pogram.");
	}//close createPoolMenu

	public static String promptAction()throws IOException{
		String choice = "";
		System.out.println("Your options are: ");
		for (Map.Entry<String,String> option : mPoolMenu.entrySet()) {
			System.out.printf("%s, %s%n",option.getKey(), option.getValue());
		}
		choice = mReader.readLine();
		System.out.printf("You entered:  %s%n%n",choice);

		return choice.toLowerCase().trim();
	}//close promptAction

	public static void rectangular()throws IOException {
			double length;
			double width;
			double depth;
			double lengthFt;
			double widthFt;
			double depthFt;
			double volumeCft;
			double volumeGal;
			System.out.println("Please enter the length (in inches) of your pool:  ");
				length = Double.parseDouble(mReader.readLine());
			System.out.printf("You entered:  %.2f%n",length);
			System.out.println("Please enter the width (in inches) of your pool:  ");
				width = Double.parseDouble(mReader.readLine());
			System.out.printf("You entered:  %.2f%n",width);
			System.out.println("Please enter the depth (in inches) of your pool:  ");
				depth = Double.parseDouble(mReader.readLine());
			System.out.printf("You entered:  %.2f%n",depth);
			lengthFt = length/12;
			widthFt = width/12;
			depthFt = depth/12;
			volumeCft = lengthFt * widthFt * depthFt;
			volumeGal = volumeCft*GALLONSPERCUFOOT;
			System.out.printf("The pool volume is : %.2f Cubic Feet.%n",volumeCft);
			System.out.printf("Thats %.2f gallons.%n%n",volumeGal);

	}//close rectangular
	public static void circular()throws IOException {
		//V=pr2h
		double diameter;
		double radius;
		double depth;
		final double pi = 3.14;
		double volume;
		System.out.println("Please enter the diameter (in inches) of your pool:  ");
				diameter = Double.parseDouble(mReader.readLine());
				radius = (diameter/12)/2;
		System.out.printf("You entered:  %.2f%n",diameter);
		System.out.println("Please enter the depth (in inches) of your pool:  ");
						depth = Double.parseDouble(mReader.readLine());
		System.out.printf("You entered:  %.2f%n",depth);
		volume = pi*(radius*radius)*(depth/12);
		System.out.printf("The pool volume is : %.2f Cubic Feet.%n",volume);
		System.out.printf("Thats %.2f gallons.%n%n",volume*GALLONSPERCUFOOT);
	}//close circular


	public static void runPoolVolume() {
		createPoolMenu();
		String choice = "";
		do {
			try {
				choice = promptAction();
				switch (choice) {
					case "rectangular":
							rectangular();
						break;
					case "circular":
							circular();
						break;
					case "quit":
						choice = "quit";
						break;
					default:
						System.out.println("Unknown entry..");
						break;
				}


			} catch(IOException ioe){
					System.out.println("IOException");
			  }

		}while (!choice.equals("quit"));

	}//close runPoolVolume


}