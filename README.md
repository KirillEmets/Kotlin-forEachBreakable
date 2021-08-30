# Kotlin-forEachBreakable
Extension function for Iterable that makes it possible to use Break and Continue keywords inside forEach action

# Problem
Consider this for loop:
```kotlin
val list = listOf(1, 2, 3, 4, 5)

for(x in list) {
    if(x % 2 == 0)
        continue

    print(x)
}
```
```
Output: 135
```

Pretty straightforward. But what if we want to use ```list.forEach()``` instead?

```kotlin
list.forEach {x ->
    if (x % 2 == 0)
        return@forEach

    print(x)
}
```

It does the same, but it's a bit harder to read, because we are all so familiar with "continue" keyword. Same for "break".


So, can we make it possible to use those keywords in forEach? The answer is ~~No, no way. Please don't do it~~ **Yes**!


Meet ```forEachBreakable```! You can use it like this:

```kotlin
list.forEachBreakable { x ->
    if (x % 2 == 0)
        Continue

    print(x)
}
```
```
Output: 135
```

Amazing, huh? Break is also available:

```kotlin
list.forEachBreakable { x ->
    if (x % 2 == 0)
        Break

    print(x)
}
```
```
Output: 1
```

If you want to use it, just copy the ForEachBreakable.kt to your project and you are ready to go!

P.S.  Consider reading what it does before using it, you might not like it.

P.P.S.  I know this is stupid af, it was fun to implement though
