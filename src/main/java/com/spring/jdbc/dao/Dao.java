package com.spring.jdbc.dao;

import java.util.List;
public interface Dao  <T,ID>{

        public int insert(T t);

        public int change(T t);

        public int delete(ID id);

        public T get(ID id);

        public List<T> getAll();
}


