package io.github.aedans.ccg.client.simple

import io.github.aedans.ccg.backend.Card
import io.github.aedans.ccg.backend.Player
import io.github.aedans.server.simple.Server
import kotlinx.coroutines.InternalCoroutinesApi

@UseExperimental(InternalCoroutinesApi::class)
class HostGameMenu(private val mainMenu: MainMenu) : KMenuFrame("Host Game") {
    private val portBox = KTextField("8080")
    private val nameBox = KTextField("Player 1")
    private val deckBox = KTextField("Default")
    private val submit = KButton("Submit") {
        val connection = Server.host(portBox.text.toInt())
        val waitingFor = WaitingFor(connection)
        connection.invokeOnCompletion(onCancelling = true) {
            @Suppress("NestedLambdaShadowedImplicitParameter")
            if (it != null) isVisible = true
            waitingFor.isVisible = false
        }
        isVisible = false
        val deck = Deck.deck(deckBox.text)
        val player = Player(
            nameBox.text,
            listOf(Card.card(deck.starter1), Card.card(deck.starter2), Card.card(deck.starter3)),
            deck.cards.map(Card.Companion::card),
            emptyList(),
            15
        )
        GameUI.start(player, connection.await())
    }

    private val cancel = KButton("Cancel") {
        mainMenu.isVisible = true
        isVisible = false
    }

    init {
        addAll(portBox, nameBox, deckBox, submit, cancel)
        pack()
    }
}
