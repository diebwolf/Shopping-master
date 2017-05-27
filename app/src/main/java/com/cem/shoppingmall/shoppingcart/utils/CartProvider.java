package com.cem.shoppingmall.shoppingcart.utils;

/**
 * Created by huangqigen on 2017/5/25.
 */

import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;

import com.cem.shoppingmall.app.MyApplication;
import com.cem.shoppingmall.home.bean.GoodsBean;
import com.cem.shoppingmall.utils.CacheUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

/**
 * 购物车数据存储类
 */
public class CartProvider {
    public static final String JSON_CART="json_cart";
    private Context context;
    //优化过的HashMap集合
    /**
     * SparseArray是android里为<Interger,Object>这样的Hashmap而专门写的类，目的是提高
     * 效率，其核心是折半查找函数（binarySearch)。在android中，当我们需要定义
     * HashMap<Integer,E> hashMap =new HashMap<Integer,E>();
     * 时，我们可以使用如下的方式来获取更好的性能。
     * SparseArray<E>spareseArray=new SpareseArray<E>();
     */
    private SparseArray<GoodsBean>datas;
    
    private static CartProvider cartProvider;
    
    private CartProvider(Context context){
        this.context=context;
        datas=new SparseArray<>(100);
        listToSparse();
    }

    public static CartProvider getInstance(){
        if(cartProvider==null){
            cartProvider=new CartProvider(MyApplication.getContext());
        }
        return cartProvider;
    }

    private void listToSparse() {
        List<GoodsBean>carts=getAllData();

        //放在sparseArray中
        if(carts!=null&&carts.size()>0){
            for(int i=0;i<carts.size();i++){
                GoodsBean goodsBean=carts.get(i);
                datas.put(Integer.parseInt(goodsBean.getProduct_id()),goodsBean);
            }
        }
    }

    private List<GoodsBean> getAllData() {
        return getDataFromLocal();
    }

    /**
     * 本地获取json数据，并通过Gson解析成list列表数据
     */
    private List<GoodsBean> getDataFromLocal() {
        List<GoodsBean>carts=new ArrayList<>();

        //从本地获取缓存数据
        String savaJson= CacheUtils.getString(context,JSON_CART);
        if(!TextUtils.isEmpty(savaJson)){
            //把数据转化成列表    该方法将指定的Json反序列化为指定类型的对象
            carts=new Gson().fromJson(savaJson,new TypeToken<List<GoodsBean>>(){}.getType());
        }
        return carts;
    }

    private void addData(GoodsBean cart){
        //添加数据
        GoodsBean tempCart=datas.get(Integer.parseInt(cart.getProduct_id()));
        if(tempCart!=null){
            tempCart.setNumber(tempCart.getNumber()+cart.getNumber());
        }else {
            tempCart=cart;
            tempCart.setNumber(1);
        }
        datas.put(Integer.parseInt(tempCart.getProduct_id()),tempCart);
        
        //保存数据
        commit();
    }

    //保存数据
    private void commit() {
        //把parseArray转换成list
        List<GoodsBean>carts=parsesToList();
        //把转化成String
        String json=new Gson().toJson(carts);

        //保存
        CacheUtils.putString(context,JSON_CART,json);
    }

    public void deleteData(GoodsBean cart){

        //删除数据
        datas.delete(Integer.parseInt(cart.getProduct_id()));

        //保存数据
        commit();
    }

    private void updataData(GoodsBean cart){
        //修改数据
        datas.put(Integer.parseInt(cart.getProduct_id()),cart);

        //保存数据
        commit();
    }

    private List<GoodsBean> parsesToList() {
        List<GoodsBean>carts=new ArrayList<>();

        if(datas!=null&&datas.size()>0){
            for (int i = 0; i < datas.size(); i++) {
                                 //返回该序列号下的一个值
                GoodsBean shoppingCart = datas.valueAt(i);
                carts.add(shoppingCart);
            }
        }
        return carts;
    }

    /**
     * 根据key查找书籍
     * @param goods_bean
     * @return
     */
    public  GoodsBean findData(GoodsBean goods_bean){
                                  //由key得到map值
        GoodsBean goodsBean=datas.get(Integer.parseInt(goods_bean.getProduct_id()));
        if(goodsBean!=null){
            return goods_bean;
        }
        return null;
    }
}
