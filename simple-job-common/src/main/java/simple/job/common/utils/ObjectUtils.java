package simple.job.common.utils;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Map;

/**
 * description: add a description
 *
 * @author 方浩
 * @version 1.0.0
 * @date 2023/06/04 16:32:04
 */
public class ObjectUtils {

    public static boolean isEmpty(final Object object) {
        if (object == null) {
            return true;
        }
        if (object instanceof CharSequence) {
            return ((CharSequence) object).length() == 0;
        }
        if (object.getClass().isArray()) {
            return Array.getLength(object) == 0;
        }
        if (object instanceof Collection<?>) {
            return ((Collection<?>) object).isEmpty();
        }
        if (object instanceof Map<?, ?>) {
            return ((Map<?, ?>) object).isEmpty();
        }
        return false;
    }

    public static boolean isNotEmpty(final Object object) {
        return !isEmpty(object);
    }

    public static boolean allNotNull(final Object... values) {
        if (values == null) {
            return false;
        }

        for (final Object val : values) {
            if (val == null) {
                return false;
            }
        }

        return true;
    }

    public static boolean anyNotNull(final Object... values) {
        return firstNonNull(values) != null;
    }

    @SafeVarargs
    public static <T> T firstNonNull(final T... values) {
        if (values != null) {
            for (final T val : values) {
                if (val != null) {
                    return val;
                }
            }
        }
        return null;
    }
}
