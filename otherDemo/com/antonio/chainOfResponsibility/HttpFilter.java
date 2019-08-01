package com.antonio.chainOfResponsibility;

import java.util.ArrayList;
import java.util.List;

public class HttpFilter implements Filter {


	@Override
	public void doFilter(Request request, Response response, FilterChain chain) {
		request.requestStr = request.requestStr.replace('<', '[').
				replace('>', ']') + "---HTMLFilter()";
		chain.doFilter(request, response, chain);
		response.responseStr += "---HTMLFilter()";
		

	}

}
