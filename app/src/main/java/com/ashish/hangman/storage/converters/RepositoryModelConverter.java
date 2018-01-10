package com.ashish.hangman.storage.converters;

import com.ashish.hangman.domain.models.GameSessionData;
import com.ashish.hangman.network.models.response.StartNewGameResponse;

/**
 * @author ashish
 * @since 11/01/18
 */
public class RepositoryModelConverter {

    public static GameSessionData convertToGameSessionData(StartNewGameResponse startNewGameResponse) {

        return new GameSessionData(
                startNewGameResponse.getSessionId(),
                startNewGameResponse.getData().getNumberOfWordsToGuess(),
                startNewGameResponse.getData().getNumberOfGuessAllowedForEachWord()
        );

    }

}
