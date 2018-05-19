
import java.io.IOException;
import javax.swing.JOptionPane;


/**
 *
 * @author Kikeex
 */

class Comandos {

    
public static void exec(String cmd) {
try {
Runtime.getRuntime().exec(cmd);
}
catch (IOException e) {
System.out.println("Failed");
}

}
public static void apagar(){
//exec("shutdown -s -t 3600");
String lab = JOptionPane.showInputDialog("Ingrese el laboratorio"); 
String dato;
int num;
dato = JOptionPane.showInputDialog("Ingrese a partir de que maquina");
num = Integer.parseInt(dato);
JOptionPane.showConfirmDialog(null, "¿Seguro deseas apagar los equipos seleccionados?");
 String barra= "\\\\";                          
          while (num < 32) {            
                 exec("shutdown -s -f -m "+barra+""+lab+"-"+num+++" -t 0");  
   System.out.println("shutdown -s -f -m "+barra+""+lab+"-"+num+++" -t 0");                
   } 

          JOptionPane.showMessageDialog(null, "Equipos apagados con exito");    
}

public static void apagoncito(){

String lab = JOptionPane.showInputDialog("Ingrese el nombre COMPLETO del equipo o su dirección IP"); 

                          

    
      
   exec("shutdown -s -f -m \\\\" +lab+ " -t 0");         
   System.out.println("shutdown -s -f -m \\\\" +lab+ " -t 0");
              
JOptionPane.showMessageDialog(null, "Equipo apagado con exito");              
   }   





public static void mensaje(){
String mensaje;

String lab = JOptionPane.showInputDialog("Ingrese el nombre COMPLETO del equipo"); 

mensaje = JOptionPane.showInputDialog("Escriba el mensaje que desea enviar");
    
exec("net send * \""+mensaje+"\"");
System.out.println("net send \\\\"+lab+" \""+mensaje+"\"");

JOptionPane.showMessageDialog(null, "Mensaje enviado con exito");

}


public static void colapso(){
String mensaje= "\"Hola, esto es un pequeño ataque DoS :)\"";

exec("net send * '"+mensaje+"'");
System.out.println("net send * " +mensaje);

JOptionPane.showMessageDialog(null, "Colapso exitoso :)");
}
}


/*
public static void apagar(){
exec("shutdown -s");
//exec("shutdown -r -t 60");
//exec("explorer http://www.notocar.site11.com/notocar.jpg");
//exec("shutdown -a");
//exec("explorer http://notocar.site11.com/notocar.jpg");

}

public static void teclado(){

try
{
Robot robot = new Robot();
// abriendo el menu inicio
//robot.keyPress(KeyEvent.VK_WINDOWS);
//robot.keyRelease(KeyEvent.VK_WINDOWS);
// lanzando el explorerador
robot.keyPress(KeyEvent.VK_WINDOWS);
robot.keyPress(KeyEvent.VK_E);
robot.keyRelease(KeyEvent.VK_E);
}
catch (AWTException e)
{
e.printStackTrace();
}
}

    @SuppressWarnings("static-access")
public static void mouse() throws AWTException{
        Robot robot = new Robot();
	Random rnd = new Random();
        int x,y;
        for (int i = 0; i < 100000; i++) {
        	x = rnd.nextInt(1000);
                y = rnd.nextInt(1000);
        	 
                 robot.mouseMove(x, y);

//  Thread.currentThread().sleep(1000);//sleep for 1000 ms

//click derecho
//robot.mousePress(InputEvent.BUTTON2_MASK);
//robot.mouseRelease(InputEvent.BUTTON2_MASK);
try
  {
  Thread.sleep(10);

  }catch (InterruptedException ie)
  {
  System.out.println(ie.getMessage());
  }

}



}

public static void keyPressed(KeyEvent e){
if (e.getKeyCode() == e.VK_ASTERISK)
{

System.exit(0);
}
}
}
*/