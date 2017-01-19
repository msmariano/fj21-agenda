package br.com.caelum.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface logica {
	String executa(HttpServletRequest req,
			HttpServletResponse res) throws Exception;

}
