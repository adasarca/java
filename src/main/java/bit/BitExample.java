/**
 * Created by Ada.Sarca
 * Date: 11/14/2018
 */
package bit;

public class BitExample {

    int bits;

    public BitExample(int bits) {
        this.bits = bits;
    }

    public static void main(String[] args) {
        BitExample bitExample = new BitExample(8);
        int a = 60;
        int b = 13;
        System.out.println("a: " + bitExample.binary(a));
        System.out.println("b: " + bitExample.binary(b));
        System.out.println("a & b: " + bitExample.binary(a & b));
        System.out.println("a | b: " + bitExample.binary(a | b));
        System.out.println("a ^ b: " + bitExample.binary(a ^ b));
        System.out.println("~a: " + bitExample.binary(~a));
        System.out.println("a << 1: " + bitExample.binary(a << 1));
        System.out.println("a >> 1: " + bitExample.binary(a >> 1));
    }

    public String binary(int x) {
        StringBuilder binary = new StringBuilder();
        for (int bitmask = 1 << this.bits - 1; bitmask > 0; bitmask /= 2) {
            int bit = (x & bitmask) > 0 ? 1 : 0;
            binary.append(bit);
        }
        return binary.toString();
    }
}
