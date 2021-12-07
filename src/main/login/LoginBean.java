package com.login;

public class LoginBean {

	public int checkLogin(String s1, String s2) {
		
		if ("Guru".equals(s1)&&"Gowd".equals(s2))
		{
			return 1;
		}
		else
		return 0;
	}

}
