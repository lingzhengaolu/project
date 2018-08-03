package com.company.demo;


import com.company.uiframework.WebDrivers;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class js_diaoyong {
    private static String url="http://www.baidu.com";
    public static void wait(int second){
        try{
            Thread.sleep(second*1000);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void wait(double second){
        try{
            Thread.sleep((int)second*1000);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String []args) {
        WebDrivers webDrivers=new WebDrivers();
        WebDriver driver=webDrivers.chromeDriver();

        driver.get(url);
        //1、在页面直接执行js
//        JavascriptExecutor js=(JavascriptExecutor)driver;
//        String i="";
//        i=(String)js.executeScript("var s=prompt('测试')");
//        while ((i=(String)((JavascriptExecutor)driver).executeScript("return s")).length()!=4){
//            System.out.println(i);
//        }

//        wait(3);
//        driver.switchTo().alert().accept();//点击确认按钮，关闭alert弹窗

        //2、在某个已经定位的元素上执行js
//        String str = (String)((JavascriptExecutor)driver).executeScript("return document.getElementById('su').value");
//        System.out.println(str);
//
        String str1 = (String)((JavascriptExecutor)driver).executeScript("return document.getElementById('su').getAttribute('id')");
        System.out.println(str1);

        //3、滚动条操作

//        driver.findElement(By.cssSelector("input.s_ipt")).sendKeys("测试");
//        wait(3);
//        driver.findElement(By.cssSelector("input#su")).click();

                        //1、滚动到element对象的底端，与当前窗口“底部”对齐
//        WebElement e1=driver.findElement(By.cssSelector("#help > a:nth-child(1)"));
//        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();",e1);
//        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(false);",e1);//与上一行代码作用一样
//        z1.com.company.mk.sleep(3);

                       //2、滚动到element对象的顶端，与当前窗口“顶部”对齐
//        WebElement e2=driver.findElement(By.cssSelector("#result_logo > img"));
//        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",e2);

                       //3、移动到页面最底部
//        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
//        wait(3);

                      //4、移动到指定的坐标(相对当前的坐标移动)
//        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, -700)");//向上移动700像素
//        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 1000)");//向下移动1000像素

                     //5、绝对滚,移动到窗口绝对位置坐标230像素位置
//        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 230)");
        //--------------------------------------------------------------------
        wait(3);
        driver.quit();
    }
}
