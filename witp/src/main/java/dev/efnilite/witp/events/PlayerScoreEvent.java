package dev.efnilite.witp.events;

import dev.efnilite.vilib.event.EventWrapper;
import dev.efnilite.witp.player.ParkourPlayer;

/**
 * This event gets called when a scores a point.
 * This event is read-only.
 */
public class PlayerScoreEvent extends EventWrapper {

    public final ParkourPlayer player;

    public PlayerScoreEvent(ParkourPlayer player) {
        this.player = player;
    }
}
