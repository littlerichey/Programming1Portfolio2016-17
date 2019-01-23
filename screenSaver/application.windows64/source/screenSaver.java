import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class screenSaver extends PApplet {

Lines[] pipes = new Lines[12];
Spiral[] spirals = new Spiral[5];
//I created diagonals, but didn't use them because i didn't like the look
public void setup() {
    
  noCursor();
  
  surface.setResizable(true);
  background(255);
  for(int i=0; i<pipes.length; i++) {
    pipes[i] = new Lines(random(width),random(height),random(2,5),random(1,20));
  }
  spirals[0] = new Spiral();
  int qy= height/4;
  spirals[1] = new Spiral(width/4,qy);
  spirals[2] = new Spiral(width/4,height-qy);
  spirals[3] = new Spiral((width/4*3),qy);
  spirals[4] = new Spiral((width/4*3),height-qy);
  
//  frameRate(20);
}

public void draw() {
  /*for(int i=0; i<pipes.length; i++) {
    Lines iLines =pipes[i];
    
    iLines.display();
    
  }*/
  background(0);
  for(Spiral i: spirals){
    i.display();
  }
}
class Lines {
  float x, y, strokeW, pointCount, reset;
  int c;

  Lines(float tx, float ty, float tstrokeW, float tpointCount) {
    x=tx;
    y=ty;
    strokeW=tstrokeW;
    pointCount=tpointCount;
    reset=0;
    c=0;
  }
  
  public void display() {
    if (reset==0) {
      c=color(random(25,256), random(25,256), random(256));
    }
    stroke(c);
    strokeW = random(2, 5);
    pointCount=random(5, 30);
    strokeWeight(strokeW);
    if (x > width || y > height || x<0 || y<0) {
      x=(random(width));
      y=(random(height));
      c=color(random(256), random(256), random(256));
    }
    if (random(100)>74.6f) {
      moveLeft(x, y, pointCount);
    } else if (random(100)>67) {
      moveUp(x, y, pointCount);
    } else if (random(100)>53) {
      moveDown(x, y, pointCount);
    } else {
      moveRight(x, y, pointCount);
    }
    reset++;
    if (reset>height) {
      background(255);
      reset=0;
      x=(random(width));
      y=(random(height));
      c=color(random(256), random(256), random(256));
    }
  }
  public void moveRight(float sx, float sy, float move) {
    for (float i=0; i<move; i++) {
      point(sx+i, sy);
      x = sx+i;
    }
  }

  public void moveLeft(float sx, float sy, float move) {
    for (float i=0; i<move; i++) {
      point(sx-i, sy);
      x = sx-i;
    }
  }

  public void moveDown(float sx, float sy, float move) {
    for (float i=0; i<move; i++) {
      point(sx, sy+i);
      y = sy+i;
    }
  }

  public void moveUp(float sx, float sy, float move) {
    for (float i=0; i<move; i++) {
      point(sx, sy-i);
      y = sy-i;
    }
  }
  public void moveRightUp(float sx, float sy, float move) {
    for (float i=0; i<move; i++) {
      point(sx+i, sy-i);
      y = sy-i;
      x = sx+i;
    }
  }
  public void moveLeftUp(float sx, float sy, float move) {
    for (float i=0; i<move; i++) {
      point(sx-i, sy-i);
      y = sy-i;
      x = sx-i;
    }
  }
  public void moveLeftDown(float sx, float sy, float move) {
    for (float i=0; i<move; i++) {
      point(sx-i, sy+i);
      y = sy+i;
      x = sx-i;
    }
  }
  public void moveRightdown(float sx, float sy, float move) {
    for (float i=0; i<move; i++) {
      point(sx+i, sy+i);
      y = sy+i;
      x = sx+i;
    }
  }
}
//<>// //<>//
class Spiral {
  int cx, cy, nx, ny, ix, iy;
  int c=color(random(256), random(256), random(256));
  int step = 0;
  ArrayList<int[]> spiral = new ArrayList(0);
  int rand = PApplet.parseInt(random(1,5));
  boolean out = true;
  boolean sys = false;
  Spiral() {
    this.ix = width/2;
    this.iy = height/2;
    quick();
  }
  Spiral(int x, int y) {
    this.ix = x;
    this.iy = y;
    quick();
    sys = true;
    rand=1;
  }
  public void quick() {
    this.cx = ix;
    this.nx = ix;
    this.cy = iy;
    this.ny = iy;
  }
  public void display() {
    if (out) {
      if (rand%2==1) {
        this.step++;
      } else {
        this.step--;
      }
      this.cx=this.nx;
      this.cy=this.ny;
      if ((rand%4)>=2) {
        this.nx= ix + PApplet.parseInt(cos(step*180/3.14f)*abs(step));
        this.ny= iy + PApplet.parseInt(sin(step*180/3.14f)*abs(step));
      } else {
        this.nx= ix + PApplet.parseInt(cos(step)*step);
        this.ny= iy + PApplet.parseInt(sin(step)*step);
      }
      int[] temp = {this.cx, this.cy, this.nx, this.ny};
      this.spiral.add(temp);
    } else {
      spiral.remove(spiral.size()-1);
    }
    for (int[] i : spiral) {
      stroke(this.c);
      line(i[0], i[1], i[2], i[3]);
    }
    if (this.ny > height ||this.ny <0 || this.nx > width ||this.nx <0) {
      out =false;
    }

    if (spiral.size()==0) {
      quick();
      c=color(random(25, 256), random(25, 256), random(25, 256));
      step = 0;
      if (!sys) {
        rand = PApplet.parseInt(random(5));
      } else {
        rand++;
      }
      out = true;
    }
  }
}
  public void settings() {  size(displayWidth,displayHeight); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "--present", "--window-color=#666666", "--stop-color=#cccccc", "screenSaver" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
