package com.alg.boot.webapi.playground


class Hero(
    private var id: Long = 0,
    private var name: String = "",
    private var power: String = "",
    private var alterEgo: String = ""
) {

    override fun toString(): String {
        return "Hero(id=$id, name='$name', power='$power', alterEgo='$alterEgo')"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Hero

        if (id != other.id) return false
        if (name != other.name) return false
        if (power != other.power) return false
        if (alterEgo != other.alterEgo) return false

        return true
    }

    override fun hashCode(): Int {
        return generateHashCode(id.hashCode())
    }

    private fun generateHashCode(key: Int?): Int {
        var hash: Int
        return if (key == null) {
            0
        } else {
            31 * key.also { hash = it } xor (hash ushr 16)
        }
    }

}
