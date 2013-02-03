package name.huangzhoujin.mymaven.utils;

public enum ProtocolType {

	Http {
		@Override
		public String getType() {
			return "http";
		}

		@Override
		public int getDefaultPort() {
			return 80;
		}

	},

	Https {
		@Override
		public String getType() {
			return "https";
		}

		@Override
		public int getDefaultPort() {
			return 443;
		}

	};

	public abstract String getType();

	public abstract int getDefaultPort();
}
