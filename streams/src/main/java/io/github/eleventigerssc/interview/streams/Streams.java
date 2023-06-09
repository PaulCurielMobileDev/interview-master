package io.github.eleventigerssc.interview.streams;

class Streams {

    /**
     * @return implementation of {@link Stream} that uses the provided {@param iterable} as its data source.
     */
    static <T> Stream<T> from(Iterable<T> iterable) {


        return new StreamDefault<T>(iterable);
    }
}
