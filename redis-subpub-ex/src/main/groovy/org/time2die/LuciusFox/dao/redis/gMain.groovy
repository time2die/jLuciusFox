import redis.clients.jedis.Jedis
import redis.clients.jedis.JedisPubSub

class gMain{

    public static void main(String [] args){

        Thread p = new Thread(new Runnable() {
            @Override
            public void run() {
                Jedis pubscriberJedis = new Jedis("localhost");
                try {
                    pubscriberJedis.publish("cc","123")
                    pubscriberJedis.publish("cc","345")
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        })

        Thread s = new Thread(new Runnable() {
            @Override
            public void run() {
                Jedis subscriberJedis = new Jedis("localhost");
                try {
                    subscriberJedis.subscribe(redSub,"CC");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        })

        s.start() ;
        Thread.sleep(1000) ;
        p.start() ;


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
            println "onPmessage"
        }

        @Override
        void onMessage(String channel, String message) {
            println "ch:"+ channel+ "message:"+ message
        }
    }

}