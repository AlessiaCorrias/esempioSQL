package it.polito.tdp.esempioSQL.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LeggiBabs {

	public void run() {
		String jdbcURL = "jdbc:mysql://localhost/babs?user=root&password=bdairam";
		
		try {
			Connection conn = DriverManager.getConnection(jdbcURL);
			
			String sql = "SELECT name FROM station WHERE landmark = ?";
			
			PreparedStatement st = conn.prepareStatement(sql);
			
			st.setString(1, "Palo Alto");
			ResultSet res = st.executeQuery();
			
			while (res.next()) {
				String nomeStazione = res.getString("name");
				System.out.println(nomeStazione);
			}
			st.close();
			
			Statement st2 = conn.createStatement();
			
			
			conn.close(); //da scrivere subito o lo dimentichiamo. Connessioni sono risorsa finita non posso crearne troppe
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
	}
	public static void main (String args[]) {
		LeggiBabs babs = new LeggiBabs();
		babs.run();
	}
	

}
