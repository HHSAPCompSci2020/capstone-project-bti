package game;

import processing.core.PApplet;

public class Button {
	  String label; // button label
	  float x;      // top left corner x position
	  float y;      // top left corner y position
	  float w;      // width of button
	  float h;      // height of button
	  
	  public Button(String label, float x, float y, float w, float h) {
	    this.label = label;
	    this.x = x;
	    this.y = y;
	    this.w = w;
	    this.h = h;
	  }
	  
	  public void draw(PApplet surface){
	    surface.fill(218);
	    surface.stroke(141);
	    surface.rect(x, y, w, h, 10);
	   // surface.textAlign(0, 0); 
	    surface.fill(0);
	    surface.text(label, x + (w / 2), y + (h / 2));
	  }
	  
	  public boolean mouseIsOver(int mouseX, int mouseY) {
	    if (mouseX > x && mouseX < (x + w) && mouseY > y && mouseY < (y + h)) {
	      return true;
	    }
	    return false;
	  }
	


}
