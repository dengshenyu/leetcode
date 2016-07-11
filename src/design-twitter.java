import java.util.*;

/**
 * Created by shenyuan on 16/3/12.
 */

public class Solution {
    public static class Twitter {
        public static class Node {
            int tweetId;
            int order;
            public Node(int tweetId, int order) {
                this.tweetId = tweetId;
                this.order = order;
            }
        }
        private Map<Integer, LinkedList<Node>> tweets;
        private Map<Integer, Set<Integer>> follows;
        private int order;

        /** Initialize your data structure here. */
        public Twitter() {
            tweets = new HashMap<Integer, LinkedList<Node>>();
            follows = new HashMap<Integer, Set<Integer>>();
        }

        /** Compose a new tweet. */
        public void postTweet(int userId, int tweetId) {
            LinkedList<Node> ts = tweets.get(userId);
            if (ts == null) {
                ts = new LinkedList<Node>();
                tweets.put(userId, ts);
            }
            ts.addFirst(new Node(tweetId, order++));
        }

        /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
        public List<Integer> getNewsFeed(int userId) {
            LinkedList<Node> news = new LinkedList<Node>();
            Set<Integer> fs = follows.get(userId);
            if (fs == null)
                fs = new HashSet<Integer>();
            fs.add(userId);
            for (Integer i : fs) {
                LinkedList<Node> ns = tweets.get(i);
                if (ns != null) {
                    int c = 0;
                    for (Node t : ns) {
                        int j = 0;
                        while (j < news.size()) {
                            if (t.order > news.get(j).order) {
                                news.add(j, t);
                                break;
                            }
                            j++;
                        }
                        if (j == news.size())
                            news.addLast(t);
                        if (news.size() > 10)
                            news.remove(10);
                        if (++c == 10)
                            break;
                    }
                }
            }
            LinkedList<Integer> res = new LinkedList<Integer>();
            for (Node n : news)
                res.add(n.tweetId);
            return res;
        }

        /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
        public void follow(int followerId, int followeeId) {
            if (followerId == followeeId)
                return;
            Set<Integer> fs = follows.get(followerId);
            if (fs == null) {
                fs = new HashSet<Integer>();
                follows.put(followerId, fs);
            }
            fs.add(followeeId);
        }

        /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
        public void unfollow(int followerId, int followeeId) {
            if (followerId == followeeId)
                return;
            Set<Integer> fs = follows.get(followerId);
            if (fs != null && fs.contains(followeeId))
                fs.remove(followeeId);
        }
    }



    public static void main(String[] args) {
        Twitter twitter = new Twitter();

// User 1 posts a new tweet (id = 5).
        twitter.postTweet(1, 5);

// User 1's news feed should return a list with 1 tweet id -> [5].
        for (Integer i : twitter.getNewsFeed(1))
                System.out.print(i + " ");

// User 1 follows user 2.
        twitter.follow(1, 2);

// User 2 posts a new tweet (id = 6).
        twitter.postTweet(2, 6);

// User 1's news feed should return a list with 2 tweet ids -> [6, 5].
// Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
        for (Integer i : twitter.getNewsFeed(1))
                System.out.print(i + " ");

// User 1 unfollows user 2.
        twitter.unfollow(1, 2);

// User 1's news feed should return a list with 1 tweet id -> [5],
// since user 1 is no longer following user 2.
        for (Integer i : twitter.getNewsFeed(1))
            System.out.print(i + " ");
    }


}