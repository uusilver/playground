package clsloader;/**
 * @COPYRIGHT (C) 2016 Schenker AG
 * <p/>
 * All rights reserved
 */

/**
 * @author Vani Li
 */
public class ObjectIsNotObject {

    static private final class Object{

    }

    public static void main(String args[]){
        java.lang.Object object = new java.lang.Object();
        System.out.print(object instanceof  clsloader.ObjectIsNotObject.Object);

    }
}
