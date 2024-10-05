# Configuration
Библиотека для работы с файлами конфигураций на основе Sponge Configurate.

## 📖 Обзор
**Configuration** — это гибкая библиотека на Java для управления различными типами конфигурационных файлов, такими как YAML, JSON и HOCON. Библиотека упрощает процесс создания, изменения и чтения конфигураций с помощью понятного и удобного API.

### ✨ Возможности
- **Поддержка нескольких форматов**: Легкое переключение между форматами YAML, JSON и HOCON.
- **Динамическое управление конфигурациями**: Устанавливайте, изменяйте и извлекайте значения из конфигураций с помощью простого синтаксиса.
- **Автоопределение формата**: Автоматическое определение формата файла по его расширению.

## 🛠 Примеры кода

### Создание конфигурации
```java
Config config = json ? 
        new JsonConfig(new File("config.json")) :
        new YamlConfig(new File("config.yml"));
```

### Установка значений в конфигурацию
```java
// Получаем нужный узел и устанавливаем его значение
config.node("string").setValue("Тестовая строка");
config.nodes("values.list").setValue(List.of(1, 2, 3));
config.nodes("values.map").setValue(Map.of("ключ", "Значение"));

// Сохранение конфигурации
config.save();
```

### Получение значений из конфигурации
```java
// Получаем значения узлов
String string = config.nodes("string").asString();
List<String> listValues = config.nodes("values.list").asList();
Map<String, String> mapValues = config.nodes("values.map").asMap();

// Получение значения узла или значения по умолчанию
String withDefaultValue = config.nodes("value").asString("Значение по умолчанию");

System.out.println(string + ", " + listValues + ", " + mapValues + ", " + withDefaultValue);

// Проверяем, существует ли узел с именем non-existing-node
if (config.nodes("non-existing-node").isNull()) {
    System.out.println("Узел non-existing-node не найден!");
}
```

### Альтернативное создание конфигурации
```java
// Типы конфигураций: YAML, JSON, HOCON или DETECT (для автоопределения формата по названию файла)
Config config = ConfigType.DETECT.createOf(new File("config.json"));
```

## 🔌 Установка

### Установка плагина
Если вы не используете версию API для самостоятельного использования, поместите JAR-файл плагина в папку `plugins` вашего сервера.

### Maven
Добавьте следующий репозиторий и зависимость в ваш `pom.xml`:
```xml
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>

<dependency>
    <groupId>com.github.MEFRREEX</groupId>
    <artifactId>Configuration</artifactId>
    <version>1.0.0</version>
</dependency>
```

### Gradle
Добавьте следующий репозиторий и зависимость в ваш `build.gradle`:
```groovy
repositories {
    mavenCentral()
    maven { url 'https://jitpack.io' }
}

dependencies {
    implementation 'com.github.MEFRREEX:Configuration:1.0.0'
}
```

---

[Переключиться на английский](README.md)
