import java.math.BigDecimal;
import java.util.Random;

class User {
    private String name;
    private BigDecimal q;
    private BigDecimal p;
    private int x;
    private BigDecimal y;
    private BigDecimal otherY;

    User(String name, BigDecimal p, BigDecimal q) {
        this.name = name;
        this.p = p;
        this.q = q;
    }

    private BigDecimal getY() {
        return y;
    }

    private void setOtherY(BigDecimal otherY) {
        this.otherY = otherY;
    }

    private String getName() {
        return name;
    }

    void generateX() {
        x = new Random().nextInt(p.intValue());
        System.out.println(name + " generated a random number");
    }

    void calculateY() {
        y = q.pow(x).remainder(p);
        System.out.println(name + " calculated an Y = " + y);
    }

    void swapWith(User otherUser) {
        otherUser.setOtherY(y);
        otherY = otherUser.getY();
        System.out.println(name + " and " + otherUser.getName() + " swapped their calculated values");
    }

    void calculateK() {
        BigDecimal k = otherY.pow(x).remainder(p);
        System.out.println(name + "'s key is " + k);
    }
}
