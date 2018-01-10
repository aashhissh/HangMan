package com.ashish.hangman.presentation.presenters;

import com.ashish.hangman.presentation.ui.BaseView;

import java.util.List;

/**
 * @author ashish
 * @since 10/01/18
 */
public interface MainPresenter  extends BasePresenter {

    void startNewGame();

    interface View extends BaseView {

    }

}