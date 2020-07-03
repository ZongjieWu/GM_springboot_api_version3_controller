package com.example.springbootmybatisplus.util;



import org.springframework.cglib.beans.BeanCopier;

import java.util.List;

/**
 * 对象属性拷贝工具
 *
 * @author
 */

public class BeanCopyTools {

    /**
     * 拷贝非List
     *
     * @param source 源数据
     * @param target 结果数据
     * @param <E>    元数据类型
     * @param <V>    结果数据类型
     */
    public static <E, V, F, T> void copy(E source, V target) {
        if (source == null || target == null) {
            return;
        }
        BeanCopier beanCopier = BeanCopier.create(source.getClass(), target.getClass(), false);
        beanCopier.copy(source, target, null);
    }

    /**
     * 拷贝非List
     *
     * @param source 源数据
     * @param classV 目标数据元素类型
     * @param <E>    元数据类型
     * @param <V>    结果数据类型
     */
    public static <E, V> V copy(E source, Class<V> classV) {
        V v = null;
        if (source != null) {
            try {
                v = classV.newInstance();
                BeanCopier beanCopier = BeanCopier.create(source.getClass(), classV, false);
                beanCopier.copy(source, v, null);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
        return v;
    }

    /**
     * 拷贝集合
     *
     * @param source 源数据
     * @param target 目标数据
     * @param classV 目标数据元素类型
     * @param <E>    源数据类型
     * @param <V>    目标数据类型
     */
    public static <E, V> void copy(List<E> source, List<V> target, Class<V> classV) {
        if (source == null) {
            return;
        }
        for (E e : source) {
            V v = null;
            try {
                v = classV.newInstance();
                copy(e, v);
                target.add(v);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
    }
}
