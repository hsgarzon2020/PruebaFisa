# PRUEBA TÉCNICA JAVA FISA GROUP

## _CONFERENCE TRACK MANAGEMENT_ 

You are planning a big programming conference and have received many proposals which have passed the initial 
screen process but you're having trouble fitting them into the time constraints of the day -- there are so many possibilities! 
So you write a program to do it for you.

- The conference has multiple tracks each of which has a morning and afternoon session.
- Each session contains multiple talks.
- Morning sessions begin at 9am and must finish by 12 noon, for lunch.
- Afternoon sessions begin at 1pm and must finish in time for the networking event.
- The networking event can start no earlier than 4:00 and no later than 5:00.
- No talk title has numbers in it.
- All talk lengths are either in minutes (not hours) or lightning (5 minutes).
- Presenters will be very punctual; there needs to be no gap between sessions.

Note that depending on how you choose to complete this problem, your solution may give a different ordering or combination of talks into tracks. 
This is acceptable; you don’t need to exactly duplicate the sample output given here.

# Test input
Writing Fast Tests Against Enterprise Rails 60min  
Overdoing it in Python 45min  
Lua for the Masses 30min  
Ruby Errors from Mismatched Gem Versions 45min  
Common Ruby Errors 45min  
Rails for Python Developers lightning  
Communicating Over Distance 60min  
Accounting-Driven Development 45min  
Woah 30min  
Sit Down and Write 30min  
Pair Programming vs Noise 45min  
Rails Magic 60min  
Ruby on Rails: Why We Should Move On 60min  
Clojure Ate Scala (on my project) 45min  
Programming in the Boondocks of Seattle 30min  
Ruby vs. Clojure for Back-End Development 30min  
Ruby on Rails Legacy App Maintenance 60min  
A World Without HackerNews 30min  
User Interface CSS in Rails Apps 30min  
 
# Test output  
Track 1:  
09:00AM Writing Fast Tests Against Enterprise Rails 60min  
10:00AM Overdoing it in Python 45min  
10:45AM Lua for the Masses 30min  
11:15AM Ruby Errors from Mismatched Gem Versions 45min  
12:00PM Lunch  
01:00PM Ruby on Rails: Why We Should Move On 60min  
02:00PM Common Ruby Errors 45min  
02:45PM Pair Programming vs Noise 45min  
03:30PM Programming in the Boondocks of Seattle 30min  
04:00PM Ruby vs. Clojure for Back-End Development 30min  
04:30PM User Interface CSS in Rails Apps 30min  
05:00PM Networking Event  
Track 2:
09:00AM Communicating Over Distance 60min  
10:00AM Rails Magic 60min  
11:00AM Woah 30min  
11:30AM Sit Down and Write 30min  
12:00PM Lunch  
01:00PM Accounting-Driven Development 45min  
01:45PM Clojure Ate Scala (on my project) 45min  
02:30PM A World Without HackerNews 30min  
03:00PM Ruby on Rails Legacy App Maintenance 60min  
04:00PM Rails for Python Developers lightning  
05:00PM Networking Event  

# Algoritmo
1. Crear un nuevo día (Track)  
2. Tomar una charla (Talk)  
3. Si la duración total + la duracion de la charla (Talk) < Límite de tiempo entonces agregue la charla (Talk) al día (Track) y regrese al paso 2    
4. De lo contrario iterar sobre los días (Track) disponibles excepto el actual  
5. Si la duración total + la duración de la charla (Talk) < límite de tiempo entonces agregue la charla (Talk) al día (Track) y regrese al paso 2    
6. De lo contrario crear un nuevo día (Track)  
7. Agregar la charla (Talk) al nuevo día (Track)  
8. Volver al paso (2)

# Para iniciar  
Para obtener el codigo fuente, por favor clonar el repositorio de git.
```sh
https://github.com/hsgarzon2020/PruebaFisa.git
```
# Pre-requisitos  
Para poder correr el proyecto debes tener instalado java 8 o superior y apache maven.
```sh
java version "1.8.0_271"
Java(TM) SE Runtime Environment (build 1.8.0_271-b09)
Java HotSpot(TM) 64-Bit Server VM (build 25.271-b09, mixed mode)
```
```sh
Apache Maven 3.8.4 (9b656c72d54e5bacbed989b64718c159fe39b537)
Maven home: C:\apache-maven-3.8.4
Java version: 1.8.0_202, vendor: Oracle Corporation, runtime: C:\Program Files\Java\jdk1.8.0_202\jre
Default locale: es_CO, platform encoding: Cp1252
OS name: "windows 10", version: "10.0", arch: "amd64", family: "windows"
```
# Ejecución
Para ver la solución del problema, por favor ejecute el siguiente comando, en la ruta out del proyecto:
```sh
java -jar conferenceManagement-1.0.jar
```
