package ua.lviv.lgs.dao.impl;

import java.awt.IllegalComponentStateException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import ua.lviv.lgs.dao.BucketDao;
import ua.lviv.lgs.domain.Bucket;
import ua.lviv.lgs.utils.ConnectionUtils;

public class BucketDaoImpl implements BucketDao {

	private static String CREATE = "insert into bucket(user_id, product_id) values(?,?)";
	private static String READ_BY_ID = "select * from bucket where id =?";
	private static String READ_ALL = "select * from bucket";
	private static String DELETE_BY_ID = "delete from bucket where id =?";
	
	private static Logger LOGER = Logger.getLogger(BucketDaoImpl.class);

	Connection connection;
	PreparedStatement preparedStatement;

	public BucketDaoImpl() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		connection = ConnectionUtils.openConnection();
	}

	@Override
	public Bucket create(Bucket bucket) {
		try {
			preparedStatement = connection.prepareStatement(CREATE, Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setInt(1, bucket.getUserId());
			preparedStatement.setInt(2, bucket.getProductId());
			preparedStatement.executeUpdate();

			ResultSet rs = preparedStatement.getGeneratedKeys();
			rs.next();
			bucket.setId(rs.getInt(1));
		} catch (SQLException e) {
			LOGER.error(e);
		}

		return bucket;
	}

	@Override
	public Bucket readById(Integer id) {
		Bucket bucket = null;
		try {
			preparedStatement = connection.prepareStatement(READ_BY_ID);
			preparedStatement.setInt(1, id);
			ResultSet result = preparedStatement.executeQuery();
			result.next();

			Integer bucketId = result.getInt("id");
			Integer userId = result.getInt("user_id");
			Integer productId = result.getInt("product_id");
			String purchaseDate = result.getString("purchase_date");
			bucket = new Bucket(bucketId, userId, productId, purchaseDate);
		} catch (SQLException e) {
			LOGER.error(e);
		}

		return bucket;
	}

	@Override
	public Bucket update(Integer id, Bucket bucket) {
		throw new IllegalComponentStateException("there is no update for bucket");
	}

	@Override
	public void delete(Integer id) {
		try {
			preparedStatement = connection.prepareStatement(DELETE_BY_ID);
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			LOGER.error(e);
		}

	}

	@Override
	public List<Bucket> readAll() {
		List<Bucket> listOfBuckets = new ArrayList<Bucket>();

		try {
			preparedStatement = connection.prepareStatement(READ_ALL);
			ResultSet result = preparedStatement.executeQuery();
			while (result.next()) {
				Integer bucketId = result.getInt("id");
				Integer userId = result.getInt("user_id");
				Integer productId = result.getInt("product_id");
				String purchaseDate = result.getString("purchase_date");
				listOfBuckets.add(new Bucket(bucketId, userId, productId, purchaseDate));
			}
		} catch (SQLException e) {
			LOGER.error(e);
		}

		return listOfBuckets;
	}
}
