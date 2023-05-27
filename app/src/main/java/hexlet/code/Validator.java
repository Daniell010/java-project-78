package hexlet.code;

import schema.MapSchema;
import schema.NumberSchema;
import schema.StringSchema;

public final class Validator {
    public StringSchema string() {
        return new StringSchema();
    }

    public NumberSchema number() {
        return new NumberSchema();
    }

    public MapSchema map() {
        return new MapSchema();
    }
}
