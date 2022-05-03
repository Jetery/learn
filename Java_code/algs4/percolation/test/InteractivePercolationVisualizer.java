package test; /******************************************************************************
 *  Compilation:  javac test.InteractivePercolationVisualizer.java
 *  Execution:    java test.InteractivePercolationVisualizer n
 *  Dependencies: test.PercolationVisualizer.java src.Percolation.java
 *                StdDraw.java StdOut.java
 *
 *  This program takes the grid size n as a command-line argument.
 *  Then, the user repeatedly clicks sites to open with the mouse.
 *  After each site is opened, it draws full sites in light blue,
 *  open sites (that aren't full) in white, and blocked sites in black.
 *
 ******************************************************************************/

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import src.Percolation;

public class InteractivePercolationVisualizer {

    public static void main(String[] args) {
        // n-by-n percolation system (read from command-line, default = 10)
        int n = 200;
        if (args.length == 1) n = Integer.parseInt(args[0]);

        // repeatedly open site specified my mouse click and draw resulting system
        StdOut.println(n);

        StdDraw.enableDoubleBuffering();
        Percolation perc = new Percolation(n);
        PercolationVisualizer.draw(perc, n);
        StdDraw.show();



        while (!perc.percolates()) {


            // convert to row i, column j
            int i = StdRandom.uniform(n) + 1;
            int j = StdRandom.uniform(n) + 1;
            while (perc.isOpen(i, j)) {
                i = StdRandom.uniform(n) + 1;
                j = StdRandom.uniform(n) + 1;
            }

            // open site (i, j) provided it's in bounds
            if (i >= 1 && i <= n && j >= 1 && j <= n) {
                if (!perc.isOpen(i, j)) {
                    //StdOut.println(i + " " + j);
                }
                perc.open(i, j);
            }

            // draw n-by-n percolation system
            PercolationVisualizer.draw(perc, n);
            StdDraw.show();

            StdDraw.pause(0);
        }


        // while (true) {
        //
        //     // detected mouse click
        //     if (StdDraw.isMousePressed()) {
        //
        //         // screen coordinates
        //         double x = StdDraw.mouseX();
        //         double y = StdDraw.mouseY();
        //
        //         // convert to row i, column j
        //         int i = (int) (n - Math.floor(y));
        //         int j = (int) (1 + Math.floor(x));
        //
        //         // open site (i, j) provided it's in bounds
        //         if (i >= 1 && i <= n && j >= 1 && j <= n) {
        //             if (!perc.isOpen(i, j)) {
        //                 StdOut.println(i + " " + j);
        //             }
        //             perc.open(i, j);
        //         }
        //
        //         // draw n-by-n percolation system
        //         PercolationVisualizer.draw(perc, n);
        //         StdDraw.show();
        //     }
        //
        //     StdDraw.pause(20);
        // }
    }
}
