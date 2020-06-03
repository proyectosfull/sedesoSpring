package com.sedeso.dig.service;

import java.util.List;

public interface IHomeService {

	public void home();

	public List<String> consultaReporte(String user) throws Exception;
}
