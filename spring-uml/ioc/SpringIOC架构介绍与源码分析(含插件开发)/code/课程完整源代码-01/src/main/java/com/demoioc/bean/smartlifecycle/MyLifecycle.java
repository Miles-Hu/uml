package com.demoioc.bean.smartlifecycle;

import lombok.extern.log4j.Log4j;
import org.springframework.context.SmartLifecycle;
import org.springframework.stereotype.Service;

//一定要实现SmartLifecycle接口才行
//且isAutoStartup要返回true。具体原因可以断点看下。
@Service
@Log4j
public class MyLifecycle implements SmartLifecycle{

	@Override
	public void start() {
		log.info("start");
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isRunning() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getPhase() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isAutoStartup() {
		return true;
	}

	@Override
	public void stop(Runnable callback) {
		// TODO Auto-generated method stub
		
	}

}
