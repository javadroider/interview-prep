## Bitmasks

- Bitmasking is a technique used to perform operations at the bit level. Leveraging bitmasks often leads to faster runtime complexity and helps limit memory usage
- Test kth bit: s & (1 << k);
- Set kth bit: s |= (1 << k);
- Turn off kth bit: s &= ~(1 << k);
- Toggle kth bit: s ^= (1 << k);
- Multiple by 2n: s << n;
- Divide by 2n: s >> n;
- Intersection: s & t;
- Union: s | t;
- Set Subtraction: s & ~t;
- Extract lowest set bit: s & (-s);
- Extract lowest unset bit: ~s & (s + 1);
- Swap Values: x ^= y; y ^= x; x ^= y;
