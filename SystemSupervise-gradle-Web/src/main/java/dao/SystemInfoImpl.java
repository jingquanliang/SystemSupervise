package dao;

public class SystemInfoImpl {
	
	private SystemInfoMapper systemInfoMapper;

	public void setUserMapper(SystemInfoMapper systemInfoMapper) {
	  this.systemInfoMapper = systemInfoMapper;
	}

	public SystemInfo doSomeBusinessStuff(String id) {
	  return this.systemInfoMapper.getSystemInfo(id);
	}
}
