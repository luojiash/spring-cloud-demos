package com.github.luojiash.demo.redis.config;

import io.lettuce.core.cluster.ClusterClientOptions;
import io.lettuce.core.cluster.ClusterTopologyRefreshOptions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.data.redis.LettuceClientConfigurationBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.lettuce.LettuceClientConfiguration;
import org.springframework.stereotype.Component;

import java.time.Duration;

import static io.lettuce.core.cluster.ClusterTopologyRefreshOptions.RefreshTrigger.MOVED_REDIRECT;
import static io.lettuce.core.cluster.ClusterTopologyRefreshOptions.RefreshTrigger.PERSISTENT_RECONNECTS;

@Component
public class LettuceConfig {
    @Value("${spring.redis.lettuce.refreshPeriod}")
    private int refreshPeriod;

    @Value("${spring.redis.lettuce.adaptiveRefreshTriggersTimeout}")
    private int adaptiveRefreshTriggersTimeout;

    @Bean
    public LettuceClientConfigurationBuilderCustomizer topologyRefreshCustomizer() {
        return new LettuceClientConfigurationBuilderCustomizer() {
            @Override
            public void customize(LettuceClientConfiguration.LettuceClientConfigurationBuilder clientConfigurationBuilder) {

                ClusterTopologyRefreshOptions options = ClusterTopologyRefreshOptions.builder()
                        .enablePeriodicRefresh(Duration.ofSeconds(refreshPeriod))
                        .enableAdaptiveRefreshTrigger(MOVED_REDIRECT, PERSISTENT_RECONNECTS)
                        .adaptiveRefreshTriggersTimeout(Duration.ofSeconds(adaptiveRefreshTriggersTimeout))
                        .build();

                clientConfigurationBuilder.clientOptions(
                        ClusterClientOptions.builder().topologyRefreshOptions(options).build()
                );
            }
        };
    }
}
