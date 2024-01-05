package test;

import java.util.ArrayList;
import java.util.List;

import dao.ItemDAO;
import model.Item;

public class DAOtest {

	public static void main(String[] args) {
		ItemDAO itemDao = new ItemDAO();
		
		List<Item> donutMenu = new ArrayList<Item>();
		List<Item> drinkMenu = new ArrayList<Item>();
		
		donutMenu = itemDao.createDonutMenu(donutMenu);
		drinkMenu = itemDao.createDrinkMenu(drinkMenu);
		
		Item donut1 = donutMenu.get(0);
		Item drink1 = drinkMenu.get(0);
		
		
		System.out.println(donut1.getName());
		System.out.println(donut1.getPrice());
		System.out.println(donut1.getKcal());
		System.out.println(donut1.getImgPath());
		System.out.println(donut1.getCategory());
		
		System.out.println(drink1.getName());
		System.out.println(drink1.getPrice());
		System.out.println(drink1.getKcal());
		System.out.println(drink1.getImgPath());
		System.out.println(drink1.getCategory());
	}

}
