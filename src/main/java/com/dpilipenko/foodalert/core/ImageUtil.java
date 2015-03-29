package com.dpilipenko.foodalert.core;

import org.springframework.context.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.Random;

@Component
public class ImageUtil {

  private final String[] resourcePaths = {
          "classpath:static/images/cookies.png",
          "classpath:static/images/pizza.png",
          "classpath:static/images/salad.png",
          "classpath:static/images/sandwich.png"
  };

  @Autowired
  ApplicationContext applicationContext;

  public BufferedImage getNextImage() throws IOException {
    int index = getIndex();
    String resourcePath = resourcePaths[index];
    Resource r = applicationContext.getResource(resourcePath);
    InputStream is = r.getInputStream();
    BufferedImage img = ImageIO.read(is);
    return img;
  }

  protected int getIndex() {
    int length = resourcePaths.length;
    double rand = Math.random();
    return (int)(rand * length);
  }

}
