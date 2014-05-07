/*************************************************************************
	> File Name: PropertyMgr.java
	> Author: Bslin
	> Mail: Baoshenglin1994@gmail.com
	> Created Time: 2014年05月07日 星期三 21时42分26秒
 ************************************************************************/

import java.util.Properties;
import java.io.IOException;

/**
 * PropertyMgr使用Singleton模式增加效率
 */

public class PropertyMgr {
	static Properties props = new Properties();

	static {
		try {
			props.load(PropertyMgr.class.getClassLoader().getResourceAsStream("config/tank.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private PropertyMgr() {};

	public static String getProperty(String key) {
		return props.getProperty(key);
	}
}
