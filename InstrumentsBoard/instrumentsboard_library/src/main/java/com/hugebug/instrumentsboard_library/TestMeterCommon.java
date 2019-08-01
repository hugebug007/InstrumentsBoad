package com.hugebug.instrumentsboard_library;

public class TestMeterCommon {

	public static final byte TEMP = 1;//温度
	public static final byte HUM = 2;//湿度
	public static final byte SOIL_TEMP = 10;// 土壤温度
	public static final byte SOIL_WATER = 5;// 土壤水分
	public static final byte SUN_SHINE = 3;// 光照
	public static final byte CO2 = 4;//二氧化碳
	public static final byte EC = 11;// 土壤电导率
	public static final byte SALTY = 12;// 土壤盐分
	public static final byte SPEED = 13;// 速度
	
	public static final String TEMP_UNIT = "℃";
	public static final String HUM_UNIT = "%";
	public static final String SOIL_TEMP_UNIT = "℃";
	public static final String SOIL_WATER_UNIT = "%";
	public static final String SUN_SHINE_UNIT = " lux";
	public static final String CO2_UNIT = "ppm";
	public static final String EC_UNIT = "mS/cm";
	public static final String SALTY_UNIT = "mol/L";
	public static final String SPEED_UNIT = "km/h";
	
	/*
	 * DEV_OUT, 0 DEV_TEMP, 1 DEV_HUMI, 2 DEV_LIGHT, 3 DEV_CO2, 4 DEV_WATER, 5
	 * DEV_WIND,6 DEV_LIGHT_F, 7 DEV_RAINSNOW, 8 DEV_PH,9 DEV_SOILTEMP,10
	 * DEV_EC,11 DEV_SALTY, 12 DEV_DISP = 253, 13 DEV_ALARM = 254, 14 DEV_POS =
	 * 255，，15
	 */
}