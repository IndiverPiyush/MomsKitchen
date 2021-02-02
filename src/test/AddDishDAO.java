package test;
import java.sql.*;
public class AddDishDAO {
	public int z;
	public int addDish(Dish db) {
		try {
			Connection con=DBConnection.getcon();
			PreparedStatement ps=con.prepareStatement("insert into Dish19 values(?,?,?,?,?,?)");
			ps.setString(1,db.getdName());
			ps.setString(2,db.getdPrice());
			ps.setString(3,db.getTpa());
			ps.setString(4,db.getDelivery());
			ps.setString(5,db.getPhno());
			ps.setString(6,db.getAvailability());
			z=ps.executeUpdate();
		}catch(Exception e) {e.printStackTrace();}
		return z;
	}

}
