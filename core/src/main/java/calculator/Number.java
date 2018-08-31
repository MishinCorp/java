package calculator;

//todo
public class Number implements INumber {
    private int i;

    //todo
    public Number(final int i) {
        this.i = i;
    }

    //todo
    @Override
    public void setValue(final int aNumber) {
        this.i = aNumber;
    }

    //todo
    @Override
    public String toStr() {
        return String.valueOf(this.i);
    }
}
