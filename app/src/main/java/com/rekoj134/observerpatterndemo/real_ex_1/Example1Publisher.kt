package com.rekoj134.observerpatterndemo.real_ex_1

class Example1Publisher {
    private val subscribers by lazy { ArrayList<Example1Subscriber>() }
    private var data: String = ""

    fun setData(data: String) {
        this.data = data
        notifyAllSubscribers()
    }

    fun subscribe(subscriber: Example1Subscriber) {
        this.subscribers.add(subscriber)
    }

    fun unSubscribe(subscriber: Example1Subscriber) {
        this.subscribers.remove(subscriber)
    }

    private fun notifyAllSubscribers() {
        subscribers.forEach {
            it.update(data)
        }
    }
}