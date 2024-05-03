package com.mefrreex.config;

import com.mefrreex.config.utils.FileUtils;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public enum ConfigType {
    DETECT,
    YAML,
    JSON,
    HOCON;

    public static final Map<String, ConfigType> EXTENSIONS = new HashMap<>();

    static {
        EXTENSIONS.put("yaml", YAML);
        EXTENSIONS.put("yml", YAML);
        EXTENSIONS.put("json", JSON);
        EXTENSIONS.put("conf", HOCON);
    }

    public Config createOf(String fileName) {
        return createOf(new File(fileName));
    }

    public Config createOf(File file) {
        String extension = FileUtils.getExtension(file).toLowerCase();

        ConfigType type = this;
        if (this == DETECT && EXTENSIONS.containsKey(extension)) {
            if (EXTENSIONS.containsKey(extension)) {
                type = EXTENSIONS.get(extension);
            } else {
                throw new RuntimeException("This type of config is not supported");
            }
        }

        return switch (type) {
            case YAML -> new YamlConfig(file);
            case JSON -> new JsonConfig(file);
            case HOCON -> new HoconConfig(file);
            default -> throw new RuntimeException("This type of config is not supported");
        };
    }
}
