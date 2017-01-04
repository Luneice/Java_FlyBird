package com.luneice;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

//柱子类
public class Column {
	BufferedImage colImage;
	int width, height;
	int x, y;// 柱子的中心点
	int gate;// 上下两个柱子的间隙，提供给鸟穿过
	int distance;// 柱子与柱子之间的距离
	int centerx,centery;
	Random random = new Random();

	public Column(int which) {
		try {
			colImage = ImageIO.read(getClass().getResource("./images/column.png"));
			width = colImage.getWidth();
			height = colImage.getHeight();
			gate = 144;
			
			// 最大距离354
			// 最小距离255
			distance = 260;
			y = random.nextInt(156) + 178;
			x = 550 + (which - 1) * distance;
			centerx = x / 2;
			centery = y / 2;
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void columnMove() {
		x--;
		if (x < -40) {
			x = 460;
			y = random.nextInt(156) + 178;
		}
	}
}
