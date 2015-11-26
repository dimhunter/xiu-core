package com.shen.thread;

public class TestYield {
  public static void main(String[] args) {
    MyThread3 t1 = new MyThread3("t1");
    MyThread3 t2 = new MyThread3("t2");
    t1.start();
    t2.start();
  }
}
class MyThread3 extends Thread {
  MyThread3(String s){
  	super(s);//调用父类的构造方法给他起个名字。
  }
  public void run(){
    for(int i =1;i<=100;i++){
      System.out.println(getName()+": "+i);
      if(i%10==0){    
        yield();      //让出cpu，给其他线程执行的机会。
      }
    }
  }
}

//该程序的结果就是当i能被10整除时让出一下cpu，此时让别的线程执行。