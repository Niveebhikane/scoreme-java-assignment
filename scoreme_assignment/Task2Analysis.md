### 1. Cause
ConcurrentModificationException occurs when a collection is modified while iterating using an iterator.

### 2. Likely Code Pattern
for (Transaction t : list) {
    if (condition) {
        list.remove(t);
    }
}

### 3. Fix
Iterator<Transaction> it = list.iterator();
while (it.hasNext()) {
    Transaction t = it.next();
    if (condition) {
        it.remove();
    }
}
