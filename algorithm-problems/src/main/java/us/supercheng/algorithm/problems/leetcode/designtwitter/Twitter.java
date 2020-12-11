package us.supercheng.algorithm.problems.leetcode.designtwitter;

import java.util.*;

class Twitter {

    List<Post> posts;
    Map<Integer, Set<Integer>> followMap;

    class Post {
        public int id;
        public int userId;
        public Post(int id, int userId) {
            this.id = id;
            this.userId = userId;
        }
    }

    public Twitter() {
        this.posts = new ArrayList<>();
        this.followMap = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        this.posts.add(new Post(tweetId, userId));
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> ret = new ArrayList<>();
        Set<Integer> followers = this.followMap.get(userId);
        for (int i=this.posts.size()-1;i>-1 && ret.size() < 10;i--) {
            Post each = this.posts.get(i);
            if ((each.userId == userId) || (followers != null && followers.contains(each.userId)))
                ret.add(each.id);
        }
        return ret;
    }

    public void follow(int followerId, int followeeId) {
        Set<Integer> followeeSet = this.followMap.get(followerId);
        if (followeeSet == null) {
            followeeSet = new HashSet<>();
            this.followMap.put(followerId, followeeSet);
        }
        followeeSet.add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        Set<Integer> followeeSet = this.followMap.get(followerId);
        if(followeeSet != null && followeeSet.contains(followeeId))
            followeeSet.remove(followeeId);
    }
}