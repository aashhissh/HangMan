package com.ashish.hangman.presentation.ui.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.ashish.hangman.R;
import com.ashish.hangman.domain.executor.impl.ThreadExecutor;
import com.ashish.hangman.presentation.presenters.MainPresenter;
import com.ashish.hangman.presentation.presenters.impl.MainPresenterImpl;
import com.ashish.hangman.presentation.ui.fragments.ProgressDialogFragment;
import com.ashish.hangman.storage.GameSessionRepositoryImpl;
import com.ashish.hangman.threading.MainThreadImpl;
import com.ashish.hangman.utils.NetworkUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements MainPresenter.View  {

    @BindView(R.id.bt_start_game)
    Button btStartNewGame;
    private MainPresenter mMainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        init();
    }

    private void init() {

        // instantiate the presenter
        mMainPresenter = new MainPresenterImpl(
                ThreadExecutor.getInstance(),
                MainThreadImpl.getInstance(),
                this,
                GameSessionRepositoryImpl.getInstance()
        );
    }

    @Override
    protected void onResume() {
        super.onResume();
        mMainPresenter.resume();
    }

    @OnClick(R.id.bt_start_game)
    void onStartGameClicked() {
        if(NetworkUtil.isNetworkAvailable(this)) {
            showProgress();
            mMainPresenter.startNewGame();
        } else {
            Toast.makeText(this, "No internet connection :(", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void showProgress() {
        ProgressDialogFragment.createDialog(this, "Please wait", true);
    }

    @Override
    public void hideProgress() {
        ProgressDialogFragment.removeDialog(this);
    }

    @Override
    public void showError(String message) {

    }

}
