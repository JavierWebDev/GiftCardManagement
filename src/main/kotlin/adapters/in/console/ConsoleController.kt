package org.example.adapters.`in`.console

import org.example.core.ports.`in`.GiftCardService

class ConsoleController(val service : GiftCardService) {
    var isActive = true

    fun start() {
        while (isActive) {
            var opc = mainMenu()

            when (opc) {
                1 -> {
                    createMenu()
                }
                2 -> {
                    topUpMenu()
                }
                3 -> {
                    chargeMenu()
                }
                4 -> {
                    println("[!] Exiting...")
                    break
                }
                else -> {
                    println("[!] Invalid option, please ingress a valid option!")
                }
            }

        }

    }

    fun mainMenu() : Int {
        val opcs = mutableListOf("Create Card","TopUp Card", "Charge Card", "Exit")
        println("[*] WELCOME TO THE GIFTCARD MANAGEMENT CENTER")
        println("Choose an option:")
        for ((index, value) in opcs.withIndex()) {
            println("${index+1}. $value")
        }
        return readln().toInt()
    }

    fun createMenu() {
        var flag = "Y"

        do {
            print("[?] Register the name of the owner of the card: ")
            var name = readln()
            var newGC = service.create(name)

            println("[*] New GiftCard created\n[*] Id: ${newGC.id}\n" +
                    "[*] Owner: ${newGC.owner}\n" +
                    "[*] Balance: ${newGC.balance}")

            println("[?] Do you want to add another GiftCard? (Y/N): ")
            flag = readln().uppercase()

        } while (flag == "Y")
    }

    fun topUpMenu() {
        var flag = "Y"

        do {
            print("[?] Which is the ID of the Card to TopUp: ")
            var id = readln().toInt()

            print("[?] Which is the amount to TopUp: ")
            var amount = readln().toLong()

            var giftCard = service.topUp(id,amount)

            println("[*] New GiftCard balance\n[*] Id: ${giftCard.id}\n" +
                    "[*] Balance: ${giftCard.balance}")

            println("[?] Do you want to Top Up another GiftCard? (Y/N): ")
            flag = readln().uppercase()

        } while (flag == "Y")
    }

    fun chargeMenu() {
        var flag = "Y"

        do {
            print("[?] Which is the ID of the Card to charge: ")
            var id = readln().toInt()

            print("[?] Which is the amount to charge: ")
            var amount = readln().toLong()

            var giftCard = service.charge(id,amount)

            println("[*] New GiftCard balance\n[*] Id: ${giftCard.id}\n" +
                    "[*] Balance: ${giftCard.balance}")

            println("[?] Do you want to charge another GiftCard? (Y/N): ")
            flag = readln().uppercase()

        } while (flag == "Y")
    }
}