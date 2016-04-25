package algorithm;/**
 * @COPYRIGHT (C) 2016 Schenker AG
 * <p/>
 * All rights reserved
 */

import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;


/**
 * @author Vani Li
 */
public class ClassReader {

    public static void main(String args[]) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException,
            IllegalAccessException {

         System.out.print(setObjectProperty("algorithm.User", "username", "Vani"));

    }

    private static Object setObjectProperty(String fullname, String properyName, String propertyValue) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Object object = Class.forName(fullname).newInstance();
        Method getMethod = object.getClass().getMethod("get" + properyName.substring(0, 1).toUpperCase() + properyName.substring(1));
        Class<?> parameterType = getMethod.getReturnType();
        Method setMethod = object.getClass().getMethod("set" + properyName.substring(0, 1).toUpperCase() + properyName.substring(1), parameterType);
        setMethod.invoke(object, propertyValue);
        return object;
    }

}

class User{
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
