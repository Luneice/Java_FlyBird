package com.luneice;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

//������
public class Ground {
	// ����ͼƬ
	BufferedImage groundIamde;
	int width, height;// ͼƬ���
	int x, y;// �����λ��

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