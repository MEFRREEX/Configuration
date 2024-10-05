# Configuration
A library for working with configuration files based on Sponge Configurate.

## 📖 Overview
**Configuration** is a flexible Java library for managing various types of configuration files, such as YAML, JSON, and HOCON. This library simplifies the process of creating, modifying, and reading configuration files with a clear and intuitive API.

### ✨ Features
- **Multiple Formats Support**: Easily switch between YAML, JSON, and HOCON formats.
- **Dynamic Configuration Handling**: Set, modify, and retrieve values from configurations with a clean syntax.
- **Auto-Detection**: Automatically detects the file format based on the extension.

## 🛠 Code Examples

### Creating a Configuration
```java
Config config = json ? 
        new JsonConfig(new File("config.json")) :
        new YamlConfig(new File("config.yml"));
```

### Setting Values in the Config
```java
// Getting the node we need and setting its value
config.node("string").setValue("Test string");
config.nodes("values.list").setValue(List.of(1, 2, 3));
config.nodes("values.map").setValue(Map.of("key", "Value"));

// Saving the config
config.save();
```

### Getting Values from the Config
```java
// Getting node values
String string = config.nodes("string").asString();
List<String> listValues = config.nodes("values.list").asList();
Map<String, String> mapValues = config.nodes("values.map").asMap();

// Getting node or default value
String withDefaultValue = config.nodes("value").asString("Default Value");

System.out.println(string + ", " + listValues + ", " + mapValues + ", " + withDefaultValue);

// Check if there is a node named non-existing-node
if (config.nodes("non-existing-node").isNull()) {
    System.out.println("Node non-existing-node not found!");
}
```

### Alternative Configuration Creation
```java
// Config types: YAML, JSON, HOCON, or DETECT (to auto-detect format by file name)
Config config = ConfigType.DETECT.createOf(new File("config.json"));
```

## 🔌 Installation

### Plugin Setup
If you're not using the standalone API version, place the appropriate plugin JAR in your server's `plugins` folder.

### Maven
Add the following repository and dependency to your `pom.xml`:
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
Add the following repository and dependency to your `build.gradle`:
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

[Switch to Russian](README_ru.md)