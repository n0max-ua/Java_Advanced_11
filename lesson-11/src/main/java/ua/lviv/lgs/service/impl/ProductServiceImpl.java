package ua.lviv.lgs.service.impl;

import java.sql.SQLException;
import java.util.List;

import ua.lviv.lgs.dao.ProductDao;
import ua.lviv.lgs.dao.impl.ProductDaoImpl;
import ua.lviv.lgs.domain.Product;
import ua.lviv.lgs.service.ProductService;

public class ProductServiceImpl implements ProductService {

	private ProductDao productDao;

	public ProductServiceImpl() {
		try {
			productDao = new ProductDaoImpl();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Product create(Product product) {
		return productDao.create(product);
	}

	@Override
	public Product readById(Integer id) {

		return productDao.readById(id);
	}

	@Override
	public Product update(Integer id, Product product) {
		return productDao.update(id, product);
	}

	@Override
	public void delete(Integer id) {
		productDao.delete(id);

	}

	@Override
	public List<Product> reatAll() {
		return productDao.reatAll();
	}

}
