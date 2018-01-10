package com.ashish.hangman.network.models.response;

import com.google.gson.annotations.SerializedName;

/**
 * @author ashish
 * @since 11/01/18
 */
@SuppressWarnings({"UnusedDeclaration"})
public class GetResultResponse {

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

        @SerializedName("totalWordCount")
        private int totalWordCount;

        @SerializedName("correctWordCount")
        private int correctWordCount;

        @SerializedName("totalWrongGuessCount")
        private int totalWrongGuessCount;

        @SerializedName("score")
        private int score;

        public int getTotalWordCount() {
            return totalWordCount;
        }

        public int getCorrectWordCount() {
            return correctWordCount;
        }

        public int getTotalWrongGuessCount() {
            return totalWrongGuessCount;
        }

        public int getScore() {
            return score;
        }
    }

}
