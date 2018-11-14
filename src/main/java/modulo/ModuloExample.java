/**
 * Created by Ada.Sarca
 * Date: 11/14/2018
 */
package modulo;

public class ModuloExample {

    private long modulo;

    public ModuloExample(long modulo) {
        this.modulo = modulo;
    }

    public long modulo(long x) {
        return x % this.modulo;
    }

    public long sum(long a, long b) {
        return ((a % this.modulo) + (b % this.modulo)) % this.modulo;
    }

    public long difference(long a, long b) {
        return ((a % this.modulo) - (b % this.modulo)) % this.modulo;
    }

    public long multiplication(long a, long b) {
        return ((a % this.modulo) * (b % this.modulo)) % this.modulo;
    }

    public static void main(String[] args) {
        long a = 5595363569532135132L;
        long b = 1325469874521365125L;

        ModuloExample moduloExample = new ModuloExample(1000000007);
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        System.out.println("a modulo = " + moduloExample.modulo(a));
        System.out.println("b modulo = " + moduloExample.modulo(b));
        System.out.println("a + b modulo = " + moduloExample.sum(a, b));
        System.out.println("a - b modulo = " + moduloExample.difference(a, b));
        System.out.println("a * b modulo = " + moduloExample.multiplication(a, b));
    }
}
