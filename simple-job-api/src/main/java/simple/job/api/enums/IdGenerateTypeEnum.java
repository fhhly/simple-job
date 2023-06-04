package simple.job.api.enums;

/**
 * description: add a description
 *
 * @author 方浩
 * @version 1.0.0
 * @date 2023/06/04 16:26:18
 */
public enum IdGenerateTypeEnum implements ICommonEnum {
    SNOW_FLAKE("snow_flake", "雪花算法"),
    CUSTOMER("CUSTOMER", "用户自定义算法");
    ;

    private String code;
    private String title;

    IdGenerateTypeEnum(String code, String title) {
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
