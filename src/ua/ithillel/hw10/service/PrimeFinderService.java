package ua.ithillel.hw10.service;

import ua.ithillel.hw10.domain.FinderResult;
import ua.ithillel.hw10.domain.PrimeFinder;

import java.util.Arrays;

public class PrimeFinderService {

    private FinderResult finderResult;
    private int numberOfThreads;
    private int intervalMin;
    private int intervalMax;

    public PrimeFinderService(int numberOfThreads, int intervalMin, int intervalMax) {
        this.finderResult = new FinderResult();
        this.numberOfThreads = numberOfThreads;
        this.intervalMin = intervalMin;
        this.intervalMax = intervalMax;
    }

    public int[] findResult() {
        PrimeFinder[] primeFinders = new PrimeFinder[numberOfThreads];
        int intervalAmount = intervalMax - intervalMin;
        int temp = intervalMin;
        if (intervalAmount >= numberOfThreads) {
            for (int i = 0; i < primeFinders.length; i++) {
                int newTemp = 0;
                if (i == primeFinders.length - 1) {
                    newTemp = intervalMax;
                } else {
                    newTemp = temp + (intervalAmount / numberOfThreads);
                }
                primeFinders[i] = new PrimeFinder(temp, newTemp, finderResult);
                temp = newTemp + 1;
            }
        }
        try {
            for (PrimeFinder primeFinder : primeFinders) {
                primeFinder.getThread().join();
            }
        } catch (InterruptedException interruptedException) {
            System.out.println("Interrupted");
        }
        return finderResult.getResult();
    }

    public FinderResult getFinderResult() {
        return finderResult;
    }

    public void setResult(FinderResult finderResult) {
        this.finderResult = finderResult;
    }

    public int getNumberOfThreads() {
        return numberOfThreads;
    }

    public void setNumberOfThreads(int numberOfThreads) {
        this.numberOfThreads = numberOfThreads;
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
}
