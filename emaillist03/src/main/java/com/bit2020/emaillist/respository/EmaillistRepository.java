package com.bit2020.emaillist.respository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.bit2020.emaillist.vo.EamillistVo;

@Repository
public class EmaillistRepository {
	public boolean insert(EamillistVo vo) {

		boolean result = false;
		Connection connection = null;
		Statement stmt = null;
		try {
			// 1. JDBC Driver 로더(MariaDB Driver)
			Class.forName("org.mariadb.jdbc.Driver");

			// 2. 연결하기
			String url = "jdbc:mysql://127.0.0.1:3306/webdb?characterEncoding=utf8";
			connection = DriverManager.getConnection(url, "webdb", "webdb"); //(url,dbname, dbpassword)

			System.out.println("연결성공");

			// 3. Statement 객체 생성
			stmt = connection.createStatement(); // sql 구문을 해주기 위해서 statement 생성

			// 4. SQL 실행
//			String firstName = "강";
//			String lastName = "성호";
//			String email = "sungho1996@naver.com";

			String sql = "insert into emaillist values(null, '" + 
						vo.getFirstName() + "','" + 
						vo.getLastName() + "','"+ 
						vo.getEmail() + "')"; // jdbc에는 sql에 세미콜론넣으면 안됨.
			int count = stmt.executeUpdate(sql); // 리턴값으로 인서트 개수가 나옴
			if (count == 1) {
				result = true;
			}

		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
		} catch (SQLException e) {
			System.out.println("에러: " + e);
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (stmt != null) {
					stmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	public List<EamillistVo> findAll() {
		List<EamillistVo> result = new ArrayList<>();
		Connection connection = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			// 1. JDBC Driver(MariaDB Driver)
			Class.forName("org.mariadb.jdbc.Driver");

			// 2. 연결하기
			String url = "jdbc:mysql://127.0.0.1:3306/webdb?characterEncoding=utf8";
			connection = DriverManager.getConnection(url, "webdb", "webdb");

			// 3. Statement 객체 생성
			stmt = connection.createStatement();

			// 4. SQL 실행
			String sql = "select no, first_name, last_name, email from emaillist";
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				Long no = rs.getLong(1);
				String firstName = rs.getString(2);
				String lastName = rs.getString(3);
				String email = rs.getString(4);

				EamillistVo vo = new EamillistVo();
				vo.setNo(no);
				vo.setFirstName(firstName);
				vo.setLastName(lastName);
				vo.setEmail(email);

				result.add(vo);
			}

		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
		} catch (SQLException e) {
			System.out.println("에러:" + e);
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return result;
	}

}
