package pe.edu.upc.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import pe.edu.upc.conexion.Conexion;
import pe.edu.upc.dao.IVehicleDao;
import pe.edu.upc.entity.Vehicle;

public class VehicleDaoImpl implements IVehicleDao {
	private Connection oCn;

	public VehicleDaoImpl() {
		oCn = Conexion.abrirConexion();
	}

	public void insert(Vehicle vehicle) {
		try {
			String sql = "insert into vehicle(ID_Roundsman,LicenseNumber_Vehicle,Brand_Vehicle,Colour_Vehicle,Type_Vehicle,Notes_Vehicle) values (?,?,?,?,?,?)";
			PreparedStatement ps = oCn.prepareStatement(sql);
			ps.setInt(1, vehicle.getID_Roundsman());
			ps.setString(2, vehicle.getLicenseNumber_Vehicle());
			ps.setString(3, vehicle.getBrand_Vehicle());
			ps.setString(4, vehicle.getColour_Vehicle());
			ps.setString(5, vehicle.getType_Vehicle());
			ps.setString(6, vehicle.getNotes_Vehicle());
			ps.executeUpdate();
			ps.close();
		} catch (Exception e) {
			System.out.println("Error al insertar vehículo");
		}
	}

	public List<Vehicle> list() {
		List<Vehicle> lista = new ArrayList<Vehicle>();
		try {
			String sql = "select * from vehicle";
			PreparedStatement ps = oCn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery(sql);
			while (rs.next()) {
				Vehicle v = new Vehicle();
				v.setID_Vehicle(rs.getInt("ID_Vehicle"));
				v.setID_Roundsman(rs.getInt("ID_Roundsman"));
				v.setLicenseNumber_Vehicle(rs.getString("LicenseNumber_Vehicle"));
				v.setBrand_Vehicle(rs.getString("Brand_Vehicle"));
				v.setColour_Vehicle(rs.getString("Colour_Vehicle"));
				v.setType_Vehicle(rs.getString("Type_Vehicle"));
				v.setNotes_Vehicle(rs.getString("Notes_Vehicle"));
				lista.add(v);
			}
			ps.close();
		} catch (Exception e) {
			System.out.println("Error al listar vehículos");
			System.out.println(e.getLocalizedMessage());
		}
		return lista;
	}

	public void delete(int ID_Vehicle) {
		try {
			String sql = "delete from vehicle where ID_Vehicle=?";
			PreparedStatement ps = oCn.prepareStatement(sql);
			ps.setInt(1, ID_Vehicle);
			ps.executeUpdate();
			ps.close();
		} catch (Exception e) {
			System.out.println("Error al eliminar vehículo");
		}
	}
}
