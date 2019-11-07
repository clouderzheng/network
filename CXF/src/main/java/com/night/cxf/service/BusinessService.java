package com.night.cxf.service;

import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * @author night
 * @version 1.1.0
 * @Date 2019/11/7 17:41
 */
@WebService
public interface BusinessService {

    public String echo(@WebParam(name = "param")String param);
}
