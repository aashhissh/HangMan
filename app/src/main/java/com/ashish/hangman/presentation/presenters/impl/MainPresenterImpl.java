package com.ashish.hangman.presentation.presenters.impl;

import com.ashish.hangman.domain.executor.Executor;
import com.ashish.hangman.domain.executor.MainThread;
import com.ashish.hangman.domain.interactors.StartNewGameInteractor;
import com.ashish.hangman.domain.interactors.impl.StartNewGameInteractorImpl;
import com.ashish.hangman.domain.models.GameSessionData;
import com.ashish.hangman.domain.repository.GameSessionRepository;
import com.ashish.hangman.presentation.presenters.AbstractPresenter;
import com.ashish.hangman.presentation.presenters.MainPresenter;

/**
 * @author ashish
 * @since 10/01/18
 */
public class MainPresenterImpl extends AbstractPresenter implements MainPresenter, StartNewGameInteractor.Callback {

    private MainPresenter.View    mView;
    private GameSessionRepository mGameSessionRepository;

    public MainPresenterImpl(Executor executor, MainThread mainThread, View view,
                             GameSessionRepository gameSessionRepository) {
        super(executor, mainThread);
        mView = view;
        mGameSessionRepository = gameSessionRepository;
    }

    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void stop() {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void onError(String message) {

    }

    @Override
    public void startNewGame() {
        StartNewGameInteractor startNewGameInteractor = new StartNewGameInteractorImpl(
                mExecutor,
                mMainThread,
                this,
                mGameSessionRepository
        );

        startNewGameInteractor.execute();
    }

    @Override
    public void newGameStarted() {
        mView.hideProgress();
    }

    @Override
    public void newGameNotStarted() {
        mView.hideProgress();
    }

}
