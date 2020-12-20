package com.converter;

import java.util.List;

public interface IConverter<S, T> {
    T convert(S s);
    S convertReverse(T t);
    List<T> convertAll(List<S> s);
}
