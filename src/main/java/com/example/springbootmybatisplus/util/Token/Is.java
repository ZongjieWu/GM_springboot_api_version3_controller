package com.example.springbootmybatisplus.util.Token;

import java.io.File;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * 非空工具类
 *
 * @author hjh
 * @version v1.3 增加Integer等类型支持,能使用三元表达式尽量使用,修复string... 只修判断到一个不为空就返回true的不合理情况,实际使用除list,map里的子集外要都不为空  2018-7-31
 */
public class Is {

    /**
     * 私有化构造对象,不能创建对象
     */
    private Is() {
        super();
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    /**
     * 判断是否大于0
     *
     * @param num 整形
     * @return true为大于0, false为小于0
     */
    public static boolean isNoEmpty(byte num) {
        return num > 0;
    }

    /**
     * 判断是否大于0
     *
     * @param num 整形
     * @return true为大于0, false为小于0
     */
    public static boolean isNoEmpty(Byte num) {
        return num != null ? num > 0 : false;
    }

    /**
     * 判断是否为空
     *
     * @param nums 数组
     * @return 如果都不为空且有值且不为负数返回true
     */
    public static boolean isNoEmpty(Byte... nums) {
        boolean flag = true;
        if (nums != null && nums.length > 0) {
            for (Byte obj : nums) {
                if (!Is.isNoEmpty(obj)) {
                    flag = false;
                    break;
                }
            }
        } else {
            flag = false;
        }
        return flag;
    }

    /**
     * 判断是否大于0
     *
     * @param num 整形
     * @return true为大于0, false为小于0
     */
    public static boolean isNoEmpty(short num) {
        return num > 0;
    }

    /**
     * 判断是否大于0
     *
     * @param num 整形
     * @return true为大于0, false为小于0
     */
    public static boolean isNoEmpty(Short num) {
        return num != null ? num > 0 : false;
    }

    /**
     * 判断是否为空
     *
     * @param nums 数组
     * @return 如果都不为空且有值且不为负数返回true
     */
    public static boolean isNoEmpty(Short... nums) {
        boolean flag = true;
        if (nums != null && nums.length > 0) {
            for (Short obj : nums) {
                if (!Is.isNoEmpty(obj)) {
                    flag = false;
                    break;
                }
            }
        } else {
            flag = false;
        }
        return flag;
    }

    /**
     * 判断是否大于0
     *
     * @param num 整数
     * @return true为大于0, false为小于0
     */
    public static boolean isNoEmpty(int num) {
        return num > 0;
    }

    /**
     * 判断是否大于0
     *
     * @param num 整数
     * @return true为大于0, false为小于0
     */
    public static boolean isNoEmpty(Integer num) {
        return num != null ? num > 0 : false;
    }

    /**
     * 判断是否为空
     *
     * @param nums 数组
     * @return 如果都不为空且有值且不为负数返回true
     */
    public static boolean isNoEmpty(Integer... nums) {
        boolean flag = true;
        if (nums != null && nums.length > 0) {
            for (Integer obj : nums) {
                if (!Is.isNoEmpty(obj)) {
                    flag = false;
                    break;
                }
            }
        } else {
            flag = false;
        }
        return flag;
    }

    /**
     * 判断是否大于0
     *
     * @param num 浮点数
     * @return true为大于0, false为小于0
     */
    public static boolean isNoEmpty(float num) {
        return num > 0;
    }

    /**
     * 判断是否大于0
     *
     * @param num 浮点数
     * @return true为大于0, false为小于0
     */
    public static boolean isNoEmpty(Float num) {
        return num != null ? num > 0 : false;
    }

    /**
     * 判断是否为空
     *
     * @param nums 数组
     * @return 如果都不为空且有值且不为负数返回true
     */
    public static boolean isNoEmpty(Float... nums) {
        boolean flag = true;
        if (nums != null && nums.length > 0) {
            for (Float obj : nums) {
                if (!Is.isNoEmpty(obj)) {
                    flag = false;
                    break;
                }
            }
        } else {
            flag = false;
        }
        return flag;
    }

    /**
     * 判断是否大于0
     *
     * @param num 双精度浮点数
     * @return true为大于0, false为小于0
     */
    public static boolean isNoEmpty(double num) {
        return num > 0;
    }

    /**
     * 判断是否大于0
     *
     * @param num 双精度浮点数
     * @return true为大于0, false为小于0
     */
    public static boolean isNoEmpty(Double num) {
        return num != null ? num > 0 : false;
    }

    /**
     * 判断是否为空
     *
     * @param nums 数组
     * @return 如果都不为空且有值且不为负数返回true
     */
    public static boolean isNoEmpty(Double... nums) {
        boolean flag = true;
        if (nums != null && nums.length > 0) {
            for (Double obj : nums) {
                if (!Is.isNoEmpty(obj)) {
                    flag = false;
                    break;
                }
            }
        } else {
            flag = false;
        }
        return flag;
    }

    /**
     * 判断是否大于0
     *
     * @param num 长整数
     * @return true为大于0, false为小于0
     */
    public static boolean isNoEmpty(long num) {
        return num > 0;
    }

    /**
     * 判断是否大于0
     *
     * @param num 长整数
     * @return true为大于0, false为小于0
     */
    public static boolean isNoEmpty(Long num) {
        return num != null ? num > 0 : false;
    }

    /**
     * 判断是否为空
     *
     * @param nums 数组
     * @return 如果都不为空且有值且不为负数返回true
     */
    public static boolean isNoEmpty(Long... nums) {
        boolean flag = true;
        if (nums != null && nums.length > 0) {
            for (Long obj : nums) {
                if (!Is.isNoEmpty(obj)) {
                    flag = false;
                    break;
                }
            }
        } else {
            flag = false;
        }
        return flag;
    }

    /**
     * 判断是否大于0
     *
     * @param num 数字
     * @return true为大于0, false为小于0
     */
    public static boolean isNoEmpty(Number num) {
        return num != null ? num.doubleValue() > 0 : false;
    }

    /**
     * 判断是否为空
     *
     * @param nums 数组
     * @return 如果都不为空且有值且不为负数返回true
     */
    public static boolean isNoEmpty(Number... nums) {
        boolean flag = true;
        if (nums != null && nums.length > 0) {
            for (Number obj : nums) {
                if (!Is.isNoEmpty(obj)) {
                    flag = false;
                    break;
                }
            }
        } else {
            flag = false;
        }
        return flag;
    }

    /**
     * 判断是否为空
     *
     * @param str 字符串
     * @return 如果str不为空返回true
     */
    public static boolean isNoEmpty(String str) {
        boolean flag = false;
        if (str != null && Is.trim(str).length() > 0) {
            flag = true;
        }
        return flag;
    }

    /**
     * 判断是否为空
     *
     * @param strs 字符串数组
     * @return 如果strs都不为空返回true
     */
    public static boolean isNoEmpty(String... strs) {
        boolean flag = true;
        if (strs != null && strs.length > 0) {
            for (String str : strs) {
                if (!Is.isNoEmpty(str)) {
                    flag = false;
                    break;
                }
            }
        } else {
            flag = false;
        }
        return flag;
    }

    /**
     * 判断是否为空
     *
     * @param file file对象
     * @return 如果file不为空返回true
     */
    public static boolean isNoEmpty(File file) {
        boolean flag = false;
        if (file != null && file.exists()) {
            flag = true;
        }
        return flag;
    }

    /**
     * 判断是否为空
     *
     * @param files file对象数组
     * @return 如果files都不为空且存在返回true
     */
    public static boolean isNoEmpty(File... files) {
        boolean flag = true;
        if (files != null && files.length > 0) {
            for (File file : files) {
                if (!Is.isNoEmpty(file)) {
                    flag = false;
                    break;
                }
            }
        } else {
            flag = false;
        }
        return flag;
    }

    /**
     * 判断是否为空
     *
     * @param list list集合或set集合
     * @return 如果list不为空(list存在至少有一个值不为空)返回true
     */
    public static <T> boolean isNoEmpty(Collection<T> list) {
        boolean flag = false;
        if (list != null && list.size() > 0) {
            for (T l : list) {
                if (Is.isNoEmpty(l)) {
                    flag = true;
                    break;
                }
            }
        }
        return flag;
    }

    /**
     * 判断是否为空
     *
     * @param map map集合
     * @return 如果map不为空(map存在至少有一个值不为空)返回true
     */
    public static boolean isNoEmpty(Map<?, ?> map) {
        boolean flag = false;
        if (map != null && map.size() > 0) {
            for (Map.Entry<?, ?> entry : map.entrySet()) {
                if (Is.isNoEmpty(entry.getValue())) {
                    flag = true;
                    break;
                }
            }
        }
        return flag;
    }

    /**
     * 判断是否为空
     * list,map 只要有一项不为空就返回true
     * 数组                   不为null且长度大于零(暂时)
     * string   不为null且不为空字符
     * number   不为null且大于零
     * file     不为null且存在
     *
     * @param objs 数据集
     * @return
     */
    public static boolean isNoEmpty(Object... objs) {
        boolean flag = true;
        if (objs != null) {
            for (Object obj : objs) {
                // 任意一项都不能为空
                if (obj == null) {
                    flag = false;
                    break;
                }
                // 判断不同数据是否符合规则
                if (obj instanceof Number) {
                    // 数字
                    if (((Number) obj).doubleValue() <= 0) {
                        flag = false;
                        break;
                    }
                } else if (obj instanceof String) {
                    // 字符
                    if (Is.trim(((String) obj)).length() <= 0) {
                        flag = false;
                        break;
                    }
                } else if (obj instanceof Collection) {
                    // 集合
                    if (!Is.isNoEmpty((Collection<?>) obj)) {
                        flag = false;
                        break;
                    }
                } else if (obj instanceof Map) {
                    // 集合
                    if (!Is.isNoEmpty((Map<?, ?>) obj)) {
                        flag = false;
                        break;
                    }
                } else if (obj.getClass().isArray()) {
                    // 数组
                    if (Array.getLength(obj) <= 0) {
                        flag = false;
                        break;
                    }
                } else if (obj instanceof File) {
                    if (!Is.isNoEmpty((File) obj)) {
                        flag = false;
                        break;
                    }
                }
            }
        } else {
            flag = false;
        }
        return flag;
    }

    /**
     * 为空或为零时返回默认值
     *
     * @param t   参数
     * @param def 默认值
     * @return t为空时返回def
     */
    public static <T> T ifNull(T t, T def) {
        if (!Is.isNoEmpty(t)) {
            // 为空
            t = def;
        }
        return t;
    }

    /**
     * 去除所有空格,换行符,换页符
     *
     * @param str 字符串
     * @return 去除后的字符串
     */
    public static String trimWrap(String str) {
        return str != null ? str.replaceAll("\\t|\r|\n", "") : str;
    }

    /**
     * 去除所有空格,换行符,换页符
     *
     * @param str 字符串
     * @return 去除后的字符串
     */
    public static String trim(String str) {
        return str != null ? str.replaceAll("\\s*|\t|\r|\n", "") : str;
    }

    /**
     * obj转str
     *
     * @param obj
     * @return
     */
    public static String parseStr(Object obj) {
        return Is.ifNull(obj, "").toString();
    }

    public static <T> T getListInfo(List<T> list, int index) {
        T temp = null;
        if (list != null && list.size() > index) {
            temp = list.get(index);
        }
        return temp;
    }
}