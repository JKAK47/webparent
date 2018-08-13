package org.vincent.web.front.bean;

/**
 * @Package: org.vincent.web.front.bean <br/>
 * @Description： TODO <br/>
 * @author: PengRong <br/>
 * @Date: Created in 2018/8/12 12:55 <br/>
 * @Company: PLCC <br/>
 * @Copyright: Copyright (c) 2018 <br/>
 * @Version: 1.0 <br/>
 * @Modified By: <br/>
 * @Created by PengRong on 2018/8/12. <br/>
 */

public class Address {
		private  String province;
		private  String city;

		public String getProvince() {
				return province;
		}

		public void setProvince(String province) {
				this.province = province;
		}

		public String getCity() {
				return city;
		}

		public void setCity(String city) {
				this.city = city;
		}

		@Override
		public String toString() {
				return "Address{" +
								"province='" + province + '\'' +
								", city='" + city + '\'' +
								'}';
		}
}
