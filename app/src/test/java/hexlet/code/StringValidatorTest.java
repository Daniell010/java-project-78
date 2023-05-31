package hexlet.code;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class StringValidatorTest {

    @Test
    public void testRequired() {
        var schema = new Validator().string();
        assertThat(schema.isValid(null)).isTrue();
        assertThat(schema.isValid("")).isTrue();

        schema.required();

        assertThat(schema.isValid(null)).isFalse();
        assertThat(schema.isValid("")).isFalse();
        assertThat(schema.isValid("test")).isTrue();
    }

    @Test
    public void testMinLength() {
        var schema = new Validator().string().minLength(3);
        assertThat(schema.isValid("12")).isFalse();
        assertThat(schema.isValid("123")).isTrue();
    }

    @Test
    public void testContains() {
        var schema = new Validator().string().contains("test");
        assertThat(schema.isValid("adasdteast")).isFalse();
        assertThat(schema.isValid("123test231")).isTrue();
    }
}
