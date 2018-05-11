package dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

public interface SystemInfoMapper {

	@Select("SELECT * FROM systemInfo WHERE id = #{Id}")
	SystemInfo getSystemInfo(String Id);
	  
	@Insert("SELECT * FROM systemInfo WHERE id = #{Id}")
	int insertSystemInfo(SystemInfo u);
}