# Configuration
Library for working with configs based on Sponge Configurate

# 🛠 Examples

Creating a config
```java
Config config = json ? 
        new JsonConfig(new File("config.json")) :
        new YamlConfig(new File("config.yml"));
```

Setting the values
```java
// Getting the node we need and setting its value
config.node("string").setValue("Test string");
config.nodes("values.list").setValue(List.of(1, 2, 3));
config.nodes("values.map").setValue(Map.of("key", "Value"));

// Saving a config
config.save();
```

Getting the values
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

Alternative config creation
```java
// Config types: YAML, JSON, HOCON or DETECT if you need to create a config by file name
Config config = ConfigType.DETECT.createOf(new File("config.json"));
```