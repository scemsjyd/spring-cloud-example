package com.scemsjyd.springcloudexample.apollo;


import com.ctrip.framework.apollo.Config;
import com.ctrip.framework.apollo.ConfigService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class ConfigTest implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {
        //config instance is singleton for each namespace and is never null
        Config config = ConfigService.getAppConfig();
        String someKey = "name";
        String someDefaultValue = "default value";
        String value = config.getProperty(someKey, someDefaultValue);
        System.out.println(value);
    }
}
