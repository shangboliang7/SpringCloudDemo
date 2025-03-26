package org.example.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


@Component
@ConfigurationProperties(prefix = "order.data")
@Data
public  class OrderProperties {
    /**
     * 上传ip
     */
    private  String host = "134.80.199.252";
    /**
     * 上传端口
     */
    private int port = 22;
    /**
     * 上传用户名
     */
    private String username = "gisinfo";
    /**
     * 上传密码
     */
    private String password = "Q!lygls";
    /**
     * 上传路径
     */
    private String remotePath = "/ftpdata2/zxfile/qly/oa_zhbg";

    /**
     * 服务器路径
     */
    private String localPath = "D:\\data\\test\\";

}
