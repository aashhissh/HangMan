package com.ashish.hangman.domain.repository;

import com.ashish.hangman.domain.models.GameSessionData;

/**
 * @author ashish
 * @since 11/01/18
 */
public interface GameSessionRepository {

    void saveGameSessionData(GameSessionData gameSessionData);

}
