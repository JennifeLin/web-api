package com.alg.boot.webapi.booking.restaurants

import com.alg.boot.webapi.booking.boards.Board
import com.alg.boot.webapi.booking.reservations.Reservation
import com.alg.boot.webapi.booking.turns.Turn
import javax.persistence.*

@Entity
@Table(name = "restaurant")
class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    var id: Long? = null

    @Column(name = "NAME")
    var name: String? = null

    @Column(name = "ADDRESS")
    var address: String? = null

    @Column(name = "DESCRIPTION")
    var description: String? = null

    @Column(name = "IMAGE")
    var image: String? = null

    @OneToMany(cascade = [CascadeType.ALL], fetch = FetchType.LAZY, mappedBy = "restaurant")
    var reservations: List<Reservation> = emptyList()

    @OneToMany(cascade = [CascadeType.ALL], fetch = FetchType.LAZY, mappedBy = "restaurant")
    var boards: List<Board> = emptyList()

    @OneToMany(cascade = [CascadeType.ALL], fetch = FetchType.LAZY, mappedBy = "restaurant")
    var turns: List<Turn> = emptyList()
}
