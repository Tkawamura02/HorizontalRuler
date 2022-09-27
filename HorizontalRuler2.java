public class HorizontalRuler2 {
    public static void drawRuler(int nInches, int majorLength) {
        // majorLength is the "depth" of the ruler, aka how many lines down it goes
        for (int j = 0; j < majorLength; j++) {
            drawLine(majorLength, majorLength);// draw inch j line and label

            // repeat process for every inch
            for (int i = 1; i <= nInches; i++) {
                drawInterval(majorLength - 1, majorLength - j); // draw interior ticks for inch
                drawLine(majorLength, majorLength); // draw inch j line and label
            }
            System.out.println();
        }

        // Print ruler labels
        drawLine(majorLength, 0, majorLength);
        for (int i = 1; i <= nInches; i++) {
            drawInterval(majorLength - 1, majorLength + 1); // draw interior ticks for inch
            drawLine(majorLength, i, majorLength);
        }
    }

    private static void drawInterval(int centralLength, int depth) {
        if (centralLength >= 1) { // otherwise, do nothing
            drawInterval(centralLength - 1, depth); // recursively draw top interval
            drawLine(centralLength, depth); // draw center tick line (without label)
            drawInterval(centralLength - 1, depth); // recursively draw bottom interval
        }
    }

    private static void drawLine(int tickLength, int tickLabel, int depth) {
        if (tickLabel >= 0) {
            System.out.print(tickLabel);
        }
        else if (tickLength >= depth)
            System.out.print("|");
        else System.out.print(" ");
    }

    private static void drawLine(int tickLength, int depth) {
        drawLine(tickLength, -1, depth);
    }

    public static void main(String[] args) {
        System.out.print("RJ Spraggins \nHorizontal English Ruler: ");
        System.out.print("\n\nRuler of length 2 with major tick length 4\n");
        drawRuler(2, 4);
        System.out.print("\n\nRuler of length 1 with major tick length 5\n");
        drawRuler(1, 5);
        System.out.print("\n\nRuler of length 3 with major tick length 3\n");
        drawRuler(3, 3);
        System.out.print("\n\nRuler of length 4 with major tick length 2 \n");
        drawRuler(4, 2);
        System.out.print("\n\nRuler of length 8 with major tick length 3 \n");
        drawRuler(8, 3);
        System.out.print("\n\nRuler of length 10 with major tick length 7 \n");
        drawRuler(10, 7);
    }

}