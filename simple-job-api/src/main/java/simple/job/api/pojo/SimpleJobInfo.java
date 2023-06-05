package simple.job.api.pojo;

import lombok.Data;

/**
 * description: add a description
 * @author 方浩
 * @version 1.0.0
 * @date 2023/06/05 14:43:51
 */
@Data
public class SimpleJobInfo {
    private String timeExpression;

    private String processorRunnerInfo;

    private Integer timeExpressionType;

    private Integer status;
}
