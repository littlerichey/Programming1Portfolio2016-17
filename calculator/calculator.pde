Button[] nums = new Button[10];
Button[] ops = new Button[4];
Button[] sps = new Button[8];

String dispVal = "0", valToComp = "", valToComp2 = "", neg1 = "", neg2 = "", sqrt = "", result2 = "";
float result = 0, valToCompI = 0, valToCompI2 = 0, howFarPastDec = 0;
char opVal = ' ';
boolean firstNum=true, gotResult = false, yup = false, pastDec = false;

void setup() {
  size(351, 281);
  background(255);
  nums[0] = new Button(25, 255).asNum(50, 50, 0);
  nums[1] = new Button(25, 205).asNum(50, 50, 1);
  nums[2] = new Button(75, 205).asNum(50, 50, 2);
  nums[3] = new Button(125, 205).asNum(50, 50, 3);
  nums[4] = new Button(25, 155).asNum(50, 50, 4);
  nums[5] = new Button(75, 155).asNum(50, 50, 5);
  nums[6] = new Button(125, 155).asNum(50, 50, 6);
  nums[7] = new Button(25, 105).asNum(50, 50, 7);
  nums[8] = new Button(75, 105).asNum(50, 50, 8);
  nums[9] = new Button(125, 105).asNum(50, 50, 9);
  ops[0] = new Button(275, 205).asOp(50, 50, "+");
  ops[1] = new Button(325, 205).asOp(50, 50, "-");
  ops[2] = new Button(225, 255).asOp(50, 50, "x");
  ops[3] = new Button(275, 255).asOp(50, 50, "/");
  sps[0] = new Button(325, 255).asSp1(50, 50, "=");
  sps[1] = new Button(325, 155).asSp1(50, 50, "C");
  sps[2] = new Button(300, 130).asSp2(10, 5, "^", 45);
  sps[3] = new Button(250, 180).asSp2(10, 5, "!", 35);
  sps[4] = new Button(200, 230).asSp2(9, 1, "√", 35);
  sps[5] = new Button(150, 280).asSp2(8, 14, "hex", 20);
  sps[6] = new Button(75, 255).asSp1(50, 50, ".");
  sps[7] = new Button(125, 255).asSp1(50, 50, "±");
  firstNum = true;
}

void draw() {
  background(255);
  for (int i = 0; i<nums.length; i++) {
    Button inum = nums[i];
    inum.display();
  }
  for (int i = 0; i<ops.length; i++) {
    Button iop = ops[i];
    iop.display();
  }
  for (int i = 0; i<sps.length; i++) {
    Button isp = sps[i];
    isp.display();
  }
  //background(255);
  //nums[0].display();
  //nums[1].display();
  updateDisplay();
}

void performCalculation() {
  valToCompI = float(valToComp);
  valToCompI2 = float(valToComp2);
}

void updateDisplay() {
  textAlign(LEFT);
  dispVal= neg1 + valToComp + opVal + "\n" + neg2 + sqrt +valToComp2 + "\n" + result2;
  noStroke();
  fill(200, 255, 200);
  ellipse(233, 80, 165, 165);
  fill(255, 100, 150);
  textSize(20);
  text(dispVal, 170, 45);
  println(valToCompI);
  println(valToComp);
  println(valToCompI2);
  println(valToComp2);
}

