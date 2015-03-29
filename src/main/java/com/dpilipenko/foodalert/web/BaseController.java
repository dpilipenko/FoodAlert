package com.dpilipenko.foodalert.web;

import com.dpilipenko.foodalert.core.ImageUtil;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;

@RestController
public class BaseController {

  @Autowired
  ImageUtil _imageUtil;

  Logger log = Logger.getLogger(BaseController.class);

	@RequestMapping(value = "/get", produces = "image/png")
	public @ResponseBody byte[] doGet(
	) {
	  try {
	    BufferedImage img = _imageUtil.getNextImage();
	    ByteArrayOutputStream bao = new ByteArrayOutputStream();
	    ImageIO.write(img, "png", bao);
	    return bao.toByteArray();
	  } catch (Exception e) {
	    log.error(e);
	    throw new RuntimeException(e);
	  }
	}
}
