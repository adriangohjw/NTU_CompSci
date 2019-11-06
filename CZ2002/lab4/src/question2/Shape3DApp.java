package question2;

import java.util.Scanner;

public class Shape3DApp {

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int numShapes = 0;
		int shapeChoice = 0;
		int tempLength, tempWidth, tempHeight, tempBase;
		
		
		System.out.println("Enter number of figures to produce:");
		numShapes = sc.nextInt();
		
		for (int i=0; i<numShapes; i++) {
			shapeChoice = 0;
			System.out.println("...Choose figure  #" + (i+1));
			System.out.println("Enter 1 for Sphere, 2 for Cuboid, 3 for Cube, 4 for Pyramid");
			
			do {
				shapeChoice = sc.nextInt();
				switch(shapeChoice) {
					case 1:
						System.out.println("Sphere chosen");
						System.out.println("...Enter radius");
						Sphere sphere = new Sphere(sc.nextInt());
						System.out.println("Volume is " + sphere.getVolume());
						break;
						
					case 2:
						System.out.println("Cuboid chosen");
						System.out.println("...Enter length");
							tempLength = sc.nextInt();
						System.out.println("...Enter width");
							tempWidth = sc.nextInt();
						System.out.println("...Enter height");
							tempHeight = sc.nextInt();
						Cuboid cuboid = new Cuboid(tempLength, tempWidth, tempHeight);
						System.out.println("Volume is " + cuboid.getVolume());
						break;
						
					case 3:
						System.out.println("Cube chosen");
						System.out.println("...Enter side");
						Cube cube = new Cube(sc.nextInt());
						System.out.println("Volume is " + cube.getVolume());
						break;
						
					case 4:
						System.out.println("Pyramid chosen");
						System.out.println("...Enter height");
							tempHeight = sc.nextInt();
						System.out.println("...Enter base");
							tempBase = sc.nextInt();
						Pyramid pyramid = new Pyramid(tempHeight, tempBase);
						System.out.println("Volume is " + pyramid.getVolume());
						break;
						
					default:
						shapeChoice = 0;
				}
			} while (shapeChoice == 0);			
		}
		
		System.out.println("### Program ended ###");
		System.exit(0);
	}
}
