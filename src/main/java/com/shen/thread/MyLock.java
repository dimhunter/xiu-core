package com.shen.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class MyLock implements Lock{
	
	private final MyAqs aqs;
	
	public MyLock(){
		aqs = new MyAqs();
	}
	
	@Override
	public void lock() {
		// TODO Auto-generated method stub
//		if (compareAndSetState(0, 1))
//            setExclusiveOwnerThread(Thread.currentThread());
//        else
		aqs.acquire(1);
	}

	@Override
	public void lockInterruptibly() throws InterruptedException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean tryLock() {
		// TODO Auto-generated method stub
		return aqs.tryAcquire(1);
	}

	@Override
	public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void unlock() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Condition newCondition() {
		// TODO Auto-generated method stub
		return null;
	}

}
