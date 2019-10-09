package util;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.BeansException;
import org.springframework.beans.FatalBeanException;
import org.springframework.util.Assert;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

/**
 * @author lyz
 * @version 1.0.0
 * @ClassName BeanUtils
 * @createTime 2019年07月01日 20:14
 */

public abstract class BeanUtil extends org.springframework.beans.BeanUtils {

    /**
     * 实体类复制
     * @param source 被复制的实体类
     * @param target 复制到的实体类
     * @return void
     * @author 刘益志
     * @date 2019-07-19 10:44:19
     */
    public static void copyProperties(Object source, Object target) throws BeansException {
        Assert.notNull(source, "Source must not be null");
        Assert.notNull(target, "Target must not be null");
        Class<?> actualEditable = target.getClass();
        PropertyDescriptor[] targetPds = getPropertyDescriptors(actualEditable);
        for (PropertyDescriptor targetPd : targetPds) {
            if (targetPd.getWriteMethod() != null) {
                PropertyDescriptor sourcePd = getPropertyDescriptor(source.getClass(), targetPd.getName());
                if (sourcePd != null && sourcePd.getReadMethod() != null) {
                    try {
                        Method readMethod = sourcePd.getReadMethod();
                        if (!Modifier.isPublic(readMethod.getDeclaringClass().getModifiers())) {
                            readMethod.setAccessible(true);
                        }
                        Object value = readMethod.invoke(source);
                        // 这里判断以下value是否为空 当然这里也能进行一些特殊要求的处理 例如绑定时格式转换等等
                        if (value != null) {
                            Method writeMethod = targetPd.getWriteMethod();
                            if (!Modifier.isPublic(writeMethod.getDeclaringClass().getModifiers())) {
                                writeMethod.setAccessible(true);
                            }
                            writeMethod.invoke(target, value);
                        }
                    } catch (Throwable ex) {
                        throw new FatalBeanException("Could not copy properties from source to target", ex);
                    }
                }
            }
        }
    }
    /**
     * outputObjectToBean
     * @param outputObject
     * @param tClass
     * @return T
     * @author 刘益志
     * @date 2019-07-19 10:45:42
     */
    public static <T> T outputObjectToBean(OutputObject outputObject, Class<T> tClass){
        if(!ReturnCode.SUCCESS.equals(outputObject.getRespCode())){
            return null;
        }
        String jsonString = JSON.toJSONString(outputObject.getData());
        T t = JSON.parseObject(jsonString, tClass);
        return t;
    }
    /**
     * outputObjectToList
     * @param outputObject
     * @param tClass
     * @return java.util.List
     * @author 刘益志
     * @date 2019-07-19 11:08:15
     */
    public static <T> List outputObjectToList(OutputObject outputObject, Class<T> tClass){
        if(!ReturnCode.SUCCESS.equals(outputObject.getRespCode())){
            return null;
        }
        if(EmptyUtil.isEmpty(outputObject.getData())){
            return new ArrayList();
        }
        String jsonString = JSON.toJSONString(outputObject.getData());
        List<T> list = JSON.parseArray(jsonString, tClass);
        return list;
    }

    /**
     * outputObjectToPageBean
     * @param outputObject
     * @param tClass
     * @return java.util.List
     * @author 刘益志
     * @date 2019-07-19 11:08:15
     */
    public static <T> PageBean outputObjectToPageBean(OutputObject outputObject, Class<T> tClass){
        if(!ReturnCode.SUCCESS.equals(outputObject.getRespCode())){
            return null;
        }
        PageBean pageBean = BeanUtil.outputObjectToBean(outputObject,PageBean.class);
        if(EmptyUtil.isEmpty(pageBean)){
            return new PageBean<>();
        }
        String listJsonString = JSON.toJSONString(pageBean.getList());
        pageBean.setList(JSON.parseArray(listJsonString, tClass));
        CollectionCopyUtil.copyList(pageBean, tClass);
        return pageBean;
    }
}
