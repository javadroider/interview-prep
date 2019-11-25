[https://www.youtube.com/watch?v=wYk0xPP_P_8](https://www.youtube.com/watch?v=wYk0xPP_P_8)

## 1. Why do we need Twitter?

## 1. Requirements and Goals of the System

**Functional Requirements:**

 - User should be able to tweet to the followers as fast as possible. Sometimes a particular user will be having about millions of followers, so user should be able to send the tweet to all of the followers in about few seconds
 - User Timeline
	 - Home timeline - List of tweets from all the people or the pages you are following
	 - User timeline - List of tweets you have made
 - Search keywords in tweets
 - Trend - List of all the trending hashtags or the topics to see what's going on in your location

**Non-Functional Requirements:**

**Extended Requirements:**

## 3. Capacity Estimation and Constraints

- Twitter gets 300M users per month.
- Twitter gets about 600 tweets per second
- Reads are about 600,000 per sec
- This is a read heavy system. As per the above data it is 1000:1 ratio between read and write.
- No need to have data consistency - eventual consistency is fine
- Twitter has a restriction of 140 characters which is not that big.


## 4. System APIs


## 5. Database Design

There will be three tables.
 1. User
 2. Tweets
 3. Followers

 One to many relationship between User & Tweets
 One to many relationship between User & Followers

 Since we Twitter is read heavy system, data should be available in the memory. We should not spend time in loading the data from the database which will slow down the read operation. We can think of using Redis as all the data is stored in the memory, and it can scale horizontally anytime load increases.
### How we will store data in Redis?
<USER_ID> - Tweets : [1, 2, 3, 4 ..... ]
<USER_ID> - Followers : [1, 2, 3, 4 ..... ]

## 6. Basic System Design and Algorithm
### How to load user timeline?
 1. One option, go to the user table by the user ID, get all the tweets/retweets, sort by the date and time and then give back the data, but this will be very slow as data is coming from the database.
 2. Another option is to use Redis.
	- In this option we need to make sure that we keep saving the data in Redis whenever someone tweets
	- USER_ID - User Tweets : [1, 2, 3, 4....]
	- TWEET_ID - 1: "Hello"
### How to load home timeline?
#### Option1 : Query database
 1. Get all the followers user is following
 2. For each follower get all the latest tweets
 3. Merge and display

This approach will  not work as Twitter is read heavy system.
- We need to make one query for each follower, and one user might be following hundreds of users; moreover, we also need to merge the result to show latest data sorted by date.
- Executing these many queries and achieving a response time of milli seconds is not possible
#### Option2 : Fanout
Fanout means moving to different direction from a single point.
- Whenever we get a tweet we should do pre-processing and then distribute the data into different users' home timeline, so we can reduce the queries we need to make when there's a request to compute the home timeline for a particular user
- Lets say there is one user who is having 5 followers
	- Whenever user tweets we need to store the data to DB
	- Make entries in the User timeline cache
	- Create entries in the followers' home timelines which will make accessing home timeline faster
- In this approach we are not at all querying database which will make response time shorter
- This approach might not work if the user is a celerbrity having millions of followers. In this case fanout process might take couple of minutes even though we are using Redis.
- To handle celebrity issue,
	- We can maintain a list of celebrity users particular user is following in Redis cache.
	- First query home timeline cache and return the response to UI
	- Query celebrity_users cache to get celebrity users. For each celebrity, go to celebrity's user timeline and check if there is any recent tweet made. If yes, add it to the response.
#### Optimization
- We can remove users who have not logged in to the twitter for a longer from the fanout process. It will save memory and computation

 ### How to calculate trends?
 Important points
 - Volume of tweets
 - Time taken to generate tweets
1000 tweets in 5 minutes is much interesting than 10,000 tweets in 1 month

#### Technique
we can implement it using different phases using Kafka streams as shown in the diagram below.

 - Filter can help in removing content which should be tagged inside trending tags
 - Parse can help in identifying hashtag for the tweets without any tags
 - Count hash tags will count tweets on the fly using a window period of n minutes

 ### How to search timeline?
 - Tweets can be stored in the inverted index fashion in the nodes
 - Search results can be combined from multiple nodes using 'scatter and gather' technique.

