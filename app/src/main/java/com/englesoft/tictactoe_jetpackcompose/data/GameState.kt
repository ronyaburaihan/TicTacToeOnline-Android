package com.englesoft.tictactoe_jetpackcompose.data

import kotlinx.serialization.Serializable

@Serializable
data class GameState(
    val playerAtTurn: String? = "X",
    val field: Array<Array<String?>> = emptyField(),
    val winingPlayer: String? = null,
    val isBoardFull: Boolean = false,
    val connectedPlayers: List<String> = emptyList()
) {
    companion object {
        fun emptyField(): Array<Array<String?>> {
            return arrayOf(
                arrayOf(null, null, null),
                arrayOf(null, null, null),
                arrayOf(null, null, null)
            )
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as GameState

        if (playerAtTurn != other.playerAtTurn) return false
        if (!field.contentDeepEquals(other.field)) return false
        if (winingPlayer != other.winingPlayer) return false
        if (isBoardFull != other.isBoardFull) return false
        if (connectedPlayers != other.connectedPlayers) return false

        return true
    }

    override fun hashCode(): Int {
        var result = playerAtTurn?.hashCode() ?: 0
        result = 31 * result + field.contentDeepHashCode()
        result = 31 * result + (winingPlayer?.hashCode() ?: 0)
        result = 31 * result + isBoardFull.hashCode()
        result = 31 * result + connectedPlayers.hashCode()
        return result
    }
}
