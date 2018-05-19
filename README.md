# NetBomber
Lo siguiente que voy a describir en las próximas lineas, es la forma de explotar vulnerabilidades para la ejecución de comandos a través de la RED. Específicamente, éste caso practico se aplicó en los laboratorio de la Universidad Dr. Rafael Belloso Chacín (URBE). Es algo bastante básico, sin embargo demuestra la posibilidad de atacar diferentes entidades si no existe una correcta auditoria de seguridad dentro del esquema de red.

Aspectos iniciales: 

Para la ejecución de comandos en red es necesario poseer privilegios administrativos, algo que realmente no es difícil de obtener si el atacante sabe utilizar bien sus recursos. Para la obtención de las contraseñas administrativas existen varios métodos, uno de ellos es la ingeniería social, pero si tienes acceso a un computador dentro del dominio de red, todo será mucho más sencillo, utilizando un rubber ducky con los comandos adecuados o como mi caso, con una distro especifica para crackear contraseñas booteada desde un disco USB. 

En esta ocasión utilicé una imagen de Ophcrack en un pendrive y durante una clase obtuve acceso a todas las contraseñas registradas en el sistema. 

NOTA: En muchos casos prácticos, no será tan fácil ya que bajo entornos bien administrados, el BIOS no estará habilitado para bootear desde USB o simplemente estará bloqueado (pulsando F12 se va a forzar a las opciones de booteo), pero ya será cuestión de intentar con otras herramientas, si el sitio en particular posee una red WIFI abierta, ya tendríamos que ejecutar un ataque Man in the middle desde un equipo nuestro, empleando DNS spoofing con cualquier otra herramienta como Kali linux o WifiSlax. 

NOTA 2: Si el BIOS se encuentra bloqueado, con abrir el case del computador y quitarle la pila ya solucionas (hombre, existen soluciones para todo).

Ya con privilegios administrativos

Tener privilegios administrativos dentro de la red de una organización te genera un amplio abanico de posibilidades. En mi caso, mi intención era totalmente ética y a modo de broma solo me interesaba apagar ordenadores (especialmente a ciertos profesores) o colapsar un poco la red. El formato el comando para apagado en red es el siguiente: 


shutdown -s -f -m \\192.168.0.2 -t 0




¿Algo bastante sencillo no? Puedes hacer la prueba desde CMD. Pero ten en cuenta, que si la cuenta no posee privilegios obtendrás el siguiente mensaje: 





Muy bien, ahora que sabemos que nuestra cuenta tiene la opcion de apagar equipos en red, vamos a automatizarlo. 

Ejecutar comandos desde la consola quita mucho tiempo, además, si intentas hacer alguna fechoría, en general tendrás poco tiempo. Lo que hice fue una aplicación en java para poder realizar una ejecución masiva o especifica de un computador. Los laboratorios en URBE tienen máximo 32 computadoras, el método pide al usuario el nombre del laboratorio y el rango de donde a donde desea apagar. Acá dejo el método para que tengan una idea: 


public static void apagar(){ //exec("shutdown -s -t 3600"); String lab = JOptionPane.showInputDialog("Ingrese el laboratorio"); String dato; int num; dato = JOptionPane.showInputDialog("Ingrese a partir de que maquina"); num = Integer.parseInt(dato); JOptionPane.showConfirmDialog(null, "¿Seguro deseas apagar los equipos seleccionados?"); String barra= "\\\\"; while (num < 32) { exec("shutdown -s -f -m "+barra+""+lab+"-"+num+++" -t 0"); System.out.println("shutdown -s -f -m "+barra+""+lab+"-

"+num+++" -t 0"); }


Interfaz:  




4 opciones, y una interfaz bastante sencilla



Únicamente con ingresar la IP o el nombre del equipo se logra apagar


Comentarios finales: 

Muchos de ustedes se preguntarán: ¿Ajá apago computadoras y qué? 
Bueno, todas las maquinas dentro del dominio poseen una IP interna con la que podemos jugar, haciendo un escaneo extenso, podremos determinar que hay subneting y posteriormente atacar todo. ¿Sabes que pasa si apagas un servidor? ¿O si apagas todas las maquinas de una caja? COLAPSA TODO. En cualquier empresa si bien no es un ataque para robar información, representa una perdida de tiempo, dinero y seriedad.

El hecho de que éstos fallos existan no quiere decir que deben ser explotados. No hagan, cualquier logro obtenido debe ser un merito personal y debe ser debidamente informado (o hasta vendido si es el caso) a la empresa, pero siempre con ética. Ser hacker no es ser un pirata, los medios nos han llenado con esa definición absurda, un hacker es una persona con hambre de conocimientos, que siempre intenta llevar al limite cualquier sistema o tecnología.


Ah otra cosa. Recuerden siempre borrar toda huella. Si ejecutan algo parecido es probable que lleguen al computador en donde ejecutó, ergo no seas subnormal y si lo haces que sea de forma remota o desde una estación diferente.
