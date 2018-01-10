package com.ashish.hangman.network.models.response;

import com.google.gson.annotations.SerializedName;

/**
 * @author ashish
 * @since 11/01/18
 */
@SuppressWarnings({"UnusedDeclaration"})
public class SubmitResultResponse {

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

    private class Data {

        @SerializedName("playerId")
        private String playerId;

        @SerializedName("sessionId")
        private String sessionId;

        @SerializedName("totalWordCount")
        private int totalWordCount;

        @SerializedName("correctWordCount")
        private int correctWordCount;

        @SerializedName("totalWrongGuessCount")
        private int totalWrongGuessCount;

        @SerializedName("score")
        private int score;

        @SerializedName("datetime")
        private String datetime;

        public String getPlayerId() {
            return playerId;
        }

        public String getSessionId() {
            return sessionId;
        }

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

        public String getDatetime() {
            return datetime;
        }
    }

}
