package com.yemast.frame.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author WangWx
 * @since 2018年08月10日 14:44
 */
@Configuration
@ConfigurationProperties(prefix = "server")
@Data
public class ServerProperties {

    /***
     * 服务器连接地址
     */
    private String url;
}
