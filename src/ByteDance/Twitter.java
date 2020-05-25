package ByteDance;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * 功能描述
 *
 * @author z00533892
 * @since 2020-04-13
 */
public class Twitter {

    int twitTime = 0;
    LinkedList<HashMap<Integer, Integer>> twits;
    HashMap<Integer, LinkedList<Twit>> users;

    /**
     * Initialize your data structure here.
     */
    public Twitter() {
        twits = new LinkedList<>();
        users = new HashMap<>();
    }

    /**
     * Compose a new tweet.
     */
    public void postTweet(int userId, int tweetId) {
        Twit temp = new Twit(tweetId, twitTime++);
        if (users.containsKey(userId)) {
            users.get(userId).add(temp);
        } else {
            LinkedList<Twit> twits = new LinkedList<>();
            twits.add(temp);
            users.put(userId, twits);
        }
    }

    /**
     * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
     */
    public List<Integer> getNewsFeed(int userId) {
        return null;
    }

    /**
     * Follower follows a followee. If the operation is invalid, it should be a no-op.
     */
    public void follow(int followerId, int followeeId) {

    }

    /**
     * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
     */
    public void unfollow(int followerId, int followeeId) {

    }

}

class Twit {
    private int id;
    private int time;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public Twit(int id, int time) {
        this.id = id;
        this.time = time;
    }
}