package com.ashish.hangman.network.models.response;

import com.google.gson.annotations.SerializedName;

/**
 * @author ashish
 * @since 11/01/18
 */
@SuppressWarnings({"UnusedDeclaration"})
public class StartNewGameResponse {

    @SerializedName("message")
    private String message;

    @SerializedName("sessionId")
    private String sessionId;

    @SerializedName("data")
    private Data data;

    public String getMessage() {
        return message;
    }

    public String getSessionId() {
        return sessionId;
    }

    public Data getData() {
        return data;
    }

    public class Data {

        @SerializedName("numberOfWordsToGuess")
        private int numberOfWordsToGuess;

        @SerializedName("numberOfGuessAllowedForEachWord")
        private int numberOfGuessAllowedForEachWord;

        public int getNumberOfWordsToGuess() {
            return numberOfWordsToGuess;
        }

        public int getNumberOfGuessAllowedForEachWord() {
            return numberOfGuessAllowedForEachWord;
        }

    }

}
