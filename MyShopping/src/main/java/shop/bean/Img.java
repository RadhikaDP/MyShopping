package shop.bean;

import java.sql.Blob;

public class Img {
private int imgid;
private Blob img;
public int getImgid() {
	return imgid;
}
public void setImgid(int imgid) {
	this.imgid = imgid;
}
public Blob getImg() {
	return img;
}
public void setImg(Blob img) {
	this.img = img;
}

}
