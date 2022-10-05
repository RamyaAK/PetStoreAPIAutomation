package properties;

import org.testng.Reporter;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesReader {
    public Properties properties;

    public PropertiesReader() {
        properties = new Properties();
        String environment = BaseProperties.QA_env;

        Reporter.log("ENVIRONMENT: " + BaseProperties.QA_env, true);

        String propertiesFilePath = environment + ".properties";
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(propertiesFilePath);

        try {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Execution Started on " + environment + " environment!");
    }

    public String getBaseURL() {
        return properties.getProperty("url");
    }
}
