package servlet;
import java.io.IOException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.openlab.utils.MybatisTools;

import dao.AdminMapper;
import dao.BlogMapper;
import domain.MessageBean;
import domain.UserBean;


public class Test {
	public static void main(String[] args) throws IOException {
		try (SqlSession ss = MybatisTools.openSession()){
			AdminMapper mapper = ss.getMapper(AdminMapper.class);
			int res = mapper.loginVerify("storm", "123456");
			System.out.println(res);
		}
	}	
}
