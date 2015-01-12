package org.rohit.ImageResize;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/*
 * @author rohit
 *
 */
public class ImageResize
{

	private static final int IMG_WIDTH = 65;
	private static final int IMG_HEIGHT = 65;

	public static void main(String[] args)
	{

		try
		{

			BufferedImage originalImage = ImageIO.read(new File("d:\\images\\Picture1.jpg"));
			int type = originalImage.getType() == 0 ? BufferedImage.TYPE_INT_ARGB : originalImage.getType();

			BufferedImage resizeImageJpg = resizeImage(originalImage, type);
			ImageIO.write(resizeImageJpg, "jpg", new File("d:\\images\\thumbs\\Picture1.jpg"));

			BufferedImage originalImage2 = ImageIO.read(new File("d:\\images\\Picture2.jpg"));
			int type2 = originalImage2.getType() == 0 ? BufferedImage.TYPE_INT_ARGB : originalImage2.getType();

			BufferedImage resizeImageJpg2 = resizeImage(originalImage2, type);
			ImageIO.write(resizeImageJpg2, "jpg", new File("d:\\images\\thumbs\\Picture2.jpg"));

			System.out.println("Images successfully resized!!");
		}
		catch (IOException e)
		{
			System.out.println(e.getMessage());
		}
		finally
		{
			System.out.println("Program Operation Completed!!");
		}

	}

	private static BufferedImage resizeImage(BufferedImage originalImage, int type)
	{
		BufferedImage resizedImage = new BufferedImage(IMG_WIDTH, IMG_HEIGHT, type);
		Graphics2D g = resizedImage.createGraphics();
		g.drawImage(originalImage, 0, 0, IMG_WIDTH, IMG_HEIGHT, null);
		g.dispose();

		return resizedImage;
	}
}
