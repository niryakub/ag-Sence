package com.example.ServerTsofen45.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ServerTsofen45.BL.DeviceBL;
import com.example.ServerTsofen45.BL.DeviceDataBL;
import com.example.ServerTsofen45.Beans.Device;
import com.example.ServerTsofen45.Beans.DeviceData;

@RestController
@RequestMapping("DeviceData")
public class DeviceDataController {
	
	@Autowired
	DeviceDataBL deviceDataBL;
	
	
	
	@GetMapping("AllDevicesData")

	public ArrayList<DeviceData> getAllDevices() {

		ArrayList<DeviceData> devices = new ArrayList<DeviceData>();
		devices = deviceDataBL.findAll();
		return devices;
	}

}