package shop;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import mybatis.SqlMapConfig;

public class ProductDAO {

	SqlSessionFactory sqlsession_f = SqlMapConfig.getSqlMapInstance();
	SqlSession session;

	public ProductDAO() {
		session = sqlsession_f.openSession(true);
	}

	public List<Product> getAllProducts() {
		return session.selectList("ProductMapper.selectAllProducts");
	}

	public void addProduct(Product product) {
		session.insert("ProductMapper.insertProduct", product);
	}

	public Product getProductById(int id) {
		return session.selectOne("ProductMapper.selectProductById", id);

	}
	public void updateProduct(Product product) {
		session.update("ProductMapper.updateProduct", product);
	}

	public void deleteProduct(int id) {
		session.delete("ProductMapper.deleteProduct", id);
	}
}
