[https://www.youtube.com/watch?v=JQDHz72OA3c](https://www.youtube.com/watch?v=JQDHz72OA3c)
[https://www.educative.io/collection/page/5668639101419520/5649050225344512/5668600916475904](https://www.educative.io/collection/page/5668639101419520/5649050225344512/5668600916475904)

## 1. Why do we need URL shortening?

URL shortening is used to create shorter aliases for long URLs. We call these shortened aliases “short links.” Users are redirected to the original URL when they hit these short links. Short links save a lot of space when displayed, printed, messaged, or tweeted. Additionally, users are less likely to mistype shorter URLs.

For example, if we shorten this page through TinyURL:

> [https://github.com/javadroider/AlgoDSInJava](https://github.com/javadroider/AlgoDSInJava)

We would get:

> [**http://tinyurl.com/y683hoxv**](**http://tinyurl.com/y683hoxv**)

The shortened URL is nearly one-third the size of the actual URL.

URL shortening is used for optimizing links across devices, tracking individual links to analyze audience and campaign performance, and hiding affiliated original URLs.

## 2. Requirements and Goals of the System

**Functional Requirements:**
1.  Given a URL, our service should generate a shorter and unique alias of it. This is called a short link.
2.  When users access a short link, our service should redirect them to the original link.
3.  Users should optionally be able to pick a custom short link for their URL.
4.  Links will expire after a standard default timespan. Users should be able to specify the expiration time.

**Non-Functional Requirements:**
1.  The system should be highly available. This is required because, if our service is down, all the URL redirections will start failing.
2.  URL redirection should happen in real-time with minimal latency.
3.  Shortened links should not be guessable (not predictable).

**Extended Requirements:**

1.  Analytics; e.g., how many times a redirection happened?
2.  Our service should also be accessible through REST APIs by other services.

## 3. Capacity Estimation and Constraints

Let's compare our system with Twitter to get the number of requests
- Twitter gets 300M users per month.
- Let's assume our system is 10% popular compared to Twitter which will give 30M users per month
- Our system will be read-heavy. There will be lots of redirection requests compared to new URL shortenings. Let’s assume 100:10 ratio between read and write.
- There will be 3M new URLs per month resulting in 100,000 URLs per day



## 4. System APIs

Following could be the definitions of the APIs for creating and deleting URLs:

    > createURL(api_dev_key, original_url, custom_alias=None,user_name=None, expire_date=None)

**Parameters:**

- **api_dev_key (string)**: The API developer key of a registered account. This will be used to, among other things, throttle users based on their allocated quota.
- **original_url (string)**: Original URL to be shortened.
- **custom_alias (string)**: Optional custom key for the URL.
- **user_name (string)**: Optional user name to be used in encoding.
- **expire_date (string)**: Optional expiration date for the shortened URL.

**Returns:**  (string)
A successful insertion returns the shortened URL; otherwise, it returns an error code.

> `deleteURL(api_dev_key, url_key)`

Where “url_key” is a string representing the shortened URL to be retrieved. A successful deletion returns ‘URL Removed’.

**How do we detect and prevent abuse?**  A malicious user can put us out of business by consuming all URL keys in the current design. To prevent abuse, we can limit users via their api_dev_key. Each api_dev_key can be limited to a certain number of URL creations and redirections per some time period (which may be set to a different duration per developer key).

## 5. Database Design
A few observations about the nature of the data we will store:
1.  We need to store billions of records.
2.  Each object we store is small (less than 1K).
3.  There are no relationships between records—other than storing which user created a URL.
4.  Our service is read-heavy.

#### Database Schema:
We would need two tables: one for storing information about the URL mappings, and one for the user’s data who created the short link.

**1. URL**
 - hash : varchar(16)
 - originalUrl : varchar(512)
 - createdDate : datetime
 - expiryDate : datetime

**2. User**
 - name : varchar(20)
 - email : varchar(32)
 - createdDate : datetime
 - lastLogin : datetime

 **What kind of database should we use?** Since we anticipate storing billions of rows, and we don’t need to use relationships between objects – a NoSQL key-value store like [DynamoDB](https://en.wikipedia.org/wiki/Amazon_DynamoDB), [Cassandra](https://en.wikipedia.org/wiki/Apache_Cassandra) or [Riak](https://en.wikipedia.org/wiki/Riak) is a better choice. A NoSQL choice would also be easier to scale.

## 6. Basic System Design and Algorithm
### a. Encoding actual URL

We can compute a unique hash (e.g.,  [MD5](https://en.wikipedia.org/wiki/MD5)  or  [SHA256](https://en.wikipedia.org/wiki/SHA-2), etc.) of the given URL. The hash can then be encoded for displaying. This encoding could be base36 ([a-z ,0-9]) or base62 ([A-Z, a-z, 0-9]) and if we add ‘-’ and ‘.’ we can use base64 encoding. A reasonable question would be, what should be the length of the short key? 6, 8 or 10 characters.

Using base64 encoding, a 6 letter long key would result in 64^6 = ~68.7 billion possible strings
Using base64 encoding, a 7 letter long key would result in 64^7 = ~4.3 trillion possible strings
Using base64 encoding, an 8 letter long key would result in 64^8 = ~281 trillion possible strings

With 68.7B unique strings, let’s assume six letter keys would suffice for our system.
100,000 new URLs per day = 68.7B/100,000/365 = 1,882 years

### b. Technique
- Maintain a counter and keep incrementing to get the next short URL
- Maintain counter ranges in the zookeeper
- Each application server will run a counter from an assigned range. Once the range is over, application server will ask zookeeeper for the next available range
- As soon as new application server, it will ask zookeeper to give the range.
- If server goes down, we need not worry about it as we have many combinations
- When an application server runs out of the range, it will ask zookeeper to give one more range

## 7. Data Partitioning and Replication

To scale out our DB, we need to partition it so that it can store information about billions of URLs. We need to come up with a partitioning scheme that would divide and store our data into different DB servers.

**a. Range Based Partitioning:**  We can store URLs in separate partitions based on the first letter of the hash key. Hence we save all the URLs starting with letter ‘A’ in one partition, save those that start with letter ‘B’ in another partition and so on. This approach is called range-based partitioning. We can even combine certain less frequently occurring letters into one database partition. We should come up with a static partitioning scheme so that we can always store/find a URL in a predictable manner.

The main problem with this approach is that it can lead to unbalanced DB servers. For example, we decide to put all URLs starting with letter ‘E’ into a DB partition, but later we realize that we have too many URLs that start with letter ‘E’.

**b. Hash-Based Partitioning:**  In this scheme, we take a hash of the object we are storing. We then calculate which partition to use based upon the hash. In our case, we can take the hash of the ‘key’ or the short link to determine the partition in which we store the data object.

Our hashing function will randomly distribute URLs into different partitions (e.g., our hashing function can always map any ‘key’ to a number between [1…256]), and this number would represent the partition in which we store our object.

This approach can still lead to overloaded partitions, which can be solved by using  Consistent Hashing.
