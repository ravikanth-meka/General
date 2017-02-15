package com.javacodegeeks.jaxws.example.publisher;

import javax.xml.ws.Endpoint;

import com.javacodegeeks.jaxws.example.CalculatorImpl;


public class WebServicePublisher {

	public static void main(String[] args) {

		Endpoint.publish("http://localhost:8084/webservice/helloworld", new CalculatorImpl());

	}

}
