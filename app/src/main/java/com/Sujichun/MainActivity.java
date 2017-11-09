package com.Sujichun;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.loader.ImageLoaderInterface;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Banner banner;

    private List<String> list = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        banner = (Banner) findViewById(R.id.banner);//获取控件；

//添加一些图片到集合中。轮播的图片即集合中的图片；

        list.add("http://img15.3lian.com/2016/h1/11/126.jpg");

        list.add("http://i03.pictn.sogoucdn.com/292e226a2115d0b2");

        list.add("http://i03.pictn.sogoucdn.com/7b9195d5032d845e");

        list.add("http://img16.3lian.com/gif2016/q20/32/82.jpg");

//设置glide方法；

        banner.setImageLoader(new Glider());

        banner.setDelayTime(2000);

//设置变换图片的间隔时间；

        banner.setImages(list);

//设置加载的图片集合

        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);

//设置格式；

        banner.start();

//开始

    }

//重写glide方法；

    public class Glider extends ImageLoader implements ImageLoaderInterface {

        @Override

        public void displayImage(Context context, Object path, View imageView) {

            Glide.with(context).load(path).into((ImageView) imageView);

        }

        @Override

        public View createImageView(Context context) {

            return null;
        }

    }

}
