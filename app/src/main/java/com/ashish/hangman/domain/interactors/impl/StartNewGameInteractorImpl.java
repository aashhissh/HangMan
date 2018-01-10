package com.ashish.hangman.domain.interactors.impl;

import com.ashish.hangman.domain.executor.Executor;
import com.ashish.hangman.domain.executor.MainThread;
import com.ashish.hangman.domain.interactors.StartNewGameInteractor;
import com.ashish.hangman.domain.interactors.base.AbstractInteractor;
import com.ashish.hangman.storage.converters.RepositoryModelConverter;
import com.ashish.hangman.domain.repository.GameSessionRepository;
import com.ashish.hangman.network.RestClient;
import com.ashish.hangman.network.models.payload.StartNewGamePayload;
import com.ashish.hangman.network.models.response.StartNewGameResponse;
import com.ashish.hangman.network.services.HangManService;

import retrofit2.Call;
import retrofit2.Response;

import static com.ashish.hangman.utils.Constants.PLAYER_ID;

/**
 * @author ashish
 * @since 11/01/18
 */
public class StartNewGameInteractorImpl extends AbstractInteractor implements StartNewGameInteractor {

    private StartNewGameInteractor.Callback mCallback;
    private GameSessionRepository           mGameSessionRepository;

    public StartNewGameInteractorImpl(Executor threadExecutor, MainThread mainThread,
                                      Callback callback, GameSessionRepository gameSessionRepository) {
        super(threadExecutor, mainThread);

        mCallback = callback;
        mGameSessionRepository = gameSessionRepository;
    }

    @Override
    public void run() {
        // initializing the REST service we will use
        HangManService hangManService = RestClient.getService(HangManService.class);

        // initializing payload object for starting new game
        StartNewGamePayload startNewGamePayload = new StartNewGamePayload(PLAYER_ID);

        hangManService.startNewGame(startNewGamePayload).enqueue(new retrofit2.Callback<StartNewGameResponse>() {
            @Override
            public void onResponse(Call<StartNewGameResponse> call, Response<StartNewGameResponse> response) {
                if(response.isSuccessful()) {
                    mGameSessionRepository.saveGameSessionData(
                            RepositoryModelConverter.convertToGameSessionData(response.body())
                    );

                    mMainThread.post(new Runnable() {
                        @Override
                        public void run() {
                            mCallback.newGameStarted();
                        }
                    });
                } else {
                    mMainThread.post(new Runnable() {
                        @Override
                        public void run() {
                            mCallback.newGameNotStarted();
                        }
                    });
                }
            }

            @Override
            public void onFailure(Call<StartNewGameResponse> call, Throwable t) {
                mMainThread.post(new Runnable() {
                    @Override
                    public void run() {
                        mCallback.newGameNotStarted();
                    }
                });
            }
        });

    }

}
