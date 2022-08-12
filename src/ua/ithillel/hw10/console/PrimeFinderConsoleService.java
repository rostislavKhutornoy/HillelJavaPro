package ua.ithillel.hw10.console;

import ua.ithillel.hw10.util.InputUtil;
import ua.ithillel.hw10.service.PrimeFinderService;

public class PrimeFinderConsoleService implements InputUtil {
    public void start() {
        int numberOfThreads, intervalMin, intervalMax;
        numberOfThreads = getPositiveInt("Number of threads -> ");
        intervalMin = getPositiveInt("Start of the interval -> ");
        intervalMax = getPositiveInt("End of the interval -> ");
        PrimeFinderService primeFinderService = new PrimeFinderService(numberOfThreads, intervalMin, intervalMax);
        System.out.println("In this interval " +
                primeFinderService.findResult().length +
                " prime numbers were found");
    }
}
