package simple.job.core.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * description: add a description
 *
 * @author 方浩
 * @version 1.0.0
 * @date 2023/06/04 16:22:45
 */
@Data
@Component
@ConfigurationProperties("simple.job")
public class SimpleJobConfig {
    private String idGenerateType;

    private String idGenerateClass;

}
