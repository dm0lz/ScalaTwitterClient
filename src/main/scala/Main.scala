package com.example.myproj

import com.redis._
import twitter4j.TwitterFactory
import twitter4j.Twitter
import twitter4j.conf.ConfigurationBuilder

object Main extends App {
    // Create Redis Object
    val r = new RedisClient("redis.fetcher", 6379)

    // create a twitter object
    val cb = new ConfigurationBuilder()
    cb.setDebugEnabled(true)
      .setOAuthConsumerKey("qSXgYnfl9TQHL0rcRw")
      .setOAuthConsumerSecret("zhzEDv12a87RimkvaisEi5IZvqISzEVmf2gDIJQCuw")
      .setOAuthAccessToken("308762265-ahoa4FzpufTaPRghxHsChqwTwMRIRaJfHkmkn5Ip")
      .setOAuthAccessTokenSecret("UwAWZJlhSGiBNgbHtDqiS2ILZJuprd091rUNbETE")
    val tf = new TwitterFactory(cb.build())
    val twitter = tf.getInstance()

    // use the twitter object to get your friend's timeline
    val statuses = twitter.getHomeTimeline()
    System.out.println("Showing friends timeline.")
    val it = statuses.iterator()
    while (it.hasNext()) {
      val status = it.next()
   //   println(status.getUser().getName() + ":" +
  //            status.getText());
 //   }
      r.set("1", status.getUser());
    }
    println("hello sbt.g8")
    
    //r.set("olivier", "test_OLI")
    println(r.get("1").get)
}