void mousePressed() {
  if (gotResult) {

    if (sps[0].over) {
      valToComp = "Ans";
      valToCompI = result;
    }
    for (int i = 0; i <ops.length; i++) {
      if (ops[i].over) {
        yup = true;
      }
    }
    if (yup) {
      valToComp = "Ans";
      valToCompI = result;
      for (int i = 0; i <ops.length; i++) {
        if (ops[i].over) {
          if (i==0) {
            opVal='+';
            firstNum=false;
          } else if (i==1) {
            opVal='-';
            firstNum=false;
          } else if (i==2) {
            opVal='*';
            firstNum=false;
          } else if (i==3) {
            opVal='/';
            firstNum=false;
          }
        }
      }
      valToComp2 = "";
      result = 0;
      result2 = "";
      valToCompI2 = 0;
      firstNum = false;
      gotResult = false;
      yup= false;
      sqrt = "";
    }
  }
  if (firstNum) {

    if (sps[7].over && valToComp == "") {
      neg1 = "-";
    }
    if (!pastDec) {
      if (sps[6].over) {
        valToComp = valToComp + ".";
        pastDec = true;
        howFarPastDec = 1;
      }

      for (int i = 0; i <nums.length; i++) {
        if (nums[i].over) {
          valToComp = valToComp + i ;
          valToCompI = (valToCompI * 10) + i ;
        }
      }
    } else if (pastDec) {
      for (int i = 0; i <nums.length; i++) {
        if (nums[i].over) {
          howFarPastDec *= 10;
          valToComp = valToComp + i ;
          valToCompI = valToCompI + (i/howFarPastDec);
        }
      }
    }
    for (int i = 0; i <ops.length; i++) {
      if (sps[2].triover) {
        opVal='^';
        pastDec = false;
        firstNum=false;
      }
      if (sps[3].triover) {
        opVal='!';
        pastDec = false;
        firstNum=false;
      }
      if (sps[5].triover) {
        valToComp2= "to hex";
        pastDec = false;
        firstNum=false;
      }
      if (sps[4].triover) {
        sqrt="√";
        pastDec = false;
        firstNum=false;
      }
      if (ops[i].over) {
        if (i==0) {
          opVal='+';
          pastDec = false;
          firstNum=false;
        } else if (i==1) {
          opVal='-';
          pastDec = false;
          firstNum=false;
        } else if (i==2) {
          opVal='*';
          pastDec = false;
          firstNum=false;
        } else if (i==3) {
          opVal='/';
          pastDec = false;
          firstNum=false;
        }
      }
    }
  } else if (!firstNum) {
    if (sps[7].over && valToComp2 == "") {
      neg2 = "-";
    }
    if (!pastDec) {
      if (sps[6].over) {
        valToComp2 = valToComp2 + ".";
        pastDec = true;
        howFarPastDec = 1;
      }
      for (int i = 0; i <nums.length; i++) {
        if (nums[i].over) {
          valToComp2 = valToComp2 + i ;
          valToCompI2 = (valToCompI2 * 10) + i ;
        }
      }
    } else if (pastDec) {
      for (int i = 0; i <nums.length; i++) {
        if (nums[i].over) {
          howFarPastDec *= 10;
          valToComp2 = valToComp2 + i ;
          valToCompI2 = valToCompI2 + (i/howFarPastDec);
        }
      }
    }
    if (sps[0].over) {
      if (neg1 == "-") {
        valToCompI *= -1;
      }
      if (neg2 == "-") {
        valToCompI2 *= -1;
      }
      if (opVal=='+') {
        gotResult=true;
        result = valToCompI + valToCompI2;
      } else if (opVal=='-') {
        gotResult=true;
        result = valToCompI - valToCompI2;
      } else if (opVal=='*') {
        gotResult=true;
        result = valToCompI * valToCompI2;
      } else if (opVal=='/') {
        gotResult=true;
        result = valToCompI / valToCompI2;
      } else if (opVal=='^') {
        gotResult=true;
        result = pow(valToCompI, valToCompI2);
      } else if (opVal=='!') {
        gotResult=true;
        result = fact(int(valToCompI));
      } else if (sqrt == "√") {
        gotResult=true;
        if (valToComp != "") {
          result = pow(valToCompI2, (1/valToCompI));
        } else {
          result = sqrt(valToCompI2);
        }
      } else if (valToComp2 == "to hex") {
        result2 = hex(int(valToCompI));
      }
      
      if (gotResult) {
        result2 = str(result);
      }
    }
  }
  if (sps[1].over) {
    dispVal = "0";
    valToComp = "";
    valToComp2 = "";
    result = 0;
    valToCompI = 0;
    valToCompI2 = 0;
    opVal= ' ';
    firstNum = true;
    gotResult=false;
    neg1 = "";
    neg2 = "";
    sqrt = "";
    result2 = "";
  }
}

int fact(int num) {
  int set = num;
  for (int i = 1; i < set; i++) {
    num *= i;
  }
  return num;
}