package enumUt;

public  enum EnumEx {
		
		IMMEDIATE("i", "immediate"),
		DELAYED("d", "delayed"),
		PERIODIC("p","periodic"),;

		private String schedulerType;
		private String schedulerTypeDescription;

		public String getSchedulerTypeDescription() {
			return schedulerTypeDescription;
		}

		private EnumEx(String schedulerType,String schedulerTypeDescription ) {
			this.schedulerType = schedulerType;
			this.schedulerTypeDescription = schedulerTypeDescription;
		}

		public String getSchedulerType() {
			return this.schedulerType;
		}



}
