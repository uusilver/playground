package clsloader;/**
 * @COPYRIGHT (C) 2016 Schenker AG
 * <p/>
 * All rights reserved
 */

/**
 * @author Vani Li
 */
public class main {

    public static void main(String args[]) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class cla1 = main.class.getClassLoader().loadClass("clsloader.Test");
        Class cla2 = main.class.getClassLoader().loadClass("clsloader.Test");

//        Class cla3 = main.class.getClassLoader().getParent().loadClass();

//           System.out.println(cla1 == cla2);
//        System.out.println(cla1 == cla3);
//        System.out.println(cla3.newInstance() instanceof Test);
    }
}
