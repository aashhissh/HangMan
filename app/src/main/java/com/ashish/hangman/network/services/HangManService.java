package com.ashish.hangman.network.services;

import com.ashish.hangman.network.models.payload.GetNewWordPayload;
import com.ashish.hangman.network.models.payload.GetResultPayload;
import com.ashish.hangman.network.models.payload.MakeGuessPayload;
import com.ashish.hangman.network.models.payload.StartNewGamePayload;
import com.ashish.hangman.network.models.payload.SubmitResultPayload;
import com.ashish.hangman.network.models.response.GetNewWordResponse;
import com.ashish.hangman.network.models.response.GetResultResponse;
import com.ashish.hangman.network.models.response.MakeGuessResponse;
import com.ashish.hangman.network.models.response.StartNewGameResponse;
import com.ashish.hangman.network.models.response.SubmitResultResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * @author ashish
 * @since 11/01/18
 *
 * A REST interface describing how data will be synced with the backend.
 */
public interface HangManService {

    @POST("on/")
    Call<StartNewGameResponse> startNewGame(@Body StartNewGamePayload startNewGamePayload);

    @POST("on/")
    Call<GetNewWordResponse> getNewWord(@Body GetNewWordPayload getNewWordPayload);

    @POST("on/")
    Call<MakeGuessResponse> makeGuess(@Body MakeGuessPayload makeGuessPayload);

    @POST("on/")
    Call<GetResultResponse> getResult(@Body GetResultPayload getResultPayload);

    @POST("on/")
    Call<SubmitResultResponse> submitResult(@Body SubmitResultPayload submitResultPayload);

}
