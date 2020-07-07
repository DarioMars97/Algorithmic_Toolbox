import java.io.*;
import java.util.*;

import static java.lang.Math.*;

public class Closest {

    public static double minDistanceGlobal = 99999.0d;

    public static class DolaPoint{
        long x, y;

        public DolaPoint(long x, long y){
            this.x = x;
            this.y = y;
        }

        public DolaPoint(DolaPoint anotherPoint){
            this.x = anotherPoint.x;
            this.y = anotherPoint.y;
        }

        public void update(DolaPoint anotherPoint){
            this.x = anotherPoint.x;
            this.y = anotherPoint.y;
        }

        public double distance(DolaPoint anotherPoint){
            return Math.sqrt(Math.pow((this.x - anotherPoint.x),2) +
            Math.pow((this.y - anotherPoint.y),2));
        }

        public boolean equals(DolaPoint anotherPoint){
            return this.x == anotherPoint.x && this.y == anotherPoint.y;
        }

        public boolean xLessThan(DolaPoint anotherPoint){
            return this.x < anotherPoint.x;
        }

        public boolean xGreaterThan(DolaPoint anotherPoint){
            return this.x > anotherPoint.x;
        }
    }

    public static int searchAscending(DolaPoint[] arr,int from, int to, long x) {
        while (from <= to) {
            if (arr[from].x < x) {
                from++;
            }else {
                return from==0? 0: from-1;
            }
        }
        return 0;
    }

    public static int searchDescending(DolaPoint[] arr,int from, int to, long x) {
        while (from >= to) {
            if (arr[from].x < x) {
                from--;
            }else {
                return from==0? 0: from+1;
            }
        }
        return from;
    }

    public static double getMinDistance(DolaPoint[] arr) {
        double minDistance = 999999999.0d;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if (arr[i].distance(arr[j]) < minDistance) {
                    minDistance = arr[i].distance(arr[j]);
                }
            }
        }
        return minDistance;
    }

    public static int[] pivotPartition3(DolaPoint[] arr, int left, int right) {
        DolaPoint pivot = new DolaPoint(arr[left]);
        int lessThan = left; 
        int greaterThan = right; 

        for (int i = left; i <= greaterThan; i++) {
            if (arr[i].xLessThan(pivot)) {
                DolaPoint temp = new DolaPoint(arr[lessThan]);
                arr[lessThan].update(arr[i]);
                arr[i].update(temp);

                lessThan++;
            }else if (arr[i].xGreaterThan(pivot)){
                DolaPoint temp = new DolaPoint(arr[greaterThan]);
                arr[greaterThan].update(arr[i]);
                arr[i].update(temp);

                greaterThan--;
                i--; // to not affect our loop from left+1 to greaterThan
            }
        }
        return new int[] {lessThan, greaterThan};
    }

    public static void optimizedTimeAndSpaceQuickSort(DolaPoint[] arr, int left, int right){
        while (left < right) {
            int k = left + ((right - left)/2);

            DolaPoint temp = new DolaPoint(arr[left]);
            arr[left].update(arr[k]);
            arr[left].update(temp);

            int[] pivotPositions = pivotPartition3(arr, left, right);
            optimizedTimeAndSpaceQuickSort(arr, left, pivotPositions[0]-1);
            left = pivotPositions[1]+1;
        }
    }

    public static double minDistance(DolaPoint[] arr){
        if (arr.length < 5) {
            return getMinDistance(arr);
        }

        // first sort the array rescpect to x
        optimizedTimeAndSpaceQuickSort(arr, 0, arr.length-1);

        // second divide into 2 arrays
        DolaPoint[] pointsLeft = Arrays.copyOfRange(arr, 0, arr.length/2);
        DolaPoint[] pointsRight = Arrays.copyOfRange(arr, arr.length/2, arr.length);

        // recursively get the min distance in each part
        double dl = getMinDistance(pointsLeft);
        double dr = getMinDistance(pointsRight);
        double d = dl < dr? dl : dr;

        // min distance in middle strip
        int from = searchAscending(arr, 0, arr.length/2, arr[arr.length/2].x-(int)d-1);
        int to = searchDescending(arr, arr.length-1, arr.length/2, arr[arr.length/2].x+(int)d+1);
        DolaPoint[] PointsMiddlle = Arrays.copyOfRange(arr, from, to);
        double dm = getMinDistance(PointsMiddlle);
        
        return dm < d? dm: d;
    }

    static class Point implements Comparable<Point> {
        long x, y;

        public Point(long x, long y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point o) {
            return o.y == y ? Long.signum(x - o.x) : Long.signum(y - o.y);
        }
    }

    static double minimalDistance(int[] x, int y[]) {
        double ans = Double.POSITIVE_INFINITY;
        //write your code here
        return ans;
    }

    public static void main(String[] args) throws Exception {
        reader = new BufferedReader(new InputStreamReader(System.in));
        writer = new PrintWriter(System.out);
        int n = nextInt();
        int[] x = new int[n];
        int[] y = new int[n];
        // me
        DolaPoint[] dolaPoints = new DolaPoint[n];
        for (int i = 0; i < n; i++) {
            x[i] = nextInt();
            y[i] = nextInt();
            // me
            dolaPoints[i] = new DolaPoint(x[i],y[i]);
        }
        // me
        double minDistance = minDistance(dolaPoints);
        System.out.println(minDistance);
        writer.close();
    }

    static BufferedReader reader;
    static PrintWriter writer;
    static StringTokenizer tok = new StringTokenizer("");


    static String next() {
        while (!tok.hasMoreTokens()) {
            String w = null;
            try {
                w = reader.readLine();
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (w == null)
                return null;
            tok = new StringTokenizer(w);
        }
        return tok.nextToken();
    }

    static int nextInt() {
        return Integer.parseInt(next());
    }
}
