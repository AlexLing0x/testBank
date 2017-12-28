package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mapper.PrintMapper;
import com.pojo.Print;
@Service
public class PrintServiceImpl implements PrintService {
	@Autowired
	private PrintMapper printMapper;
	@Override
	public List<Print> getAllPrint(Print print) {
		// TODO Auto-generated method stub
		return this.printMapper.getList(print);
	}
	@Override
	public void addPrint(Print print) {
		// TODO Auto-generated method stub
		printMapper.addOne(print);
	}

}
