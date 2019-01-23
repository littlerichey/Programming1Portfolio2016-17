//<>// //<>//
class Spiral {
  int cx, cy, nx, ny, ix, iy;
  color c=color(random(256), random(256), random(256));
  int step = 0;
  ArrayList<int[]> spiral = new ArrayList(0);
  int rand = int(random(1,5));
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
  void quick() {
    this.cx = ix;
    this.nx = ix;
    this.cy = iy;
    this.ny = iy;
  }
  void display() {
    if (out) {
      if (rand%2==1) {
        this.step++;
      } else {
        this.step--;
      }
      this.cx=this.nx;
      this.cy=this.ny;
      if ((rand%4)>=2) {
        this.nx= ix + int(cos(step*180/3.14)*abs(step));
        this.ny= iy + int(sin(step*180/3.14)*abs(step));
      } else {
        this.nx= ix + int(cos(step)*step);
        this.ny= iy + int(sin(step)*step);
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
        rand = int(random(5));
      } else {
        rand++;
      }
      out = true;
    }
  }
}
