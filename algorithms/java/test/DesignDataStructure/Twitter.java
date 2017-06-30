package DesignDataStructure;

import java.util.*;

public class Twitter {
    final static int kMaximumTweets = 10;

    int timestamp;

    class Tweet {
        int id;
        int timestamp;

        Tweet(int id, int timestamp) {
            this.id = id;
            this.timestamp = timestamp;
        }
    }

    Map<Integer, Set<Integer>> followees;
    Map<Integer, Deque<Tweet>> tweets;

    /**
     * Initialize your data structure here.
     */
    public Twitter() {
        followees = new HashMap<>();
        tweets = new HashMap<>();
        timestamp = 0;
    }

    public Tweet newTweet(int tweetId) {
        return new Tweet(tweetId, timestamp++);
    }

    /**
     * Compose a new tweet.
     */
    public void postTweet(int userId, int tweetId) {
        Deque<Tweet> myTweets = tweets.getOrDefault(userId, new LinkedList<>());
        myTweets.offerFirst(newTweet(tweetId));
        if (myTweets.size() > kMaximumTweets) {
            myTweets.pollLast(); // discard the oldest
        }
        tweets.put(userId, myTweets);
    }

    /**
     * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed
     * must be posted by users who the user followed or by the user herself. Tweets must be
     * ordered from most recent to least recent.
     */
    public List<Integer> getNewsFeed(int userId) {
        int[] users = getUserIds(userId);
        List<List<Tweet>> tweets = getFeeds(users);
        return getTopKFeeds(tweets);
    }

    List<List<Tweet>> getFeeds(int[] users) {
        List<List<Tweet>> tweetList = new ArrayList<>(users.length);
        for (int user : users) {
            Deque<Tweet> t = tweets.get(user);
            if (t != null) {
                tweetList.add(new ArrayList<>(t));
            }
        }
        return tweetList;
    }

    List<Integer> getTopKFeeds(List<List<Tweet>> tweets) {
        List<Tweet> topKtweets = mergeTopKTweets(tweets, 0, tweets.size() - 1);
        List<Integer> result = new ArrayList<>(kMaximumTweets);
        for (Tweet t : topKtweets) {
            result.add(t.id);
        }
        return result;
    }

    List<Tweet> mergeTopKTweets(List<List<Tweet>> tweets, int start, int end) {
        if(start > end) return Collections.emptyList();
        if (start == end) return tweets.get(start);
        int mid = start + (end - start) / 2;
        List<Tweet> left = mergeTopKTweets(tweets, start, mid);
        List<Tweet> right = mergeTopKTweets(tweets, mid + 1, end);
        int i = 0, j = 0;
        List<Tweet> result = new ArrayList<>(kMaximumTweets);
        while (i < left.size() || j < right.size()) {
            if (j == right.size() || i < left.size() && left.get(i).timestamp > right.get(j).timestamp) {
                result.add(left.get(i++));
            } else {
                result.add(right.get(j++));
            }
            if (result.size() == kMaximumTweets) return result;
        }
        return result;
    }

    int[] getUserIds(int userId) {
        Set<Integer> followee = followees.get(userId);
        int[] users = new int[1 + (followee == null ? 0 : followee.size())];
        int i = 0;
        users[i++] = userId;
        if (followee != null) {
            for (int f : followee) {
                users[i++] = f;

            }
        }
        return users;
    }

    /**
     * Follower follows a followee. If the operation is invalid, it should be a no-op.
     */
    public void follow(int followerId, int followeeId) {
        if(followerId == followeeId) return;
        Set<Integer> followee = this.followees.getOrDefault(followerId, new HashSet<>());
        followee.add(followeeId);
        this.followees.put(followerId, followee); // in case followee is get by default;
    }

    /**
     * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
     */
    public void unfollow(int followerId, int followeeId) {
        Set<Integer> followee = this.followees.get(followerId);
        if(followee == null) return;
        followee.remove(followeeId);
    }
}
