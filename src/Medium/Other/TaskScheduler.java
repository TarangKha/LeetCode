package Medium.Other;

import java.util.*;
import java.io.*;

public class TaskScheduler {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] test = {'A','A','A','B','B','B'};
		int testN = 2;
		System.out.println(leastInterval(test,testN));
	}
	
	public static int leastInterval(char[] tasks, int n) {
		Queue<Character> waitQueue = new LinkedList<Character>();
		Queue<Character> taskQueue = new LinkedList<Character>();
		HashSet<Character> set = new HashSet<Character>();
		String debug = "";
		ArrayList<Character> tasksList = new ArrayList<Character>();
		for(int i = 0; i < tasks.length; i++) {
			tasksList.add(tasks[i]);
		}
		int size = tasksList.size();
		int cycles = 0; //return this
		
		for(int i = 0; i<size;i++) {
			if(taskQueue.isEmpty()) { //if no tasks were skipped
				if(!set.contains(tasks[i])) { //if the current task is available
					for(int j = 0; j < n; j++) { //make task wait n times
						waitQueue.add(tasks[i]);
					}
					set.add(tasks[i]); //make sure task can't be repeated until n passes
					if(cycles != 0 && (cycles)%n == 0) {
						set.remove(waitQueue.peek());
					}
					cycles++; //DO TASK
					debug = debug+tasks[i];
					if(cycles != 1) {
						waitQueue.remove();
					}
				} else {
					taskQueue.add(tasks[i]); //this task was skipped, put it in taskQueue
				}
			} else if(taskQueue.peek() != null && !set.contains(taskQueue.peek())) { //if the current task is available
				for(int j = 0; j < n; j++) { //make task wait n times
					waitQueue.add(taskQueue.peek()); //do the task that was skipped
				}
				debug = debug+taskQueue.peek();
				set.add(taskQueue.poll()); //make sure task can't be repeated until n passes
				if(cycles != 0 && (cycles)%n == 0) {
					set.remove(waitQueue.peek());
				}
				cycles++; //DO TASK
				waitQueue.remove();
			} else if(!set.contains(tasks[i])){
				for(int j = 0; j < n; j++) { //make task wait n times
					waitQueue.add(tasks[i]);
				}
				set.add(tasks[i]); //make sure task can't be repeated until n passes
				if(cycles != 0 && (cycles)%n == 0) {
					set.remove(waitQueue.peek());
				}
				cycles++; //DO TASK
				debug = debug + tasks[i];
				waitQueue.remove();
			} else {
				taskQueue.add(tasks[i]);
			}
			if(i == tasksList.size()-1 && !taskQueue.isEmpty()) {
				if(cycles != 0 && (cycles)%n == 0) {
					set.remove(waitQueue.peek());
				}
				cycles++; //IDLE
				waitQueue.poll();
				debug = debug+"-I-";
				tasksList = new ArrayList<Character>();
				int queueSize = taskQueue.size();
				for(int k =0; k < queueSize; k++) {
					tasksList.add(taskQueue.poll());
				}
				size = tasksList.size();
				int p = 0;
				while( p < size) {
					taskQueue.add(tasksList.get(p));
					p++;
				}
				i=-1;
			}
		}
		/*
		while(!taskQueue)
		while(!taskQueue.isEmpty()) {
			if(!set.contains(taskQueue.peek())) {
				for(int i = 0; i<n;i++) {
					waitQueue.add(taskQueue.peek());
				}
				debug = debug + taskQueue.peek();
				set.add(taskQueue.poll());
				if(cycles != 0 && (cycles)%n == 0) {
					set.remove(waitQueue.peek());
				}
				cycles++; //DO TASK
				waitQueue.remove();
			} else {
				if(cycles != 0 && (cycles)%n == 0) {
					set.remove(waitQueue.peek());
				}
				cycles++; //IDLE
				waitQueue.poll();
				debug = debug+" I ";
			}
		}
		*/
		System.out.println(debug);
		return cycles+1;
    }

}
