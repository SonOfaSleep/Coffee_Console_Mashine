package machine

enum class State {
    MENU, BUY, FILL, TAKE, REMAINING, EXIT
}

class CoffeeMachine {
    var water = 400
    var milk = 540
    var beans = 120
    var cups = 9
    var money = 550
    var status = State.MENU

    fun menu() {
        println("Write action (buy, fill, take, remaining, exit):")
        when (readLine()!!.lowercase()) {
            "buy" -> status = State.BUY
            "fill" -> status = State.FILL
            "take" -> status = State.TAKE
            "remaining" -> status = State.REMAINING
            "exit" -> status = State.EXIT
            else -> {
                println("No such choice, try another one")
                println()
                menu()
            }
        }
        while (status != State.EXIT){
            when(status){
                State.MENU -> menu()
                State.BUY -> buy()
                State.FILL -> fill()
                State.TAKE -> take()
                State.REMAINING -> stats()
                else -> State.EXIT
            }
        }
    }

    fun buy() {
        println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:")
        val coffeeTypeInput = readLine()!!
        when (coffeeTypeInput) {
            "1" -> {
                if (check1()) {
                    println("I have enough resources, making you a coffee!")
                    println()
                    water -= 250
                    milk -= 0
                    beans -= 16
                    cups -= 1
                    money += 4
                    menu()
                } else {
                    menu()
                }
            }

            "2" -> {
                if (check2()) {
                    println("I have enough resources, making you a coffee!")
                    println()
                    water -= 350
                    milk -= 75
                    beans -= 20
                    cups -= 1
                    money += 7
                    menu()
                } else {
                    menu()
                }
            }
            "3" -> {
                if (check3()) {
                    println("I have enough resources, making you a coffee!")
                    println()
                    water -= 200
                    milk -= 100
                    beans -= 12
                    cups -= 1
                    money += 6
                    menu()
                } else {
                    menu()
                }
            }
            "back" -> status = State.MENU
            else -> println("Error!")
        }
    }

    fun check1(): Boolean {
        var bool = false
        if (water - 250 >= 0 && beans - 16 >= 0 && cups - 1 >= 0) {
            bool = true
        } else if (water - 250 < 0) {
            println("Sorry, not enough water!")
            bool = false
        } else if (beans - 16 < 0) {
            println("Sorry, not enough beans!")
            bool = false
        } else if (cups - 1 < 0) {
            println("Sorry, not enough cups!")
            bool = false
        }
        println()
        return bool
    }

    fun check2(): Boolean {
        var bool = false
        if (water - 350 >= 0 && milk - 75 >= 0 && beans - 20 >= 0 && cups - 1 >= 0) {
            bool = true
        } else if (water - 350 < 0) {
            println("Sorry, not enough water!")
            bool = false
        } else if (milk - 75 < 0) {
            println("Sorry, not enough milk!")
            bool = false
        } else if (beans - 20 < 0) {
            println("Sorry, not enough beans!")
            bool = false
        } else if (cups - 1 < 0) {
            println("Sorry, not enough cups!")
            bool = false
        }
        println()
        return bool
    }

    fun check3(): Boolean {
        var bool = false
        if (water - 200 >= 0 && milk - 100 >= 0 && beans - 12 >= 0 && cups - 1 >= 0) {
            bool = true
        } else if (water - 200 < 0) {
            println("Sorry, not enough water!")
            bool = false
        } else if (milk - 100 < 0) {
            println("Sorry, not enough milk!")
            bool = false
        } else if (beans - 12 < 0) {
            println("Sorry, not enough beans!")
            bool = false
        } else if (cups - 1 < 0) {
            println("Sorry, not enough cups!")
            bool = false
        }
        println()
        return bool
    }

    fun fill() {

        val str1 = "Write how many"
        val str2 = "do you want to add: "

        print("$str1 ml of water $str2")
        water += readLine()!!.toInt()
        print("$str1 ml of milk $str2")
        milk += readLine()!!.toInt()
        print("$str1 grams of coffee beans $str2")
        beans += readLine()!!.toInt()
        print("$str1 disposable cups of coffee $str2")
        cups += readLine()!!.toInt()
        println()
        menu()
    }

    fun take() {
        println("I gave you $$money")
        println()
        money = 0
        menu()
    }

    fun stats() {
        println("The coffee machine has:\n" +
                "$water of water\n" +
                "$milk of milk\n" +
                "$beans of coffee beans\n" +
                "$cups of disposable cups\n" +
                "$money of money")
        println()
        menu()
    }
}

fun main() {
    val machine = CoffeeMachine()
    machine.menu()
}