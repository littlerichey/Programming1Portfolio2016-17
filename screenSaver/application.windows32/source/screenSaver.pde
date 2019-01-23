Lines[] pipes = new Lines[12];
Spiral[] spirals = new Spiral[5];
//I created diagonals, but didn't use them because i didn't like the look
void setup() {
    
  noCursor();
  size(displayWidth,displayHeight);
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

void draw() {
  /*for(int i=0; i<pipes.length; i++) {
    Lines iLines =pipes[i];
    
    iLines.display();
    
  }*/
  background(0);
  for(Spiral i: spirals){
    i.display();
  }
}
