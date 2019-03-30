import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public class Main {
    private static BigDecimal getPrimitiveRootOf(BigDecimal p) {
        for (BigDecimal i = BigDecimal.ZERO; i.compareTo(p) == -1; i = i.add(BigDecimal.ONE)) {
            if (isPrimitiveRootOf(p, i)) {
                return i;
            }
        }
        return BigDecimal.ZERO;
    }

    private static boolean isPrimitiveRootOf(BigDecimal p, BigDecimal q) {
        if (q.compareTo(BigDecimal.ZERO) == 0 || q.compareTo(BigDecimal.ONE) == 0) {
            return false;

        }

        BigDecimal last = BigDecimal.ONE;
        Set<BigDecimal> set = new HashSet<>();

        for (BigDecimal i = BigDecimal.ZERO; i.compareTo(p.subtract(BigDecimal.ONE)) == -1; i = i.add(BigDecimal.ONE)) {
            last = last.multiply(q).remainder(p);

            if (set.contains(last)) {
                return false;
            }

            set.add(last);
        }

        return true;
    }

    public static void main(String[] args) {
        PrimeNumberGenerator generator = new PrimeNumberGenerator(20);
        BigDecimal p = generator.generate();
        BigDecimal q = getPrimitiveRootOf(p);

        User alice = new User("Alice", p, q);
        User bob = new User("Bob", p, q);

        alice.generateX();
        bob.generateX();

        alice.calculateY();
        bob.calculateY();

        alice.swapWith(bob);

        alice.calculateK();
        bob.calculateK();
    }
}
