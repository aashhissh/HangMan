package com.ashish.hangman.domain.executor;

import com.ashish.hangman.domain.interactors.base.AbstractInteractor;

/**
 * @author ashish
 * @since 10/01/18
 */
public interface Executor {

    /**
     * This method should call the interactor's run method and thus start the interactor. This should be called
     * on a background thread as interactors might do lengthy operations.
     *
     * @param interactor The interactor to run.
     */
    void execute(final AbstractInteractor interactor);
}

