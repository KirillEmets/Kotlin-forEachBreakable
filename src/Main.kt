fun main() {
    val list = listOf(1, 2, 3, 4, 5)

    list.forEachContinue { x ->
        if (x % 2 == 0)
            Continue

        print(x)
    }
    // Output: 135

    println()
    list.forEachContinue { x ->
        if (x % 2 == 0)
            Break

        print(x)
    }
    // Output: 1

    println()
    list.forEachContinue { x ->
        if(x % 2 == 0)
            Continue

        list.forEachContinue { y ->
            if(y == 2)
                Continue

            if(y == 4)
                Break

            print("$x$y ")
        }
    }
    // Output: 11 13 31 33 51 53
}