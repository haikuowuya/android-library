package de.fhconfig.android.library.util;

/**
 * Created by larsgrefer on 11.10.15.
 */
public interface Function<V,R> {

	R apply(V value);
}
