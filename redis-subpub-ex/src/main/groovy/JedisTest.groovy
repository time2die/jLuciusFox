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

        // publish away!
        publishLatch.countDown();

        messageReceivedLatch.await();
        log("Got message: %s", messageContainer.iterator().next());

        jedisPubSub.unsubscribe();
    }

    private void setupPublisher() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    log("Connecting");
                    Jedis jedis = jPool.getResource() ;
                    log("Waiting to publish");
                    publishLatch.await();
                    log("Ready to publish, waiting one sec");
                    Thread.sleep(1000);
                    log("publishing");
                    jedis.publish("test", "This is a message");
                    log("published, closing publishing connection");
                    jedis.quit();
                    log("publishing connection closed");
                } catch (Exception e) {
                    log(">>> OH NOES Pub, " + e.getMessage());
                    // e.printStackTrace();
                }
            }
        }, "publisherThread").start();
    }

    private JedisPubSub setupSubscriber() {
        final JedisPubSub jedisPubSub = new JedisPubSub() {
            @Override
            public void onUnsubscribe(String channel, int subscribedChannels) {
                log("onUnsubscribe");
            }

            @Override
            public void onSubscribe(String channel, int subscribedChannels) {
                log("onSubscribe");
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
                log("Message received");
                messageReceivedLatch.countDown();
            }
        };
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    log("Connecting");
                    Jedis jedis = jPool.getResource();
                    log("subscribing");
                    jedis.subscribe(jedisPubSub, "test");
                    log("subscribe returned, closing down");
                    jedis.quit();
                } catch (Exception e) {
                    log(">>> OH NOES Sub - " + e.getMessage());
                    // e.printStackTrace();
                }
            }
        }, "subscriberThread").start();
        return jedisPubSub;
    }

    static final long startMillis = System.currentTimeMillis();

    private static void log(String string, Object... args) {
        long millisSinceStart = System.currentTimeMillis() - startMillis;
        System.out.printf("%20s %6d %s\n", Thread.currentThread().getName(), millisSinceStart,
                String.format(string, args));
    }
}