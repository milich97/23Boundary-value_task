package edu.spbu;

import java.util.function.DoubleUnaryOperator;

/**
 * Created by Миша on 21.11.2017.
 */
public class Main {
    public static void main(String[] args) {
        int n = 10;
        double alpha = 0.1 - 4;
        int a = 0;
        int b = 1;
        int alpha0 = 1, beta0 = 1, alpha1 = -2, beta1 = 0;

        DoubleUnaryOperator p = x -> -(x * x + alpha);
        DoubleUnaryOperator q = x -> -2 * x;
        DoubleUnaryOperator f = x -> 2 * (3 * x * x - alpha) / Math.pow(x * x + alpha, 3);

        FirstWay.main(n,alpha0,beta0,alpha1,beta1,alpha,a,b,p,q,f);
        SecondWay.main(n,alpha0,beta0,alpha1,beta1,alpha,a,b,p,q,f);




    }
}
