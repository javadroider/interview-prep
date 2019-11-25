- In observer design pattern multiple observer objects registers with a subject for change notification. When the state of subject changes, it notifies the observers. Objects that listen or watch for change are called observers and the object that is being watched for is called subject.


**Important Points on Observer Design Pattern**

- Subject provides interface for observers to register and unregister themselves with the subject.
- Subject knows who its subscribers are.
- Multiple observers can subscribe for notifications.
- Subject publishes the notifications.
- Subject just sends the notification saying the state has changed. It does not pass any state information.
- Once the notification is received from subject, observers call the subject and get data that is changed.

The above last two points are not strictly followed in observer design pattern implementation. Along with the notification, state is also passed in some implementation so that the observer need not query back to know the status. It is better not to do this way.
