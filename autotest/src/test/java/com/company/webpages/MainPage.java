package com.company.webpages;

import com.company.uiframework.BasePage;
import com.company.uiframework.LocatorE;
import org.openqa.selenium.WebDriver;

import java.sql.Connection;

public class MainPage extends BasePage {
	private LocatorE
			waiHuRenWu,
			waiHuFenPei,
			waiHuBaoBiao,
			waiHuLuYin,
			baiTanBaoBiao,
			huDongZhiCheng,
			muBanShenHe,
			mianDaRaoMingDan,
	        yongHuGuanLi,
	        buMenGuanLi,
	        quanXianGuanLi,
	        yuRePeiZhi,
	        biaoQianGuanLi,
	        baiTanMingXi,
	        zhangHaoHuoYue,
	        tuiGuanXiaoYi,
	        loginOut;
	public MainPage(Connection connection, WebDriver driver){
		super(connection,driver);
		waiHuRenWu=getLocator("waiHuRenWu".trim());//外呼任务
		waiHuFenPei=getLocator("waiHuFenPei".trim());//外呼分配
		waiHuBaoBiao=getLocator("waiHuBaoBiao".trim());//外呼报表
		waiHuLuYin=getLocator("waiHuLuYin".trim());//外呼录音
		baiTanBaoBiao=getLocator("baiTanBaoBiao".trim());//摆摊报表
		huDongZhiCheng=getLocator("huDongZhiCheng".trim());//互动支撑
		muBanShenHe=getLocator("muBanShenHe".trim());//模板审核
		mianDaRaoMingDan=getLocator("mianDaRaoMingDan".trim());//免打扰名单
		yongHuGuanLi=getLocator("yongHuGuanLi".trim());//用户管理
		buMenGuanLi=getLocator("buMenGuanLi".trim());//部门管理
		quanXianGuanLi=getLocator("quanXianGuanLi".trim());//权限管理
		yuRePeiZhi=getLocator("yuRePeiZhi".trim());//预热配置
		biaoQianGuanLi=getLocator("biaoQianGuanLi".trim());//标签管理
		baiTanMingXi=getLocator("baiTanMingXi".trim());//摆摊明细
		zhangHaoHuoYue=getLocator("zhangHaoHuoYue".trim());//账号活跃
		tuiGuanXiaoYi=getLocator("tuiGuanXiaoYi".trim());//推广效益
		loginOut=getLocator("loginOut".trim());//退出登录
	}
	public void clickWaiHuRenWu(){
		click(waiHuRenWu);
	}
	public void clickWaiHuFenPei(){
		click(waiHuFenPei);
	}
	public void clickWaiHuBaoBiao(){
		click(waiHuBaoBiao);
	}
	public void clickWaiHuLuYin(){
		click(waiHuLuYin);
	}
	public void clickBaiTanBaoBiao(){
		click(baiTanBaoBiao);
	}
	public void clickHuDongZhiCheng(){
		click(huDongZhiCheng);
	}
	public void clickMuBanShenHe(){
		click(muBanShenHe);
	}
	public void clickMianDaRaoMingDan(){
		click(mianDaRaoMingDan);
	}
	public void clickYongHuGuanLi(){
		click(yongHuGuanLi);
	}
	public void clickBuMenGuanLi(){
		click(buMenGuanLi);
	}
	public void clickQuanXianGuanLi(){
		click(quanXianGuanLi);
	}
	public void clickYuRePeiZhi(){
		click(yuRePeiZhi);
	}
	public void clickBiaoQianGuanLi(){
		click(biaoQianGuanLi);
	}
	public void clickBaiTanMingXi(){
		click(baiTanMingXi);
	}
	public void clickZhangHaoHuoYue(){
		click(zhangHaoHuoYue);
	}
	public void clickTuiGuanXiaoYi(){
		click(tuiGuanXiaoYi);
	}
	public void clickLoginOut(){
		click(loginOut);
	}
}
