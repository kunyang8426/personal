package com.kazma.util;



import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Collection;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 系统检测辅助类
 * 
 * @author YRJ
 * 
 */
public final class Check {

	/**
	 * 系统空值检测辅助类
	 * 
	 * @author YRJ
	 * 
	 */
	public static class NULL {

		/**
		 * 检测Java对象是否为空.
		 * 
		 * @param obj
		 *            待检测的对象
		 * @return true: 空; false:非空.
		 */
		public static boolean NuNObj(final Object obj) {
			if (obj instanceof String) {
				return NuNStr((String) obj);
			}
			return obj == null;
		}

		/**
		 * 检测Java对象是否为空. 同时检测多个指定的对象, 如果存在一个为空, 则全部为空.
		 * 
		 * @param objs
		 *            待检测的对象
		 * @return true: 空; false:非空.
		 */
		public static boolean NuNObjs(final Object... objs) {
			for (final Object obj : objs) {
				final boolean nun = NuNObj(obj);
				if (nun) {
					return true;
				}
			}
			return false;
		}

		/**
		 * 检测Java对象是否为空. 同时检测多个指定的对象, 如果存在一个为空, 则全部为空.
		 * 
		 * @param objs
		 *            待检测的对象
		 * @return true: 空; false:非空.
		 */
		public static boolean NuNObject(final Object[] objs) {
			if ((objs == null) || (objs.length == 0)) {
				return true;
			}
			for (final Object obj : objs) {
				final boolean nun = NuNObj(obj);
				if (nun) {
					return true;
				}
			}
			return false;
		}

		/**
		 * 检测字符串是否为空.
		 * <p>
		 * 1. 未分配内存
		 * </p>
		 * <p>
		 * 2. 字符串剔除掉前后空格后的长度为0
		 * </p>
		 * 
		 * @param str
		 *            待检测的字符串
		 * @return true: 空; false:非空.
		 */
		public static boolean NuNStr(final String str) {
			return (str == null) || (str.trim().length() == 0)  || "null".equals(str) || str.equals("0");
		}

		public static boolean NuNStrP(final String str) {
			return (str == null) || (str.trim().length() == 0)  || str.equals("null");
		}

		/**
		 * 严格的检测字符串是否为空.
		 * <p>
		 * 1. 未分配内存
		 * </p>
		 * <p>
		 * 2. 字符串剔除掉前后空格后的长度为0
		 * </p>
		 * <p>
		 * 3. 字符串为'null'字串.
		 * </p>
		 * 
		 * @param str
		 *            待检测的字符串
		 * @return true: 空; false:非空.
		 */
		public static boolean NuNStrStrict(final String str) {
			return NuNStr(str) || "null".equalsIgnoreCase(str);
		}

		/**
		 * 严格的检测字符串是否为空.
		 * <p>
		 * 1. 未分配内存
		 * </p>
		 * <p>
		 * 2. 字符串剔除掉前后空格后的长度为0
		 * </p>
		 * <p>
		 * 3. 字符串为'null'字串.
		 * </p>
		 *
		 * @param str
		 *            待检测的字符串
		 * @return true: 空; false:非空.
		 */
		public static boolean NuNStrStrictP(final String str) {
			return NuNStrP(str) || "null".equalsIgnoreCase(str);
		}

		/**
		 * 判断集合是否为空
		 * 
		 * @param colls
		 *            待检测的集合
		 * @return true: 空; false:非空.
		 */
		public static boolean NuNCollection(final Collection<?> colls) {
			return (colls == null) || colls.isEmpty();
		}

		/**
		 * 判断Map集合是否为空
		 * 
		 * @param map
		 *            待检测的集合
		 * @return true: 空; false:非空.
		 */
		public static boolean NuNMap(final Map<?, ?> map) {
			return (map == null) || map.isEmpty();
		}
	}


	/**
	 * 验证Email格式
	 * 
	 * @param email
	 * @return
	 */
	public static boolean VerifyEmailFormatter(final String email) {
		final boolean tag = true;
		final String str = "^\\w+([-+.']\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*";
		final Pattern pattern = Pattern.compile(str);
		final Matcher mat = pattern.matcher(email);
		if (!mat.matches()) {
			return false;
		}
		return tag;
	}

	public static String encode(final String value) {
		try {
			return URLEncoder.encode(value, "UTF-8");
		} catch (final UnsupportedEncodingException e) {
//			System.out.println("Fuck!");
			return value;
		}
	}

	public static String decode(final String value) {
		try {
			return URLDecoder.decode(value, "UTF-8");
		} catch (final UnsupportedEncodingException e) {
//			System.out.println("Fuck!");
			return value;
		}
	}

	/**
	 * 将字符串转换为整数. 如果转换失败则返回默认值
	 * 
	 * @param str
	 *            待转换的字符串
	 * @param defaultValue
	 *            默认值
	 * @return
	 */
	public static int parseInt(final String str, final int defaultValue) {
		int val;
		try {
			val = Integer.parseInt(str);
		} catch (final NumberFormatException ignore) {
			val = defaultValue;
		}
		return val;
	}

//	/**
//	 * 检测设备的合法性
//	 *
//	 * @param __current
//	 * @return
//	 */
	/*public static boolean IllegalDevice(final Client ci) {
		if (NULL.NuNObj(ci)) {
			return true;
		}
		final String device = ci.getDevice() + "";
		if (NULL.NuNStr(device)) {
			return true;
		}
		return Device.IllegalDevice(parseInt(device, -1));
	}*/

//	/**
//	 * 获取请求上下文
//	 *
//	 * @param __current
//	 * @return
//	 */
	/*public static Connection getRequestContext(final Client ci) {
		if (NULL.NuNObj(ci)) {
			return null;
		}
		final Ice.TCPConnectionInfo request = (Ice.TCPConnectionInfo) __current.con.getInfo();
		final String ip = request.remoteAddress;
		final int port = request.remotePort;

		final String ver = __current.ctx.get("ClientVersion");
		final String sour = __current.ctx.get("Source");
		final String token = __current.ctx.get("Token");
		final String device = __current.ctx.get("DeviceType");
		final String remoteIp = __current.ctx.get("RemoteIp");

		return new Connection(ip, port, device, ver, sour, token, remoteIp);
	}*/

//	/**
//	 * 获取请求设备类型
//	 *
//	 * @param __current
//	 * @return
//	 */
	/*public static int getRequestDeviceNumber(final Ice.Current __current) {
		return parseInt(__current.ctx.get("DeviceType"), -1);
	}*/

//	/**
//	 * 获取请求上下文指定的参数
//	 *
//	 * @param __current
//	 * @param key
//	 *            参数名
//	 * @return
//	 */
	/*public static String getRequestContextToStr(final Ice.Current __current, final String key) {
		if (Check.NULL.NuNObjs(__current, key)) {
			return null;
		}
		return __current.ctx.get(key);
	}*/

	/*
	 * 获取用户Token
	 * 
	 * @param __current
	 * @return
	 *public static String getToken(final Ice.Current __current) {
		return getRequestContextToStr(__current, "Token");
	}*/

	private Check() {
		throw new AssertionError("Uninstantiable class");
	};
	
	/**
	 * 重建分页
	 * 
	 * @param pager
	 */
}
