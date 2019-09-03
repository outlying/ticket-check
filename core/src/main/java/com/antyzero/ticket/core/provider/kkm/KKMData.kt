package com.antyzero.ticket.core.provider.kkm

import com.antyzero.ticket.core.model.Ticket
import com.antyzero.ticket.core.provider.kkm.KKMData.Student.Collage
import java.math.BigInteger

/**
 *
 */
sealed class KKMData : Ticket.Data() {

    /**
     * Common KKM card used by most people
     *
     * To verify those cards [cardNumber] and client ID ([Ticket.id]) is needed
     */
    data class Normal(
        val cardNumber: BigInteger
    ) : KKMData()

    /**
     * Card used by collage students
     *
     * To verify those cards album number ([Ticket.id]) and [collegeId]
     *
     * @property [collegeId] only values from [Collage.id] are accepted
     */
    data class Student(
        val collegeId: Int
    ) {

        init {
            require(Collage.values().map { it.id }.contains(collegeId)) {
                "Given collage ID $collegeId is not valid"
            }
        }

        /**
         * Supported collages in Kraków
         */
        enum class Collage(val id: Int) {

            WSZiB(20),
            AGH(21),
            UJ(22),
            PK(23),
            UE(24),
            UR(25),
            PWST(26),
            AM(27),
            WSE(28),
            AIK_WSFP(29),
            UP(30),
            WSH(31),
            KA(32),
            WSEI(33),
            IFJ_PAN(34),
            IF_PAN(35),
            IKiFP_PAN(36)
        }
    }
}

