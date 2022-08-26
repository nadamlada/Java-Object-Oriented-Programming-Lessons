package shopAndGoods;

import javax.naming.OperationNotSupportedException;

public class Main {
    public static void main(String[] args) throws OperationNotSupportedException {
        Shop shop = new Shop();
        Goods good1 = new Goods("Dracaena", "D");

        shop.addGoods("Shelves1", good1);
        System.out.println(good1.getGoodsCode());

        System.out.println(shop.removeGoods("Shelves1", good1));
    }
}
