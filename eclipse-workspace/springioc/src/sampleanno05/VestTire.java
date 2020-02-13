﻿package sampleanno05;

import org.springframework.stereotype.Component;

@Component // name = vestTire, Component에 이름을 안주면 name = vestTire로 생성됨.
public class VestTire implements Tire{

	public VestTire() {
		System.out.println("VestTire - Create object");
	}
	@Override
	public String getBrand() {
		return "MICHELIN Tire!!";
	}
}