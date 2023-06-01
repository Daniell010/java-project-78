package hexlet.code.schemas;

public final class NumberSchema extends BaseSchema {

    public NumberSchema() {
        super.addCheck(n -> n == null || n instanceof Integer);
    }

    public NumberSchema positive() {
        addCheck(n -> n == null || ((int) n) > 0);
        return this;
    }

    public NumberSchema range(int leftBorder, int rightBorder) {
        addCheck(n -> n == null || (((int) n) >= leftBorder && ((int) n) <= rightBorder));
        return this;
    }
}
