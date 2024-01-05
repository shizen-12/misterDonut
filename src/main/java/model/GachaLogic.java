package model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Random;



public class GachaLogic {
	
	public List<Item> execute(List<Item> gachaList, int price){
		//引数のリストをもとにガチャをするよ
		//ガチャの結果リストを作成して最後に返すよ
		Random rand = new Random();
		List<Item> gachaResult = new ArrayList<Item>();
		
		//現在の合計抽選金額
		int priceSum = 0;
		
		//メニュー上の最安金額;
		Optional<Item> minItem = gachaList.stream().min(Comparator.comparing(Item::getPrice));
		int minPrice = minItem.get().getPrice();
		
		
		while (price - priceSum >= minPrice) {
			Item item = gachaList.get(rand.nextInt(gachaList.size()));
			
			if (item.getPrice() <= price - priceSum) {
				gachaResult.add(item);
				priceSum += item.getPrice();
			}
		}
		
		
		return gachaResult;
	}
	
	
	
}
