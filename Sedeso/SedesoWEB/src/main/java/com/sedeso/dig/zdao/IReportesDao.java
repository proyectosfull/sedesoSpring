package com.sedeso.dig.zdao;

import java.util.ArrayList;
import java.util.List;

public interface IReportesDao {
	public List<String>list = new ArrayList<String>();
	public List<String>consultaDirReporte(String user) throws Exception;
}
