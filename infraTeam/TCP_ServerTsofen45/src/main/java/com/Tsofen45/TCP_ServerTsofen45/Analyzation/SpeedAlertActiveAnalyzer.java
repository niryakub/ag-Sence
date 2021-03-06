package com.Tsofen45.TCP_ServerTsofen45.Analyzation;

import java.io.IOException;

import org.springframework.stereotype.Service;

import com.Tsofen45.TCP_ServerTsofen45.Device.DeviceData;


@Service
public class SpeedAlertActiveAnalyzer extends Analyzer {

	@Override
	public void Analyze(DeviceData d) throws IOException {
		// TODO Auto-generated method stub
		if(d.isSpeedingAlertActive()) {
			if(d.isCanSpeedAlert()) {
				json.put("speed", d.getSpeed());
				sendNotify(d.getImei()+"",10,json);
				
				d.setCanSpeedAlert(false);
			}

		}
	}



}
