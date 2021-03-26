package sia.tacocloud.Observer.Test;

import sia.tacocloud.Observer.Dong;
import sia.tacocloud.Observer.ProductList;
import sia.tacocloud.Observer.Tao;

public class ObserverTest {
    public static void main(String[] args) {
        ProductList productList = ProductList.getProductList();

        productList.addObserver(new Tao());
        productList.addObserver(new Dong());

//        产品列表新增产品
//        成功增加D巧克力
//        成功增加T巧克力



        productList.addProduct("巧克力");
    }
}

