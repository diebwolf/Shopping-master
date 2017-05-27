package com.cem.shoppingmall.app;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.cem.shoppingmall.R;
import com.cem.shoppingmall.home.bean.GoodsBean;
import com.cem.shoppingmall.shoppingcart.utils.CartProvider;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.List;

/**
 * 商品信息列表页面
 */
@ContentView(R.layout.activity_goods_info)
public class GoodsInfoActivity extends AppCompatActivity {
    @ViewInject(R.id.ib_good_info_back)
    private ImageButton ibGoodInfoBack;

    @ViewInject(R.id.ib_good_info_more)
    private ImageButton ibGoodInfoMore;

    @ViewInject(R.id.iv_good_info_image)
    private ImageView ivGoodInfoImage;

    @ViewInject(R.id.tv_good_info_name)
    private TextView tvGoodInfoName;

    @ViewInject(R.id.tv_good_info_desc)
    private TextView tvGoodInfoDesc;

    @ViewInject(R.id.tv_good_info_price)
    private TextView tvGoodInfoPrice;

    @ViewInject(R.id.tv_good_info_store)
    private TextView tvGoodInfoStore;

    @ViewInject(R.id.tv_good_info_style)
    private TextView tvGoodInfoStyle;

    @ViewInject(R.id.wb_good_info_more)
    private WebView wbGoodInfoCallcenter;

    @ViewInject(R.id.tv_good_info_callcenter)
    private TextView tvGoodInfoCallcenter;

    @ViewInject(R.id.tv_good_info_collection)
    private TextView tvGoodInfoCollection;

    @ViewInject(R.id.tv_good_info_cart)
    private TextView tvGoodInfoCart;

    @ViewInject(R.id.btn_good_info_addcart)
    private Button btnGoodInfoAddcart;

    @ViewInject(R.id.tv_more_share)
    private TextView tvMoreShare;

    @ViewInject(R.id.tv_more_search)
    private TextView tvMoreSearch;

    @ViewInject(R.id.tv_more_home)
    private TextView tvMoreHome;

    @ViewInject(R.id.ll_root)
    private LinearLayout ll_root;

    @ViewInject(R.id.btn_more)
    private Button btn_more;

    private CartProvider cartProvider;
    //private Boolean isFirst=true;




    /**模拟商家的数组
    private String[]sellers=new String[]{"尚硅谷","画影工作室","Wacom"};
    private List<GoodsBean> goodsLists;
    private GoodsList goodsList; */
    private List<GoodsBean> goodsBeans;
    private GoodsBean goods_bean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);

    }




}
