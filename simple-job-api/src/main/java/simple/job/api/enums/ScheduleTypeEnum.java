package simple.job.api.enums;

/**
 * description: add a description
 *
 * @author 方浩
 * @version 1.0.0
 * @date 2023/06/02 09:59:32
 */
public enum ScheduleTypeEnum implements ICommonEnum{
    CORN("CORN", "corn表达式"),
    DATETIME("DATETIME", "日期");
    ;
    private String code;
    private String title;

    ScheduleTypeEnum(String code, String title) {
        this.code = code;
        this.title = title;
    }

    @Override
    public String getCode() {
        return this.code;
    }

    @Override
    public String getTitle() {
        return this.title;
    }
}
