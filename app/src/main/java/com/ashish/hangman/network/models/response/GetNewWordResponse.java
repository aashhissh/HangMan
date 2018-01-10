package com.ashish.hangman.network.models.response;

import com.google.gson.annotations.SerializedName;

/**
 * @author ashish
 * @since 11/01/18
 */
@SuppressWarnings({"UnusedDeclaration"})
public class GetNewWordResponse {

    @SerializedName("sessionId")
    private String sessionId;

    @SerializedName("data")
    private Data data;

    public String getSessionId() {
        return sessionId;
    }

    public Data getData() {
        return data;
    }

    private class Data {

        @SerializedName("word")
        private String word;

        @SerializedName("totalWordCount")
        private int totalWordCount;

        @SerializedName("wrongGuessCountOfCurrentWord")
        private int wrongGuessCountOfCurrentWord;

        public String getWord() {
            return word;
        }

        public int getTotalWordCount() {
            return totalWordCount;
        }

        public int getWrongGuessCountOfCurrentWord() {
            return wrongGuessCountOfCurrentWord;
        }
    }

}
