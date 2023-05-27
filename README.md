### Hexlet tests and linter status:
[![Actions Status](https://github.com/Daniell010/java-project-78/workflows/hexlet-check/badge.svg)](https://github.com/Daniell010/java-project-78/actions)
<h1>Валидатор данных</h1>

<p>Валидатор данных - это библиотека для проверки корректности любых данных. Такие библиотеки существуют во многих языках программирования, так как большинство программ работает с внешними данными, которые необходимо проверять на корректность. В первую очередь это касается данных из форм, заполняемых пользователями.</p>

<p>Данный проект основан на библиотеке yup.</p>

<h2>Использование</h2>

<p><pre>
Validator v = new Validator();

// строки
StringSchema schema = v.string().required();

schema.isValid("what does the fox say"); // true
schema.isValid(""); // false

// числа
NumberSchema schema = v.number().required().positive();

schema.isValid(-10); // false
schema.isValid(10); // true

// объект Map с поддержкой проверки структуры
Map<String, BaseSchema> schemas = new HashMap<>();
schemas.put("name", v.string().required());
schemas.put("age", v.number().positive());

MapSchema schema = v.map().sizeof(2).shape(schemas);

Map<String, Object> human1 = new HashMap<>();
human1.put("name", "Kolya");
human1.put("age", 100);
schema.isValid(human1); // true

Map<String, Object> human2 = new HashMap<>();
human2.put("name", "");
human2.put("age", null);
schema.isValid(human1); // false
</pre></p>
