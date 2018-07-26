package com.stock.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.stock.model.Stock;
import com.stock.util.DBConnection;

@Repository
public class StockDaoImpl implements StockDao {

	PreparedStatement pstm = null;
	ResultSet rs = null;
	Connection con = null;
	String insertSql = "Insert into trade.tradeorderdetails values (?,?,?,?,?,?,?,?,?)";
	String selectSql = "Select *from trade.tradeorderdetails where tradeorderdetails.user_name = ?";
	boolean selectFlag = false;
	boolean createFlag = false;
	int record = 0;

	@Override
	public boolean createStock(Stock stock) {
		// convert from LocalDateTime to Timestamp and vice versa.
		LocalDateTime ldt = LocalDateTime.now();
		Timestamp t = Timestamp.valueOf(ldt);
		// LocalDateTime ldt2 = t.toLocalDateTime();

		try {
			con = DBConnection.getDbConnection();
			pstm = con.prepareStatement(insertSql);
			pstm.setString(1, stock.getUserName());
			pstm.setInt(2, stock.getUserPhone());
			pstm.setString(3, stock.getStockName());
			pstm.setDouble(4, stock.getStockPrice());
			pstm.setInt(5, stock.getVolumePurchased());
			pstm.setDouble(6, stock.getTotalPrice());
			pstm.setDouble(7, stock.getFees());
			pstm.setDouble(8, stock.getTotalFees());
			pstm.setTimestamp(9, t);
			record = pstm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
				pstm.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (record > 0) {
			createFlag = true;
		}
		return createFlag;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Stock> getOrderDetails(String customerName) {
		@SuppressWarnings("rawtypes")
		List orderList = new ArrayList();

		try {
			con = DBConnection.getDbConnection();
			pstm = con.prepareStatement(selectSql);
			pstm.setString(1, customerName);
			rs = pstm.executeQuery();
			while (rs.next()) {
				/*
				 * orderList.add(rs.getString(1)); orderList.add(rs.getInt(2));
				 * orderList.add(rs.getString(3)); orderList.add(rs.getDouble(4));
				 * orderList.add(rs.getInt(5)); orderList.add(rs.getDouble(6));
				 * orderList.add(rs.getDouble(7)); orderList.add(rs.getDouble(8));
				 * orderList.add(rs.getTimestamp(9));
				 */
				orderList.add(new Stock(rs.getString(1), rs.getInt(2), rs.getString(3), rs.getDouble(4), rs.getInt(5),
						rs.getDouble(6), rs.getDouble(7), rs.getDouble(8), rs.getTimestamp(9)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return orderList;
	}

}
