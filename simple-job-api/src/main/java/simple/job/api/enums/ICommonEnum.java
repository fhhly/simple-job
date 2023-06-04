package simple.job.api.enums;

import java.util.EnumSet;

/**
 * description: add a description
 *
 * @author 方浩
 * @version 1.0.0
 * @date 2023/06/02 09:59:32
 */
public interface ICommonEnum {
    String getCode();

    String getTitle();

    static <E extends Enum<E> & ICommonEnum> E getByCode(String value, Class<E> clazz) {
        EnumSet<E> all = EnumSet.allOf(clazz);
        return all.stream().filter(e -> e.getCode().equalsIgnoreCase(value)).findFirst().orElse(null);
    }
}