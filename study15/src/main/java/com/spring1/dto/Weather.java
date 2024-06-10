package com.spring1.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Weather {
	public final static String serviceKey = "w%2BrTXuzOm4hEphqqzsFctJRKCMRsbBvQ55%2BDsTk%2FptN8X%2FuZLBgseXYK3mPFkADq%2F4iE88pHQLFmYYOtQjA76w%3D%3D";
	//public final static String serviceKey = "일반 인증키 (Encoding)";
	private String baseDate;
	private String baseTime;
	private String nx;
	private String ny;
	private String pty;
	private String rn1;
	private String reh;
	private String t1h;
	private String uuu;
	private String vec;
	private String vvv;
	private String sky;
	private String wsd;
	/* T1H : 기온(℃)
	 RN1 : 1시간 강수량(범주(1 mm))
	 SKY : 하늘상태(코드값)
	 UUU : 동서바람성분(m/s)
	 VVV : 남북바람성분(m/s)
	 REH : 습도(%)
	 PTY : 강수형태(코드값)
	 LGT : 낙뢰(코드값)
	 VEC : 풍향(deg)
	 WSD : 풍속(m/s) */
}
