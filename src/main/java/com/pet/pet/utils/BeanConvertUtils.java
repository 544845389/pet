package com.pet.pet.utils;

import com.lorne.core.framework.exception.ServiceException;
import sun.reflect.generics.reflectiveObjects.ParameterizedTypeImpl;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @author lorne
 * @date 2018/6/9
 * @description
 */
public final class BeanConvertUtils {


    public static Map<String,Object> toMap(Object obj) throws ServiceException{
        Class clazz = obj.getClass();
        Map<String, Object> maps = new HashMap<String, Object>();
        try {
            PropertyDescriptor[] propertyDescriptors = propertyDescriptors(clazz);
            for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
                Method gmethod = propertyDescriptor.getReadMethod();
                Method smethod = propertyDescriptor.getWriteMethod();
                if (null != gmethod && smethod != null) {
                    try {
                        maps.put(propertyDescriptor.getName(), propertyDescriptor.getReadMethod().invoke(obj));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            return maps;
        } catch (Exception e) {
            throw new ServiceException( e.getMessage());
        }
    }

    private static PropertyDescriptor[] propertyDescriptors(Class<?> c) throws Exception {
        BeanInfo beanInfo = null;
        try {
            beanInfo = Introspector.getBeanInfo(c);
        } catch (IntrospectionException var4) {
            throw new Exception("Bean introspection failed: " + var4.getMessage());
        }
        return beanInfo.getPropertyDescriptors();
    }



    private static Object getVal(Object convertBean,String propertyName) throws Exception{
        PropertyDescriptor[] propertyDescriptors = propertyDescriptors(convertBean.getClass());
        for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
            Method gmethod = propertyDescriptor.getReadMethod();
            Method smethod = propertyDescriptor.getWriteMethod();
            if (null != gmethod && smethod != null) {
                if(propertyName.equals(propertyDescriptor.getName())){
                    return gmethod.invoke(convertBean);
                }
            }
        }
        return null;
    }

    public static <T> T toBean(Class<T> clazz,Object convertBean) throws ServiceException {
        try {
            T instance =  clazz.newInstance();
            resetBean(clazz,instance,convertBean);
            return instance;
        } catch (Exception e) {
            throw new ServiceException( e.getMessage());
        }
    }


    public static void resetBean(Class<?> clazz, Object instance, Object convertBean) throws ServiceException {
        try {
            PropertyDescriptor[] propertyDescriptors = propertyDescriptors(clazz);
            for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
                Method gmethod = propertyDescriptor.getReadMethod();
                Method smethod = propertyDescriptor.getWriteMethod();
                if (null != gmethod && smethod != null) {
                    Object val = getVal(convertBean,propertyDescriptor.getName());

                    //对Collection 做处理.
                    if(val instanceof Collection){
                        Class itemClass = null;
                        Type type = gmethod.getGenericReturnType();
                        if(type instanceof ParameterizedTypeImpl){
                            ParameterizedTypeImpl parameterizedType = (ParameterizedTypeImpl) type;
                            if(parameterizedType.getActualTypeArguments()!=null
                                    &&parameterizedType.getActualTypeArguments().length>0) {
                                Type typeName =  parameterizedType.getActualTypeArguments()[0];
                                itemClass = Class.forName(typeName.getTypeName());
                            }
                        }

                        Collection collections = (Collection) val;
                        Collection newList =  (Collection) gmethod.invoke(instance);
                        for(Object item:collections){
                            newList.add(toBean(itemClass,item));
                        }
                        smethod.invoke(instance, newList);
                        continue;
                    }

                    if(val!=null) {
                        smethod.invoke(instance, val);
                    }
                }
            }
        } catch (Exception e) {
            throw new ServiceException( e.getMessage());
        }
    }
}
