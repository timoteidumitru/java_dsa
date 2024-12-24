package com.javaPlayground.javaBatch.partition;

import org.springframework.batch.core.partition.support.Partitioner;
import org.springframework.batch.item.ExecutionContext;

import java.util.HashMap;
import java.util.Map;

public class RangePartitioner implements Partitioner {

    @Override
    public Map<String, ExecutionContext> partition(int gridSize) {
        int min = 1;
        int max = 1000;
        int targetSize = (max-min) / gridSize + 1;
        Map<String, ExecutionContext> result = new HashMap<>();

        int number = 1;
        int start = min;
        int end = start + targetSize - 1;

        while (start <= max){
            ExecutionContext value = new ExecutionContext();
            result.put("partition "+number, value);

            if (end >= max){
                end = max;
            }

            value.putInt("min-value", start);
            value.putInt("max-value", end);

            start += targetSize;
            end += targetSize;
            number++;

        }

        System.out.println("Partition result: " + result.toString());

        return result;
    }
}
