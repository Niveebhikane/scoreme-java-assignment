import java.util.concurrent.*;
import java.util.*;

public class Task3 {

    private AtomicInteger processedCount = new AtomicInteger(0); // FIX

    public void process(List<StatementRecord> records) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(10);

        for (StatementRecord record : records) {
            executor.submit(() -> {
                processRecord(record);
                processedCount.incrementAndGet(); // FIX: thread-safe
            });
        }

        executor.shutdown();
        executor.awaitTermination(5, TimeUnit.MINUTES);
    }

    public int getProcessedCount() {
        return processedCount.get(); // FIX
    }

    private void processRecord(StatementRecord r) {}
}
