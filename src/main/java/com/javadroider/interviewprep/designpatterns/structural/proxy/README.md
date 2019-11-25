- Proxy pattern intent is to “Provide a surrogate or placeholder for another object to control access to it”. The definition itself is very clear and proxy pattern is used when we want to provide controlled access of a functionality.

- Let’s say we have a class that can run some command on the system. Now if we are using it, its fine but if we want to give this program to a client application, it can have severe issues because client program can issue command to delete some system files or change some settings that you don’t want.
1. Create a "wrapper" for a remote, or expensive, or sensitive target
2. Encapsulate the complexity/overhead of the target in the wrapper
3. The client deals with the wrapper
4. The wrapper delegates to the target
