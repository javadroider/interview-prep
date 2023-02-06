
## Capacity Planning
- 200 countries in the world
- 4000 cities in India
- World population - 8 billion
- India population - 1.4 billion
- 1 Billion users, 100 million users using feature, 10 million DAU
- 2 million websocket connections per server ([Whatsapp](https://blog.whatsapp.com/1-million-is-so-2011))
- Quad core machine
    - [300K requests per sec for redis](https://skipperkongen.dk/2013/08/27/how-many-requests-per-second-can-i-get-out-of-redis/)
    - 100 GB memory

## Patterns

## Concepts

- Communication Protocols
	- Websockets
	- Server Side Events
	- Long polling
- [Redis pipelining](https://redis.io/docs/manual/pipelining/)
- Read-your-writes consistency
- Thundering herd problem
    - [https://instagram-engineering.com/thundering-herds-promises-82191c8af57d](https://instagram-engineering.com/thundering-herds-promises-82191c8af57d)
    - Request collapsing
    - Adding promise
- Erasure coding(Alex -2, S3 like object storage)
- System design patterns(Grokking advanced)
    - Bloomfilters
    - Consistent hashing
        - vNodes
    - Obvious ones
        - Quorum
        - Leader and follower
        - Lease
        - Heartbeat
        - Checksum
    - Write ahead log
    - Segmented log
    - High water mark index
    - Gossip protocol
    - Phi Accrual Failure Detection - Outputs a suspicion level about the server
    - Split Brain
        - Zombie leader
        - Generation clock
    - Fencing
        - 2 Techniques
            - Resource fencing
            - Node fencing - power off or reset the node
                - **STONIT**(Shoot The Other Node In The Head)
    - Vector clocks
    - PACELC Theorem
    - Hinted Handoff
    - Sloppy quorum
    - Read repair
    - Merkle tree
        - It is a binary tree of hashes, where each internal node is the hash of its two children, and each leaf node is a hash of a portion of the original data.
    - Geohash - Proximity service
    	- Encodes geographic coordinates (latitude and longitude) into a short string of digits and letters describing an area on a map, which is called a cell, with varying resolutions. The more characters in the string, the more precise the location.
		-  4 -> (39.1km x 19.5km), 6 -> (1.2km x 600m)
    - To Read
        - Hierarchical timing wheels
        - Operational transformation
        - Count min sketch
        - Hyperloglog
        - Raft/Paxos








