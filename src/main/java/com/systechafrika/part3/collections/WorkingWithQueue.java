package com.systechafrika.part3.collections;

import java.util.LinkedList;
import java.util.Queue;

public class WorkingWithQueue {
    public static void main(String[] args) {

        workingWithQueues();
    }

    public static void workingWithQueues() {

        Queue<PrintJob> queue = new LinkedList<>();
        queue.add(new PrintJob("articles"));
        queue.add(new PrintJob("book"));
        queue.add(new PrintJob("journal"));// throws runtime exception when its not
        // possible to add
        queue.offer(new PrintJob("manual"));

        System.out.println(queue);// returns [] when there's no item on the queue
        System.out.println(queue.size());
        System.out.println(queue.element());// throws an exception
        System.out.println(queue.peek());// returns first item and null when there's no first item
        System.out.println(queue.remove());// throws a runtime exception(returns and removes the first element of the
                                           // container)
        System.out.println(queue);
        System.out.println(queue.poll());// returns and removes the first element of the container without
        // printing an exxception
        System.out.println(queue);

    }

}
