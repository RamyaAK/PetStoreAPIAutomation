package properties;

public class BaseProperties {
    public static final String QA_env = System.getProperty("environment", "QA");
    public static final String PROD_env = System.getProperty("environment", "PROD");
    public static final String STAGING_env = System.getProperty("environment", "STAGING");
    public static final String DEV_env = System.getProperty("environment", "DEV");
}