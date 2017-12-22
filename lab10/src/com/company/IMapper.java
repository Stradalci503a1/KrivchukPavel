package com.company;


public interface IMapper<TDestination, TSource> {

    TDestination map(TSource source, Class<TDestination> destionationType) throws Exception;
}
