
-- Pointcut (puntos de corte)
Se indica donde de nuestro sistema se aplicaran los consejos, para ello se ultilizan los siguientes elementos

- Nombre de paquetes, clases y metodos.
- Tipo de Acceso (public, protected, ..).
- Tipo de Argumentos. (se ponen entre parentesis).
- Comodines: "*" (cualquiera) y ".." (varios).
- Se pueden Combinar con Operadores Logicos &&, || y ! (and , or and NOT)
- Se puede definir un punto de Corte para Reutilizarlo, esto es asignandole un Nombre
    @pointcut(<expresion>) public void methodName(){ } //methodName sera el nombre del punto de Corte


 Ejemplos
    A - @pointcut("execution(* * (..))")         //aplica a todos los metodos
    B - @pointcut("execution(public * * (..))")  //aplica a todos los metodos publicos
    C - @pointcut("execution(package.*.* (..))") //aplica a todos los metodos de las clases de un paquete
    D - @pointcut("within(package.*)")           //aplica a todos los metodos de las clases de un paquete
    [noten que C y D son dos formas de hacer lo mismo]
    E - @pointcut("within(package..*)")          //aplica a todos los metodos de las clases de un paquete y subpaquetes
    F - @pointcut("execution(* suf* (..))")      //aplica a todos los metodos que empiezan con el sufijo "suf"
    G - @pointcut("args(arg))")                  //aplica a todos los metodos que tienen un argumento del tipo indicado
    H - @within("package.GenericAnotation")      //aplica a todos los metodos cuya clase tiene esa anotacion
    F - @annotation("package.MethodGenericAnotation") //aplica a todos los metodos que tienen esa anotacion
    G - @pointcut("execution(* package.method())")    //aplica a un metodo determinado



-- Advices (Consejos) , es una accion que se debe realizar.

Para indicar cuando realizarla tenemos una serie de anotaciones

@Before. Se lanza antes de la ejecucion del metodo

@AfterReturning. Se lanza despues de la ejecucion del metodo. si no provoca una excepcion

@AfterThrowing. Se lanza despues de la ejecucion del metododo, si se genera una excepcion
[Esta es una muy buena forma de eliminar try catch de la aplicacion]

@After.Se lanza despues de la ejecucion del metodo, genere o no una excepcion,
 es decir al estilo finally

@Around. Esta anotacion ejecuta parte antes y parte despues de la ejecucion del metodo.
