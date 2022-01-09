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

    protected constructor() : super() {}
    constructor(
        id: Long?, name: String?, address: String?, description: String?, image: String?,
        reservations: List<Reservation>?, boards: List<Board>?, turns: List<Turn>?
    ) : super() {
        this.id = id
        this.name = name
        this.address = address
        this.description = description
        this.image = image
        if (reservations != null) {
            this.reservations = reservations
        }
        if (boards != null) {
            this.boards = boards
        }
        if (turns != null) {
            this.turns = turns
        }
    }
}