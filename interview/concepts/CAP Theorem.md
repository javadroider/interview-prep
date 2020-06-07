## CAP Theorem 
### 1. Consistency 
- Assuming you have a storage system which has more than one machine, consistency implies that the data is same across the cluster, so you can read or write to/from any node and get the same data.  
- All users see the same data at the same time
- **Eventual consistency** : Exactly what the name suggests. In a cluster, if multiple machines store the same data, an eventual consistent model implies that all machines will have the same data eventually. Its possible that at a given instance, those machines have different versions of the same data ( temporarily inconsistent ) but they will eventually reach a state where they have the same data.  
### 2. Availability
- In the context of a database cluster, Availability refers to the ability to always respond to queries ( read or write ) irrespective of nodes going down.  
- System continues to function even with node failures
### 3. Partition Tolerance
- In the context of a database cluster, cluster continues to function even if there is a “partition” (communications break) between two nodes (both nodes are up, but can’t communicate).
- System continues to function even if communication fails

#### CA - RDBMS
#### PA - Cassandra, CouchDB
#### CP - BigTable, Mongon DB, HBase


