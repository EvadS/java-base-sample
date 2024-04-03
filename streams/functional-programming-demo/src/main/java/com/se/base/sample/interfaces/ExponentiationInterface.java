package com.se.base.sample.interfaces;

@FunctionalInterface
public interface ExponentiationInterface<T,R> {
    public T calculate(R variable);
}
