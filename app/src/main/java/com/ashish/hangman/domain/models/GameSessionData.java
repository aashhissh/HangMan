package com.ashish.hangman.domain.models;

/**
 * @author ashish
 * @since 11/01/18
 */
public class GameSessionData {

    private String mSessionId;
    private int mNumberOfWordsToGuess;
    private int mNumberOfGuessAllowedForEachWord;

    public GameSessionData(String sessionId, int numberOfWordsToGuess,
                           int numberOfGuessAllowedForEachWord) {
        mSessionId = sessionId;
        mNumberOfWordsToGuess = numberOfWordsToGuess;
        mNumberOfGuessAllowedForEachWord = numberOfGuessAllowedForEachWord;
    }

    public String getSessionId() {
        return mSessionId;
    }

    public int getNumberOfWordsToGuess() {
        return mNumberOfWordsToGuess;
    }

    public int getNumberOfGuessAllowedForEachWord() {
        return mNumberOfGuessAllowedForEachWord;
    }

    @Override
    public String toString() {
        return "GameSessionData{" +
                "mSessionId=" + mSessionId +
                ", mNumberOfWordsToGuess='" + mNumberOfWordsToGuess + '\'' +
                ", mNumberOfGuessAllowedForEachWord='" + mNumberOfGuessAllowedForEachWord + '\'' +
                '}';
    }

}
