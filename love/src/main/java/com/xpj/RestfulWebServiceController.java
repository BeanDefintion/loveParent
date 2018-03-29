package com.xpj;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/restful", method = { RequestMethod.GET, RequestMethod.POST })
public class RestfulWebServiceController {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
