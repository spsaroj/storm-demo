# Storm App
 **Members:**
 * [Sagar Tiwari](https://github.com/005sagar)
 * [Saroj Paudel](https://github.com/spsaroj)
 * [Su-sun Maharjan](https://github.com/susanmaharjan)
 * [Jing Li](https://github.com/JingLi521864)
 
 **Sub Topic**
 * Sagar - Demonstrate on Spouts and Topology. 
 * Susan - Demonstrate Installation and set up process.
 * Saroj - Demonstrate on Bolts.
 * Jing - Demonstrate Architecture of Storm

### Susan Maharjan
## How to install and run Storm: 
Click in the [Video Link](https://use.vg/Wea8GO) to watch the video of How to install and run Storm
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
## Apache Storm: Architecture

Apache Storm is a distributed realtime computation system. Similar to how Hadoop provides a set of general primitives for doing batch processing, Storm provides a set of general primitives for doing the realtime computation. Storm is simple, can be used with any programming language, is used by many companies, and is a lot of fun to use!


#### Apache Storm master node 
Nimbus is a master node of Storm cluster. All other nodes in the cluster are called as worker nodes. Master node is responsible for distributing data among all the worker nodes, assign tasks to worker nodes and monitoring failures.

Command:

```storm nimbus```

Results:
![stormnimbus](https://github.com/spsaroj/storm-demo/blob/main/storm_nimbus.png)


#### Apache Storm worker node
The nodes that follow instructions given by the nimbus are called as Supervisors. A supervisor has multiple worker processes and it governs worker processes to complete the tasks assigned by the nimbus.

Command:

```storm supervisors```

Results:
![stormsup](https://github.com/spsaroj/storm-demo/blob/main/storm_sup.png)

#### Apache Storm UI Results
Command:

```storm ui```
![stormui](https://github.com/spsaroj/storm-demo/blob/main/storm_ui.png)


### Sagar Tiwari
After completing all the process above, now lets talk about Spout and Topology.

#### Topology
A topology is a graph of computation. We use it for realtime computation on Storm.Running a topology is straightforward. First, you package all your code and dependencies into a single jar. Then, run the following code:
```storm jar all-my-code.jar org.apache.storm.MyTopology arg1 arg2```
- While making a topology first you have to make a topology builder 
```TopologyBuilder builder```
- After the toplogy is created you need to set Spout in that topology
```builder.setSpout```
- Then you need to set bolt in that topology
```builder.setBolt```
- After you set spout and bolt you need to sumbit the topology
```submit()```
- Finnaly you can start the topology 
``` ConfigurableTopology.start ```

#### Spouts
A spout is a source of streams in a topology. Generally spouts will read tuples from an external source and emit them into the topology. Spouts can either be reliable or unreliable. Spout also has different methods, such as
- ```open()``` - It will call a task for this component is initialized within.
- ```nextTuple()``` - When this method is called. Storm is requesting that the Spout emit tuple to the output collector.
- ```ack()``` - Storm has determined that the tuple emitted by this Spout with the id identifier has been fully processed.
- ```fail()``` - The tuple emitted by this Spout with the id identifier has failed to be fully processed.

### Saroj Paudel
#### Bolts
Bolts are where all the processing in the topologies are done. All the processings like filtering, functions, aggregations, joins, talking to database etc. can be done in the bolts. If you want your topology to emit more than one streams, you can do in the bolt.
```execute()``` is the main and most important method in apache storm where you do the calculation and emit the values in the topology.

In our example we are doing word count that are created in the spout and are splitted in split bolt and are counted in the count bolt.
Example: if you were to do equivalence of map reduce job, you would fetch the data in the spout and would do mapper, sort and reducer in their particular bolts. And finally you would bind them together in the Topology.


## How to run:

Assuming you have zookeeper, nimbus, supervisor and UI running, follow the following steps to run the project:
```Powershell mvn clean compile assembly:single ``` - This will first clean the project, compiles it and create a target folder with a fat jar file.


## Reference
- https://www.tutorialspoint.com/apache_storm/apache_storm_cluster_architecture.htm
- https://blog.knoldus.com/apache-storm-architecture/
- https://storm.apache.org/releases/current/Tutorial.html
- https://storm.apache.org/releases/current/Concepts.html
- https://www.youtube.com/watch?v=5kiZs1a8UPM&ab_channel=edureka%21
- http://ptgoetz.github.io/blog/2013/12/18/running-apache-storm-on-windows/
- https://github.com/apache/storm/tree/master/examples/storm-starter

 

