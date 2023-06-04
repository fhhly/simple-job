package simple.job.common.utils;

/**
 * description: add a description
 * @author 方浩
 * @version 1.0.0
 * @date 2023/06/04 11:17:09
 */
public class ArrayUtils {
    public static boolean isEmpty(Object[] array) {
        return array == null || array.length == 0;
    }

    /**
     * <p>Checks if an array of primitive longs is empty or <code>null</code>.</p>
     *
     * @param array  the array to test
     * @return <code>true</code> if the array is empty or <code>null</code>
     * @since 2.1
     */
    public static boolean isEmpty(long[] array) {
        return array == null || array.length == 0;
    }

    /**
     * <p>Checks if an array of primitive ints is empty or <code>null</code>.</p>
     *
     * @param array  the array to test
     * @return <code>true</code> if the array is empty or <code>null</code>
     * @since 2.1
     */
    public static boolean isEmpty(int[] array) {
        return array == null || array.length == 0;
    }

    /**
     * <p>Checks if an array of primitive shorts is empty or <code>null</code>.</p>
     *
     * @param array  the array to test
     * @return <code>true</code> if the array is empty or <code>null</code>
     * @since 2.1
     */
    public static boolean isEmpty(short[] array) {
        return array == null || array.length == 0;
    }

    /**
     * <p>Checks if an array of primitive chars is empty or <code>null</code>.</p>
     *
     * @param array  the array to test
     * @return <code>true</code> if the array is empty or <code>null</code>
     * @since 2.1
     */
    public static boolean isEmpty(char[] array) {
        return array == null || array.length == 0;
    }

    /**
     * <p>Checks if an array of primitive bytes is empty or <code>null</code>.</p>
     *
     * @param array  the array to test
     * @return <code>true</code> if the array is empty or <code>null</code>
     * @since 2.1
     */
    public static boolean isEmpty(byte[] array) {
        return array == null || array.length == 0;
    }

    /**
     * <p>Checks if an array of primitive doubles is empty or <code>null</code>.</p>
     *
     * @param array  the array to test
     * @return <code>true</code> if the array is empty or <code>null</code>
     * @since 2.1
     */
    public static boolean isEmpty(double[] array) {
        return array == null || array.length == 0;
    }

    /**
     * <p>Checks if an array of primitive floats is empty or <code>null</code>.</p>
     *
     * @param array  the array to test
     * @return <code>true</code> if the array is empty or <code>null</code>
     * @since 2.1
     */
    public static boolean isEmpty(float[] array) {
        return array == null || array.length == 0;
    }

    /**
     * <p>Checks if an array of primitive booleans is empty or <code>null</code>.</p>
     *
     * @param array  the array to test
     * @return <code>true</code> if the array is empty or <code>null</code>
     * @since 2.1
     */
    public static boolean isEmpty(boolean[] array) {
        return array == null || array.length == 0;
    }

    // ----------------------------------------------------------------------
    /**
     * <p>Checks if an array of Objects is not empty or not <code>null</code>.</p>
     *
     * @param array  the array to test
     * @return <code>true</code> if the array is not empty or not <code>null</code>
     * @since 2.5
     */
    public static boolean isNotEmpty(Object[] array) {
        return (array != null && array.length != 0);
    }

    /**
     * <p>Checks if an array of primitive longs is not empty or not <code>null</code>.</p>
     *
     * @param array  the array to test
     * @return <code>true</code> if the array is not empty or not <code>null</code>
     * @since 2.5
     */
    public static boolean isNotEmpty(long[] array) {
        return (array != null && array.length != 0);
    }

    /**
     * <p>Checks if an array of primitive ints is not empty or not <code>null</code>.</p>
     *
     * @param array  the array to test
     * @return <code>true</code> if the array is not empty or not <code>null</code>
     * @since 2.5
     */
    public static boolean isNotEmpty(int[] array) {
        return (array != null && array.length != 0);
    }

    /**
     * <p>Checks if an array of primitive shorts is not empty or not <code>null</code>.</p>
     *
     * @param array  the array to test
     * @return <code>true</code> if the array is not empty or not <code>null</code>
     * @since 2.5
     */
    public static boolean isNotEmpty(short[] array) {
        return (array != null && array.length != 0);
    }

    /**
     * <p>Checks if an array of primitive chars is not empty or not <code>null</code>.</p>
     *
     * @param array  the array to test
     * @return <code>true</code> if the array is not empty or not <code>null</code>
     * @since 2.5
     */
    public static boolean isNotEmpty(char[] array) {
        return (array != null && array.length != 0);
    }

    /**
     * <p>Checks if an array of primitive bytes is not empty or not <code>null</code>.</p>
     *
     * @param array  the array to test
     * @return <code>true</code> if the array is not empty or not <code>null</code>
     * @since 2.5
     */
    public static boolean isNotEmpty(byte[] array) {
        return (array != null && array.length != 0);
    }

    /**
     * <p>Checks if an array of primitive doubles is not empty or not <code>null</code>.</p>
     *
     * @param array  the array to test
     * @return <code>true</code> if the array is not empty or not <code>null</code>
     * @since 2.5
     */
    public static boolean isNotEmpty(double[] array) {
        return (array != null && array.length != 0);
    }

    /**
     * <p>Checks if an array of primitive floats is not empty or not <code>null</code>.</p>
     *
     * @param array  the array to test
     * @return <code>true</code> if the array is not empty or not <code>null</code>
     * @since 2.5
     */
    public static boolean isNotEmpty(float[] array) {
        return (array != null && array.length != 0);
    }

    /**
     * <p>Checks if an array of primitive booleans is not empty or not <code>null</code>.</p>
     *
     * @param array  the array to test
     * @return <code>true</code> if the array is not empty or not <code>null</code>
     * @since 2.5
     */
    public static boolean isNotEmpty(boolean[] array) {
        return (array != null && array.length != 0);
    }
}
