package com.shen.thread;

import sun.misc.Signal;

@SuppressWarnings("restriction")
public class ServiceManager {

    private static Object[] lock = new Object[0];

    public static void shutdown() {
        System.out.println("---shutdown---");
        synchronized (lock) {
            lock.notifyAll();
        }
    }

    private static class SignalHandler implements sun.misc.SignalHandler {
//        @Override
        public void handle(Signal signal) {
            synchronized (lock) {
                lock.notifyAll();
            }
        }
    }

    public static void startAll() {
        SignalHandler handler = new SignalHandler();
        Signal.handle(new Signal("INT"), handler);
        Signal.handle(new Signal("TERM"), handler);
    }


    public static void sync() {
        System.out.println("---sync---");
        synchronized (lock) {
            try {
                lock.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
