import redis.clients.jedis.Jedis
import redis.clients.jedis.JedisPool
import redis.clients.jedis.JedisPubSub

import java.util.concurrent.CountDownLatch

public class JedisTest {
    static JedisPool jPool ;
    private ArrayList<String> messageContainer = new ArrayList<String>();

    private CountDownLatch messageReceivedLatch = new CountDownLatch(1);
    private CountDownLatch publishLatch = new CountDownLatch(1);

    public static void main(String[] args) throws InterruptedException {
        new JedisTest().run();
    }

    private void run() throws InterruptedException {
        jPool = new JedisPool() ;

        setupPublisher();
        JedisPubSub jedisPubSub = setupSubscriber();


        publishLatch.countDown();
        messageReceivedLatch.await();

        jedisPubSub.unsubscribe();
    }

    private void setupPublisher() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Jedis jedis = jPool.getResource() ;
                    publishLatch.await();
                    Thread.sleep(1000);
                    jedis.publish("test", "This is a message");
                    jedis.quit();
                } catch (Exception e) {
                }
            }
        }, "publisherThread").start();
    }

    private JedisPubSub setupSubscriber() {
        final JedisPubSub jedisPubSub = new JedisPubSub() {
            @Override
            public void onUnsubscribe(String channel, int subscribedChannels) {

            }

            @Override
            public void onSubscribe(String channel, int subscribedChannels) {

            }

            @Override
            public void onPUnsubscribe(String pattern, int subscribedChannels) {
            }

            @Override
            public void onPSubscribe(String pattern, int subscribedChannels) {
            }

            @Override
            public void onPMessage(String pattern, String channel, String message) {
            }

            @Override
            public void onMessage(String channel, String message) {
                messageContainer.add(message);
                messageReceivedLatch.countDown();
            }
        };
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Jedis jedis = jPool.getResource();
                    jedis.subscribe(jedisPubSub, "test");
                    jedis.quit();
                } catch (Exception e) {
                }
            }
        }, "subscriberThread").start();
        return jedisPubSub;
    }

}