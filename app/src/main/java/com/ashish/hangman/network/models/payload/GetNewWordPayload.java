package com.ashish.hangman.network.models.payload;

import com.google.gson.annotations.SerializedName;

/**
 * @author ashish
 * @since 11/01/18
 */
@SuppressWarnings({"UnusedDeclaration"})
public class GetNewWordPayload {

    @SerializedName("sessionId")
    private String sessionId;

    @SerializedName("action")
    private String action;

    public GetNewWordPayload(String sessionId) {
        this.sessionId = sessionId;
        this.action = "nextWord";
    }
}
