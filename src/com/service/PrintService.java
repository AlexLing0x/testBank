package com.service;

import java.util.List;

import com.pojo.Print;

public interface PrintService {

	List<Print> getAllPrint(Print print);

	void addPrint(Print print);

}
