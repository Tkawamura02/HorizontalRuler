public class HorizontalRuler {
   private static void drawLine(int depth, int majorLength) {
    if (majorLength >= 1) {
        drawLine(depth, majorLength - 1);
    }  
    if (depth <= majorLength) {
        System.out.print("|");
    } else {
        System.out.print(" ");
    }
    if (majorLength >= 1) {
        drawLine(depth, majorLength - 1);
    }
}

private static void drawInterval(int depth, int majorLength) {
    if (majorLength >= depth) {
        System.out.print("|");
    } 
}

private static void drawMajor(int nInches, int depth, int majorLength) {
    drawInterval(depth, majorLength);
    for (int j = 1; j <= nInches; j++) {
        drawLine(depth, majorLength - 1);
        drawInterval(depth, majorLength);
    }
}

private static void drawRuler(int nInches, int majorLength) {
    for (int i = majorLength-1; i >= 0; i--) {
        drawMajor(nInches, i, majorLength);
        System.out.println();
        
    }
    System.out.print("0");
    for (int i = 1; i<=nInches; i++) {
		if(nInches==3) {System.out.print("       "+i);}
		if(nInches==2) {System.out.print("               "+i);}
		if(nInches==1) {System.out.print("                               "+i);}
	}
}

public static void main(String[] args) {
	System.out.print("Horizontal Ruler - Tiffany Kawamura");
    System.out.print("\n\nRuler of length 2 with major tick length 4\n");
	drawRuler(2, 4);
	System.out.print("\n\nRuler of length 1 with major tick length 5\n");
	drawRuler(1, 5);
	System.out.print("\n\nRuler of length 3 with major tick length 3\n");
	drawRuler(3, 3);
	}
}