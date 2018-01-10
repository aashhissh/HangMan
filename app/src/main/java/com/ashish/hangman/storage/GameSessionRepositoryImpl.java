package com.ashish.hangman.storage;

import android.util.Log;

import com.ashish.hangman.domain.models.GameSessionData;
import com.ashish.hangman.domain.repository.GameSessionRepository;

/**
 * @author ashish
 * @since 11/01/18
 */
public class GameSessionRepositoryImpl implements GameSessionRepository {

    public static GameSessionRepositoryImpl instance;

    private GameSessionRepositoryImpl(){}

    public static GameSessionRepositoryImpl getInstance() {
        if(instance == null) {
            synchronized (GameSessionRepositoryImpl.class) {
                if(instance == null) {
                    instance = new GameSessionRepositoryImpl();
                }
            }
        }

        return instance;
    }

    @Override
    public void saveGameSessionData(GameSessionData gameSessionData) {
        Log.e("FIRST TEST", gameSessionData.getSessionId());
        Log.e("FIRST TEST", gameSessionData.getNumberOfWordsToGuess() + "");
        Log.e("FIRST TEST", gameSessionData.getNumberOfGuessAllowedForEachWord() + "");
    }

}
