package Geometry;

public class HilbertCurve {
    // <x, y, iter> -> point on hilbert curve
    // <x, y> must in range [0, 2^iter-1]
    int hilbert_curve(int x, int y, int iter) {
        if(iter == 0) { // only has 1 point
            return 1;
        }
        // int axisMax = (1 << iter) -1; // 0, 1, 3
        int axisHalf = 1 << (iter-1); // 1, 2
        // next smaller square's size
        int squareSize = (axisHalf)*(axisHalf);
        //  2th, 3th
        //  1th, 4th
        if(x >= axisHalf) {
            if(y >= axisHalf) { // 3th
                return 2 * squareSize + hilbert_curve(x - axisHalf, y - axisHalf, iter - 1);
            } else { // 4th ***
                int axisMax = axisHalf*2;
                return 3*squareSize + hilbert_curve(axisMax-1-y-axisHalf, axisMax-1-x,iter-1);
            }
        } else {
            if(y>=axisHalf) {// 2th
                return squareSize + hilbert_curve(x, y-axisHalf, iter-1);
            } else { //1th ***
                return hilbert_curve(y, x, iter-1);
            }
        }
    }
}
