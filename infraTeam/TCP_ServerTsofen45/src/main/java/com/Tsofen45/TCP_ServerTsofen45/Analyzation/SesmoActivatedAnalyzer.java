package com.Tsofen45.TCP_ServerTsofen45.Analyzation;

import java.io.IOException;

import org.springframework.stereotype.Service;

import com.Tsofen45.TCP_ServerTsofen45.Device.DeviceData;


@Service
public class SesmoActivatedAnalyzer extends Analyzer {

	@Override
	public void Analyze(DeviceData d) throws IOException {
		// TODO Auto-generated method stub
		if(d.isSesmoActivated()) {
			if(d.isCanSesmoActivated()) {
				System.out.println("Entered sesmo activated");
				
				sendNotify(d.getImei()+"",7,json);
				
				d.setCanSesmoActivated(false);
			}

		}
	}



}
