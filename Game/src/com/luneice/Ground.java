package com.luneice;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

//地面类
public class Ground {
	// 地面图片
	BufferedImage groundIamde;
	int width, height;// 图片宽高
	int x, y;// 地面的位置

	public Ground() {
		try {
			groundIamde = ImageIO.read(getClass().getResource("./images/ground.png"));
			width = groundIamde.getWidth();
			height = groundIamde.getHeight();
			x = 0;
			y = 498;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void groundMove() {
		x--;
		if (x == -109) {
			x = 0;
		}
	}
}