package edu.spbu;

import java.util.function.DoubleUnaryOperator;

/**
 * Created by Миша on 21.11.2017.
 */
public class SecondWay {

    public static void main(int n, double alpha0, double beta0, double alpha1, double beta1, double alpha, double a, double b, DoubleUnaryOperator p, DoubleUnaryOperator q, DoubleUnaryOperator f) {
        double[] y = new double[n + 2];
        double[] y_accuracy = new double[n + 2];
        double[] m = new double[n + 2];
        double[] k = new double[n + 2];
        double A = 1 / alpha;
        double B = 1 / (alpha + 1);
        double h = (b - a) / ((double) n);
        double p1 = (alpha0 * h + 2 * alpha1) / (2 * alpha1 - alpha0 * h);
        double d1 = -2 * A * h / (2 * alpha1  - alpha0 * h);
        double p2 = (2 * beta1 - beta0 * h) / (2 * beta1 + beta0 * h);
        double d2 = 2 * B * h / (2 * beta1 + beta0 * h);

        m[0] = p1;
        k[0] = d1;
        for (int i = 1; i < m.length; i++) {
            m[i] = (1 + (h * p.applyAsDouble(a + i * h - h / 2) / 2)) / (2 - h * h * q.applyAsDouble(a + i * h - h / 2) - m[i - 1] * (1 - h * p.applyAsDouble(a + i * h - h / 2) / 2));
            k[i] = ((1 - h * p.applyAsDouble(a + i * h - h / 2) / 2) * k[i - 1] - h * h * f.applyAsDouble(a + i * h - h / 2)) / (2 - h * h * q.applyAsDouble(a + i * h - h / 2) - m[i - 1] * (1 - h * p.applyAsDouble(a + i * h - h / 2) / 2));
        }
        y[n+1] = (p2 * k[n] + d2) / (1 - p2 * m[n]);
        for (int i = m.length - 2; i >= 0; i--) {
            y[i] = m[i] * y[i + 1] + k[i];
        }
        for (int i = 0; i < y_accuracy.length; i++) {
            y_accuracy[i] = 1 / (alpha + (a + i * h - h / 2) * (a + i * h - h / 2));
        }
        double max = 0;
        double g;
        for (int i = 0; i < y.length; i++) {
            g = Math.abs(y[i] - y_accuracy[i]);
            System.out.println(g);
            if (g > max) max = g;
        }
        System.out.println();
        System.out.println(max);
    }
}
