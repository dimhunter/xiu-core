package com.shen.thread;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

public class MyAqs extends AbstractQueuedSynchronizer {

	@Override
	protected boolean tryAcquire(int arg) {
		// TODO Auto-generated method stub
		return super.tryAcquire(arg);
	}

	@Override
	protected boolean tryRelease(int arg) {
		// TODO Auto-generated method stub
		return super.tryRelease(arg);
	}

	@Override
	protected int tryAcquireShared(int arg) {
		// TODO Auto-generated method stub
		return super.tryAcquireShared(arg);
	}

	@Override
	protected boolean tryReleaseShared(int arg) {
		// TODO Auto-generated method stub
		return super.tryReleaseShared(arg);
	}

	@Override
	protected boolean isHeldExclusively() {
		// TODO Auto-generated method stub
		return super.isHeldExclusively();
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

}
