package com.hazelcast.demo.config;

import com.hazelcast.config.Config;
import com.hazelcast.config.EvictionPolicy;
import com.hazelcast.config.MapConfig;
import com.hazelcast.config.MaxSizeConfig;
import com.hazelcast.config.MaxSizeConfig.MaxSizePolicy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HazelcastConfig {

    public static final String CONFIGURATION_NAME = "test-configuration";

    private static final String INSTANCE_NAME = "test-instance";
    private static final int TIME_TO_LIVE_SECONDS = 30;
    private static final int MAX_CONFIG_SIZE = 200;

    @Bean
    public Config config() {
        final Config config = new Config();
        config.setInstanceName(INSTANCE_NAME)
                .addMapConfig(new MapConfig()
                        .setName(CONFIGURATION_NAME)
                        .setMaxSizeConfig(new MaxSizeConfig(MAX_CONFIG_SIZE, MaxSizePolicy.FREE_HEAP_SIZE))
                        .setEvictionPolicy(EvictionPolicy.LRU)
                        .setTimeToLiveSeconds(TIME_TO_LIVE_SECONDS));

        return config;
    }
}
