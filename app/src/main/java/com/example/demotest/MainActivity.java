package com.example.demotest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    //从一个URL加载一个Document对象。
                    Document doc = Jsoup.connect("http://home.meishichina.com/show-top-type-recipe.html").get();
                    //选择“美食天下”所在节点
                    Elements elements = doc.select("div.top-bar");
                    //打印 <a>标签里面的title
                    //默认选择的是第0条
                    Log.i("mytag",elements.select("a").attr("title"));
                    Log.i("mytag",elements.select("a").attr("href"));

                    //指定选择哪一条
                    Log.i("mytag",elements.select("a").get(1).attr("title"));

//                    Elements elements1 = doc.select("ul.bar-left left").select("a");
//                    Log.i("mytag",elements1.get(1).attr("title"));
                }catch(Exception e) {
                    Log.i("mytag", e.toString());
                }

//                 class中某个标签存在多个，需要采用索引！！！
//                try {
//                    //还是一样先从一个URL加载一个Document对象。
//                    Document doc = Jsoup.connect("http://home.meishichina.com/show-top-type-recipe.html").get();
//
//                    //“椒麻鸡”和它对应的图片都在<div class="pic">中
//                    Elements titleAndPic = doc.select("div.pic");
//                    //使用Element.select(String selector)查找元素，使用Node.attr(String key)方法取得一个属性的值
//                    Log.i("mytag", "title:" + titleAndPic.get(1).select("a").attr("title") + "pic:" + titleAndPic.get(1).select("a").select("img").attr("data-src"));
//
//                    //所需链接在<div class="detail">中的<a>标签里面
//                    Elements url = doc.select("div.detail").select("a");
//                    Log.i("mytag", "url:" + url.get(1).attr("href"));
//
//                    //原料在<p class="subcontent">中
//                    Elements burden = doc.select("p.subcontent");
//                    //对于一个元素中的文本，可以使用Element.text()方法
//                    Log.i("mytag", "burden:" + burden.get(1).text());
//
//                }catch(Exception e) {
//                    Log.i("mytag", e.toString());
//                }
            }
        }).start();
    }
}
