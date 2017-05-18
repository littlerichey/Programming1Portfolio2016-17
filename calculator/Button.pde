class Button {
  int x, y, h, w, x2, y2, x3, y3, xOffset, yOffset, t;
  String opVal, spVal;
  color b1 = color(161, 151, 250), b2 = color(255, 146, 244), t1 = color(146, 255, 157), t2 = color(146, 255, 157);
  boolean over, triover, isNum, isSp1, isSp2;
  float numVal;

  //standard
  Button(int x, int y) {
    this.x=x;
    this.y=y;
  }

  //numbers
  Button asNum(int th, int tw, float ttxt ) {
    isNum=true;
    h= th;
    w= tw;
    numVal = ttxt;
    return this;
  }

  //operators
  Button asOp(int w, int h, String opVal) {
    this.w=w;
    this.h=h;
    this.opVal=opVal;
    return this;
  }

  //special
  Button asSp1(int w, int h, String spVal) {
    isSp1 = true;
    this.w=w;
    this.h=h;
    this.spVal=spVal;
    return this;
  }

  //triangle Buttons

  Button asSp2(int xOffset, int yOffset, String spVal, int t) {
    isSp2 = true;
    x2 = x+50;
    y2 = y;
    x3 = x2;
    y3 = y2-50;
    this.spVal=spVal;
    this.xOffset=xOffset;
    this.yOffset=yOffset;
    this.t=t;
    return this;
  }
  void display() {
    hover();
    rectMode(CENTER);
    if (isNum) {
      textAlign(LEFT);
      textSize(60);
      if (!over) {

        //rect
        stroke(0);
        fill(b1);
        rect(x, y, w, h);

        //text
        fill(t1);
        text(int(numVal), x-(w/2.5), y+(h/2)-1);
      } else {
        stroke(0);
        fill(b2);
        rect(x, y, w, h );
        fill(t2);
        text(int(numVal), x-(w/2.5), y+(h/2)-1);
      }
    } else if (isSp1) {
      textSize(55);
      textAlign(CENTER, CENTER);
      if (!over) {

        //rect
        stroke(0);
        fill(b1);
        rect(x, y, w, h);

        //text
        fill(t1);
        text(spVal, x, y-(w/5));
      } else {
        stroke(0);
        fill(b2);
        rect(x, y, w, h );
        fill(t2);
        text(spVal, x, y-(w/5));
      }
    } else if (isSp2) {
      textSize(t);
      textAlign(CENTER, CENTER);
      if (!triover) {
        stroke(0);
        fill(b1);
        triangle(x, y, x2, y2, x3, y3 );
        fill(t1);
        text(spVal, ((x+x2)/2)+ xOffset, ((y+y3)/2) + yOffset);
      } else {
        stroke(0);
        fill(b2);
        triangle(x, y, x2, y2, x3, y3 );
        fill(t2);
        text(spVal, ((x+x2)/2)+ xOffset, ((y+y3)/2) + yOffset);
      }
    } else {
      textSize(55);
      textAlign(CENTER, CENTER);
      if (!over) {

        //rect
        stroke(0);
        fill(b1);
        rect(x, y, w, h);

        //text
        fill(t1);
        text(opVal, x, y-(w/5));
      } else {
        stroke(0);
        fill(b2);
        rect(x, y, w, h );
        fill(t2);
        text(opVal, x, y-(w/5));
      }
    }
  }

  void hover() {
    if (mouseX<x+(w/2) && mouseX>x-(w/2) && mouseY<y+(h/2) && mouseY>y-(h/2)) {
      over= true;
    } else {
      over= false;
    }
    if (mouseX < x2 && mouseY < y2 && ((mouseX-x) + (mouseY-y3)) >50) {
      triover = true;
    } else {
      triover= false;
    }
  }
}