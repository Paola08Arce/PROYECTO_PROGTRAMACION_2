package com.limpieza.control;


import java.sql.SQLException;

import com.limpieza.view.Menus.MenuPrincipal;

public class Pantalla {
	
	public static boolean bol = false;

	public static void main(String[] args) throws SQLException {

		MenuPrincipal menuPrincipal = new MenuPrincipal();
		menuPrincipal.Principal();

		do {
			bol = false;

			try {
				menuPrincipal.Principal();
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Cometió un error...Intente de nuevo");
			}
		} while (bol == true);
	}

}
