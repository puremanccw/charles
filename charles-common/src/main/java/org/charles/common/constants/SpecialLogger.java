package org.charles.common.constants;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public interface SpecialLogger {
	//controller层日志
    public static final Logger controllerLogger = LoggerFactory.getLogger("controller");

}
