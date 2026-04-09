package utilitiesopc;

import java.io.InputStream;
import java.util.Properties;

public class Config {

    Properties prop;

    public Config(String filePath) throws Exception {
        prop = new Properties();

        InputStream fis = getClass().getClassLoader().getResourceAsStream(filePath);

        System.out.println("Loading file: " + filePath);
        System.out.println(getClass().getClassLoader().getResource(filePath));
        
        if (fis == null) {
            throw new RuntimeException("File not found: " + filePath);
        }

        prop.load(fis);
    }

    public String get(String key) {
        return prop.getProperty(key);
    }
}

