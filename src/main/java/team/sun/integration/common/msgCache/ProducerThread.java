package team.sun.integration.common.msgCache;

import java.util.concurrent.atomic.AtomicInteger;

public class ProducerThread extends Thread {
    //创建初始值为0的counter
    private static AtomicInteger counter = new AtomicInteger(0);
    private MessageQueue messageQueue;

    public ProducerThread(MessageQueue messageQueue, int seq) {
        //为线程起名字
        super("Producer>>>>>" + seq);
        this.messageQueue = messageQueue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Message message = new Message("设备id", "Message>>>>>" + counter.getAndIncrement());
                messageQueue.put(message);
                System.out.println(Thread.currentThread().getName() + "   Put MessageData：" + message.getData());
                Thread.sleep(100);
            } catch (Exception e) {
                break;
            }

        }
    }
}
