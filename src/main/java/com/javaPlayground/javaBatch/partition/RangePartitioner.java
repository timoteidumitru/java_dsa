package com.javaPlayground.javaBatch.partition;

import org.springframework.batch.core.partition.support.Partitioner;
import org.springframework.batch.item.ExecutionContext;

import java.util.HashMap;
import java.util.Map;

public class RangePartitioner implements Partitioner {

    private final int min;
    private final int max;

    public RangePartitioner(int min, int max) {
        this.min = min;
        this.max = max;
    }

    @Override
    public Map<String, ExecutionContext> partition(int gridSize) {
        if (gridSize <= 0) {
            throw new IllegalArgumentException("Grid size must be greater than 0.");
        }

        int range = max - min + 1;
        int targetSize = (range + gridSize - 1) / gridSize; // Ensure ceiling division
        Map<String, ExecutionContext> result = new HashMap<>();

        int number = 1;
        int start = min;

        while (start <= max) {
            int end = Math.min(start + targetSize - 1, max);

            ExecutionContext value = new ExecutionContext();
            value.putInt("min-value", start);
            value.putInt("max-value", end);

            result.put("partition " + number, value);

            System.out.printf("Partition %d: min-value=%d, max-value=%d%n", number, start, end);

            start = end + 1;
            number++;
        }

        return result;
    }
}
