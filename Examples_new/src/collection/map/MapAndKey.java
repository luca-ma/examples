package collection.map;

import java.util.HashMap;
import java.util.Map;

public class MapAndKey {

	/*
	 * *example using a mutable obj as a key in a a Map
	 */

	public static void main(String[] args) {
		Map<Key, String> mutableMap = new HashMap<Key, String>();

		Key key1 = new MapAndKey().new Key("luca");
		mutableMap.put(key1, "lucama");

		System.out.println("key1 val: " + mutableMap.get(key1));
		key1.setSurname("lucamaa");

		System.out.println("key1 modified but equals to previous : "
				+ mutableMap.get(key1));

		key1.setName("luca1");

		System.out.println("key1 modified but NOT equals to previous : "
				+ mutableMap.get(key1));

	}

	class Key {

		private String name = "";
		private String surname = "";

		public String getSurname() {
			return surname;
		}

		public void setSurname(String surname) {
			this.surname = surname;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getName() {
			return name;
		}

		public void Key(String name, String surname) {
			this.name = name;
			this.surname = surname;
		}

		public Key(String key) {
			super();
			this.name = key;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getOuterType().hashCode();
			result = prime * result + ((name == null) ? 0 : name.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Key other = (Key) obj;
			if (!getOuterType().equals(other.getOuterType()))
				return false;
			if (name == null) {
				if (other.name != null)
					return false;
			} else if (!name.equals(other.name))
				return false;
			return true;
		}

		private MapAndKey getOuterType() {
			return MapAndKey.this;
		}
	}

}
