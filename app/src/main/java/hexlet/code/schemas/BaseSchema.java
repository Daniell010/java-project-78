package hexlet.code.schemas;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

public abstract class BaseSchema {
    private final List<Predicate> checks = new ArrayList<>();

    protected final void addCheck(Predicate validate) {
        checks.add(validate);
    }

    /**
     * Метод добавляет проверку на null.
     *
     * @return экземпляр класса BaseSchema.
     */
    public BaseSchema required() {
        addCheck(Objects::nonNull);
        return this;
    }
    public final boolean isValid(Object validatedString) {
        return checks.stream()
                .allMatch(sp -> sp.test(validatedString));
    }
}
