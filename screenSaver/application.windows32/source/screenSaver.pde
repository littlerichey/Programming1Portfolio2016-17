Lines[] pipes = new Lines[12];
Spiral spiral;
//I created diagonals, but didn't use them because i didn't like the look
void setup() {
    
  noCursor();
  size(displayWidth,displayHeight);
  surface.setResizable(true);
  background(255);
  for(int i=0; i<pipes.length; i++) {
    pipes[i] = new Lines(random(width),random(height),random(2,5),random(1,20));
  }
  spiral = new Spiral();
//  frameRate(20);
}

void draw() {
  /*for(int i=0; i<pipes.length; i++) {
    Lines iLines =pipes[i];
    
    iLines.display();
    
  }*/
  background(0);
  spiral.display();
}
