class Lines {
  float x, y, strokeW, pointCount, reset;
  color c;

  Lines(float tx, float ty, float tstrokeW, float tpointCount) {
    x=tx;
    y=ty;
    strokeW=tstrokeW;
    pointCount=tpointCount;
    reset=0;
    c=0;
  }
  
  void display() {
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
    if (random(100)>74.6) {
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
  void moveRight(float sx, float sy, float move) {
    for (float i=0; i<move; i++) {
      point(sx+i, sy);
      x = sx+i;
    }
  }

  void moveLeft(float sx, float sy, float move) {
    for (float i=0; i<move; i++) {
      point(sx-i, sy);
      x = sx-i;
    }
  }

  void moveDown(float sx, float sy, float move) {
    for (float i=0; i<move; i++) {
      point(sx, sy+i);
      y = sy+i;
    }
  }

  void moveUp(float sx, float sy, float move) {
    for (float i=0; i<move; i++) {
      point(sx, sy-i);
      y = sy-i;
    }
  }
  void moveRightUp(float sx, float sy, float move) {
    for (float i=0; i<move; i++) {
      point(sx+i, sy-i);
      y = sy-i;
      x = sx+i;
    }
  }
  void moveLeftUp(float sx, float sy, float move) {
    for (float i=0; i<move; i++) {
      point(sx-i, sy-i);
      y = sy-i;
      x = sx-i;
    }
  }
  void moveLeftDown(float sx, float sy, float move) {
    for (float i=0; i<move; i++) {
      point(sx-i, sy+i);
      y = sy+i;
      x = sx-i;
    }
  }
  void moveRightdown(float sx, float sy, float move) {
    for (float i=0; i<move; i++) {
      point(sx+i, sy+i);
      y = sy+i;
      x = sx+i;
    }
  }
}
