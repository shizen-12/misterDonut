package listener;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import dao.ItemDAO;
import model.Item;


@WebListener
public class MenuCreate implements ServletContextListener {

    public void contextInitialized(ServletContextEvent sce)  { 
    	//アプリケーションスコープの作成
    	ServletContext context = sce.getServletContext();
    	List<Item> donutMenu = new ArrayList<Item>();
    	List<Item> drinkMenu = new ArrayList<Item>();
    	
		
		ItemDAO itemDAO = new ItemDAO();
		//ドーナツメニューリストの作成
		donutMenu = itemDAO.createDonutMenu(donutMenu);
		
		//飲み物メニューリストの作成
		drinkMenu = itemDAO.createDrinkMenu(drinkMenu);
    	
		//アプリケーションスコープに入れる
		context.setAttribute("donutMenu", donutMenu);
		context.setAttribute("drinkMenu", drinkMenu);
    }
	
}
