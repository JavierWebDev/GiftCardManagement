package org.example.core.ports.`in`

import org.example.core.domain.GiftCard

interface GiftCardService {
    fun create(owner : String) : GiftCard
    fun topUp(id : Int, amount : Long) : GiftCard
    fun charge(id: Int, amount: Long) : GiftCard
}

