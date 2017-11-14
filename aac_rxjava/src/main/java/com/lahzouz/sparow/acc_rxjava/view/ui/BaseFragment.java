package com.lahzouz.sparow.acc_rxjava.view.ui;

/**
 * Created by sparow on 11/1/17.
 */

import android.arch.lifecycle.LifecycleOwner;
import android.support.v4.app.Fragment;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public class BaseFragment extends Fragment implements LifecycleOwner {
    private CompositeDisposable disposables = new CompositeDisposable();

    protected final void addDisposable(Disposable disposable) {
        disposables.add(disposable);
    }

    @Override
    public void onDestroy() {
        System.out.println("Cleaning up disposables ...");
        disposables.dispose();
        super.onDestroy();
    }
}
