Lines[] pipes = new Lines[12];
//I created diagonals, but didn't use them brecause i didn't like the look
void setup() {
  size(displayWidth,displayHeight);
  background(255);
  for(int i=0; i<pipes.length; i++) {
    pipes[i] = new Lines(random(width),random(height),random(2,5),random(1,20));
  }
//  frameRate(20);
}

void draw() {
  for(int i=0; i<pipes.length; i++) {
    Lines iLines =pipes[i];
    
    iLines.display();
    
  }
}