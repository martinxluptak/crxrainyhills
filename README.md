# CRXRainyHills

This program implements a solution for the CRX Markets Java EE coding exercise specified by "RainyHills.pdf."\
The solution uses Spring Boot and can be run in Docker.

![Rainy Hills assignment snippet](./static/rainyhills-snippet.jpg)

## Dependencies
The application is built with JDK 17 and runs on JRE 17. 
Having these packages installed on your system is required for compiling and running the application respectively.
Installation instructions (for Debian-based Linux distributions):

```sh
$ sudo apt-get install openjdk-17 openjdk-17-jre
```
or a similar command depending on your package manager.

## Running in Docker
The application can also be run in Docker. This requires a JDK 17 to build the application and Docker Engine to run the Docker container.
This can be achieved with the following commands.
```sh
# Build the application into a .jar file.
$ sh gradlew build

# Create a docker image.
$ docker build --build-arg JAR_FILE=build/libs/\*.jar -t luptak/crx-rainy-hills-docker .

# Run the docker image as a web server on port 8080 (Spring Boot default).
$ docker run -p 8080:8080 luptak/crx-rainy-hills-docker
```

## How to use
Send a GET request to URI `/rainy` specifying the height profile as a comma-separated integer list in a GET parameter `surfaces`.\
Here is an example with the application running on `localhost:8080`:

```sh
$ curl -X GET http://localhost:8080/rainy \
       -G -d "surfaces=8,0,8"
```
The response is a JSON object with a property "volume" and the result integer value:
```json
{"volume":8}
```

## Running as a console application
The application JAR can be used without any networking through a simple command line interface. Additionally, by disabling logging
and additional Spring messages it can be piped with your own scripts.
Just supply a comma-separated integer list as a command line argument when running the jar file (in this case `1,2,4,7,8`):
```sh
$ java -jar \
     -Dspring.main.web-application-type=NONE \
     -Dlogging.level.root=OFF \
     -Dspring.main.banner-mode=off \
     crxrainyhills.jar 1,2,4,7,8
```

## Complexity
The application uses `RainCalculatorImpl` class which calculates the result in linear time `O(n)`
and constant memory usage `O(1)`.
