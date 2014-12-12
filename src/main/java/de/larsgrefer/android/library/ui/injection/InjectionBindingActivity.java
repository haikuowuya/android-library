package de.larsgrefer.android.library.ui.injection;

import android.app.Application;
import android.os.Bundle;
import android.view.Menu;

import de.larsgrefer.android.library.injection.ActivityXmlInjector;
import de.larsgrefer.android.library.injection.exceptions.ViewIdNotFoundException;
import gueei.binding.v30.app.BindingActivityV30;

public class InjectionBindingActivity extends BindingActivityV30 {
	ActivityXmlInjector injector;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		injector = new ActivityXmlInjector(this);
		injector.tryInjectLayout();

		Application app = getApplication();
		if(app instanceof InjectionApplication)
			((InjectionApplication)app).getInjector().inject(this);
	}

	@Override
	public void setContentView(int layoutResID) {
		super.setContentView(layoutResID);
		try {
			injector.injectViews();
		} catch (ViewIdNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		if(injector.getMenuId() != 0){
			getMenuInflater().inflate(injector.getMenuId(), menu);
			super.onCreateOptionsMenu(menu);
			return true;
		}
		return super.onCreateOptionsMenu(menu);
	}
}
