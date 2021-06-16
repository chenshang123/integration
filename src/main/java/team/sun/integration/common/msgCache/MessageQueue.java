package team.sun.integration.common.msgCache;

import java.util.LinkedList;

import org.springframework.stereotype.Component;

@Component
public class MessageQueue {
    private static int MAX_LIMIT = 500;
    private LinkedList<Message> queue;
    private int limit;

    public MessageQueue() {
        this(MAX_LIMIT);
    }

    public MessageQueue(int limit) {
        this.queue = new LinkedList<>();
        this.limit = limit;
    }

    /**
     * 将数据存放到队列中
     *
     * @param message
     */
    public void put(Message message) {
        synchronized (queue) {
            while (queue.size() > limit) {
                try {
                    queue.wait();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            queue.addLast(message);
            queue.notifyAll();
        }
    }

    /**
     * 将队列的数据拿出来
     *
     * @return
     */
    public Message take() {
        synchronized (queue) {
            while (queue.isEmpty()) {
                try {
                    queue.wait();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            Message message = queue.removeFirst();
            queue.notifyAll();
            return message;

        }
    }

    /**
     * 获取队列最大的存放数量
     *
     * @return
     */
    public int getMaxLimit() {
        return this.limit;
    }

    /**
     * 获取队列当前大小
     *
     * @return
     */
    public int getQueueSize() {
        synchronized (queue) {
            return queue.size();
        }
    }
}
