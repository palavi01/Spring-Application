package com.indusnet.converter;

public interface GenericConverter<E,M> 
{
	E modelToEntity(M m);
	M entityToModel(E e);
}
