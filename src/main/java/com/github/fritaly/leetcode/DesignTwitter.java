package com.github.fritaly.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicInteger;

public class DesignTwitter {

	public static class Twitter {
		
		private static final AtomicInteger sequence = new AtomicInteger();
		
		private static class Tweet implements Comparable<Tweet> {
			final int id;
			
			final int order = sequence.incrementAndGet();
			
			Tweet previous;
			
			public Tweet(int id) {
				this.id = id;
			}
			
			@Override
			public int compareTo(Tweet other) {
				return -1 * Integer.compare(this.order, other.order);
			}
		}
		
		private static class User {
			final int id;
			
			final Set<Integer> followees = new TreeSet<Integer>();
			
			Tweet latestTweet;
			
			public User(int id) {
				this.id = id;
			}
			
			void tweet(int tweetId) {
				final Tweet tweet = new Tweet(tweetId);
				
				if (latestTweet != null) {
					tweet.previous = latestTweet;
				}
				
				latestTweet = tweet;
			}
		}
		
		final Map<Integer, User> users = new HashMap<Integer, User>();

	    /** Initialize your data structure here. */
	    public Twitter() {
	    }
	    
	    private User getOrCreateUser(int userId) {
	    	User user = users.get(userId);
	    	
	    	if (user == null) {
	    		user = new User(userId);
	    		
	    		users.put(userId, user);
	    	}
	    	
	    	return user;
	    }
	    
	    List<User> getUserAndFollowees(int userId) {
	    	User user = users.get(userId);
	    	
	    	if (user == null) {
	    		return Collections.emptyList();
	    	}
	    	
			final List<User> result = new ArrayList<User>();
			result.add(user);
	    	
	    	for (int followeeId : user.followees) {
				User followee = users.get(followeeId);
				
				if (followee != null) {
					result.add(followee);
				}
			}
	    	
	    	return result;
		}
	    
	    /** Compose a new tweet. */
	    public void postTweet(int userId, int tweetId) {
	    	getOrCreateUser(userId).tweet(tweetId);
	    }
	    
	    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
	    public List<Integer> getNewsFeed(int userId) {
	    	if (!users.containsKey(userId)) {
	    		return Collections.emptyList();
	    	}
	        
	    	final List<Tweet> tweets = new ArrayList<Tweet>();
	    	
	    	for (User aUser : getUserAndFollowees(userId)) {
	    		Tweet current = aUser.latestTweet;
	    		
	    		while (current != null) {
	    			tweets.add(current);
	    			
	    			current = current.previous;
	    		}
			}
	    	
	    	Collections.sort(tweets);
	    	
	    	final List<Integer> result = new ArrayList<Integer>();
	    	
	    	for (int i = 0; i < Math.min(10, tweets.size()); i++) {
				result.add(tweets.get(i).id);
			}
	    	
	    	return result;
	    }
	    
	    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
	    public void follow(int followerId, int followeeId) {
	    	if (followerId != followeeId) {
		    	User user = getOrCreateUser(followerId);
		    	
		    	if (user != null) {
		    		user.followees.add(followeeId);
		    	}	    		
	    	}
	    }
	    
	    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
	    public void unfollow(int followerId, int followeeId) {
	    	if (followerId != followeeId) {
		    	User user = users.get(followerId);
		    	
		    	if (user != null) {
		    		user.followees.remove(followeeId);
		    	}	    		
	    	}
	    }
	}
	
	public static void main(String[] args) {
		Twitter twitter = new Twitter();

		// User 1 posts a new tweet (id = 5).
		twitter.postTweet(1, 5);

		// User 1's news feed should return a list with 1 tweet id -> [5].
		System.out.println(twitter.getNewsFeed(1));

		// User 1 follows user 2.
		twitter.follow(1, 2);

		// User 2 posts a new tweet (id = 6).
		twitter.postTweet(2, 6);

		// User 1's news feed should return a list with 2 tweet ids -> [6, 5].
		// Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
		System.out.println(twitter.getNewsFeed(1));

		// User 1 unfollows user 2.
		twitter.unfollow(1, 2);

		// User 1's news feed should return a list with 1 tweet id -> [5],
		// since user 1 is no longer following user 2.
		System.out.println(twitter.getNewsFeed(1));
	}
}