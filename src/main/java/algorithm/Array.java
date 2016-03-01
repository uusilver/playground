package algorithm;/**
 * @COPYRIGHT (C) 2016 Schenker AG
 * <p/>
 * All rights reserved
 */

/**
 * @author Vani Li
 */
public class Array {
    //Initialize a team
    static int team[] = new int[20];

    static {
        team[0] = 80;
        team[1] = 181;
        team[2] = 965;
        team[3] = 344;
        team[4] = 491;
        team[5] = 149;
        team[6] = 109;
        team[7] = 866;
        team[8] = 704;
        team[9] = 205;
    }

    public static void insert(int number, int index) throws Exception {
        if (index > team.length) throw new Exception("Index over size");
        if (index < 0) throw new Exception("Index invalid, index should be greater than 0");
        team[index] = number;
    }

    public static void insert(int number) throws Exception {
        for (int i = 0; i < team.length; i++)
            if (team[i] == 0){
                team[i] = number;
                break;
            }

    }

    public static int search(int number) {
        int index = -1;
        for (int i = 0; i < team.length; i++)
            if (team[i] == number) {
                index = i;
                break;
            }

        return index;
    }

    public static void delete(int number) {
        for (int i = 0; i < team.length; i++)
            if (team[i] == number)
                team[i] = 0;
    }

    public static void main(String args[]) throws Exception {
        insert(99);
        insert(445, 12);
        System.out.println(search(981));
        delete(704);
        System.out.println("----------");
        for (int i : team) {
            System.out.println(i);
        }
    }
}
