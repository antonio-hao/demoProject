package com.antonio.chainOfResponsibility;

public interface Filter {
	
	void doFilter(Request request,Response response,FilterChain chain);

}
