import java.util.ArrayList;

/**
 * Created by andrey_prvt on 14.10.15.
 */
public class ProcessSheulder {

    static  ArrayList<Process> Q0 = new ArrayList<Process>();
    static  ArrayList<Process> Q1 = new ArrayList<>();

    final static int quantQ0 = 50;
    final static int quantQ1 = 100;

    public static void main(String[] args) {

/*

        for (int i = 1; i <= 5; i++) {
            Q0.add(new Process(quantQ0, i, (int) Math.pow(2 * i * quantQ0, i)));
            Q1.add(new Process(quantQ1, 5 + i, (int) Math.pow(2 * i * quantQ1, i)));
        }

        System.out.println("Process number||Start||Execution||End||Delay");

        for (Process process: Q0)
            new Thread(process).start();

       // System.out.println("Process number||Start||Execution||End||Delay");

       // for (Process process: Q1)
       //     new Thread(process).start();

*/
        System.out.println("Process number||Start Time||Running Time||Work Time||End Time||Delay Time");

        new Thread(new Process(1,  7, 2)).start();
        new Thread(new Process(2, 12, 2)).start();
        new Thread(new Process(3,  15,2)).start();
        new Thread(new Process(4,  8, 2)).start();
        new Thread(new Process(5,  20, 2)).start();


    }

}
