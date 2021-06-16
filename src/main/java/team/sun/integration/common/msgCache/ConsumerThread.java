package team.sun.integration.common.msgCache;

public class ConsumerThread extends Thread {
    private MessageQueue messageQueue;

    public ConsumerThread(MessageQueue messageQueue, int seq) {
        //为线程起名字
        super("Consumer>>>>>" + seq);
        this.messageQueue = messageQueue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Message message = messageQueue.take();
                System.out.println(Thread.currentThread().getName() + "   get MessageData：" + message.getData());
                Thread.sleep(100);
            } catch (Exception e) {
                break;
            }

        }
    }
}
