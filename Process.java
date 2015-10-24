/**
 * Created by andrey_prvt on 15.10.15.
 */
import java.lang.Runnable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.Semaphore;

public class Process implements Runnable {

    int quant;
    int runningTime;
    int workingTime;
    int threadNumber;
    int startTimeCurrent;
    boolean flag;
    int delayTime;

    static Semaphore innerSemaphore = new Semaphore(1);
    private static int timeStart = 0;
    private static int threadAmaount = 5;


    Process(int threadNumber, int workingTime, int quant){
        this.quant = quant;
        this.threadNumber = threadNumber;
        this.workingTime = workingTime;
        runningTime = workingTime;
        startTimeCurrent = 0;
        flag = true;
    }


    @Override
    public void run() {



        try {



            innerSemaphore.acquire();
            runningTime-= quant;
            startTimeCurrent = timeStart;
            timeStart += quant;
            innerSemaphore.release();

            innerSemaphore.acquire();
            System.out.println("\t\t#" + threadNumber + "\t\t\t" + startTimeCurrent + " \t\t\t" + quant + "\t\t  " + '\t' + workingTime + "\t\t " +
                    (100 - runningTime * 100 / workingTime) + "% done\t\t" + (delayTime = quant * (threadNumber - 1)));
            innerSemaphore.release();


            Thread.sleep(10l * (threadAmaount) * quant);


            innerSemaphore.acquire();
            if (runningTime > 0)
                runningTime-= 2*quant;
            startTimeCurrent = timeStart;
            timeStart += 2 * quant;
            innerSemaphore.release();

            innerSemaphore.acquire();
            System.out.println("\t\t#" + threadNumber + "\t\t\t" + startTimeCurrent + " \t\t\t" + 3 * quant + "\t\t  " + '\t' + workingTime + "\t\t "
                    + (100 - runningTime * 100 / workingTime) + "% done\t\t" + (delayTime = startTimeCurrent - quant));
            innerSemaphore.release();


            Thread.sleep(30l * workingTime);

           ;

            innerSemaphore.acquire();
            if (workingTime - runningTime > 0){
                startTimeCurrent = timeStart;
                timeStart += workingTime - 3*quant;
            }
            innerSemaphore.release();

            innerSemaphore.acquire();
            System.out.println("\t\t#" + threadNumber + "\t\t\t" + startTimeCurrent + " \t\t\t" + workingTime + "\t\t  " + '\t' + workingTime + "\t\t "
                    + (workingTime + (delayTime = startTimeCurrent - quant)) +"\t\t\t\t" + (delayTime ));
            innerSemaphore.release();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
