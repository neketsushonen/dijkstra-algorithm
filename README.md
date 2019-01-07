Generación de ruta API:

Para poder correr esta aplicación, en primer lugar, se debe instalar el comando mvn desde el sistema operativo (sea en linux o en windows).

Luego, descargar este repositorio desde GitHUB

Para compilar esta aplicación, se debe ejecutar el siguiente comando desde la raíz de la aplicación (por ejemplo, en mi computador, la aplicación se compila desde /Users/chunhaulai/lai-algorithm-dijkstra)

````
mvn clean package
````

Para correr la aplicación, basta ejecutar el siguiete comando:

````
mvn exec:java@proceso1 -Dexec.args='ejemplo/nodos.txt ejemplo/arcos.txt ejemplo/'
````
donde se recibe tres parametros: 

1) la ruta absoluta donde está el archivo nodos.txt
2) la ruta absoluta donde está el archvo arcos.txt
3) la ruta absoluta donde se generará las salidas (por ejemplo, en la ruta donde se encuentra especificada la carpeta ejemplo/)

Una vez ejecutado, se verán las salidas en la ruta especificada en el punto 3.


