package sia.tacocloud.Observer.Test;

import sia.tacocloud.Observer.Dong;
import sia.tacocloud.Observer.ProductList;
import sia.tacocloud.Observer.Tao;

public class ObserverTest {
    public static void main(String[] args) {
        ProductList productList = ProductList.getProductList();

        productList.addObserver(new Dong());
        productList.addObserver(new Tao());
        productList.addProduct("巧克力");
    }
}

