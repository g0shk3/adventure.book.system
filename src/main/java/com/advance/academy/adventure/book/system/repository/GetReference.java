package com.advance.academy.adventure.book.system.repository;

public interface GetReference {
    public <T> T getReference(Class<T> tClass,Integer id);

}
