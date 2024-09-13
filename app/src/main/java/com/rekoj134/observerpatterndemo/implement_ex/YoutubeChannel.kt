package com.rekoj134.observerpatterndemo.implement_ex

class YoutubeChannel {
    private val subscribers by lazy { HashMap<String, ArrayList<Subscriber>?>() }

    fun subscribe(subscriberType: String, subscriber: Subscriber) {
        val listSubscriber = if (subscribers[subscriberType] != null) subscribers[subscriberType] else ArrayList<Subscriber>()
        listSubscriber?.add(subscriber)
        subscribers[subscriberType] = listSubscriber
    }

    fun unSubscribe(subscriberType: String, subscriber: Subscriber) {
        val listSubscriber = if (subscribers[subscriberType] != null) subscribers[subscriberType] else ArrayList<Subscriber>()
        listSubscriber?.remove(subscriber)
        subscribers[subscriberType] = listSubscriber
    }

    fun notifySubscribers(subscriberType: String, data: String) {
        val listSubscriber = if (subscribers[subscriberType] != null) subscribers[subscriberType] else ArrayList<Subscriber>()
        listSubscriber?.forEach {
            it.notifyNew(data)
        }
    }
}