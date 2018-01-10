package com.ashish.hangman.network.models.payload;

import com.google.gson.annotations.SerializedName;

/**
 * @author ashish
 * @since 11/01/18
 */
@SuppressWarnings({"UnusedDeclaration"})
public class StartNewGamePayload {

    @SerializedName("playerId")
    private String playerId;

    @SerializedName("action")
    private String action;

    public StartNewGamePayload(String playerId) {
        this.playerId = playerId;
        this.action = "startGame";
    }

}
