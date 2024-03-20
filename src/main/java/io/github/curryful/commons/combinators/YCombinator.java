package io.github.curryful.commons.combinators;

import java.util.function.Function;

public final class YCombinator {

	private interface RecursiveFunction<F> extends Function<RecursiveFunction<F>, F> { }

	private YCombinator() {
		// noop
	}

	public static final <A, B> Function<A, B> Y(Function<Function<A, B>, Function<A, B>> f) {
		RecursiveFunction<Function<A, B>> r = w -> f.apply(x -> w.apply(w).apply(x));
		return r.apply(r);
	}
}

