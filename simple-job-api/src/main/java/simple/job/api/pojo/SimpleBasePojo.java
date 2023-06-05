package simple.job.api.pojo;

import lombok.Data;

import java.util.Date;

/**
 * description: add a description
 * @author 方浩
 * @version 1.0.0
 * @date 2023/06/05 14:40:27
 */
@Data
public class SimpleBasePojo {
    private String id;

    private Date createdTime;

    private String createdBy;

    private Date updateTime;

    private String updateBy;

    private Integer enable;
}
