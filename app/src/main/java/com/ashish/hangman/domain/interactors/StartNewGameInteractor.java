package com.ashish.hangman.domain.interactors;

import com.ashish.hangman.domain.interactors.base.Interactor;

/**
 * @author ashish
 * @since 11/01/18
 * <p/>
 * This interactor is responsible for starting new game.
 */
public interface StartNewGameInteractor extends Interactor {

    interface Callback {
        void newGameStarted();

        void newGameNotStarted();
    }

}
