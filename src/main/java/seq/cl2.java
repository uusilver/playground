package seq;/**
 * @COPYRIGHT (C) 2016 Schenker AG
 * <p/>
 * All rights reserved
 */

/**
 * @author Vani Li
 */
public class cl2 extends cl1{

    @Override
    public void call() {
        super.call();
    }

    @Override
    public void say() {
        System.out.println("Cl2");
    }

    public static void main(String args[]){
        ClassLoader classLoader = cl2.class.getClassLoader();
        while(classLoader != null){
            System.out.println(classLoader);
            classLoader = classLoader.getParent();
        }
    }
}
