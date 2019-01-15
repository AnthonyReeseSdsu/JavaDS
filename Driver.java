package tester;

import data_structures.*;


/* This was built in order to test the times of all of our implementations */
public class Driver {
    private static final int size = 1000000;
    private static PriorityQueue<Integer> pq;

    public static void main(String[] args) {

        pq = new BinaryHeapPriorityQueue<Integer>(size);   /* change this line to any of the implementations to check various times */
        
        long start, stop;
        for (int i = 0; i < 250; i++) {
            pq.insert(5);
            pq.insert(2);
            pq.insert(3);
            pq.insert(4);
        }
        start = System.currentTimeMillis();

        for (int i = 0; i < 50000; i++) {
            pq.insert(3);
            pq.remove();
        }
        stop = System.currentTimeMillis();
        long first = stop - start;

        start = System.currentTimeMillis();

        for (int i = 0; i < 50000; i++) {
            pq.insert(5);
            pq.remove();
        }
        stop = System.currentTimeMillis();
        long second = stop - start;

        start = System.currentTimeMillis();

        for (int i = 0; i < 50000; i++) {
            pq.insert(3);
            pq.remove();
        }
        stop = System.currentTimeMillis();
        long third = stop - start;
        
        start = System.currentTimeMillis();

        for (int i = 0; i < 50000; i++) {
            pq.insert(5);
            pq.remove();
        }
        stop = System.currentTimeMillis();
        long fourth = stop - start;
        
        start = System.currentTimeMillis();

        for (int i = 0; i < 50000; i++) {
            pq.insert(3);
            pq.remove();
        }
        stop = System.currentTimeMillis();
        long fifth = stop - start;
        
        long averageFor1k = (fifth + fourth + third + second + first)/5;
        
        System.out.println("Binary Heap 1k: " + averageFor1k);
        
        //**************************************************************
        //
        
        for (int i = 0; i < 500; i++) {
            pq.insert(5);
            pq.insert(2);
            pq.insert(3);
            pq.insert(4);
        }
        start = System.currentTimeMillis();

        for (int i = 0; i < 50000; i++) {
            pq.insert(5);
            pq.remove();
        }
        stop = System.currentTimeMillis();
        first = stop - start;

        start = System.currentTimeMillis();

        for (int i = 0; i < 50000; i++) {
            pq.insert(5);
            pq.remove();
        }
        stop = System.currentTimeMillis();
        second = stop - start;

        start = System.currentTimeMillis();

        for (int i = 0; i < 50000; i++) {
            pq.insert(5);
            pq.remove();
        }
        stop = System.currentTimeMillis();
        third = stop - start;
        
        start = System.currentTimeMillis();

        for (int i = 0; i < 50000; i++) {
            pq.insert(5);
            pq.remove();
        }
        stop = System.currentTimeMillis();
        fourth = stop - start;
        
        start = System.currentTimeMillis();

        for (int i = 0; i < 50000; i++) {
            pq.insert(5);
            pq.remove();
        }
        stop = System.currentTimeMillis();
        fifth = stop - start;
        
        long averageFor2k = (fifth + fourth + third + second + first)/5;
        
        System.out.println("2k: " + averageFor2k);
        
        //**************************************************************
        
                //
                for (int i = 0; i < 1000; i++) {
                    pq.insert(5);
                    pq.insert(2);
                    pq.insert(3);
                    pq.insert(4);
                }
                start = System.currentTimeMillis();

                for (int i = 0; i < 50000; i++) {
                    pq.insert(5);
                    pq.remove();
                }
                stop = System.currentTimeMillis();
                first = stop - start;

                start = System.currentTimeMillis();

                for (int i = 0; i < 50000; i++) {
                    pq.insert(5);
                    pq.remove();
                }
                stop = System.currentTimeMillis();
                second = stop - start;

                start = System.currentTimeMillis();

                for (int i = 0; i < 50000; i++) {
                    pq.insert(5);
                    pq.remove();
                }
                stop = System.currentTimeMillis();
                third = stop - start;
                
                start = System.currentTimeMillis();

                for (int i = 0; i < 50000; i++) {
                    pq.insert(5);
                    pq.remove();
                }
                stop = System.currentTimeMillis();
                fourth = stop - start;
                
                start = System.currentTimeMillis();

                for (int i = 0; i < 50000; i++) {
                    pq.insert(5);
                    pq.remove();
                }
                stop = System.currentTimeMillis();
                fifth = stop - start;
                
                long averageFor4k = (fifth + fourth + third + second + first)/5;
                
                System.out.println("4k: " + averageFor4k);
                
                //**************************************************************
                //
                for (int i = 0; i < 2000; i++) {
                    pq.insert(5);
                    pq.insert(2);
                    pq.insert(3);
                    pq.insert(4);
                }
                start = System.currentTimeMillis();

                for (int i = 0; i < 50000; i++) {
                    pq.insert(5);
                    pq.remove();
                }
                stop = System.currentTimeMillis();
                first = stop - start;

                start = System.currentTimeMillis();

                for (int i = 0; i < 50000; i++) {
                    pq.insert(5);
                    pq.remove();
                }
                stop = System.currentTimeMillis();
                second = stop - start;

                start = System.currentTimeMillis();

                for (int i = 0; i < 50000; i++) {
                    pq.insert(5);
                    pq.remove();
                }
                stop = System.currentTimeMillis();
                third = stop - start;
                
                start = System.currentTimeMillis();

                for (int i = 0; i < 50000; i++) {
                    pq.insert(5);
                    pq.remove();
                }
                stop = System.currentTimeMillis();
                fourth = stop - start;
                
                start = System.currentTimeMillis();

                for (int i = 0; i < 50000; i++) {
                    pq.insert(5);
                    pq.remove();
                }
                stop = System.currentTimeMillis();
                fifth = stop - start;
                
                long averageFor8k = (fifth + fourth + third + second + first)/5;
                
                System.out.println("8k: " + averageFor8k);
                
                //**************************************************************
                //
                for (int i = 0; i < 4000; i++) {
                    pq.insert(5);
                    pq.insert(2);
                    pq.insert(3);
                    pq.insert(4);
                }
                start = System.currentTimeMillis();

                for (int i = 0; i < 50000; i++) {
                    pq.insert(5);
                    pq.remove();
                }
                stop = System.currentTimeMillis();
                first = stop - start;

                start = System.currentTimeMillis();

                for (int i = 0; i < 50000; i++) {
                    pq.insert(5);
                    pq.remove();
                }
                stop = System.currentTimeMillis();
                second = stop - start;

                start = System.currentTimeMillis();

                for (int i = 0; i < 50000; i++) {
                    pq.insert(5);
                    pq.remove();
                }
                stop = System.currentTimeMillis();
                third = stop - start;
                
                start = System.currentTimeMillis();

                for (int i = 0; i < 50000; i++) {
                    pq.insert(5);
                    pq.remove();
                }
                stop = System.currentTimeMillis();
                fourth = stop - start;
                
                start = System.currentTimeMillis();

                for (int i = 0; i < 50000; i++) {
                    pq.insert(5);
                    pq.remove();
                }
                stop = System.currentTimeMillis();
                fifth = stop - start;
                
                long averageFor16k = (fifth + fourth + third + second + first)/5;
                
                System.out.println("16k: " + averageFor16k);
                
                //**************************************************************
                
                //
                for (int i = 0; i < 8000; i++) {
                    pq.insert(5);
                    pq.insert(2);
                    pq.insert(3);
                    pq.insert(4);
                }
                start = System.currentTimeMillis();

                for (int i = 0; i < 50000; i++) {
                    pq.insert(5);
                    pq.remove();
                }
                stop = System.currentTimeMillis();
                first = stop - start;

                start = System.currentTimeMillis();

                for (int i = 0; i < 50000; i++) {
                    pq.insert(5);
                    pq.remove();
                }
                stop = System.currentTimeMillis();
                second = stop - start;

                start = System.currentTimeMillis();

                for (int i = 0; i < 50000; i++) {
                    pq.insert(5);
                    pq.remove();
                }
                stop = System.currentTimeMillis();
                third = stop - start;
                
                start = System.currentTimeMillis();

                for (int i = 0; i < 50000; i++) {
                    pq.insert(5);
                    pq.remove();
                }
                stop = System.currentTimeMillis();
                fourth = stop - start;
                
                start = System.currentTimeMillis();

                for (int i = 0; i < 50000; i++) {
                    pq.insert(5);
                    pq.remove();
                }
                stop = System.currentTimeMillis();
                fifth = stop - start;
                
                long averageFor32k = (fifth + fourth + third + second + first)/5;
                
                System.out.println("32k: " + averageFor32k);
                
                //**************************************************************
                //
                for (int i = 0; i < 16000; i++) {
                    pq.insert(5);
                    pq.insert(2);
                    pq.insert(3);
                    pq.insert(4);
                }
                start = System.currentTimeMillis();

                for (int i = 0; i < 50000; i++) {
                    pq.insert(5);
                    pq.remove();
                }
                stop = System.currentTimeMillis();
                first = stop - start;

                start = System.currentTimeMillis();

                for (int i = 0; i < 50000; i++) {
                    pq.insert(5);
                    pq.remove();
                }
                stop = System.currentTimeMillis();
                second = stop - start;

                start = System.currentTimeMillis();

                for (int i = 0; i < 50000; i++) {
                    pq.insert(5);
                    pq.remove();
                }
                stop = System.currentTimeMillis();
                third = stop - start;
                
                start = System.currentTimeMillis();

                for (int i = 0; i < 50000; i++) {
                    pq.insert(5);
                    pq.remove();
                }
                stop = System.currentTimeMillis();
                fourth = stop - start;
                
                start = System.currentTimeMillis();

                for (int i = 0; i < 50000; i++) {
                    pq.insert(5);
                    pq.remove();
                }
                stop = System.currentTimeMillis();
                fifth = stop - start;
                
                long averageFor64k = (fifth + fourth + third + second + first)/5;
                
                System.out.println("64k: " + averageFor64k);
                
                //**************************************************************
                //
                for (int i = 0; i < 32000; i++) {
                    pq.insert(5);
                    pq.insert(2);
                    pq.insert(3);
                    pq.insert(4);
                }
                start = System.currentTimeMillis();

                for (int i = 0; i < 50000; i++) {
                    pq.insert(5);
                    pq.remove();
                }
                stop = System.currentTimeMillis();
                first = stop - start;

                start = System.currentTimeMillis();

                for (int i = 0; i < 50000; i++) {
                    pq.insert(5);
                    pq.remove();
                }
                stop = System.currentTimeMillis();
                second = stop - start;

                start = System.currentTimeMillis();

                for (int i = 0; i < 50000; i++) {
                    pq.insert(5);
                    pq.remove();
                }
                stop = System.currentTimeMillis();
                third = stop - start;
                
                start = System.currentTimeMillis();

                for (int i = 0; i < 50000; i++) {
                    pq.insert(5);
                    pq.remove();
                }
                stop = System.currentTimeMillis();
                fourth = stop - start;
                
                start = System.currentTimeMillis();

                for (int i = 0; i < 50000; i++) {
                    pq.insert(5);
                    pq.remove();
                }
                stop = System.currentTimeMillis();
                fifth = stop - start;
                
                long averageFor128k = (fifth + fourth + third + second + first)/5;
                
                System.out.println("128k: " + averageFor128k);
                
                //**************************************************************
                //
                for (int i = 0; i < 64000; i++) {
                    pq.insert(5);
                    pq.insert(2);
                    pq.insert(3);
                    pq.insert(4);
                }
                start = System.currentTimeMillis();

                for (int i = 0; i < 50000; i++) {
                    pq.insert(5);
                    pq.remove();
                }
                stop = System.currentTimeMillis();
                first = stop - start;

                start = System.currentTimeMillis();

                for (int i = 0; i < 50000; i++) {
                    pq.insert(5);
                    pq.remove();
                }
                stop = System.currentTimeMillis();
                second = stop - start;

                start = System.currentTimeMillis();

                for (int i = 0; i < 50000; i++) {
                    pq.insert(5);
                    pq.remove();
                }
                stop = System.currentTimeMillis();
                third = stop - start;
                
                start = System.currentTimeMillis();

                for (int i = 0; i < 50000; i++) {
                    pq.insert(5);
                    pq.remove();
                }
                stop = System.currentTimeMillis();
                fourth = stop - start;
                
                start = System.currentTimeMillis();

                for (int i = 0; i < 50000; i++) {
                    pq.insert(5);
                    pq.remove();
                }
                stop = System.currentTimeMillis();
                fifth = stop - start;
                
                long averageFor256k = (fifth + fourth + third + second + first)/5;
                
                System.out.println("256k: " + averageFor256k);
                
                
                //**************************************************************
                //
                for (int i = 0; i < 128000; i++) {
                    pq.insert(5);
                    pq.insert(2);
                    pq.insert(3);
                    pq.insert(4);
                }
                start = System.currentTimeMillis();

                for (int i = 0; i < 50000; i++) {
                    pq.insert(5);
                    pq.remove();
                }
                stop = System.currentTimeMillis();
                first = stop - start;

                start = System.currentTimeMillis();

                for (int i = 0; i < 50000; i++) {
                    pq.insert(5);
                    pq.remove();
                }
                stop = System.currentTimeMillis();
                second = stop - start;

                start = System.currentTimeMillis();

                for (int i = 0; i < 50000; i++) {
                    pq.insert(5);
                    pq.remove();
                }
                stop = System.currentTimeMillis();
                third = stop - start;
                
                start = System.currentTimeMillis();

                for (int i = 0; i < 50000; i++) {
                    pq.insert(5);
                    pq.remove();
                }
                stop = System.currentTimeMillis();
                fourth = stop - start;
                
                start = System.currentTimeMillis();

                for (int i = 0; i < 50000; i++) {
                    pq.insert(5);
                    pq.remove();
                }
                stop = System.currentTimeMillis();
                fifth = stop - start;
                
                long averageFor512k = (fifth + fourth + third + second + first)/5;
                
                System.out.println("512k: " + averageFor512k);
                
                //**************************************************************
                //
                for (int i = 0; i < 256000; i++) {
                    pq.insert(5);
                    pq.insert(2);
                    pq.insert(3);
                    pq.insert(4);
                }
                start = System.currentTimeMillis();

                for (int i = 0; i < 50000; i++) {
                    pq.insert(5);
                    pq.remove();
                }
                stop = System.currentTimeMillis();
                first = stop - start;

                start = System.currentTimeMillis();

                for (int i = 0; i < 50000; i++) {
                    pq.insert(5);
                    pq.remove();
                }
                stop = System.currentTimeMillis();
                second = stop - start;

                start = System.currentTimeMillis();

                for (int i = 0; i < 50000; i++) {
                    pq.insert(5);
                    pq.remove();
                }
                stop = System.currentTimeMillis();
                third = stop - start;
                
                start = System.currentTimeMillis();

                for (int i = 0; i < 50000; i++) {
                    pq.insert(5);
                    pq.remove();
                }
                stop = System.currentTimeMillis();
                fourth = stop - start;
                
                start = System.currentTimeMillis();

                for (int i = 0; i < 50000; i++) {
                    pq.insert(5);
                    pq.remove();
                }
                stop = System.currentTimeMillis();
                fifth = stop - start;
                
                long averageFor1mk = (fifth + fourth + third + second + first)/5;
                
                System.out.println("1 million: " + averageFor1mk);
                
                
                //**************************************************************
                //
                for (int i = 0; i < 512000; i++) {
                    pq.insert(5);
                    pq.insert(2);
                    pq.insert(3);
                    pq.insert(4);
                }
                start = System.currentTimeMillis();

                for (int i = 0; i < 50000; i++) {
                    pq.insert(3);
                    pq.remove();
                }
                stop = System.currentTimeMillis();
                first = stop - start;

                start = System.currentTimeMillis();

                for (int i = 0; i < 50000; i++) {
                    pq.insert(3);
                    pq.remove();
                }
                stop = System.currentTimeMillis();
                second = stop - start;

                start = System.currentTimeMillis();

                for (int i = 0; i < 50000; i++) {
                    pq.insert(3);
                    pq.remove();
                }
                stop = System.currentTimeMillis();
                third = stop - start;
                
                start = System.currentTimeMillis();

                for (int i = 0; i < 50000; i++) {
                    pq.insert(4);
                    pq.remove();
                }
                stop = System.currentTimeMillis();
                fourth = stop - start;
                
                start = System.currentTimeMillis();

                for (int i = 0; i < 50000; i++) {
                    pq.insert(3);
                    pq.remove();
                }
                stop = System.currentTimeMillis();
                fifth = stop - start;
                
                long averageFor2m = (fifth + fourth + third + second + first)/5;
                
                System.out.println("2 million: " + averageFor2m);
                
                

    }

}
