package com.Tsofen45.TCP_ServerTsofen45.Analyzation;

import java.io.IOException;

import org.springframework.stereotype.Service;

import com.Tsofen45.TCP_ServerTsofen45.Device.DeviceData;


@Service
public class Switch2ActivatedAnalyzer extends Analyzer{

	@Override
	public void Analyze(DeviceData d) throws IOException {
		// TODO Auto-generated method stub
		if(d.isSwitch2Activated()) {
			if(d.isCanSwitch2()) {
				
				System.out.println("Enter switch1");
				
				sendNotify(d.getImei()+"",5,json);
				d.setCanSwitch2(false);
			}		}
	}



}
