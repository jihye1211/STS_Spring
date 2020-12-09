import org.apache.ibatis.session.SqlSession;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Test1 {
	private SqlSession sqlSession;
	
	public Test1(SqlSession sqlSession) {
		this.sqlSession=sqlSession;
	}
	
	public void insert(Singer singer) {
		sqlSession.insert("singerMapper.insertSinger",singer);
		System.out.println("레코드 삽입");
	}
	
	public static void main(String[] args) {
		ApplicationContext ctx = new GenericXmlApplicationContext("bean.xml");
		Test1 test1 = (Test1)ctx.getBean("test1");
		test1.insert(new Singer("BTS",7));
	}
}
