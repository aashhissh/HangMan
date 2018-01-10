package com.ashish.hangman.domain.interactors.base;

/**
 * @author ashish
 * @since 10/01/18
 */
public interface Interactor {

    /**
     * This is the main method that starts an interactor. It will make sure that the interactor operation is done on a
     * background thread.
     */
    void execute();
}
