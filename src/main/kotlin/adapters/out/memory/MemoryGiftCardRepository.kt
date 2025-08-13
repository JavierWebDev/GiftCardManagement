package org.example.adapters.out.memory

import org.example.core.domain.GiftCard
import org.example.core.ports.out.GiftCardRepository

class MemoryGiftCardRepository : GiftCardRepository {
    var giftCards : MutableList<GiftCard> = mutableListOf()

    override fun save(giftCard: GiftCard) {
        giftCards.add(giftCard)
    }

    override fun findById(id: Int): GiftCard? {
        return giftCards.find { it.id == id }
    }

    override fun findLast(): GiftCard? = giftCards.lastOrNull()


    override fun findLastId() : Int {
        return if (giftCards.isEmpty()) 1 else (giftCards.last().id + 1)
    }

    override fun showAll() {
        for (gc in giftCards) {
            println(gc)
        }
    }
}