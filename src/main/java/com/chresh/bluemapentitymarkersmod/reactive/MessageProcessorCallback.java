package com.chresh.bluemapentitymarkersmod.reactive;

@FunctionalInterface
public interface MessageProcessorCallback<T> {
    void processMessage(T message);
}
