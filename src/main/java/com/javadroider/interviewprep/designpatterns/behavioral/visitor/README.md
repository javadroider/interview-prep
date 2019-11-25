- Visitor pattern is used when we have to perform an operation on a group of similar kind of Objects. 
- With the help of visitor pattern, we can move the operational logic from the objects to another class and if the logic of operation changes, then we need to make change only in the visitor implementation rather than doing it in all the item classes

- **For example,**
Think of a Shopping cart where we can add different type of items (Elements). When we click on checkout button, it calculates the total amount to be paid. Now we can have the calculation logic in item classes or we can move out this logic to another class using visitor pattern. 
