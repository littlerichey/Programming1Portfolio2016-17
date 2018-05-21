class ColorPicker{
  int r=200,g=0,b=0;
  Button red = new Button(10,100);
  Button green = new Button(10,125);
  Button Blue = new Button(10,150);
  Button go = new Button(275, 100).asOp(50, 50, "Go");
  boolean stay = true;
  color c = color(0);
  ColorPicker(){}
  void run(){
    surface.setSize(350,180);
    background(0);
    
    while(stay){
      go.display();
      noStroke();
      fill(r,g,b);
      rect(10,10,330,80);
    }
    c = color(r,g,b);
  }
  
}