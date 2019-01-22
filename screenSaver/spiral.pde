 //<>// //<>//
class Spiral {
  int cx = width/2;
  int cy = height/2;
  int nx = width/2;
  int ny = height/2;
  color c=color(random(256), random(256), random(256));
  int step = 0;
  ArrayList<int[]> spiral = new ArrayList(0);
  int rand = int(random(5));
  boolean out = true;
  Spiral() {
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
      if (rand>2) {
        this.nx= width/2 + int(cos(step*180/3.14)*abs(step));
        this.ny= height/2 + int(sin(step*180/3.14)*abs(step));
      } else {
        this.nx= width/2 + int(cos(step)*step);
        this.ny= height/2 + int(sin(step)*step);
      }
      int[] temp = {this.cx, this.cy, this.nx, this.ny};
      this.spiral.add(temp);
    }else{
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
      cx = width/2;
      cy = height/2;
      nx = width/2;
      ny = height/2;
      c=color(random(25, 256), random(25, 256), random(25, 256));
      step = 0;
      rand = int(random(5));
      out = true;
    }
  }
}
