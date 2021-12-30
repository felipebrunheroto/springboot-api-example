package br.com.brunheroto.springbootApiExample.mapper;

public interface AbstractMapper<T, D> {

	D fromEntityToDto(T entity);

	T fromDtoToEntity(D dto);
}
