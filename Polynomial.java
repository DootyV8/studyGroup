

public class Polynomial {
    private final int[] coefficients;

    public Polynomial(int[] coefficients) {
        this.coefficients = coefficients;
    }

    public int[] getCoefficients() {
        return coefficients;
    }

    public Polynomial add(Polynomial other) {
        int maxLength = Math.max(coefficients.length, other.coefficients.length);
        int[] result = new int[maxLength];
        for (int i = 0; i < maxLength; i++) {
            int thisCoefficient = (i < other.coefficients.length) ? coefficients[i] : 0;
            result[i] = thisCoefficient + other.coefficients[i];
        }
        return new Polynomial(result);
    }

    public Polynomial multiply(Polynomial other) {
        int newLength = this.coefficients.length + other.coefficients.length - 1;
        int[] result = new int[newLength];
        for (int i = 0; i < this.coefficients.length; i++) {
            for (int j = 0; j < other.coefficients.length; j++) {
                result[i + j] += this.coefficients[i] * other.coefficients[j];
            }
        }

        return new Polynomial(result);
    }

    public double evaluate(double x) {
        double result = 0;
        for (int i = 0; i < coefficients.length; i++) {
            result += coefficients[i] * Math.pow(x, i);
        }
        return result;
    }

    public Polynomial derivative() {
        if (coefficients.length <= 1) {
            return new Polynomial(new int[]{0}); // Derivative of a constant is 0
        }
        int[] result = new int[coefficients.length - 1];
        for (int i = 1; i < coefficients.length; i++) {
            result[i - 1] = coefficients[i] * i; // Derivative: multiply by the power (i)
        }
        return new Polynomial(result);
    }

}