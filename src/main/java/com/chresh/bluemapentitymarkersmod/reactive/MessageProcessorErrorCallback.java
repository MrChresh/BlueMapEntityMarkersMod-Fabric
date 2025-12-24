package com.chresh.bluemapentitymarkersmod.reactive;

@FunctionalInterface
public interface MessageProcessorErrorCallback {
    void onError(Throwable throwable);
}
