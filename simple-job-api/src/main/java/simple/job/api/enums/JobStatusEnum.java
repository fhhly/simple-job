package simple.job.api.enums;

/**
 * @author 方浩
 * @version 1.0.0
 * @date 2023/06/02 09:59:32
 */
public enum JobStatusEnum {
    WAIT_SCHEDULE(0, "待调度"),
    SCHEDULEING(1, "调度中"),
    SCHEDULED(2, "已调度"),
    DISABLE(3, "已禁用")
    ;
    private Integer code;
    private String title;

    JobStatusEnum(Integer code, String title) {
        this.code = code;
        this.title = title;
    }

    public Integer getCode() {
        return this.code;
    }

    public String getTitle() {
        return this.title;
    }
}
