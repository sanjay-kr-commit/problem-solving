import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

// @leet start

class Twitter {

  class node {
    int userId;
    int tweetId;
    node prev;

    public node(node prev) {
      this.prev = prev;
    }
  }

  node tweets;
  HashMap<Integer, HashSet<Integer>> followTable;

  public Twitter() {
    followTable = new HashMap<>();
  }

  public void postTweet(int userId, int tweetId) {
    tweets = new node(tweets);
    tweets.userId = userId;
    tweets.tweetId = tweetId;
  }

  public List<Integer> getNewsFeed(int userId) {
    HashSet<Integer> follower = followTable.getOrDefault(userId, new HashSet<>());
    LinkedList<Integer> feed = new LinkedList<>();
    int feedCount = 0;
    node currTweet = tweets;
    while (currTweet != null && feedCount < 10) {
      if (userId == currTweet.userId || follower.contains(currTweet.userId)) {
        feed.add(currTweet.tweetId);
        feedCount++;
      }
      currTweet = currTweet.prev;
    }
    return feed;
  }

  public void follow(int followerId, int followeeId) {
    HashSet<Integer> follower = followTable.getOrDefault(followerId, new HashSet<>());
    follower.add(followeeId);
    followTable.put(followerId, follower);
  }

  public void unfollow(int followerId, int followeeId) {
    followTable.getOrDefault(followerId, new HashSet<>())
        .remove(followeeId);
  }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
// @leet end
