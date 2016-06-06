/*
 * Copyright (c) the Department of Informatics, Technische Universität Darmstadt. All Rights Reserved.
 *
 * Unauthorized distribution of this file via any medium is strictly prohibited.
 */
package de.tudarmstadt.ukp.dkpro.argumentation.annotations.uima;

import java.util.function.Function;

import org.apache.uima.jcas.tcas.Annotation;

import de.tudarmstadt.ukp.dkpro.argumentation.annotations.TextSpanAnnotation;

/**
 * @author <a href="mailto:shore@ukp.informatik.tu-darmstadt.de">Todd Shore</a>
 * @since May 2, 2016
 *
 */
public final class TextSpanAnnotationFactory implements Function<Annotation, TextSpanAnnotation> {

	/**
	 * {@link SingletonHolder} is loaded on the first execution of
	 * {@link TextSpanAnnotationFactory#getInstance()} or the first access to
	 * {@link SingletonHolder#INSTANCE}, not before.
	 *
	 * @author <a href="http://www.cs.umd.edu/~pugh/">Bill Pugh</a>
	 * @see <a href=
	 *      "https://en.wikipedia.org/wiki/Singleton_pattern#The_solution_of_Bill_Pugh">
	 *      https://en.wikipedia.org/wiki/Singleton_pattern#
	 *      The_solution_of_Bill_Pugh</a>
	 */
	private static final class SingletonHolder {
		/**
		 * A singleton instance of {@link TextSpanAnnotationFactory}.
		 */
		private static final TextSpanAnnotationFactory INSTANCE = new TextSpanAnnotationFactory();
	}

	public static TextSpanAnnotationFactory getInstance() {
		return SingletonHolder.INSTANCE;
	}

	private TextSpanAnnotationFactory() {
	}

	@Override
	public TextSpanAnnotation apply(final Annotation annotation) {
		return new TextSpanAnnotation(annotation.getBegin(), annotation.getEnd(), annotation.getType().getShortName(),
				annotation.getCoveredText());
	}

}
