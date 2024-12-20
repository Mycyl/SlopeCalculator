public class LinearEquation {

    private double x1;
    private double x2;
    private double y1;
    private double y2;
 
    public LinearEquation (int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }
 
    public double distance () {
        return roundedToHundredth(Math.sqrt(Math.pow((y2 - y1), 2) + Math.pow((x2 - x1), 2)));
    }

    public double slope () {
        return roundedToHundredth((y2-y1)/(x2-x1));
    }
    // y = mx + b
    public double yIntercept () {
        return roundedToHundredth(y1 - (slope() * x1));
    }
 
    public String equation () {

        double deltaY = y2 - y1;
        double deltaX = x2 - x1;

        String returnStr = "";

        if (deltaY != 0) {

            if (deltaY % deltaX != 0) { // indivisible slope

                if (deltaX < 0) {
                    if (deltaY < 0) {
                        returnStr += "y = " + (int)(-1 * deltaY) + "/" + (int)(-1 * deltaX) + "x";
                    } else {
                        returnStr += "y = -" + (int)deltaY + "/" + (int)(-1 * deltaX) + "x";
                    }
                } else {
                    returnStr += "y = " + (int)deltaY + "/" + (int)deltaX  + "x";
                }
                                
            } else {

                if (deltaY/deltaX != 1) {
                    returnStr += "y = " + (int) (deltaY/deltaX) + "x";
                } else { // slope of 1
                    if (deltaY/deltaX > 0) {
                        returnStr += "y = x";
                    } else {
                        returnStr += "y = -x"; 
                    }
                }
            }

            if (yIntercept() != 0) { // Y intercept
                if (yIntercept() < 0) {
                    returnStr += " - " + yIntercept() * -1;
                } else if (yIntercept() > 0) {
                    returnStr += " + " + yIntercept();
                }
                
            }

        } else { // horizontal line
            returnStr += "y = " + yIntercept();
        }
        return returnStr;

    }
 
    public String coordinateForX (double x) {
        return "(" + x + ", " + (slope() * x + yIntercept()) + ")";
    }
 
    public String lineInfo() {
        String returnStr = "";
        if (x2 - x1 != 0) {
            returnStr += "The two points are: (" + (int)x1 + ", " + (int)y1 + ") and (" + (int)x2 + ", " + (int)y2 + ")";
            returnStr += "\nThe equation of the line between these points is: " + equation();
            returnStr += "\nThe slope of this line is: " + slope();
            returnStr += "\nThe y-intercept of the line is: " + yIntercept();
            returnStr += "\nthe distance between the two points is: " + distance();
        } else {
            returnStr += "These points are on a vertical line: x = " + x1; // vertical line
        }
        return returnStr;
 
    }
 
    private double roundedToHundredth (double toRound) {
        return Math.round(toRound * 100)/100.0;
    }
 }
 