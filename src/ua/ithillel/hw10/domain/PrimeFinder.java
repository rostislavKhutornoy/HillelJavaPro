package ua.ithillel.hw10.domain;

import java.util.Arrays;

public class PrimeFinder implements Runnable {
    private Thread thread;
    private int intervalMin;
    private int intervalMax;
    private FinderResult finderResult;
    private int[] result;

    public PrimeFinder(int intervalMin, int intervalMax, FinderResult finderResult) {
        this.intervalMin = intervalMin;
        this.intervalMax = intervalMax;
        this.finderResult = finderResult;
        this.result = new int[] {};
        this.thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        for (int i = intervalMin; i <= intervalMax; i++) {
            if (isPrime(i)) {
                result = Arrays.copyOf(result, result.length + 1);
                result[result.length - 1] = i;
            }
        }
        finderResult.pushArray(result);
    }

    public static boolean isPrime(int num) {
        if (num < 2) {
            return false;
        }
        for (int j = 2; j <= Math.sqrt(num); j++) {
            if (num % j == 0) {
                return false;
            }
        }
        return true;
    }

    public Thread getThread() {
        return thread;
    }

    public void setThread(Thread thread) {
        this.thread = thread;
    }

    public int getIntervalMin() {
        return intervalMin;
    }

    public void setIntervalMin(int intervalMin) {
        this.intervalMin = intervalMin;
    }

    public int getIntervalMax() {
        return intervalMax;
    }

    public void setIntervalMax(int intervalMax) {
        this.intervalMax = intervalMax;
    }

    public FinderResult getFinderResult() {
        return finderResult;
    }

    public void setFinderResult(FinderResult finderResult) {
        this.finderResult = finderResult;
    }

    public int[] getResult() {
        return result;
    }

    public void setResult(int[] result) {
        this.result = result;
    }
}
