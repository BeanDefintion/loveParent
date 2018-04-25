package com.ndc.nio;

public class ThreadList {

    private static ThreadGroup getThreadGroup() {
        ThreadGroup threadGroup = Thread.currentThread().getThreadGroup();
        while (threadGroup.getParent() != null) {
            threadGroup = threadGroup.getParent();
        }
        return threadGroup;
    }

    private static void getThreads(ThreadGroup threadGroup) {
        Thread[] threads = new Thread[threadGroup.activeCount()];
        int count = threadGroup.enumerate(threads, false);
        for (int i = 0; i < count; i++) {
            System.err.println("綫程組名字" + threadGroup.getName() + "綫程名字:" + threads[i].getName() + "優先級"
                    + threads[i].getPriority());

        }
        // ThreadGroup[] threadGroups=new
        // ThreadGroup[threadGroup.activeGroupCount()];
        // int count2=threadGroup.enumerate(threadGroups,false);
        // for (int i = 0; i < count2; i++) {
        // System.err.println(threadGroup.getName()+"1111111111111111"+threadGroups[i].getName());
        // }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        getThreads(getThreadGroup());
    }

}
