package io.freefair.android.mvvm.helper;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.ObservableField;

public class BindableHelper extends BaseObservable
{
	@Bindable
	public ObservableField<String> item = new ObservableField<>();
}
