package com.luneice;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

//鸟类
public class Bird {

	BufferedImage birdImage;
	int width, height;// 图片宽高
	int x, y;// 地面的位置
	int radius;// 半径

	public Bird() {
		// TODO Auto-generated constructor stub
		try {
			birdImage = ImageIO.read(getClass().getResource("./images/0.png"));
			width = birdImage.getWidth();
			height = birdImage.getHeight();
			radius = 40;
			x = 120;
			y = 250;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 自动坠落
	public void birdFall() {
		if (y < 498 - radius / 2) {
			y++;
		}

	}
	//自由飞翔
	public void birdFly() {
		if (y > radius) {
			y -= 35;
		}
	}
}
