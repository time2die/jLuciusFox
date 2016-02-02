import redis.clients.jedis.Jedis
import redis.clients.jedis.JedisPool
import redis.clients.jedis.JedisPubSub

class gMain{
    static JedisPool jedisPool ;
    public static void main(String [] args){
        jedisPool = new JedisPool() ;
        Thread p = new Thread(new Runnable() {
            @Override
            public void run() {
                Jedis pubscriberJedis = jedisPool.getResource() ;
                try {
                    Thread.sleep(1000) ;
                    pubscriberJedis.publish("cc","123")
                    pubscriberJedis.publish("cc","345")
                    pubscriberJedis.quit();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        })

        Thread s = new Thread(new Runnable() {
            @Override
            public void run() {
                Jedis subscriberJedis = jedisPool.getResource() ;
                try {
                    subscriberJedis.subscribe(redSub,"cc");
                    subscriberJedis.quit() ;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        })

        p.start() ;
        s.start() ;
        Thread.sleep(2000)
        redSub.unsubscribe() ;
    }

    static JedisPubSub redSub = new JedisPubSub() {
        public void onUnsubscribe(String channel, int subscribedChannels) {
            println("onUnsubscribe");
        }

        @Override
        public void onSubscribe(String channel, int subscribedChannels) {
            println("onSubscribe");
        }

        @Override
        public void onPUnsubscribe(String pattern, int subscribedChannels) {
            println "onPUnsubscribe"
        }

        @Override
        public void onPSubscribe(String pattern, int subscribedChannels) {
        }

        @Override
        public void onPMessage(String pattern, String channel, String message) {
            println "onPmessage:"+ message
        }

        @Override
        void onMessage(String channel, String message) {
            println "ch:"+ channel+ "message:"+ message
        }
    }
}