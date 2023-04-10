package io.github.eleventigerssc.interview.streams

internal class StreamDefault<T>(var value:Iterable<T>):Stream<T>{


    override fun iterator(): Iterator<T> {
        return value.iterator()
    }

    override fun filter(predicate: Predicate<in T>): Stream<T> {
        val list:MutableList<T> = mutableListOf()
        this.forEach{
            if(predicate.test(it)){
                list.add(it)
            }
        }
        return StreamDefault(list.asIterable())
    }

    override fun <R : Any?> flatMap(mapper: Function<in T, out Stream<out R>>?): Stream<R> {
        val list:MutableList<R> = mutableListOf()

        this.forEach {
            val element=mapper?.call(it)
            element!!.forEach {
                list.add(it)
            }
        }

        return StreamDefault(list.asIterable())
    }

    override fun <R : Any?> map(mapper: Function<in T, out R>): Stream<R> {
        val list:MutableList<R> = mutableListOf()

        this.forEach {
            val element=mapper.call(it)
            list.add(element)
        }

        return StreamDefault(list.asIterable())
    }

    override fun forEach(action: Consumer<in T>) {
        for (i in iterator()){
            action.accept(i)
        }
    }


}