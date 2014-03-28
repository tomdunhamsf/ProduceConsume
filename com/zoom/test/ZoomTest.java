package com.zoom.test;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import java.util.concurrent.*;
import java.util.*;



public class ZoomTest {

	private BlockingQueue<ZoomMessage> msgQueue =null;
	private Producer producer;
	private List<Consumer> consumers;
	private WorkQueue queue=new WorkQueue();
	private int finalFound=0;
	@Before
	public void setUp() throws Exception {
		producer=new Producer();
		consumers=new ArrayList<Consumer>();
		for(int i=0;i<10;i++){
			consumers.add(new Consumer());
		}
		queue=new WorkQueue();
	}

	@Test
	public void test() {
		msgQueue=queue.getQueue();
		new Thread(producer).start();
			for(Consumer c:consumers){
				new Thread(c).start();
			}
		// wait main thread to allow run to completion
			synchronized(this){
				try {
					wait(3000l);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

      org.junit.Assert.assertTrue("500 messages processed", sumConsumers()==500);	
	}
	public synchronized int sumConsumers(){
		int totalSize=0;
		for(Consumer c:consumers){
			System.out.println(c.getNumConsumed());
			totalSize=c.getNumConsumed()+totalSize;
		}
		return totalSize;
	}

}
