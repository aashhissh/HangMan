package com.ashish.hangman.presentation.presenters;

import com.ashish.hangman.domain.executor.Executor;
import com.ashish.hangman.domain.executor.MainThread;

/**
 * @author ashish
 * @since 10/01/18
 */
public abstract class AbstractPresenter {

    protected Executor mExecutor;
    protected MainThread mMainThread;

    public AbstractPresenter(Executor executor, MainThread mainThread) {
        mExecutor = executor;
        mMainThread = mainThread;
    }

}
