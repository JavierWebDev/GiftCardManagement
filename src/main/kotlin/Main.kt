package org.example

import org.example.adapters.`in`.console.ConsoleController
import org.example.adapters.out.memory.MemoryGiftCardRepository
import org.example.core.domain.GiftCard
import org.example.core.usecases.GiftCardServiceImp

fun main() {
    val repository = MemoryGiftCardRepository()
    val adapter = GiftCardServiceImp(repository)
    val consoleController = ConsoleController(adapter)

/*
    adapter.create("John")
    adapter.topUp(1,1000)

    adapter.create("Juan")
    adapter.topUp(2,3000)

    adapter.charge(1,500)
*/

    consoleController.start()

    repository.showAll()
}