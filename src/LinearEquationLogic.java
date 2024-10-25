import java.util.Scanner;
public class LinearEquationLogic {




    private Scanner scan;
    private String coordinate1;
    private String coordinate2;
    private int x1;
    private int x2;
    private int y1;
    private int y2;




    public LinearEquationLogic () {
        scan = new Scanner(System.in);
    }


    private int parseX (String coordinate) {
        return Integer.parseInt(coordinate.substring(1, coordinate.indexOf(",")));
    }


    private int parseY (String coordinate) {
        return Integer.parseInt(coordinate.substring(coordinate.indexOf(",") + 2, coordinate.length() - 1));
    }


    public void start () {
        double xCoord;
        System.out.println("Welcome to the linear equation calculator!");
        System.out.print("Enter coordinate 1: ");
        coordinate1 = scan.nextLine();
        System.out.print("Enter coordinate 2: ");
        coordinate2 = scan.nextLine();
        x1 = parseX(coordinate1);
        x2 = parseX(coordinate2);
        y1 = parseY(coordinate1);
        y2 = parseY(coordinate2);
        LinearEquation linearEquation = new LinearEquation(x1, y1, x2, y2);
        System.out.println();
        System.out.println(linearEquation.lineInfo());


        if (x2 - x1 != 0) {
            System.out.print("Enter a value for x: ");
            xCoord = scan.nextDouble();
            scan.nextLine();
            System.out.println();
            System.out.println("The point on the line is " + linearEquation.coordinateForX(xCoord));
        }
        System.out.println();
        System.out.print("Would you like to enter another pair of coordinates? y/n: ");
        String yOrNResponse = scan.nextLine();


        while (yOrNResponse.equals("y")) {
            System.out.print("Enter coordinate 1: ");
            coordinate1 = scan.nextLine();
            System.out.print("Enter coordinate 2: ");
            coordinate2 = scan.nextLine();
            x1 = parseX(coordinate1);
            x2 = parseX(coordinate2);
            y1 = parseY(coordinate1);
            y2 = parseY(coordinate2);
            LinearEquation newLinearEquation = new LinearEquation(x1, y1, x2, y2);
            System.out.println();
            System.out.println(newLinearEquation.lineInfo());
            if (x2 - x1 != 0) {
                System.out.print("Enter a value for x: ");
                xCoord = scan.nextDouble();
                scan.nextLine();
                System.out.println();
                System.out.println("The point on the line is " + newLinearEquation.coordinateForX(xCoord));
            }
            System.out.println();
            System.out.print("Would you like to enter another pair of coordinates? y/n: ");
            yOrNResponse = scan.nextLine();
        }
    }




}

