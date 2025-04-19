// C++ code
//

String memoria[100] = {"0"};
int pc = 4;
int pos = 4;
String linha = "";
boolean temAlgo = false;
int contComandos = 1;
int contPrints = 0;
String w = "0";

void setup()
{
  Serial.begin(9600);
  pinMode(13, OUTPUT);
  pinMode(12, OUTPUT);
  pinMode(11, OUTPUT);
  pinMode(10, OUTPUT);
  memoria[0] = String(pc);
}

void loop()
{  
  
  //Carregar a memoria
  
  if(Serial.available() > 0) {
    for(int i = 0; i < 100; i++) {
      if(Serial.peek() == -1) {
      	break;
      }
    	memoria[pos] = Serial.readStringUntil(' ');
      	pos++;
      	contComandos++;
    }  
    memoria[1] = "0";
    memoria[2] = "0";
    memoria[3] = "0";
    temAlgo = true;
  }
  
 pos = 4;
  
  //Executar os comandos
  if(temAlgo){
    if(contPrints != contComandos){
      	//Essa função acende os leds conforme o valor que temos em w
      	acenderLed(strtol(w.c_str(), nullptr, 16));
  		Serial.print("->|" + memoria[0] + "|" + memoria[1] + "|" + memoria[2] + "|" + memoria[3]+ "|");
      	while(memoria[pos] != "") {
          Serial.print(memoria[pos] + "|");
          pos++;
        }
      	Serial.println();
  		String x = String(memoria[pc].charAt(0));
  		String y = String(memoria[pc].charAt(1));
      	w = resultado(x, y, pc);
      	memoria[1] = w;
  		memoria[2] = x;
  		memoria[3] = y;
  		pc++;
    	contPrints++;
      	memoria[0] = String(pc);
    } else {
    	Serial.println("Todos comandos executados");
      	delay(1000);
      	while(1){
          digitalWrite(13, LOW);
          digitalWrite(12, HIGH);
          digitalWrite(11, LOW);
          digitalWrite(10, HIGH);
          delay(2500);
          digitalWrite(13, HIGH);
          digitalWrite(12, LOW);
          digitalWrite(11, HIGH);
          digitalWrite(10, LOW);
          delay(2500);
        }
    }
  }
  delay(2000);
}


String resultado(String x, String y, int pc) {
    // Converter os parâmetros x e y de hexadecimal para int
    int numX = strtol(x.c_str(), nullptr, 16);
    int numY = strtol(y.c_str(), nullptr, 16);
  	//opChar corresponde ao W
	char opChar = memoria[pc].charAt(2);
  	int op = strtol(String(opChar).c_str(), nullptr, 16);
    // Variável para armazenar o resultado da operação
    int res = 0;
  	if(memoria[pc] == "") {
  		exit;
  	}
    // Usando switch-case para verificar o valor de pc e fazer a operação correspondente
    switch (op) {
        case 0: // zeroL
            res = 0 & 0xF;
            break;
        case 1: // umL
            res = 1 & 0xF;
            break;
        case 2: // copiaA
            res = (numX) & 0xF;
            break;
        case 3: // copiaB
            res = (numY) & 0xF;
            break;
        case 4: // nA
            res = (~numX) & 0xF;
            break;
        case 5: // nB
            res = (~numY) & 0xF;
            break;
        case 6: // AenB
            res = (numX & ~numY) & 0xF;
            break;
        case 7: // nAeB
            res = (~numX & numY) & 0xF;
            break;
        case 8: // AxB
            res = (numX ^ numY) & 0xF;
            break;
        case 9: // nAxnB
            res = (~numX ^ ~numY) & 0xF;
            break;
        case 10: // nAxnBn
            res = ~(~numX ^ ~numY) & 0xF;
            break;
        case 11: // AeB
            res = (numX & numY) & 0xF;
            break;
        case 12: // AeBn
            res = ~(numX & numY) & 0xF;
            break;
        case 13: // AoBn
            res = ~(numX | numY) & 0xF;
            break;
        case 14: // AoB
            res = (numX | numY) & 0xF;
            break;
        case 15: // nAonBn
            res = ~(~numX | ~numY) & 0xF;
            break;
        default:
            // Caso o valor de pc não seja válido
            return "Erro";
    }
   	char hexResult[20];
    sprintf(hexResult, "%X", res);
    return hexResult;
  
 
}

void acenderLed(int res) {
    switch(res) {
      case 0:
        digitalWrite(13, LOW);
        digitalWrite(12, LOW);
        digitalWrite(11, LOW);
        digitalWrite(10, LOW);
        break;
      case 1:
        digitalWrite(13, HIGH);
        digitalWrite(12, HIGH);
        digitalWrite(11, HIGH);
        digitalWrite(10, HIGH);
        break;
      case 2:
        digitalWrite(13, LOW);
        digitalWrite(12, LOW);
        digitalWrite(11, HIGH);
        digitalWrite(10, LOW);
        break;
      case 3:
        digitalWrite(13, LOW);
        digitalWrite(12, LOW);
        digitalWrite(11, HIGH);
        digitalWrite(10, HIGH);
        break;
      case 4:
        digitalWrite(13, LOW);
        digitalWrite(12, HIGH);
        digitalWrite(11, LOW);
        digitalWrite(10, LOW);
        break;
      case 5:
        digitalWrite(13, LOW);
        digitalWrite(12, HIGH);
        digitalWrite(11, LOW);
        digitalWrite(10, HIGH);
        break;
      case 6:
        digitalWrite(13, LOW);
        digitalWrite(12, HIGH);
        digitalWrite(11, HIGH);
        digitalWrite(10, LOW);
        break;
      case 7:
        digitalWrite(13, LOW);
        digitalWrite(12, HIGH);
        digitalWrite(11, HIGH);
        digitalWrite(10, HIGH);
        break;
      case 8:
        digitalWrite(13, HIGH);
        digitalWrite(12, LOW);
        digitalWrite(11, LOW);
        digitalWrite(10, LOW);
        break;
      case 9:
        digitalWrite(13, HIGH);
        digitalWrite(12, LOW);
        digitalWrite(11, LOW);
        digitalWrite(10, HIGH);
        break;
      case 10:
        digitalWrite(13, HIGH);
        digitalWrite(12, LOW);
        digitalWrite(11, HIGH);
        digitalWrite(10, LOW);
        break;
      case 11:
        digitalWrite(13, HIGH);
        digitalWrite(12, LOW);
        digitalWrite(11, HIGH);
        digitalWrite(10, HIGH);
        break;
      case 12:
        digitalWrite(13, HIGH);
        digitalWrite(12, LOW);
        digitalWrite(11, HIGH);
        digitalWrite(10, LOW);
        break;
      case 13:
        digitalWrite(13, HIGH);
        digitalWrite(12, HIGH);
        digitalWrite(11, LOW);
        digitalWrite(10, HIGH);
        break;
      case 14:
        digitalWrite(13, HIGH);
        digitalWrite(12, HIGH);
        digitalWrite(11, HIGH);
        digitalWrite(10, LOW);
        break;
      case 15:
        digitalWrite(13, HIGH);
        digitalWrite(12, HIGH);
        digitalWrite(11, HIGH);
        digitalWrite(10, HIGH);
        break;
      default:
        digitalWrite(13, LOW);
        digitalWrite(12, LOW);
        digitalWrite(11, LOW);
        digitalWrite(10, LOW);
        break;
    }
}
//Serial.readStringUntil('\n');