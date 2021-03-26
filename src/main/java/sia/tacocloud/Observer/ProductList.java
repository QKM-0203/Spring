package sia.tacocloud.Observer;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class ProductList extends Observable {

      private  List<String> productLists = null;

      private static ProductList productList = null;


      private ProductList(){

      }

    /**
     * 单例模式
     * @return
     */
    public static ProductList getProductList(){

          if(productList == null){

              productList = new ProductList();

              productList.productLists = new ArrayList<>();
          }

          return productList;
      }


    /**
     * 增加产品
     * @param newProduct
     */
      public void addProduct(String newProduct){
           productLists.add(newProduct);
          System.out.println("产品列表新增产品");

          //设置被观察者出现了变化
          super.setChanged();

          //通知观察者，并传递新产品
           super.notifyObservers(newProduct);
      }





}
