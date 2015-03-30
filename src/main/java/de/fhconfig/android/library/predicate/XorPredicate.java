package de.fhconfig.android.library.predicate;

/**
 * Created by larsgrefer on 31.03.15.
 */
public class XorPredicate<T> extends Predicate<T> {

	com.google.common.base.Predicate<? super T> first, second;

	public XorPredicate(com.google.common.base.Predicate<? super T> first, com.google.common.base.Predicate<? super T> second) {
		this.first = first;
		this.second = second;
	}

	@Override
	public boolean apply(T input) {
		return first.apply(input) ^ second.apply(input);
	}
}
