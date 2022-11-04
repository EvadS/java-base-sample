

# Improving Performance with Java’s CompletableFuture

## Increase performance with Parallel stream  
### Demo - Synchronous Implementation
total time is more 9 sec. 1 sec per one transaction

### DemoParallel
our application runs  faster
my computer has 8 processor so if we run the code above with ten transactions 
it should take at least 1 second. One operation for one processor

### CompletableFuture

CompletableFuture.supplyAsync()
supplyAsync(Supplier<U> supplier,Executor executor)

Supplier is functional interface -> 
```java
{
    T get();
}
```
It doesn't get any param as argument
