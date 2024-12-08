import java.util.Arrays;
import java.util.Scanner;
import java.math.*;

import static java.lang.Math.sqrt;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double x0 = scanner.nextDouble();
        double y0 = scanner.nextDouble();
        double[][] xy = {
                {x0},
                {y0}
        };
        double prov = 100000;
        while (prov > 0.0001){
            double[][] a = new double[2][1];
            double[][] b = new double[2][2];
            a[0][0] = xy[0][0] * xy[0][0] * xy[0][0] - xy[1][0] * xy[1][0] - 1;
            a[1][0] = xy[0][0] * (xy[1][0] * xy[1][0] * xy[1][0]) - xy[1][0] - 4;
            b[0][0] = 3 * (xy[0][0] * xy[0][0]);
            b[1][0] = 1;
            b[0][1] = 2 * (xy[1][0]);
            b[1][1] = 3 * (xy[1][0] * xy[1][0]) - 1;
            double opred = b[0][0] * b[1][1] - b[1][0] * b[0][1];
            double[][] c = new double[2][2];
            c[0][0] = (1/opred) * b[1][1];
            c[1][1] = (1/opred) * b[0][0];
            c[1][0] = (1/opred) * -b[0][1];
            c[0][1] = (1/opred) * -b[1][0];
            double[][] xyn = new double[2][1];
            xyn[0][0] = xy[0][0] - (c[0][0] * a[0][0] + c[0][1] * a[1][0]);
            xyn[1][0] = xy[1][0] - (c[1][0] * a[0][0] + c[1][1] * a[1][0]);
            System.out.println(Arrays.deepToString(xyn));
            prov = sqrt(((xyn[0][0]-xy[0][0])*(xyn[0][0]-xy[0][0])) + ((xyn[1][0]-xy[1][0])*(xyn[1][0]-xy[1][0])));
            System.out.println(prov);
            xy[0][0] = xyn[0][0];
            xy[1][0] = xyn[1][0];
        }
    }

}