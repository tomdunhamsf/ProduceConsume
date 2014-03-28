package com.zoom.test;
import java.util.concurrent.*;
public class WorkQueue {
	private static BlockingQueue<ZoomMessage> queue=null;
	public WorkQueue(){
		createQueue();
	}
	public static synchronized void createQueue(){
		if(queue==null){
			queue=new LinkedBlockingQueue<ZoomMessage>();
		}
	}
	public BlockingQueue<ZoomMessage> getQueue(){
		return queue;
	}
}
