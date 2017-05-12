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

public class hacknslash extends PApplet {

int r = 50, g = 200, b = 255, score= 0, l = 1, h = 8, i = 0, t, tt, u; //<>//
float frames = 0;
boolean day = true, done = false, p;
Mob m[] = new Mob[100000000];
P1 p1 = new P1(450, 550, color(0));
public void setup() {
  
  background(75, 200, 255);
  frameRate(20);
}

public void draw() {
    if (!done) {
    background(r, g, b);
    frames += 1;
    if (frames/13 == PApplet.parseInt(frames/13)) {
      if (day) {
        r -= 1;
        g-= 3;
        b-= 3;
        if (r <= 0) {
          day = false;
          h += 1;
        }
      } else {
        r+= 1;
        g+= 3;
        b+= 3;
        if (b >= 255) {
          day = true;
          h += 1;
        }
      }
    }
    rectMode(CORNER);
    noStroke();
    fill(120, 69, 19);
    rect(0, height-30, width, 30);
    fill(34, 150, 34);
    rect(0, height-40, width, 10);
    rectMode(CENTER);
    fill(0);
    rect(width/2, height/1.5f, 50, 53);
    fill(255);
    ellipse(width/2, height/2.2f, 33, 33);
    textSize(30);
    text(score, 5, 25);
    p1.display();
    if (frames/30 == PApplet.parseInt(frames/30)) {
      tt = PApplet.parseInt(random(l, h));
      if (tt >= 8) {
        t = 3;
      } else if (tt >= 4) {
        t = 2;
      } else {
        t = 1;
      }
      if (PApplet.parseInt(random(1, 2.5f)) == 2) {
        p = true;
      } else {
        p = false;
      }
      m[i] =new Mob(t, p);
      i++;
    }
    for (int d = 0; d<i; d++) { 
      m[d].display();
    }
  } else {
    background(0);
    fill(255, 0, 0);
    textAlign(CENTER, TOP);
    text("Game Over" + "\n Score: " +score, width/2, 10);
  }
}
 class Mob {
  int type, x, y, dx, w;
  boolean die = false;
  boolean r = true;
  Mob(int type, boolean x) {
    this.type = type;
    if(x){
      this.x = 998;
    }else {
      this.x = 2;
    }
    dx = 20;
    y=135;
    w = 35;
  }

  public void display() {
    dx = p1.kx;
    die();
    if (!die) {
      stroke(0);
      if (type == 1) {
        fill(0, 255, 0);
      } else if (type == 2) {
        fill(0, 0, 255);
      } else if (type == 3) {
        fill(255, 0, 0);
      }
      ellipse(x,y,w,w);
      line(x+w/4,y+w/2.25f,x+w/4,height-40);
      line(x-w/4,y+w/2.25f,x-w/4,height-40);
      if( x< width/2){
        x+= type;
        r=true;
      }else if (x>width/2){
        x -= type;
        r=false;
      }else {
        done = true;
      }
    }
  }

  public void die() {
    if (!r){
      if (dx >= x-(w/2) && dx <= x+(w)) {
        x = 2000;
        score += type;
        die = true;
      }
    }else{
      if (dx >= x-(w) && dx <= x+(w/2)) {
        x = 2000;
        score += type;
        die = true;
      }
    }
    
  }
}
class P1 {
  int l1, l2, x, y, kx, kx2, t = 0;
  int c;
  boolean right = false, up = true, ld, rd;
  P1 (int l1, int l2, int c) {
    this.l1 = l1;
    this.l2 = l2;
    this.x = l1;
    this.c = c;
    y = 134;
    kx=5;
  }

  public void display() {
    kx=5;
    kx2=5;
    move();
    zoog(x, y, c);
  }

  public void zoog(float x, float y, int grey) {
    kx = 20000;
    ellipseMode(CENTER);
    rectMode(CENTER);
    stroke(0);
    fill(grey);
    rect(x, y, 14, 30);
    stroke(0);
    fill(255); 
    ellipse(x, y-20, 20, 20);
    fill(0);
    ellipse(x-5, y-20, 4, 8);
    ellipse(x+5, y-20, 4, 8);
    stroke(0);
    line(x-7, y+15, x-10, y+25);
    line(x+7, y+15, x+10, y+25);
    if (right && up) {
      stroke(0);
      line(x-7, y-7, x-14, y);
      line(x+7, y-7, x+14, y);
      noStroke();
      rect(x+15, y, 2, 6);
      rect(x+15, y-2, 6, 2);
      rect(x+15, y-8, 4, 10);
      triangle(x+13, y-13, x+15, y-16, x+17, y-13);
      kx = 100000;
    } else if (!right && up) {
      stroke(0);
      line(x-7, y-7, x-14, y);
      line(x+7, y-7, x+14, y);
      noStroke();
      rect(x-15, y, 2, 6);
      rect(x-15, y-2, 6, 2);
      rect(x-15, y-8, 4, 10);
      triangle(x-13, y-13, x-15, y-16, x-17, y-13);
      kx = 10000;
    } else if (right && !up) {
      stroke(0);
      line(x-7, y-7, x-14, y);
      line(x+7, y-7, x+14, y);
      noStroke();
      rect(x+17, y, 6, 2);
      rect(x+19, y, 2, 6);
      rect(x+25, y, 10, 4);
      triangle(x+33, y, x+30, y-2, x+30, y+2);
      kx = 583;
    } else if (!right && !up) {
      stroke(0);
      line(x-7, y-7, x-14, y);
      line(x+7, y-7, x+14, y);
      noStroke();
      rect(x-17, y, 6, 2);
      rect(x-19, y, 2, 6);
      rect(x-25, y, 10, 4);
      triangle(x-33, y, x-30, y-2, x-30, y+2);
      kx= 417;
    }
  }
  public void move() {
    if (keyCode == 'd' || keyCode == 'D') {
      right = true;
      x = l2;
    } else if (keyCode == 'a' || keyCode == 'A') {
      right = false;
      x = l1;
    } else if (keyCode == ' ') {
      up = false;

      t++;
      if (t>=4) {
        up = true;
        keyCode=1;
        t = 00;
      }
    } else {
      up = true;
    }
  }
}
  public void settings() {  size(1000, 200); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "hacknslash" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
