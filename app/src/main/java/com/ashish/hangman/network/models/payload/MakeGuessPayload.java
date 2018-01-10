package com.ashish.hangman.network.models.payload;

import com.google.gson.annotations.SerializedName;

/**
 * @author ashish
 * @since 11/01/18
 */
@SuppressWarnings({"UnusedDeclaration"})
public class MakeGuessPayload {

    @SerializedName("sessionId")
    private String sessionId;

    @SerializedName("action")
    private String action;

    @SerializedName("guess")
    private String guess;

    public MakeGuessPayload(String sessionId, String guess) {
        this.sessionId = sessionId;
        this.action = "guessWord";
        this.guess = guess;
    }

}
