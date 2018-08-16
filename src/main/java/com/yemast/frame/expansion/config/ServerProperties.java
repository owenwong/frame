package com.yemast.frame.expansion.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author WangWx
 * @since 2018年08月10日 14:44
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "server")
public class ServerProperties {

    /***
     * 服务器连接地址
     */
    private String url;
}
