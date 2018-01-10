package com.ashish.hangman.presentation.ui.fragments;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;

/**
 * @author ashish
 * @since 10/01/18
 */
public class ProgressDialogFragment extends DialogFragment {
    private static final String DIALOG_TAG = "progress_dialog";
    private static final String KEY_DIALOG_MESSAGE = "dialog_message";
    private static final String KEY_DIALOG_TITLE = "dialog_title";
    private static final String KEY_DIALOG_CANCELABLE = "is_dialog_cancelable";

    /**
     * Create basic non-cancelable progress dialog
     *
     * @param activity target activity
     * @param message  message to be displayed for progress
     */
    public static void createDialog(FragmentActivity activity, String message) {
        createDialog(activity, message, false);
    }

    /**
     * Create basic progress dialog
     *
     * @param activity   target activity
     * @param message    message to be displayed
     * @param cancelable set dialog to be cancellable ot not
     */
    public static void createDialog(FragmentActivity activity, String message,
                                    boolean cancelable) {
        createDialog(activity, message, null, cancelable);
    }

    /**
     * Create basic progress dialog
     *
     * @param activity   target activity
     * @param message    message to be displayed
     * @param title      title to be displayed on dialog
     * @param cancelable set dialog to be cancellable ot not
     */
    public static void createDialog(FragmentActivity activity, String message, String title,
                                    boolean cancelable) {
        ProgressDialogFragment frag = new ProgressDialogFragment();
        Bundle args = new Bundle();
        args.putString(KEY_DIALOG_MESSAGE, message);
        args.putString(KEY_DIALOG_TITLE, title);
        args.putBoolean(KEY_DIALOG_CANCELABLE, cancelable);
        frag.setArguments(args);
        FragmentTransaction ft = activity.getSupportFragmentManager().beginTransaction();
        ft.add(frag, DIALOG_TAG);
        ft.commitAllowingStateLoss();
    }

    /**
     * Remove previously created dialog
     *
     * @param activity target activity using which previous dialog was created
     */
    public static void removeDialog(FragmentActivity activity) {
        if (null == activity) {
            return;
        }
        Fragment frag = activity.getSupportFragmentManager().findFragmentByTag(DIALOG_TAG);
        if (frag != null && frag instanceof ProgressDialogFragment) {
            ((ProgressDialogFragment) frag).dismissAllowingStateLoss();
        }
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Bundle arguments = getArguments();
        String message = arguments.getString(KEY_DIALOG_MESSAGE);
        String title = arguments.getString(KEY_DIALOG_TITLE);
        boolean cancelable = arguments.getBoolean(KEY_DIALOG_CANCELABLE);
        ProgressDialog dialog = new ProgressDialog(getContext());
        dialog.setTitle(title);
        dialog.setMessage(message);
        setCancelable(cancelable);
        return dialog;
    }
}
