package hexlet.code;

import org.junit.jupiter.api.Test;
import hexlet.code.schemas.BaseSchema;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class MapValidatorTest {

    @Test
    public void testRequired() {
        var schema = new Validator().map();
        assertThat(schema.isValid(null)).isTrue();

        schema.required();
        assertThat(schema.isValid(null)).isFalse();
        assertThat(schema.isValid(new HashMap())).isTrue();
    }

    @Test
    public void testSizeof() {
        var schema = new Validator().map().sizeof(2);

        assertThat(schema.isValid(Map.of("1", "1", "2", "2"))).isTrue();

        assertThat(schema.isValid(Map.of("1", "1"))).isFalse();
    }

    @Test
    public void shapeTest() {
        var schema = new Validator().map();

        Map<String, BaseSchema> schemas = new HashMap<>();
        schemas.put("name", new Validator().string().required());
        schemas.put("age", new Validator().number().positive());
        schema.shape(schemas);

        Map<String, Object> human1 = Map.of(
                "name", "Kolya",
                "age", 100
        );
        assertThat(schema.isValid(human1)).isTrue();

        Map<String, Object> human2 = new HashMap<>();
        human2.put("name", "Kolya");
        human2.put("age", null);
        assertThat(schema.isValid(human2)).isTrue();

        Map<String, Object> human3 = Map.of(
                "name", "",
                "age", 100
        );
        assertThat(schema.isValid(human3)).isFalse();

        Map<String, Object> human4 = Map.of(
                "name", "Valya",
                "age", -5
        );
        assertThat(schema.isValid(human4)).isFalse();
    }
}
