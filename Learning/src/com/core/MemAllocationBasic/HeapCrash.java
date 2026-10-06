package com.core.MemAllocationBasic;

import java.util.ArrayList;
import java.util.List;

//this program try to crash the heap to occur the MemoryOutOfBoundError

public class HeapCrash {
    public static void main(String[] args) {
        int count = 0;
        List<int[]> list = new ArrayList<>();
        while(true)
        {
            // 1 int size is 4 bytes
            // 250000 int size is 4*250000 bytes = 1000000 bytes
            // 1000000 bytes  = 1MB (approx 1000 bytes = 1KB, 1000KB = 1MB)
            list.add(new int[250000]);
            count++;
            System.out.println("Total number of block created: " + count);
        }
    }
}
