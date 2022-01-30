package com.example.domain;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.convert.DataSizeUnit;
import org.springframework.boot.convert.DurationUnit;
import org.springframework.stereotype.Component;
import org.springframework.util.unit.DataSize;
import org.springframework.util.unit.DataUnit;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Max;
import java.time.Duration;
import java.time.temporal.ChronoUnit;

/**
 * DataSource
 *
 * @author Qing2514
 * @since 0.0.1
 */
@Data
@Component
// "" 中不能有大写
@ConfigurationProperties("source")
// 开启对当前bean的属性注入校验
@Validated
public class Source {
    private String driver;
    private String url;
    @Max(value = 8888, message = "最大值不能超过8888")
    private int port;
    @DurationUnit(ChronoUnit.DAYS)
    private Duration timeout;
    @DataSizeUnit(DataUnit.KILOBYTES)
    private DataSize dataSize;
}
