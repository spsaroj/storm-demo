# Storm App
 **Members:**
 * [Sagar Tiwari](https://github.com/005sagar)
 * [Saroj Paudel](https://github.com/spsaroj)
 * [Su-sun Maharjan](https://github.com/susanmaharjan)
 * [Jing Li](https://github.com/JingLi521864)
 
 **Sub Topic**
 * Sagar - I will do the demonstartion on spouts. 
 * Susan - Demonstrate Installation and set up process.
 * Saroj - I will do demonstration on Bolts.
 * Jing - Demonstrate Architecture of Storm

### Susan Maharjan
## How to install and run Storm:  
### Pre-requisites  
1. Anaconda3

1. Java

1. Maven

1. Zookeeper

### Install pre-requisites 
I have used chocolatey to install Anaconda3 Java and Maven

Anaconda3  
```choco install anaconda3 -y```

Java

```choco install openjdk -y```

Maven

```choco install maven -y```

Zookeeper

For Zookeeper I have used the same path as we used before. So I used following command to configure Zookeeper.  
```.\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties```

But you can download zookeeper from following link.

[http://download.nextag.com/apache/zookeeper/zookeeper-3.3.6/](http://download.nextag.com/apache/zookeeper/zookeeper-3.3.6/)

After downloading use following commands to configure zookeeper.
```
> cd zookeeper-3.3.6

> copy conf\zoo_sample.cfg conf\zoo.cfg

> .\bin\zkServer.cmd
```
  
Strom

Download the Zipped file for storm from the below link.

[https://dl.dropboxusercontent.com/s/iglqz73chkul1tu/storm-0.9.1-incubating-SNAPSHOT-12182013.zip](https://dl.dropboxusercontent.com/s/iglqz73chkul1tu/storm-0.9.1-incubating-SNAPSHOT-12182013.zip)  
Then extract it in C:\ using 7zip.

#### Set up the following variable and value inside Environment variable

- Variable= M2_HOME Value= C:\ProgramData\chocolatey\lib\maven\apache-maven-3.6.3  
Inside Path

- Variable= JAVA_HOME Value= C:\OpenJDK\jdk-15.0.1

- Variable=STORM_HOME Value= C:\storm-0.9.1-incubating-SNAPSHOT-12182013  

Make sure that files are stored in same address or use your own address. I have stored everything in C:\  drive.  


#### Inside Path in environment variable make sure there is following path setup:

- %JAVA_HOME%\bin

- %M2_HOME%\bin

- %STORM_HOME%\bin

- C:\tools\Anaconda3

- C:\tools\Anaconda3\Library\mingw-w64\bin

- C:\tools\Anaconda3\Library\usr\bin

- C:\tools\Anaconda3\Library\bin

- C:\tools\Anaconda3\Scripts

Then Start Nimbus, Supervisor and Strom UI to start Storm.

For each, open a separate command prompt.

Use following commands in each command prompt.

```
storm nimbus
```

```
storm supervisor
```

```
storm ui
```

After running these, open [http://localhost:8080/](http://localhost:8080/) in the browser and if you can see following screen, your Storm is running.
![stromrunningwindow](https://github.com/spsaroj/storm-demo/blob/main/Screenshot%20(43).png)

### Jing Li
Start typing here

### Sagar Tiwari
Start typing here

### Saroj Paudel
Start typing here
