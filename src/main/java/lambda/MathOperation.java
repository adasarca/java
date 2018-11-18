package lambda;

public interface MathOperation<T> {
    T calculate(T a, T b);
}
