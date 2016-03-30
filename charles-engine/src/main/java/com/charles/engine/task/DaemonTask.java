package com.charles.engine.task;

import org.charles.common.constants.SpecialLogger;


public interface DaemonTask extends SpecialLogger {
	
	/**
	 * 执行定时任务
	 */
	public void execute();
}
