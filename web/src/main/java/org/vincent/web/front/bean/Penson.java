package org.vincent.web.front.bean;

/**
 * @Package: org.vincent.web.front.bean <br/>
 * @Description： TODO <br/>
 * @author: PengRong <br/>
 * @Date: Created in 2018/8/12 12:25 <br/>
 * @Company: PLCC <br/>
 * @Copyright: Copyright (c) 2018 <br/>
 * @Version: 1.0 <br/>
 * @Modified By: <br/>
 * @Created by PengRong on 2018/8/12. <br/>
 */

public class Penson {
		private String name;
		private short age;
		private Address address;

		public String getName() {
				return name;
		}

		public void setName(String name) {
				this.name = name;
		}

		public short getAge() {
				return age;
		}

		public void setAge(short age) {
				this.age = age;
		}

		public Address getAddress() {
				return address;
		}

		public void setAddress(Address address) {
				this.address = address;
		}

		@Override
		public String toString() {
				return "Penson{" +
								"name='" + name + '\'' +
								", age=" + age +
								", address=" + address +
								'}';
		}
}
