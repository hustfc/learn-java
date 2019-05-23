package leetcode;

public class Solution {
    public double myPow(double x, int n) {
        double res = 1.0;
        for(int i = n; i != 0; i = i / 2) {
            if(i % 2 != 0){
                res = res * x;
            }

        }
    }
}
