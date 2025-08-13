package org.example.core.ports.out

import org.example.core.domain.GiftCard

interface GiftCardRepository {
    fun findById(id : Int) : GiftCard?
    fun save(giftCard: GiftCard)
    fun findLast() : GiftCard?
    fun findLastId() : Int
    fun showAll()
}