package com.mapper;

import java.util.List;

import com.pojo.Print;

public interface PrintMapper {

	List<Print> getList(Print print);

	void addOne(Print print);

}
