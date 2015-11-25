package com.revosoft.web.authentication;

import lombok.extern.slf4j.Slf4j;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.io.FileSystemResourceLoader;
import org.springframework.core.io.ResourceLoader;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

@Configuration
@Slf4j
public class PropertiesConfig {

    @Bean
    public static PropertySourcesPlaceholderConfigurer placeholderConfigurer (ApplicationContext applicationContext) throws IOException {

        PropertySourcesPlaceholderConfigurer placeholderConfigurer =
                new PropertySourcesPlaceholderConfigurer();

        MutablePropertySources propertySources = new MutablePropertySources();

        String propertiesLocationsAsString = System.getProperty("propertyfile.location");
        final Map<String, Object> map = parsePropertyFile(propertiesLocationsAsString);

        Properties properties = new Properties();

        jsonToProperties(map, properties, "");

        PropertiesPropertySource propertiesPropertySource = new PropertiesPropertySource("serviceNameProperties", properties);

        propertySources.addLast(propertiesPropertySource);

        placeholderConfigurer.setPropertySources(propertySources);
        placeholderConfigurer.setIgnoreUnresolvablePlaceholders(true);
        return placeholderConfigurer;

    }

    private static void jsonToProperties(Map<String, Object> jsonValues, Properties properties,
                                         String prefix) {
        for(Map.Entry<String, Object> jsonEntry : jsonValues.entrySet()) {
            final String newPrefix = prefix + (prefix.isEmpty() ? "" : ".") + jsonEntry.getKey();
            final Object value = jsonEntry.getValue();

            if (value == null) {
                log.error("Null value found for property "+newPrefix);
            }
            else if (value instanceof Map) {
                jsonToProperties((Map<String, Object>) value, properties, newPrefix);
            }
            else {
                properties.put(newPrefix, value.toString());
            }
        }
    }

    public static Map<String, Object> parsePropertyFile(final String propertiesFile) throws IOException {

        ObjectMapper mapper = new ObjectMapper();

        ResourceLoader resourceLoader=new FileSystemResourceLoader();
        InputStream inputStream = resourceLoader.getResource(propertiesFile).getInputStream();

        Map<String, Object> jsonValues = null;


        try {
            jsonValues  = mapper.readValue(inputStream, mapper.getTypeFactory().constructMapType(HashMap.class,
                    String.class, Object.class));
        }
        catch (IOException e) {
         log.info(e.getMessage());
        }


        return jsonValues;

    }
}
