package org.example.core.usecases

import org.example.core.domain.GiftCard
import org.example.core.ports.`in`.GiftCardService
import org.example.core.ports.out.GiftCardRepository
import java.util.*

class GiftCardServiceImp(val repository: GiftCardRepository) : GiftCardService {
    override fun create(owner: String) : GiftCard {
        val id = repository.findLastId()

        val giftCard = GiftCard(id, owner)
        repository.save(giftCard)
        return giftCard
    }

    override fun charge(id: Int, amount: Long) : GiftCard {
        val gcToCharge = repository.findById(id)
            ?: throw NoSuchElementException("GiftCard con id $id no encontrada")

        gcToCharge.balance-= amount
        return gcToCharge

    }

    override fun topUp(id: Int, amount: Long): GiftCard {
        val gcToTopUP = repository.findById(id)
            ?: throw NoSuchElementException("GiftCard con id $id no encontrada")

        gcToTopUP.balance += amount
        return gcToTopUP
    }

}