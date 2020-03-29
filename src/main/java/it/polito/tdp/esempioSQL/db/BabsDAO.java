package it.polito.tdp.esempioSQL.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.esempioSQL.model.Station;

public class BabsDAO {
	
	
	public List<Station> listStation(){
		
		List<Station> result = new ArrayList<>();
		String sql = "SELECT station_id, name, dockcount, landmark FROM station";
		

		
		try {
			Connection conn = DBconnect.getConnection();
			
			PreparedStatement st = conn.prepareStatement(sql);
			
			ResultSet res = st.executeQuery();
			
			while (res.next()) {
				Station s =new Station(res.getInt("station_id"), 
						res.getString("name"),
						res.getInt("dockcount"),
						res.getString("landmark"));
				result.add(s);
			}
			st.close();
			
			
			conn.close(); //da scrivere subito o lo dimentichiamo. Connessioni sono risorsa finita non posso crearne troppe
		
		return result;
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		/*
		 * FACTORY = creazione di un oggetto di una classe senza conoscere
		 * il tipo della classe (NON potevo usare new)
		 * Uso un altro metodo fornito da una classe che farà new internamente
		 * conoscendo il tipo di classe effettivo.s. L'ho usato per creare
		 * conn, st, res
		 */
		
		return null;
	}
	
public List<Station> listStationByLandmark(String landmark){
		
		List<Station> result = new ArrayList<>();
		String sql = "SELECT station_id, name, dockcount, landmark FROM station "+
				"WHERE landmark=? ORDER BY name";
		
		try {
			Connection conn = DBconnect.getConnection();
			
			PreparedStatement st = conn.prepareStatement(sql);
			
			st.setString(1, landmark);
			ResultSet res = st.executeQuery();
			
			while (res.next()) {
				Station s =new Station(res.getInt("station_id"), 
						res.getString("name"),
						res.getInt("dockcount"),
						res.getString("landmark"));
				result.add(s);
			}
			st.close();
			
			
			conn.close();
		
		return result;
		
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	
		return null;
	}
}
